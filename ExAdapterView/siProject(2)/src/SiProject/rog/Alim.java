package SiProject.rog;

import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Alim extends Activity {
	//static final String[] body = { "스마트폰 이용시 눈 건강법", "거북목증후군", "손가락 손목 통증",
	//		"눈 건조증 유발", "항문 질환"};
	int mLastAction;
	ProgressDialog dialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alim);

		ArrayList<MyItem> arrayItems=new ArrayList<MyItem>();
		
		arrayItems.add(new MyItem(R.drawable.a1,"  스마트폰 중독 자가진단","   심각한 스마트폰 중독을 예방합시다..."));
		arrayItems.add(new MyItem(R.drawable.a2,"  올바른 스마트폰 사용법","   스마트폰을 바르게 사용합시다..."));
        arrayItems.add(new MyItem(R.drawable.a3,"  눈 건강법","   7가지 건강법..."));
        arrayItems.add(new MyItem(R.drawable.a4,"  눈에 좋은 음식","   눈이 생명입니다..."));
        arrayItems.add(new MyItem(R.drawable.a5,"  스트래칭 방법","   함께하는 스트래칭..."));
        arrayItems.add(new MyItem(R.drawable.a6,"  스트래칭 동영상(daum)","   함께하는 스트래칭..."));
        
        CustomAdater adapter = new CustomAdater(this,R.layout.itemlayout,arrayItems); 
        ListView list = (ListView)this.findViewById(R.id.listview1);
        list.setAdapter(adapter);  
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent;
				AlertDialog.Builder d = new AlertDialog.Builder(Alim.this);
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0:
					intent = new Intent(Alim.this, Jagates.class);
					startActivity(intent);
					break;
				case 1:
					d.setTitle("스마트폰 올바른 사용법");
					d.setMessage("1.어색하고 힘들더라도 스마트폰을 시선과 같은 높이로 올린다.\n\n"
							+ "2.액정과 눈의 거리를 30cm 이상 유지한다.\n\n" + "3.한 손가락만 사용하는 것을 자제한다.\n\n"
							+ "4.사용 중 손이 저리고 아프면 일단 중단하고 따뜻한 물에 손을 담가 5~10분 정도 쥐었다 펴주기를 반복한다.\n\n"
							+ "5.장시간 사용할 경우 목을 가볍게 돌리거나 손목 돌리기,털기,깍지 끼고 앞으로 뻗기 등 스트레칭으로 틈틈이 근육을 풀어준다.\n\n");

					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				case 2:
					d.setTitle("스마트폰 이용시 눈 건강법");
					d.setMessage("1.30cm 이상 떨어져서 본다.\n\n"
							+ "2.1시간 이상 연속 사용을 피한다.\n\n" + "3.주기적으로 먼 곳을 응시한다\n\n"
							+ "4.장시간 사용할 경우 눈 깜빡임을 의식적으로 한다.\n\n"
							+ "5.눕거나 엎드리는 자세는 피한다.\n\n"
							+ "6.눈이 피로하다고 식염수 등을 함부로 넣지 않는다.\n\n"
							+ "7.어두운 곳을 피하고 되도록 밝은 곳에서 사용한다.");
					
					d.setNegativeButton("닫기",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									// finish();
								}
							});
					d.show();
					break;
				case 3:
					Toast.makeText(Alim.this, "Wi-Fi를 추천드립니다.!! Wi-Fi가 아무래도 빠르겠죠??", Toast.LENGTH_SHORT).show();
					timeThread();
					intent = new Intent(Alim.this, Str11.class);
					startActivity(intent);
					break;
				case 4:
					Toast.makeText(Alim.this, "Wi-Fi를 추천드립니다.!! Wi-Fi가 아무래도 빠르겠죠??", Toast.LENGTH_SHORT).show();
					intent = new Intent(Alim.this, Stretching.class);
					startActivity(intent);
					break;
				case 5:			
					Toast.makeText(Alim.this, "Wi-Fi를 추천드립니다.!! Wi-Fi가 아무래도 빠르겠죠??", Toast.LENGTH_SHORT).show();
					Intent intent2 = new Intent(Alim.this, DaumapiActivity.class);
					startActivity(intent2);
					
					break;
				}
			}
		
        
        });
	}

		
		//ArrayAdapter adapter = new ArrayAdapter(this,
		//		android.R.layout.simple_list_item_1, body);
		//final ListView list = (ListView) this.findViewById(R.id.listview1);

		//list.setAdapter(adapter);
        
        //setContentView(R.layout.alim);
     /*   ArrayList<MyItem> arrayItems2=new ArrayList<MyItem>();

 
        
        CustomAdater adapter2 = new CustomAdater(this,R.layout.itemlayout,arrayItems2);
       
        list = (ListView)this.findViewById(R.id.listview2);
        list.setAdapter(adapter2);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				// TextView text = (TextView)findViewById(R.id.li)
				AlertDialog.Builder d = new AlertDialog.Builder(Alim.this);

				switch (arg2) {
				

				}

			}

		});
		
	}
	*/
	/*@Override
	   public boolean dispatchTouchEvent(MotionEvent ev)
       {
               int action = ev.getAction();

              // boolean mbIsScrollEnabled = false;

                       //int mLastAction = 0;
					if (action == mLastAction) {
                               ev.setAction(MotionEvent.ACTION_CANCEL);
                               super.dispatchTouchEvent(ev);
                               return true;
                       }
                       mLastAction = action;


               return super.dispatchTouchEvent(ev);
       }*/
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



