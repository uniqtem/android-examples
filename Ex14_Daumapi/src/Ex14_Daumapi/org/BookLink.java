package Ex14_Daumapi.org;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class BookLink extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.booklink);

		Intent intent = getIntent();
		String booklink = intent.getStringExtra("param1");

		WebView web1 = (WebView) this.findViewById(R.id.web1);
		web1.setWebViewClient(new WebViewClient());

		WebSettings set = web1.getSettings();
		set.setJavaScriptEnabled(true);
		set.setBuiltInZoomControls(true);

		web1.loadUrl(booklink);

		Button btn = (Button) this.findViewById(R.id.btn1web);
		btn.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		finish();

	}
}
