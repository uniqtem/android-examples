package SiProject.rog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Intro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);

		new Thread(new Runnable() {
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (Throwable ex) {
					ex.printStackTrace();
				}
				Intent i = new Intent(Intro.this, SiProjectActivity.class);
				startActivity(i);
				finish();
			}
		}).start();
	}

}
