package Ex14_Daumapi.org;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Ex14_DaumapiActivity extends Activity implements OnClickListener,
		OnItemClickListener {
	ArrayList<MyItem> mItems;
	CustomAdater mAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mItems = new ArrayList<MyItem>();

		mAdapter = new CustomAdater(this, R.layout.item, mItems);
		ListView list = (ListView) this.findViewById(R.id.list);
		list.setAdapter(mAdapter);
		list.setOnItemClickListener(this);

		Button btn = (Button) this.findViewById(R.id.button1);
		btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {

		case R.id.button1:
			EditText edit = (EditText) this.findViewById(R.id.editname);
			String mName = edit.getText().toString();
			if (mName != null) {
				mItems.clear();
				String url = "http://apis.daum.net/search/book?q=" + mName
						+ "&apikey=af0374a169c37f9d94ee8f47da127252d0d5e975";
				JXMLParser jxml = new JXMLParser(this);
				String xml = jxml.downloadURL(url);
				jxml.parseXML(xml, mItems);

				// String xml = downloadURL(url);
				// parseXML(xml);
				mAdapter.notifyDataSetChanged();

			}

			break;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, BookLink.class);
		intent.putExtra("param1", mItems.get(arg2).booklink);
		startActivity(intent);

	}
}