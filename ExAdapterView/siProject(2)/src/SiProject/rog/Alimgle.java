package SiProject.rog;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Alimgle extends Activity implements OnClickListener {
	EditText et;
	int val;
	SharedPreferences pref;
	String name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	super.onCreate(savedInstanceState);
	setContentView(R.layout.interfacesetting2);
	TextView tv = (TextView)this.findViewById(R.id.tv1);
	tv.setText(" 알림글을 입력하세요.                                   ");
	
	pref = getSharedPreferences("PrefTest",0);
    name = pref.getString("Name", "고만해라 마이 했다이가...");//name을 못읽었을때 guest
	
	et = (EditText)this.findViewById(R.id.et1);
	et.setText(name);

	Intent i = new Intent(Alimgle.this, ScreenReceiver.class);
	i.putExtra("gle", name);

	//name = pref.getString("Name", "고만해라 마이 했다이가...");
	

	Button bt1 = (Button)this.findViewById(R.id.bto1);
	bt1.setOnClickListener(this);
	Button bt2 = (Button)this.findViewById(R.id.bto2);
	bt2.setOnClickListener(this);
	
}
@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		pref = getSharedPreferences("PrefTest", 0);
    	SharedPreferences.Editor edit = pref.edit();
    	if(val==1){
    	edit.putString("Name", et.getText().toString());
    	
    	}
    	edit.commit();
	}

public String gle(String a){
	String name1 = a;
	
	
	return name1;
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
