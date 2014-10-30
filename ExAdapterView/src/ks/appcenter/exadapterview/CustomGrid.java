package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class CustomGrid extends Activity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        
        ArrayList<Integer> arrayItem = new ArrayList<Integer>();
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        arrayItem.add(R.drawable.icon);
        
        ImageAdapter adapter
        	= new ImageAdapter(this, arrayItem);
                
        GridView grid = (GridView)findViewById(R.id.grid1);
        grid.setAdapter(adapter);     
        
        grid.setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, ConnectedActivity.class);
		intent.putExtra("Param1", arg2);
		startActivity(intent);	
	}
}

