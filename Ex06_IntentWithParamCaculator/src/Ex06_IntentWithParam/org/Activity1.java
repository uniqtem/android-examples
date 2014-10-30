package Ex06_IntentWithParam.org;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends Activity implements OnClickListener {
	EditText edit;
	int val;
	TextView tx;
	
	
	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity);
	    	
	        
	        Intent intent = getIntent();
	        String s = intent.getStringExtra("param1"); 
	        val = Integer.valueOf(s);
	        
	        tx = (TextView)this.findViewById(R.id.result);
	        tx.setText(s);
	        
	        edit = (EditText)this.findViewById(R.id.edittext);
	        //edit.setO
	        Button btn1 = (Button)this.findViewById(R.id.ok);
	        btn1.setOnClickListener(this);
	        Button btn2 = (Button)this.findViewById(R.id.cancel);
	        btn2.setOnClickListener(this);
	        Button bt3 = (Button)this.findViewById(R.id.duhagi);
	        bt3.setOnClickListener(this);
	        Button bt4 = (Button)this.findViewById(R.id.duhagi1);
	        bt4.setOnClickListener(this);
	        Button bt5 = (Button)this.findViewById(R.id.duhagi2);
	        bt5.setOnClickListener(this);
	        Button bt6 = (Button)this.findViewById(R.id.duhagi3);
	        bt6.setOnClickListener(this);
	    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.ok:
			String s2 = tx.getText().toString();
			Intent retIntent = new Intent();
			retIntent.putExtra("retVal", s2);
			setResult(RESULT_OK,retIntent);
			finish();
			break;
		case R.id.cancel:
			setResult(RESULT_CANCELED);
			finish();
			break;
			
		case R.id.duhagi:
			//edit = (EditText)this.findViewById(R.id.edittext);
			String a = edit.getText().toString();
			int a11 = Integer.parseInt(a);
			val=val+a11;
			//tx = (TextView)this.findViewById(R.id.result);
			String b = Integer.toString(val);
			tx.setText(b);
			break;
		case R.id.duhagi1:
			//edit = (EditText)this.findViewById(R.id.edittext);
			a = edit.getText().toString();
			a11 = Integer.parseInt(a);
			val=val-a11;
			//tx = (TextView)this.findViewById(R.id.result);
			b = Integer.toString(val);
			tx.setText(b);
			break;
		case R.id.duhagi2:
			//edit = (EditText)this.findViewById(R.id.edittext);
			a = edit.getText().toString();
			a11 = Integer.parseInt(a);
			val=val*a11;
			//tx = (TextView)this.findViewById(R.id.result);
			b = Integer.toString(val);
			tx.setText(b);
			break;
		case R.id.duhagi3:
			//edit = (EditText)this.findViewById(R.id.edittext);
			a = edit.getText().toString();
			a11 = Integer.parseInt(a);
			val=val/a11;
			//tx = (TextView)this.findViewById(R.id.result);
			b = Integer.toString(val);
			tx.setText(b);
			break;
		}
		
	}
}
