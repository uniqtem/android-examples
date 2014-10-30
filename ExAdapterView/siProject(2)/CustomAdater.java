package SiProject.rog;

import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomAdater extends BaseAdapter {
	Context context;
	int itemlayout; 
	ArrayList<MyItem> arrayItems;
	LayoutInflater inflater;
	public CustomAdater(Context c, int sublayout, ArrayList<MyItem> list){
		this.context=c;
		this.itemlayout=sublayout;
		this.arrayItems=list;
		
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return arrayItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//final int pos = position;
		//if(convertView == null){
			convertView = inflater.inflate(itemlayout, parent,false);
		//}
		if(position==0 || position==4){
			TextView text = (TextView)convertView.findViewById(R.id.itemtext1);
			text.setTextSize((float) 10.0);
	     	text.setText(arrayItems.get(position).text);
	     	//LinearLayout lv = (LinearLayout)convertView.findViewById(R.id.linear);
			//lv.setBackgroundColor(444444);
		}
		else{
		ImageView img = (ImageView)convertView.findViewById(R.id.itemimage1);
		//img.setImageResource(arrayItems.get(position).image);
		img.setImageResource(arrayItems.get(position).image);
		TextView text = (TextView)convertView.findViewById(R.id.itemtext1);
     	text.setText(arrayItems.get(position).text);
			
		TextView text1 = (TextView)convertView.findViewById(R.id.itemtext2);
		text1.setText(arrayItems.get(position).text2);
		}
		return convertView;
	}

}
