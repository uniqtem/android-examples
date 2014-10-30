package ks.appcenter.exadapterview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ConnectedActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.connected);
        
        TextView textview1 = (TextView)findViewById(R.id.textview1);
        textview1.setText(getIntent().getIntExtra("Param1", 0)+"번째 아이템");
    }

}
