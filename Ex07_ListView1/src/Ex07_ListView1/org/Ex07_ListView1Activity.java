package Ex07_ListView1.org;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class Ex07_ListView1Activity extends Activity implements
		OnItemClickListener, OnClickListener {
	/** Called when the activity is first created. */
	ArrayList<String> s;
	ListView lv;
	GridView grid;
	ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		s = new ArrayList<String>();
		s.add("itemt0");
		s.add("itemt1");

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, s);

		lv = (ListView) this.findViewById(R.id.listview);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);

		grid = (GridView) this.findViewById(R.id.grid1);
		grid.setAdapter(adapter);
		grid.setOnItemClickListener(this);

		Button bt = (Button) this.findViewById(R.id.button1);
		bt.setOnClickListener(this);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.button1) {
			EditText et = (EditText) this.findViewById(R.id.edittext1);
			String s11 = et.getText().toString();
			s.add(s11);
			//onPause();
			// adapter.notifyDataSetChanged();
			// lv.setAdapter(adapter);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		// Toast.makeText(this, s.get(arg2), Toast.LENGTH_LONG).show();

		Intent intent = new Intent(this, MyPrint.class);
		intent.putExtra("param1", s.get(arg2));
		startActivity(intent);
	}

}