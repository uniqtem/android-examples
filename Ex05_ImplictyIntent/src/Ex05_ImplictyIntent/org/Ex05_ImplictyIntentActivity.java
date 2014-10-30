package Ex05_ImplictyIntent.org;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ex05_ImplictyIntentActivity extends Activity implements
		OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button b1 = (Button) this.findViewById(R.id.bu1);
		b1.setOnClickListener(this);
		Button b2 = (Button) this.findViewById(R.id.bu2);
		b2.setOnClickListener(this);
		Button b3 = (Button) this.findViewById(R.id.bu3);
		b3.setOnClickListener(this);
		Button b4 = (Button) this.findViewById(R.id.bu4);
		b4.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		// String path = getFilesDir().getAbsolutePath();
		Intent intent = null;

		switch (arg0.getId()) {

		case R.id.bu1:
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.google.com/"));
			startActivity(intent);
			break;
		case R.id.bu2:
			intent = new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:010-1234-1234"));
			startActivity(intent);
			break;
		case R.id.bu3:
			intent = new Intent(Intent.ACTION_VIEW);
			Uri uri = Uri.fromFile(new File("/sdcard/picture1.jpg"));
			intent.setDataAndType(uri, "image/jpg");
			startActivity(intent);
			break;
		case R.id.bu4:
			intent = new Intent(this, Ex05_Calulator.class);
			startActivity(intent);
			break;
		}

	}
}