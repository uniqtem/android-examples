package SiProject.rog;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdater2 extends BaseAdapter {
	Context context;
	int itemlayout; 
	ArrayList<MyItem2> arrayItems;
	LayoutInflater inflater;
	public CustomAdater2(Context c, int sublayout, ArrayList<MyItem2> list){
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
		final int pos = position;
		
		if(convertView == null){
			convertView = inflater.inflate(itemlayout, parent,false);
		}
		
		ImageView img = (ImageView)convertView.findViewById(R.id.image1);
		//img.setImageResource(arrayItems.get(position).image);
		//img.setImageResource(R.drawable.icon);//초기화
		try{
			InputStream is = new URL(arrayItems.get(position).coverImage).openStream();
			Bitmap bit = BitmapFactory.decodeStream(is); // Factory 비트맵 다운로드
			img.setImageBitmap(bit);
			is.close();
		}
		catch(Exception e){
			img.setImageResource(R.drawable.icon);
		}
		
		TextView text1 = (TextView)convertView.findViewById(R.id.text1);
		text1.setText("작성자 :"+arrayItems.get(position).author
				);
		
		TextView text2 = (TextView)convertView.findViewById(R.id.text2);
		String aa = arrayItems.get(position).title;
		String ab,ac;
		ab = aa.replaceAll("<b>", "");
		//ab = aa.replaceAll("</b>", "");
		ac = ab.replaceAll("</b>", "");
		
		text2.setText("제목 : "+ac);
		
		TextView text3 = (TextView)convertView.findViewById(R.id.text3);
		text3.setText("출처 : "+arrayItems.get(position).pubdate);
						
		return convertView;
	}

}
