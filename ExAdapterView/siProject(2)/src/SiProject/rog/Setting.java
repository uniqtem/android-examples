package SiProject.rog;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Setting extends Activity {
	//static final String[] body = { "설명서", "시간 설정", "사용량", "알림글", "알림형식", "종료"
//};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settingn);

		//ArrayAdapter adapter = new ArrayAdapter(this,
		//		android.R.layout.simple_list_item_1, body);
		//final ListView list = (ListView) this.findViewById(R.id.lv1);
		ArrayList<MyItem> arrayItems=new ArrayList<MyItem>();

		arrayItems.add(new MyItem(R.drawable.a1,"  사용량","   Smart phone 이용시간"));
	
		arrayItems.add(new MyItem(R.drawable.a2,"  시간 설정","   일정 시간 사용시 알림"));
		arrayItems.add(new MyItem(R.drawable.a3,"  알림글","   원하는 알림글 설정"));
		arrayItems.add(new MyItem(R.drawable.a4,"  알림 형식","   사용중 알림을 나타내는 형식"));

		arrayItems.add(new MyItem(R.drawable.a5,"  도움말","   프로그램에 대한 도움"));
		arrayItems.add(new MyItem(R.drawable.a6,"  버젼 정보","   올스 Ver 1.0.0"));
	
		CustomAdater adapter = new CustomAdater(this,R.layout.itemlayout,arrayItems);
		
		ListView list = (ListView)this.findViewById(R.id.lv1);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			
		
			
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent;
				switch(arg2){
				case 0: //사용량
					intent = new Intent(Setting.this, Today.class);
					startActivity(intent);
					break;
				case 1: // 시간성정
					intent = new Intent(Setting.this, Times.class);
					startActivity(intent);
					break;
				case 2: // 알림글
					//SubMenu sub=menu.
					intent = new Intent(Setting.this, Alimgle.class);
					startActivity(intent);
				break;
				case 3: // 알림 형식
					intent = new Intent(Setting.this, Alimhung.class);
					startActivity(intent);
					break;
				case 4: // 도움말
					break;
				case 5: // 버젼 정보
					break;
				case 6:
					break;
				}
				
				
			}
		});
		
		/*ArrayList<MyItem> arrayItems2=new ArrayList<MyItem>();
	
		
		CustomAdater adapter2 = new CustomAdater(this,R.layout.itemlayout,arrayItems2);
		
		ListView list2 = (ListView)this.findViewById(R.id.lv2);
		list2.setAdapter(adapter2);
		list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			}
		});
		
		ArrayList<MyItem> arrayItems3 = new ArrayList<MyItem>();

	
		
		CustomAdater adapter3 = new CustomAdater(this,R.layout.itemlayout,arrayItems3);
		
		ListView list3 = (ListView)this.findViewById(R.id.lv3);
		list3.setAdapter(adapter3);
		list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			}
		});*/
		
		
	}

}
