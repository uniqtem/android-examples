package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class ExGridView extends Activity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        
        
        //1. 데이터 생성
        //String[] arrayItems = {"item0", "item1", "item2", "item3"}; 
        ArrayList<String> arrayItems = new ArrayList<String>();
        arrayItems.add("item0");
        arrayItems.add("item1");
        arrayItems.add("item2");
        arrayItems.add("item3");
        
        //2. 어댑터 생성
        ArrayAdapter<String> adapter 
        	= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayItems);
        
        //3. 어댑터와 어댑터뷰 연결
        GridView grid1 = (GridView) findViewById(R.id.grid1);
        grid1.setAdapter(adapter);
        
        //4. 이벤트리스터 등록
        grid1.setOnItemClickListener(this);
                
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(ExGridView.this, ConnectedActivity.class);
		intent.putExtra("Param1", arg2);
		startActivity(intent);	
	}
}