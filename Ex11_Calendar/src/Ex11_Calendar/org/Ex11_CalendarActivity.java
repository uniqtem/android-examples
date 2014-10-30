package Ex11_Calendar.org;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Ex11_CalendarActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	ArrayList<String> mItems;
	ArrayAdapter<String> adapter;
	TextView textYear;
	TextView textMon;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		textYear = (TextView) this.findViewById(R.id.edit1);
		textMon = (TextView) this.findViewById(R.id.edit2);

		mItems = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mItems);

		GridView gird = (GridView) this.findViewById(R.id.grid1);
		gird.setAdapter(adapter);
		gird.setOnItemClickListener(this);

		Date date = new Date();// 오늘에 날짜를 세팅 해준다.
		int year = date.getYear() + 1900;
		int mon = date.getMonth() + 1;
		textYear.setText(year + "");
		textMon.setText(mon + "");

		fillDate(year, mon);

		Button btnmove = (Button) this.findViewById(R.id.bt1);
		btnmove.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if (arg0.getId() == R.id.bt1) {
			int year = Integer.parseInt(textYear.getText().toString());
			int mon = Integer.parseInt(textMon.getText().toString());
			fillDate(year, mon);
		}

	}

	private void fillDate(int year, int mon) {
		mItems.clear();

		mItems.add("일");
		mItems.add("월");
		mItems.add("화");
		mItems.add("수");
		mItems.add("목");
		mItems.add("금");
		mItems.add("토");

		Date current = new Date(year - 1900, mon - 1, 1);
		int day = current.getDay(); // 요일도 int로 저장.

		for (int i = 0; i < day; i++) {
			mItems.add("");
		}

		current.setDate(32);// 32일까지 입력하면 1일로 바꿔준다.
		int last = 32 - current.getDate();

		for (int i = 1; i <= last; i++) {
			mItems.add(i + "");
		}
		adapter.notifyDataSetChanged();

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if (mItems.get(arg2).equals("")) {
			;
		} else {
			Intent intent = new Intent(this, ExToday.class);
			intent.putExtra("Param1", textYear.getText().toString() + "/"
					+ textMon.getText().toString() + "/" + mItems.get(arg2));
			startActivity(intent);
		}
	}
}
