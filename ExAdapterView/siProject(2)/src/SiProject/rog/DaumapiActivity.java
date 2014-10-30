package SiProject.rog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class DaumapiActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	int count;

	ProgressThread progressThread;
	ProgressDialog progressDialog;

	ArrayList<MyItem2> mItems;
	CustomAdater2 mAdapter;
	int val = 1;
	Button btn,btn2, btn3;
	String xml;
	int val11;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.daum);

		mItems = new ArrayList<MyItem2>();

		mAdapter = new CustomAdater2(this, R.layout.item, mItems);
		ListView list = (ListView) this.findViewById(R.id.list);
		list.setAdapter(mAdapter);
		list.setOnItemClickListener(this);

		btn = (Button) this.findViewById(R.id.button1);
		btn.setOnClickListener(this);
		btn2 = (Button) this.findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		btn3 = (Button) this.findViewById(R.id.button3);
		btn3.setOnClickListener(this);

		btn2.setVisibility(View.INVISIBLE);
		btn3.setVisibility(View.INVISIBLE);

	}

	String url;

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String s = "스트레칭";
		Random rand = new Random(System.currentTimeMillis());
		val11 = rand.nextInt(1000000);

		switch (arg0.getId()) {

		case R.id.button1:
			mItems.clear();

			showDialog(val11);

			btn2.setVisibility(View.VISIBLE);
			btn3.setVisibility(View.VISIBLE);
			btn.setVisibility(View.INVISIBLE);

			break;

		case R.id.button2:

			mItems.clear();
			count = val;
			val--;

			showDialog(val11);

			break;
		case R.id.button3:

			mItems.clear();
			count = 0;
			val++;

			showDialog(val11);
		}
	}
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub

		progressDialog = new ProgressDialog(this);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setMessage("Loading...");
		progressThread = new ProgressThread(handler);
		progressThread.start();
		return progressDialog;

	}

	final Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			int total = msg.getData().getInt("total");

			progressDialog.setProgress(total);
			if (total >= 100) {
				mAdapter.notifyDataSetChanged();
				setResult(RESULT_OK);
				total = 0;
				dismissDialog(val11);
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

		ProgressThread(Handler h) {
			mHandler = h;
		}

		public void run() {
			mState = STATE_RUNNING;

			// Thread.sleep(100);
			int itemtype = 0;
			int startItem = 0;

			String coverImage = "";
			String author = "";
			String publisher = "";
			String title = "";
			String pubdate = "";
			String booklink = "";
			try {

				String s = "스트레칭";
				s = URLEncoder.encode(s);
				url = "http://apis.daum.net/search/vclip?q=" + s
						+ "&result=10&pageno=" + val
						+ "&apikey=af0374a169c37f9d94ee8f47da127252d0d5e975";
				URL xurl = new URL(url);
				XmlPullParserFactory factory = XmlPullParserFactory
						.newInstance();
				XmlPullParser parser = factory.newPullParser();
				parser.setInput(xurl.openStream(), null);

				int eventType = parser.getEventType();
				while (eventType != XmlPullParser.END_DOCUMENT
						&& mState == STATE_RUNNING) {
					switch (eventType) {
					case XmlPullParser.START_DOCUMENT:
						break;
					case XmlPullParser.END_DOCUMENT:
						break;
					case XmlPullParser.START_TAG:
						if (parser.getName().equals("thumbnail")) {
							itemtype = 1;
						}
						if (parser.getName().equals("author")) {
							itemtype = 2;
							// showDialog(0);

						}
						if (parser.getName().equals("pub_nm")) {
							itemtype = 3;
						}
						if (parser.getName().equals("title")) {
							itemtype = 4;
						}
						if (parser.getName().equals("cpname")) {
							itemtype = 5;
						}
						if (parser.getName().equals("link")) {
							itemtype = 6;
						}
						if (parser.getName().equals("item")) {
							startItem = 1;
						}

						break;
					case XmlPullParser.END_TAG:
						if (parser.getName().equals("item")) {
							mItems.add(new MyItem2(coverImage, author,
									publisher, title, pubdate, booklink));
							count++;
							coverImage = "";
							author = "";
							publisher = "";
							title = "";
							pubdate = "";
							booklink = "";
						}
						break;
					case XmlPullParser.TEXT:
						if (startItem == 0) {
							break;
						}
						if (itemtype == 1) {
							coverImage = parser.getText();
						}
						if (itemtype == 2) {
							author = parser.getText();
						}
						if (itemtype == 3) {
							publisher = parser.getText();
						}
						if (itemtype == 4) {
							title = parser.getText();
						}
						if (itemtype == 5) {
							pubdate = parser.getText();
						}
						if (itemtype == 6) {
							booklink = parser.getText();
						}

						itemtype = 0;
						break;
					}
					eventType = parser.next();
					Message msg = mHandler.obtainMessage();
					Bundle b = new Bundle();
					b.putInt("total", count * 10);
					msg.setData(b);
					mHandler.sendMessage(msg);
				}
			} catch (Exception e) {
				;
			}
		}

		public void setState(int state) {
			mState = state;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mItems
				.get(arg2).booklink));
		// intent.putExtra("param1", mItems.get(arg2).booklink);
		startActivity(intent);

	}

}