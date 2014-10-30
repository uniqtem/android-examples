package SiProject.rog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Str3 extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	//requestWindowFeature(Window.FEATURE_NO_TITLE);  
	setContentView(R.layout.str1);

	WebView mWeb;
	mWeb = (WebView)findViewById(R.id.web1);
    mWeb.setWebViewClient(new WebViewClient());
    
    WebSettings set = mWeb.getSettings();
    set.setJavaScriptEnabled(true);
    set.setBuiltInZoomControls(true);
    
    mWeb.loadUrl("http://blogfiles.naver.net/20110722_74/namseungngil_13113280891119zoq0_PNG/str3.PNG");

//	mWeb.loadDataWithBaseURL(null, creHtmlBody
//			("http://blogfiles.naver.net/20110722_74/namseungngil_13113280891119zoq0_PNG/str3.PNG"), "text/html", "utf-8", null);

}
//public static String creHtmlBody(String _imageURL){
//	StringBuffer sb = new StringBuffer("<HTML>");
//	sb.append("<HEAD>");
//	sb.append("</HEAD>");
//	sb.append("<BODY>");
//	sb.append("<img width=\"100%\" src=\""+_imageURL+"\"/>");
//	sb.append("</BODY>");
//	sb.append("</HTML>");
//	return sb.toString();
//	
//}
}
