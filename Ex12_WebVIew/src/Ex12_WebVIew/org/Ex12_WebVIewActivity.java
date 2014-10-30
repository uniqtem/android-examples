package Ex12_WebVIew.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Ex12_WebVIewActivity extends Activity implements OnClickListener {
	WebView mWeb;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mWeb = (WebView) this.findViewById(R.id.web1);
		mWeb.setWebViewClient(new WebViewClient());

		WebSettings set = mWeb.getSettings();
		set.setJavaScriptEnabled(true);
		set.setBuiltInZoomControls(true);

		mWeb.loadUrl("http://www.naver.com");
		Button btn = (Button) this.findViewById(R.id.Button1);
		btn.setOnClickListener(this);
		Button btn2 = (Button) this.findViewById(R.id.Button2);
		btn2.setOnClickListener(this);
		Button btn3 = (Button) this.findViewById(R.id.Button3);
		btn3.setOnClickListener(this);
		Button btn4 = (Button) this.findViewById(R.id.Button4);
		btn4.setOnClickListener(this);
		Button btn5 = (Button) this.findViewById(R.id.Button5);
		btn5.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		EditText addr = (EditText) this.findViewById(R.id.etn1);
		switch (arg0.getId()) {
		case R.id.Button1: // 홈으로가기
			String url = addr.getText().toString();
			mWeb.loadUrl(url);
			break;
		case R.id.Button2: // 뒤로가기
			mWeb.goBack();
			break;
		case R.id.Button3: // 앞으로가기
			if (mWeb.canGoForward()) {
				mWeb.goForward();
			}
			break;
		case R.id.Button4:
			mWeb.loadUrl("file:///android_asset/test.html");
			break;
		case R.id.Button5:
			mWeb.loadUrl("http://www.google.com");
			break;
		}
	}
}