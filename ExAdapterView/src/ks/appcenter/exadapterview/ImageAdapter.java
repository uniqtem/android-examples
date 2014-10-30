package ks.appcenter.exadapterview;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<Integer> mArrayItem;
	
	public ImageAdapter(Context c, ArrayList<Integer> arrayItem){
		mContext = c;
		mArrayItem = arrayItem;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mArrayItem.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mArrayItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageview;
		
		if(convertView == null)
		{
			imageview = new ImageView(mContext);
			//imageview.setLayoutParams(new GridView.LayoutParams(45, 45));
			//imageview.setAdjustViewBounds(false);
			imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageview.setPadding(8, 8, 8, 8);
		}
		else{
			imageview = (ImageView) convertView;
		}
		
		imageview.setImageResource(mArrayItem.get(position));
			
		return imageview;
	}
	
}