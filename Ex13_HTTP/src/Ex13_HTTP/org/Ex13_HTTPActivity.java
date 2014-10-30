package Ex13_HTTP.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Ex13_HTTPActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button xml = (Button) this.findViewById(R.id.xml);
		xml.setOnClickListener(this);
		Button html = (Button) this.findViewById(R.id.html);
		html.setOnClickListener(this);
		Button parse = (Button) this.findViewById(R.id.parse);
		parse.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		TextView text1 = (TextView) this.findViewById(R.id.tv1);
		switch (arg0.getId()) {

		case R.id.html:
			String html = downloadURL("http://www.naver.com");
			text1.setText(html);
			break;
		case R.id.xml:
			// String name = "oisoo";
			// int count = 2;
			String url1 = "http://www.naver.com";
			// ? 뒤에는 매개변수 & 추가적인 정보
			String xml1 = downloadURL(url1);
			text1.setText(xml1);

			break;
		case R.id.parse:

			String url = "http://twitter.com/statuses/user_timeline.xml?screen_name=oisoo&count=5";
			// ? 뒤에는 매개변수 & 추가적인 정보
			String xml = downloadURL(url);
			parseXML(xml);
			break;

		}

	}

	void parseXML(String xml) {
		int itemtype = 0;
		String itemText = "";

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
					if (parser.getName().equals("text")) {
						itemtype = 1;
					}

				case XmlPullParser.END_TAG:
					break;
				case XmlPullParser.TEXT:
					if (itemtype == 1) {
						itemText = itemText + parser.getText() + "\n";
						itemtype = 0;
					}
					break;
				}
				eventType = parser.next();
			}
		} catch (Exception e) {
			;
		}
		TextView text1 = (TextView) this.findViewById(R.id.tv1);
		text1.setText(itemText);

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
				// conn.disconnect();
			}
		} catch (Exception ex) {
			;
		}

		return doc;

	}

}