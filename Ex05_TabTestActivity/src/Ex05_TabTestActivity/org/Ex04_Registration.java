package Ex05_TabTestActivity.org;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Ex04_Registration extends Activity implements OnClickListener, OnCheckedChangeListener {
    
	String sex="남자";
	String hap;
	
	/** Called when the activity is first created. */
    @Override
  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        
        
        Button button1 = (Button)this.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        
        RadioGroup rg = (RadioGroup)this.findViewById(R.id.sex);
        rg.setOnCheckedChangeListener(this);
       
       
        
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1){
			//Toast.makeText(this, "추가되었습니다.", Toast.LENGTH_SHORT).show();
			 EditText ak = (EditText)this.findViewById(R.id.name);
		     hap=ak.getText().toString();
		     ak = (EditText)this.findViewById(R.id.sosok);
		     hap=hap+" "+ak.getText().toString();
		     ak = (EditText)this.findViewById(R.id.number);
		     hap=hap+" "+ak.getText().toString();
		     ak = (EditText)this.findViewById(R.id.phonenumber);
		     hap=hap+" "+ak.getText().toString();
		     ak = (EditText)this.findViewById(R.id.email);
		     hap=hap+" "+ak.getText().toString();
		     hap=hap+" "+sex;
			
			Toast.makeText(this, hap, Toast.LENGTH_SHORT).show();
			
		}
		
	}

	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case R.id.sex1:
			sex="남자";
			break;
		case R.id.sex2:
			sex="여자";
			break;
		}
		
	}
}
