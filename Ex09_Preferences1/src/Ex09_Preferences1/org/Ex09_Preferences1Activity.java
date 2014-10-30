package Ex09_Preferences1.org;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Ex09_Preferences1Activity extends Activity implements
		OnClickListener {
	EditText text1;
	EditText text2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		text1 = (EditText) this.findViewById(R.id.edittext1);
		text2 = (EditText) this.findViewById(R.id.edittext2);

		SharedPreferences pref = getSharedPreferences("PrefTest", 0);
		String name = pref.getString("Name", "Guest");// name을 못읽었을때 guest
		int no = pref.getInt("No", 0);

		text1.setText(name);
		text2.setText(no + "");

		Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(this);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		SharedPreferences pref = getSharedPreferences("PrefTest", 0);
		SharedPreferences.Editor edit = pref.edit();

		edit.putString("Name", text1.getText().toString());
		edit.putInt("No", Integer.parseInt(text2.getText().toString()));
		edit.commit();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, Setting.class);
		startActivity(intent);

	}
}