package SiProject.rog;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Times extends Activity implements OnClickListener {
	EditText et;
	int name;
	int val=0;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	super.onCreate(savedInstanceState);
	setContentView(R.layout.interfacesetting);
	TextView tv = (TextView)this.findViewById(R.id.tv1);
	tv.setText(" 시간(분단위)을 입력하세요.    ");
	
	SharedPreferences pref = getSharedPreferences("Pref",0);
    name = pref.getInt("No", 10);//name을 못읽었을때 guest
	et = (EditText)this.findViewById(R.id.et1);
	et.setText(Integer.toString(name));
	

	Button bt1 = (Button)this.findViewById(R.id.bto1);
	bt1.setOnClickListener(this);
	Button bt2 = (Button)this.findViewById(R.id.bto2);
	bt2.setOnClickListener(this);
	
}

@Override
	protected void onPause() {
		// TODO Auto-generated method stub
	super.onPause();
	SharedPreferences pref = getSharedPreferences("Pref", 0);
	SharedPreferences.Editor edit = pref.edit();
	if(val==1){
	edit.putInt("No", Integer.parseInt(et.getText().toString()));
	}
	edit.commit();
	}
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	switch(arg0.getId()){
	case R.id.bto1:
		val=1;
		finish();
		break;
	case R.id.bto2:
		val=0;
		finish();
		break;
	}
}
}
