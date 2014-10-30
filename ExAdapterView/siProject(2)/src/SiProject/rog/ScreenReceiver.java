package SiProject.rog;

import java.util.Calendar;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class ScreenReceiver extends BroadcastReceiver {
	public static boolean wasScreenOn = true;
	private boolean screenOff;
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	 int si=0,bun=0,cho=0;
	public int minuteresult, secondresult;
	Context con;
	String name;
	int val,vall;
	MyDBHelper mDBHelper;
	SQLiteDatabase db;
	int val1,val2;
	private Handler handler = new Handler();

	@Override
	public void onReceive(Context context, Intent intent) {
		 
		/*
		 * 안드로이드 시스템의 알람 매니저는 전원이 오프 되면 삭제 된다.
		 * 따라서
		 */
		
		  if(intent.getAction().equals("android.intent.action.TIME_SET")){
			
		  Calendar rightNow = Calendar.getInstance();// 날짜 불러오는 함수
		  int year = rightNow.get(Calendar.YEAR);// 100을 나눠서 년도표시를 2009->9지만
		  // decimal포멧으로 09로 표현
		  int month = rightNow.get(Calendar.MONTH);// 달
		  int date = rightNow.get(Calendar.DATE);// 일
		  int times = rightNow.get(Calendar.HOUR);
		  int timess = rightNow.get(Calendar.MINUTE);
		  

			SharedPreferences pref3 = context
			.getSharedPreferences("Prefre",1);
           int su1 = pref3.getInt("No1", 0);//name을 못읽었을때 guest
           int su2 = pref3.getInt("No2", 0);
           
		  cho = cho + su1%60;
		  bun = bun + su1/60;
		  bun = bun +  su2%60;
		  si = si +  su2/60;

		  mDBHelper = new MyDBHelper(context, "Today.db", null, 1);
		  db = mDBHelper.getWritableDatabase(); // 디비 넣기
			db.execSQL("INSERT INTO today VALUES(null, '"
					+ Integer.toString(year)+"년 "+Integer.toString(month+1)+"월 "+Integer.toString(date)+"일"
					+Integer.toString(times)+"시 "+Integer.toString(timess)+"분 "
					+ "', '" 
					+ Integer.toString(si)+"시 "+Integer.toString(bun)+"분 "+Integer.toString(cho)+"초"
					+ "');");
			
			
			SharedPreferences.Editor edit = pref3.edit();
		    edit.putInt("No1",0);
		    edit.putInt("No2",0);
		    cho = 0;
		    bun = 0;
		    si = 0;
			edit.commit();
			
		  }

		con = context;
		

		// TODO Auto-generated method stub
		if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
			
			handler.removeCallbacks(doUpdateTimer);
			minuteresult += minute;
			secondresult += second;
			
			SharedPreferences pref = con.getSharedPreferences("Prefre", 1);
			SharedPreferences.Editor edit = pref.edit();
		    edit.putInt("No1",secondresult);
		    edit.putInt("No2",minuteresult);
			edit.commit();
			
			minute=0;
			second=0;

			screenOff = true;
			wasScreenOn = false;
		}
		if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
			
			handler.postDelayed(doUpdateTimer, 100);
			screenOff = false;
			wasScreenOn = true;
		}
	}

	public Runnable doUpdateTimer = new Runnable() {
		
		@Override
		public void run() {
			SharedPreferences pref = con
					.getSharedPreferences("PrefTest", 0);
			name = pref.getString("Name", "고만해라 마이 했다이가...");
			SharedPreferences pref2 = con
					.getSharedPreferences("Pref",1);
		    val = pref2.getInt("No", 10);//name을 못읽었을때 guest
			
		    SharedPreferences pref3 = con.
		    		getSharedPreferences("Prefee",0);
		    vall = pref3.getInt("how", 0);//name을 못읽었을때 guest
			// TODO Auto-generated method stub
			second++;
			if(second==val){
				Vibrator vibe = (Vibrator)con.getSystemService(con.VIBRATOR_SERVICE); 
				vibe.vibrate(1000);
				Toast.makeText(con, "<"+Integer.toString(minute)+"분 경과>\n"+name,
				 Toast.LENGTH_SHORT).show();
			}

			if (second >= 60) {
				second = 0;
				minute++;
				if (minute == val || minute == val*2 || minute == val*3 || minute == val*4 || minute == val*5 ||
						minute == val*6 ||minute == val*7||minute == val*8||minute == val*9||minute == val*10 ||
						minute == val*11 || minute == val*12 || minute == val*13 || minute == val*14 || minute == val*15 ||
						minute == val*16 ||minute == val*17||minute == val*18||minute == val*19||minute == val*20) {
					if(vall==1){
						Toast.makeText(con, "<"+Integer.toString(minute)+"분 경과>\n"+name,
						Toast.LENGTH_SHORT).show();
					}
					else if(vall==2){
						Vibrator vibe = (Vibrator)con.getSystemService(con.VIBRATOR_SERVICE); 
						vibe.vibrate(1000);
						Toast.makeText(con, "<"+Integer.toString(minute)+"분 경과>\n"+name,
						 Toast.LENGTH_SHORT).show();
					}
					else if(vall==3){
						Toast.makeText(con, "<"+Integer.toString(minute)+"분 경과>\n"+name,
						 Toast.LENGTH_SHORT).show();
					}

				}
			}

			handler.postDelayed(doUpdateTimer, 1000);
		}
	};
	
}

