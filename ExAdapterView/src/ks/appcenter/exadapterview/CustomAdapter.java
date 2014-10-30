package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	int layout;
	ArrayList<MyItem> arrayItems;
	
	LayoutInflater inflater;	
	
	CustomAdapter(Context context, int alayout, ArrayList<MyItem> aItems){
		mContext = context;
		layout = alayout;
		arrayItems = aItems;
		
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayItems.size();
	}

	@Override
	public Object getItem(int arg0) { //arg0 - position
		// TODO Auto-generated method stub
		return arrayItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) { //arg0 - position
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) { //arg0-position, arg1-itemLayout, agr2-listview
		// TODO Auto-generated method stub
		final int pos = position;
		
		if(convertView == null){
			convertView = inflater.inflate(layout, parent, false);
		}
		
		ImageView img = (ImageView)convertView.findViewById(R.id.itemimg1);
		img.setImageResource(arrayItems.get(position).icon);
		
		TextView text = (TextView)convertView.findViewById(R.id.itemtext1);
		text.setText(arrayItems.get(position).name);
		text.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(mContext, pos+"", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(mContext, ConnectedActivity.class);
				intent.putExtra("Param1", pos);
				mContext.startActivity(intent);				
			}
		});
		
		Button btn = (Button)convertView.findViewById(R.id.itembtn1);
		btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				arrayItems.remove(pos);
				notifyDataSetChanged();
			}
		
		});
		
		return convertView;
	}
}
