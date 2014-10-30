package Ex06_plicitIntent.org;

import java.io.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ex06_plicitIntentActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button1 = (Button)this.findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button)this.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button)this.findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button)this.findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent;
		switch(arg0.getId()){
		case R.id.button1:
			intent = new Intent(this, Hello.class);
			startActivity(intent);
		break;
		case R.id.button2:
			intent = new Intent(this, Ex04_Registration.class);
			startActivity(intent);
		break;
		case R.id.button3:
			intent = new Intent(this, Ex05_Calulator.class);
			startActivity(intent);
		break;
		case R.id.button4:
			//screen
			finish();
			break;
		
		
		}
		
	}

}