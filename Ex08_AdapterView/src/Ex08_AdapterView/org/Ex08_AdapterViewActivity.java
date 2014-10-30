package Ex08_AdapterView.org;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Ex08_AdapterViewActivity extends Activity implements
		OnClickListener, OnItemClickListener {

	ArrayList<Integer> arrayItem;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview);

		arrayItem = new ArrayList<Integer>();// 单捞磐 积己
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);
		arrayItem.add(R.drawable.icon);

		ImageAdapter adapter = new ImageAdapter(this, arrayItem);// Adapter 积己

		GridView grid = (GridView) this.findViewById(R.id.grid1);// 楷搬
		grid.setAdapter(adapter);

		// grid.setOnClickListener(this);
		grid.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MyPrint.class);
		intent.putExtra("param1", arrayItem.get(arg2));
		startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}