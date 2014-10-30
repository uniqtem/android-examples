package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ExAdapterView extends Activity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        
        //1. 데이터 만들기
        ArrayList<String> arrayItem = new ArrayList<String>();
        arrayItem.add("ListView");
        arrayItem.add("GridView");
        arrayItem.add("Spinner");
        arrayItem.add("Gallery");
        arrayItem.add("CustomGrid");
        arrayItem.add("CustomList");
        
        //2. Adapter 만들기
        ArrayAdapter<String> adapter
        	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayItem);
        
        //3. Adapter 와 AdapterView 연결
        ListView list = (ListView)findViewById(R.id.list1);
        list.setAdapter(adapter);
        
        //4. 이벤트리스너 등록
        list.setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Intent intent;
		switch(position){
		case 0:
			intent = new Intent(this, ExListView.class);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(this, ExGridView.class);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(this, ExSpinner.class);
			startActivity(intent);
			break;
		case 3:
			intent = new Intent(this, ExGallery.class);
			startActivity(intent);
			break;
		case 4:
			intent = new Intent(this, CustomGrid.class);
			startActivity(intent);
			break;
		case 5:
			intent = new Intent(this, CustomList.class);
			startActivity(intent);
			break;
		}
	}
}