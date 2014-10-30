package ksappcenter.ex.intentex2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Compute extends Activity implements OnClickListener {
	int num;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compute);
		
		Intent intent = getIntent();
		num = intent.getIntExtra("param1", 1000000);
		String s = Integer.toString(num);
		
		TextView text = (TextView) findViewById(R.id.text1compute);
		text.setText(s);
		
		Button btn1 = (Button) findViewById(R.id.btn1compute);
		btn1.setOnClickListener(this);
		Button btn2 = (Button) findViewById(R.id.btn2compute);
		btn2.setOnClickListener(this);
		Button btn3 = (Button) findViewById(R.id.btn3compute);
		btn3.setOnClickListener(this);
		Button btn4 = (Button) findViewById(R.id.btn4compute);
		btn4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText edit = (EditText) findViewById(R.id.edit1compute);
		String s = edit.getText().toString();
		int num2 = Integer.valueOf(s);
		int result;
		Intent data;
		
		switch(v.getId()){
		case R.id.btn1compute:
			result = num + num2;
			data = new Intent();
			data.putExtra("result", result);
			setResult(1, data);
			finish();
			break;
		case R.id.btn2compute:
			result = num - num2;
			data = new Intent();
			data.putExtra("result", result);
			setResult(1, data);
			finish();
			break;
		case R.id.btn3compute:
			result = num * num2;
			data = new Intent();
			data.putExtra("result", result);
			setResult(1, data);
			finish();
			break;
		case R.id.btn4compute:
			result = num / num2;
			data = new Intent();
			data.putExtra("result", result);
			setResult(1, data);
			finish();
			break;
		}
	}
}
