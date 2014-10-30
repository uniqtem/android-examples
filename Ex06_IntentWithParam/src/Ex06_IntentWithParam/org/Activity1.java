package Ex06_IntentWithParam.org;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity implements OnClickListener {
	EditText edit;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);

		Intent intent = getIntent();
		String s = intent.getStringExtra("param1");  ""
		intent.getIntExtra(name, -1);

		edit = (EditText) this.findViewById(R.id.edittext);
		edit.setText(s);
		// edit.setO

		Button btn1 = (Button) this.findViewById(R.id.ok);
		btn1.setOnClickListener(this);
		Button btn2 = (Button) this.findViewById(R.id.cancel);
		btn2.setOnClickListener(this);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.ok:
			String s2 = edit.getText().toString();
			Intent retIntent = new Intent();
			retIntent.putExtra("retVal", s2);
			setResult(RESULT_OK, retIntent);
			finish();
			break;
		case R.id.cancel:
			setResult(RESULT_CANCELED);
			finish();
			break;
		}

	}
}
