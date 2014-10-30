package Ex14_Daumapi.org;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.app.ProgressDialog;
import android.content.Context;

public class JXMLParser {
	Context mContext;

	public JXMLParser(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	void parseXML(String xml, ArrayList<MyItem> arrayItems) {
		// TODO Auto-generated method stub
		int itemtype = 0;
		int startItem = 0;

		String coverImage = "";
		String author = "";
		String publisher = "";
		String title = "";
		String pubdate = "";
		String booklink = "";

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = factory.newPullParser();
			parser.setInput(new StringReader(xml));

			int eventType = parser.getEventType();
			while (eventType != XmlPullParser.END_DOCUMENT) {
				switch (eventType) {
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.END_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if (parser.getName().equals("cover_s_url")) {
						itemtype = 1;
					}
					if (parser.getName().equals("author")) {
						itemtype = 2;
					}
					if (parser.getName().equals("pub_nm")) {
						itemtype = 3;
					}
					if (parser.getName().equals("title")) {
						itemtype = 4;
					}
					if (parser.getName().equals("pub_date")) {
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
						arrayItems.add(new MyItem(coverImage, author,
								publisher, title, pubdate, booklink));
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
			}
		} catch (Exception e) {
			;
		}
	}

	String downloadURL(String addr) {
		ProgressDialog mProgress = ProgressDialog.show(mContext, "Wait",
				"Downloading...");
		String doc = "";
		try {
			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (conn != null) {
				conn.setConnectTimeout(10000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
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

		mProgress.dismiss();
		return doc;
	}

}
