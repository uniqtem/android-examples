package ksappcenter.example.excalendar;

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

public class ExCalendar extends Activity implements OnClickListener, OnItemClickListener {
	ArrayList<String> mItems;
	ArrayAdapter<String> adapter;
	TextView textYear;
	TextView textMon;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excalendar);
        
        textYear = (TextView)findViewById(R.id.textYear);
        textMon = (TextView)findViewById(R.id.textMon);

        
        mItems = new ArrayList<String>();

        adapter = 
        		new ArrayAdapter<String>(this, 
        				android.R.layout.simple_list_item_1, 
        				mItems);
        
        GridView grid = (GridView)findViewById(R.id.grid1);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(this);
        
        Date date = new Date();
        int year = date.getYear()+1900;
        int mon = date.getMonth()+1;
        textYear.setText(year+"");
        textMon.setText(Integer.toString(mon));
        fillDate(year, mon);
        
        Button btnmove = (Button)findViewById(R.id.btnmove);
        btnmove.setOnClickListener(this);
    }
    private void fillDate(int year, int mon){
    	mItems.clear();
    	
    	mItems.add("일");
    	mItems.add("월");
    	mItems.add("화");
    	mItems.add("수");
    	mItems.add("목");
    	mItems.add("금");
    	mItems.add("토");
    	
    	Date current = new Date(year-1900, mon-1, 1);
    	int day = current.getDay();
    	
    	for(int i = 0; i < day; i++){
    		mItems.add("");
    	}
    	
    	current.setDate(32);
    	int last = 32 - current.getDate();
    	
    	for(int i = 1; i <= last ; i++){
    		mItems.add(i+"");
    	}
    	
    	adapter.notifyDataSetChanged();
    }
    
//    private void fillDate(int year, int mon){
//		mItems.clear();
//		
//		int n=0;
//        
//        mItems.add(n++, "일");
//        mItems.add(n++, "월");
//        mItems.add(n++, "화");
//        mItems.add(n++, "수");
//        mItems.add(n++, "목");
//        mItems.add(n++, "금");
//        mItems.add(n++, "토");
//        
//        
//        
//		Date date = new Date(year-1900, mon-1, 1);
//        int day = date.getDay();
//        
//        date.setDate(32);
//        int last = 32-date.getDate(); 
//        
//        textYear.setText(year+"");
//        textMon.setText(mon+"");
//        
//        for(int i=0; i<day; i++){
//        	mItems.add(n++, "");
//        	}
//        for(int i=1; i<=last; i++){
//        	mItems.add(n++, i+"");
//        }
//        
//        adapter.notifyDataSetChanged();
//	}
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnmove:
			//int year = Integer.parseInt(textYear.getText().toString());
			//int mon = Integer.parseInt(textMon.getText().toString());
			String sYear = textYear.getText().toString();
			String sMon = textMon.getText().toString();
			int year = Integer.valueOf(sYear);
			int mon = Integer.valueOf(sMon);
			fillDate(year, mon);
			break;
		}
	}
	
		
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		if(mItems.get(position).equals("")){
			;
		}else{		
			Intent intent = new Intent(this, ExToday.class);
			intent.putExtra("Param1", 
					textYear.getText().toString()+"/" +	
					textMon.getText().toString()+"/"+
					mItems.get(position));
			startActivity(intent);
		}
	}
}