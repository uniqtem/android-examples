package Ex05_CustomTab.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Ex05_CustomTabActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b1=(Button)this.findViewById(R.id.button1);
        b1.setOnClickListener(this);
        Button b2=(Button)this.findViewById(R.id.button2);
        b2.setOnClickListener(this);
        Button b3=(Button)this.findViewById(R.id.button3);
        b3.setOnClickListener(this);
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		LinearLayout a1 = (LinearLayout)this.findViewById(R.id.number1);
		a1.setVisibility(View.INVISIBLE);
		LinearLayout a2 = (LinearLayout)this.findViewById(R.id.number2);
		a2.setVisibility(View.INVISIBLE);
		LinearLayout a3 = (LinearLayout)this.findViewById(R.id.number3);
		a3.setVisibility(View.INVISIBLE);
		
		switch(arg0.getId()){
		case R.id.button1:
			a1.setVisibility(View.VISIBLE);
			break;
		case R.id.button2:
			a2.setVisibility(View.VISIBLE);
			break;
		case R.id.button3:
			a3.setVisibility(View.VISIBLE);
			break;
		}
		
	}
}