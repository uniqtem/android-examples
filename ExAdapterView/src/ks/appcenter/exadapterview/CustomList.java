package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomList extends Activity implements OnClickListener {
	ArrayList<MyItem> arrayItems;
	CustomAdapter adapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customlist);
        
        //create data - String[], ArrayList<T>
        arrayItems = new ArrayList<MyItem>();
        arrayItems.add(new MyItem(R.drawable.icon, "item0"));
        arrayItems.add(new MyItem(R.drawable.icon, "item1"));
        arrayItems.add(new MyItem(R.drawable.icon, "item2"));
        arrayItems.add(new MyItem(R.drawable.icon, "item3"));
        
        //create adapter - ArrayAdapter<T>
        adapter = new CustomAdapter(this, R.layout.itemlayout, arrayItems);
        
        //connect adapter with ListView - setAdapter(adapter)
        ListView list1 = (ListView) findViewById(R.id.list1);
        list1.setAdapter(adapter);
        
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText edit1 = (EditText)findViewById(R.id.edit1);
		arrayItems.add(new MyItem(R.drawable.icon, edit1.getText().toString()));
		adapter.notifyDataSetChanged();
		edit1.setText("");
	}
}

