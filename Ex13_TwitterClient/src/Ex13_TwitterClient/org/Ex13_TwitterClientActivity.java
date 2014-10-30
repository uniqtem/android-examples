package Ex13_TwitterClient.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Ex13_TwitterClientActivity extends Activity implements
		OnClickListener {
	static int ITEMCOUNT = 5;
	ArrayList<MyItem> mItems;
	CustomAdater mAdapter;
	String mName;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mItems = new ArrayList<MyItem>();

		mAdapter = new CustomAdater(this, R.layout.item, mItems);

		ListView list = (ListView) this.findViewById(R.id.list);
		list.setAdapter(mAdapter);

		Button btn = (Button) this.findViewById(R.id.button1);
		btn.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:
			EditText edit = (EditText) this.findViewById(R.id.editname);
			mName = edit.getText().toString();
			if (mName != null) {
				mItems.clear();
				String url = "http://twitter.com/statuses/user_timeline.xml?screen_name="
						+ mName + "&count=" + ITEMCOUNT;

				// http://twitter.com/statuses/user_timeline.xml?screen_name=oisoo&count=5"
				String xml = downloadURL(url);
				parseXML(xml);
				mAdapter.notifyDataSetChanged();
			}

			break;

		}

	}

	void parseXML(String xml) {
		int itemtype = 0;
		//int itemtype2=0;
		String itemText = "";
		// MyItem temp = new MyItem();
		String tempicon = "", tempscreen = "", tempname = "", temptext = "", temptime = "";

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new StringReader(xml));
			// 여기까지 의미있는부분을 짤라준다.
			int eventType = parser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.END_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("profile_image_url"))itemtype = 1;
					if (parser.getName().equals("screen_name"))itemtype = 2;
					if (parser.getName().equals("name"))itemtype = 3;
					if (parser.getName().equals("text"))itemtype = 4;
					if (parser.getName().equals("created_at"))itemtype = 5;
					break;
				case XmlPullParser.END_TAG:
					if (parser.getName().equals("status")) {
						// mItems.add(new MyItem(temp));
						mItems.add(new MyItem(tempicon, tempscreen, tempname,
								temptext, temptime));
					}
					break;
				case XmlPullParser.TEXT:
					if (itemtype == 1) tempicon = parser.getText();
					if (itemtype == 2) tempscreen = parser.getText();
					if (itemtype == 3) tempname = parser.getText();
					if (itemtype == 4) temptext = parser.getText();
					if (itemtype == 5) temptime = parser.getText();
					
					itemtype = 0;
					break;
				}
				eventType = parser.next();
			}
		} 
		catch (Exception e) {
			
		}
		// TextView text1 = (TextView)this.findViewById(R.id.tv1);
		// text1.setText(itemText);

	}

	String downloadURL(String addr) {
		String doc = "";
		try {
			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (conn != null) {
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) { // 연결이
																			// 완성이됫다
					BufferedReader br = new BufferedReader(
							new InputStreamReader(conn.getInputStream()));
					for (;;) {
						String line = br.readLine();
						if (line == null)
							break;
						doc = doc + line + "\n";
					}
					br.close();
				}
				 conn.disconnect();
			}
		} catch (Exception ex) {
			;
		}

		return doc;

	}
}