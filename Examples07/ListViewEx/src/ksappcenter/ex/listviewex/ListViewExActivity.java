package ksappcenter.ex.listviewex;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewExActivity extends Activity implements OnItemClickListener, OnClickListener {
	ArrayList<String> arrayList;
	ArrayAdapter<String> adapter;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //String[] s = {"item0", "item1", "item2", "item3", "item4", "item5"};
        arrayList = new ArrayList<String>();
        arrayList.add("item0");
        arrayList.add("item1");
        arrayList.add("item2");
        arrayList.add("item3");
        arrayList.add("item4");
        arrayList.add("item5");
        
        adapter = new ArrayAdapter<String>(
        		this,
        		android.R.layout.simple_list_item_1,
        		arrayList);
        
//        ListView list = (ListView) findViewById(R.id.list1);
//        list.setAdapter(adapter); 
//        list.setOnItemClickListener(this);
        
      GridView grid = (GridView)findViewById(R.id.grid1);
      grid.setAdapter(adapter);
      
      grid.setOnItemClickListener(this);  
        
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		//Toast.makeText(this, s.get(arg2), Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, MyPrint.class);
		intent.putExtra("param1", arrayList.get(arg2));
		startActivity(intent);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.btn1:
			EditText edit = (EditText)findViewById(R.id.edit1);
			String s = edit.getText().toString();
			arrayList.add(s);
			adapter.notifyDataSetChanged();
			break;
		}
	}

}