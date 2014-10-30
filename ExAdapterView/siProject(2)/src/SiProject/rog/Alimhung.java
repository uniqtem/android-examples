package SiProject.rog;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Alimhung extends Activity implements OnCheckedChangeListener,
		OnClickListener {
	String powerStatus;
	RadioButton rt1,rt2,rt3;
	int val;
	int count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.interfacesetting3);

		SharedPreferences pref = getSharedPreferences("Prefee",0);
	    val = pref.getInt("how", 0);//name을 못읽었을때 guest
	    
		
		RadioGroup rg = (RadioGroup)this.findViewById(R.id.radiogroup1);
		rt1 = (RadioButton)this.findViewById(R.id.radio1);
		rt2 = (RadioButton)this.findViewById(R.id.radio2);
		rt3 = (RadioButton)this.findViewById(R.id.radio3);
		
		switch(val){
		case 1:
			rt1.setChecked(true);
			break;
		case 2:
			rt2.setChecked(true);
			break;
		case 3:
			rt3.setChecked(true);
			break;
		}
		Button bto1 = (Button) this.findViewById(R.id.bto01);
		bto1.setOnClickListener(this);

		
		rg.setOnCheckedChangeListener(this);

	}
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		SharedPreferences pref = getSharedPreferences("Prefee", 0);
		SharedPreferences.Editor edit = pref.edit();
			
		    
		
		    if(rt1.isChecked()==true){
				edit.putInt("how", 1);	    
			}

			if(rt2.isChecked()==true){
				edit.putInt("how", 2);	    
			}


			if(rt3.isChecked()==true){
				edit.putInt("how", 3);	    
			}
			
			edit.commit();
	
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bto01:
			finish();
			break;

		}

	}
}
