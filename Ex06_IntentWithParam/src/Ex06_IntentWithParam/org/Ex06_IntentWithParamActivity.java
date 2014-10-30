package Ex06_IntentWithParam.org;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ex06_IntentWithParamActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button)this.findViewById(R.id.button1);
        button.setOnClickListener(this);
        
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.button1:
			TextView tv =(TextView)this.findViewById(R.id.textview);
			Intent intent = new Intent(this, Activity1.class);
			intent.putExtra("param1", tv.getText().toString());
			startActivityForResult(intent,1);
			break;
		}
	
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, data);
		switch(requestCode){
		case 1:
			if(resultCode == RESULT_OK){
				String ret = data.getStringExtra("retVal");
				TextView tv1 = (TextView)this.findViewById(R.id.textview);
				tv1.setText(ret);
			}else if(resultCode == RESULT_CANCELED){
				
			}
			break;
		}
		
	}
}
