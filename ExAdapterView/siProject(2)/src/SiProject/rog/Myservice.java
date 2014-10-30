package SiProject.rog;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Myservice extends Service {

	private final IBinder mBinder = new MyBinder(); 
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.d("MY_TAG", "Service onCreate()");

	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		BroadcastReceiver mReceiver = new ScreenReceiver();
		registerReceiver(mReceiver, filter);
		boolean screenOn = intent.getBooleanExtra("screen_state", false);
		if(!screenOn){
			
		}else{
			
		}
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.d("MY_TAG", "Service onBind()");
		return mBinder;
	}

	public class MyBinder extends Binder {
		Myservice getService() {
			return Myservice.this;
		}
	}
}
