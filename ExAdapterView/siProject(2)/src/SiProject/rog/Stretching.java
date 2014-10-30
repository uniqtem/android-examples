package SiProject.rog;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Stretching extends Activity implements OnItemClickListener {
	ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stretching);
		ArrayList<MyItem> arrayItems = new ArrayList<MyItem>();

		arrayItems.add(new MyItem(R.drawable.notice, "  온가족이 함께하는 스트레칭",
				"   각각 3~5회 반복합니다..."));
		arrayItems.add(new MyItem(R.drawable.notice, "  척추 튼튼 스트레칭",
				"   TV 볼 때도 건강을 챙기세요..."));
		arrayItems.add(new MyItem(R.drawable.notice, "  의자 스트레칭",
				"   학교에서나 직장에서 쉽고 간편하게 할수 있는..."));
		arrayItems.add(new MyItem(R.drawable.notice, "  파워 스트레칭",
				"   전신 스트레칭 방법..."));

		CustomAdater adapter = new CustomAdater(this, R.layout.itemlayout,
				arrayItems);

		ListView list = (ListView) this.findViewById(R.id.strelist1);

		list.setAdapter(adapter);
		list.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Intent intent;
		switch(arg2){
		case 0:
			timeThread();
			intent = new Intent(Stretching.this, Str1.class);
			startActivity(intent);
			break;
		case 1:
			timeThread();
			intent = new Intent(Stretching.this, Str2.class);
			startActivity(intent);
			break;
		case 2:
			timeThread();
			intent = new Intent(Stretching.this, Str3.class);
			startActivity(intent);
			break;
		case 3:
			timeThread();
			intent = new Intent(Stretching.this, Str4.class);
			startActivity(intent);
			break;
		}
		
	}
public void timeThread(){
		
		
		dialog = new ProgressDialog(this);
		dialog = new ProgressDialog(this);
		dialog.setTitle("Wait...");
		dialog.setMessage("Please wait while loading...");
		dialog.setIndeterminate(true);
		dialog.setCancelable(true);
		dialog.show();
		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (Throwable ex) {
					ex.printStackTrace();
				}
				dialog.dismiss();
			}
		}).start();	
	}
}
