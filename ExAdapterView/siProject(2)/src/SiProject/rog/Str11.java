package SiProject.rog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Str11 extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) { // 눈에 좋은 음식
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
    
    mWeb.loadUrl("http://blogfiles.naver.net/20110724_136/namseungngil_1311505279474tnBrj_JPEG/naver_com_20110724_195609.jpg");
	//mWeb.loadDataWithBaseURL(null, creHtmlBody
	//		("http://blogfiles.naver.net/20110724_136/namseungngil_1311505279474tnBrj_JPEG/naver_com_20110724_195609.jpg"), "text/html", "utf-8", null);

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
