package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
import android.widget.Toast;

public class ExGallery extends Activity implements OnItemSelectedListener, OnItemClickListener {
	ArrayList<String> arrayItems;
	ArrayAdapter<String> adapter;
	Gallery gallery1;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        
        
        //1. 데이터 생성
        //String[] arrayItems = {"item1", "item2", "item3", "item4"}; 
        arrayItems = new ArrayList<String>();
        arrayItems.add("item0");
        arrayItems.add("item1");
        arrayItems.add("item2");
        arrayItems.add("item3");
        
        //2. 어댑터 생성
        adapter 
        	= new ArrayAdapter<String>(this, android.R.layout.simple_gallery_item, arrayItems);
        
        //3. 어댑터와 어댑터뷰 연결
        gallery1 = (Gallery) findViewById(R.id.gallery1);
        gallery1.setAdapter(adapter);
        
        //4. 이벤트리스터 등록
        //gallery1.setOnItemSelectedListener(this);
        gallery1.setOnItemClickListener(this);
                
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arg2 + "th item is selected", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ConnectedActivity.class);
		intent.putExtra("Param1", arg2);
		startActivity(intent);
	}

}