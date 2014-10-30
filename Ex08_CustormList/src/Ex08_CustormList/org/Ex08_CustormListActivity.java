package Ex08_CustormList.org;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Ex08_CustormListActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayList<MyItem> arrayItems = new ArrayList<MyItem>();
		arrayItems.add(new MyItem(R.drawable.icon, "item4", "item22"));
		arrayItems.add(new MyItem(R.drawable.icon, "item5", "item33"));

		CustomAdater adapter = new CustomAdater(this, R.layout.itemlayout,
				arrayItems);

		ListView list = (ListView) this.findViewById(R.id.listview);
		list.setAdapter(adapter);

	}
}