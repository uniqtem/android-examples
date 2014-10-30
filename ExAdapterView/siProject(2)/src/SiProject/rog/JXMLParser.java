package SiProject.rog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class JXMLParser extends Activity{
	int count;
	Context mContext;
	ProgressThread progressThread;
	ProgressDialog progressDialog;
	
	public JXMLParser(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	
	}
	
	void parseXML(String xml, ArrayList<MyItem2> arrayItems) {
		// TODO Auto-generated method stub
		int itemtype = 0;
		int startItem = 0;
		
		String coverImage = "";
		String author = "";
		String publisher = "";
		String title = "";
		String pubdate = "";
		String booklink = "";
		
		try{
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new StringReader(xml));
			
			int eventType = parser.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT) {
				switch(eventType){
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.END_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if(parser.getName().equals("thumbnail")){
						itemtype = 1;
					}
					if(parser.getName().equals("author")){
						itemtype = 2;
						//showDialog(0);
						count++;
					}
					if(parser.getName().equals("pub_nm")){
						itemtype = 3;
					}
					if(parser.getName().equals("title")){
						itemtype = 4;
					}
					if(parser.getName().equals("cpname")){
						itemtype = 5;
					}
					if(parser.getName().equals("link")){
						itemtype = 6;
					}
					if(parser.getName().equals("item")){
						startItem = 1;
					}
					
					break;
				case XmlPullParser.END_TAG:
					if(parser.getName().equals("item")){
						arrayItems.add(new MyItem2(coverImage, author, publisher, title, pubdate,booklink));
						coverImage = "";
						author = "";
						publisher = "";
						title = "";
						pubdate = "";
						booklink = "";
					}
					break;
				case XmlPullParser.TEXT:
					if(startItem == 0){break;}
					if(itemtype == 1){				
						coverImage = parser.getText();
					}
					if(itemtype == 2){				
						author = parser.getText();
					}
					if(itemtype == 3){				
						publisher = parser.getText();
					}
					if(itemtype == 4){
						title = parser.getText();
					}
					if(itemtype == 5){				
						pubdate = parser.getText();
					}
					if(itemtype == 6){				
						booklink = parser.getText();
					}
					itemtype = 0;
					break;
				}
				eventType = parser.next();
				
			}
		}
		catch(Exception e){	; }
	}
	
	String downloadURL(String addr){
		ProgressDialog mProgress = ProgressDialog.show(mContext, "Wait", "Downloading...");
		String doc ="";
		try{
			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			if(conn != null){
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					for(;;){
						String line = br.readLine();
						if(line == null) break;
						doc = doc + line + "\n";
					}
					br.close();
				}
				conn.disconnect();
			}
		}
		catch(Exception ex){;}
		
		mProgress.dismiss();
		return doc;
	}
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case 0:
			progressDialog = new ProgressDialog(this);
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			progressDialog.setMessage("Loading...");
			progressThread = new ProgressThread(handler);
			progressThread.start();
			return progressDialog;
		default:
			return null;
		}
	}

	final Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			int total = msg.getData().getInt("total");

			progressDialog.setProgress(total);
			if (total >= 100) {
				dismissDialog(0);
				progressThread.setState(ProgressThread.STATE_DONE);
			}
		}
	};

	// 프로그레스를 처리하는 클래스 내부 클래스 정의
	private class ProgressThread extends Thread {
		Handler mHandler;
		final static int STATE_DONE = 0;
		final static int STATE_RUNNING = 1;
		int mState;
		int total;

		ProgressThread(Handler h) {
			mHandler = h;
		}

		public void run() {
			mState = STATE_RUNNING;
			total = 0;
			while (mState == STATE_RUNNING) {
				try {
					//Thread.sleep(100);
				} catch (Exception e) {

				}
				
				Message msg = mHandler.obtainMessage();
				Bundle b = new Bundle();
				b.putInt("total", count*10);
				msg.setData(b);
				mHandler.sendMessage(msg);
				
			}
		}

		public void setState(int state) {
			mState = state;
		}
	}


}
