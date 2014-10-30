package Ex08_CustormList.org;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyPrint extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myprint);
		
		Intent intent = getIntent();
		String s = intent.getStringExtra("param1");
		
		TextView text = (TextView)this.findViewById(R.id.text1print);
		text.setText(s);
		
	}

}
