package Ex06_plicitIntent.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Hello extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
        
        Button b1 = (Button)this.findViewById(R.id.bbuuton1);
        b1.setOnClickListener(this);
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.bbuuton1){
			finish();
		}
		
	}
}
