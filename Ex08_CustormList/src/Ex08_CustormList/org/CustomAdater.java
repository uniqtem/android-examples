package Ex08_CustormList.org;

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

public class CustomAdater extends BaseAdapter {
	Context context;
	int itemlayout;
	ArrayList<MyItem> arrayItems;
	LayoutInflater inflater;

	public CustomAdater(Context c, int sublayout, ArrayList<MyItem> list) {
		this.context = c;
		this.itemlayout = sublayout;
		this.arrayItems = list;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		if (convertView == null) {
			convertView = inflater.inflate(itemlayout, parent, false);
		}

		ImageView img = (ImageView) convertView.findViewById(R.id.itemimage1);
		// img.setImageResource(arrayItems.get(position).image);
		img.setImageResource(arrayItems.get(position).image);

		TextView text = (TextView) convertView.findViewById(R.id.itemtext1);
		text.setText(arrayItems.get(position).text);
		text.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, Integer.toString(pos),
						Toast.LENGTH_LONG).show();
				Intent intent = new Intent(context, MyPrint.class);
				intent.putExtra("param1", Integer.toString(pos));
				context.startActivity(intent);
			}
		});

		TextView text1 = (TextView) convertView.findViewById(R.id.itemtext2);
		text1.setText(arrayItems.get(position).text2);

		Button btn = (Button) convertView.findViewById(R.id.itembutton1);
		btn.setText("Delete");
		btn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				arrayItems.remove(pos);
				notifyDataSetChanged();
			}

		});

		return convertView;
	}

}
