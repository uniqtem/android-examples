package Ex08_AdapterView.org;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPrint extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myprint);

		Intent intent = getIntent();

		int val = intent.getIntExtra("param1", 0);

		TextView text = (TextView) this.findViewById(R.id.text1print);
		String s = Integer.toString(val);
		text.setText(s);

		ImageView view = (ImageView) this.findViewById(R.id.image1print);
		view.setImageResource(val);

	}
}
