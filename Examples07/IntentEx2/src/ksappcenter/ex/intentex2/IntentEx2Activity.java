package ksappcenter.ex.intentex2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class IntentEx2Activity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button) findViewById(R.id.btn1main);
        btn.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.btn1main:
			TextView text = (TextView) findViewById(R.id.text1main);
			String s = text.getText().toString();
			int num = Integer.valueOf(s);
			
			Intent intent = new Intent(this, Compute.class);
			intent.putExtra("param1", num);
			startActivityForResult(intent, 1);
			break;
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode){
		case 1:
			if(resultCode == 1){
				int num = data.getIntExtra("result", 1000000);
				String s = Integer.toString(num);
				TextView text = (TextView) findViewById(R.id.text1main);
				text.setText(s);
			}else if(resultCode == 0){
				;
			}
			break;
		}
	}
}