package Ex07_Spinner.org;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Ex07_SpinnerActivity extends Activity implements
		OnItemSelectedListener {
	ArrayList<String> arraylist;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		arraylist = new ArrayList<String>();
		arraylist.add("data0");
		arraylist.add("data1");
		arraylist.add("data2");
		arraylist.add("data3");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, arraylist);

		Spinner sp = (Spinner) this.findViewById(R.id.spinner);
		sp.setPrompt("°ñ¶óºÁ"); // ½ºÇÇ³Ê Á¦¸ñ
		sp.setAdapter(adapter);
		sp.setOnItemSelectedListener(this);

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arraylist.get(arg2), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}