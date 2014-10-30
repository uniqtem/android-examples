package Ex15_Alarm.org;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ex15_AlarmActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn1 = (Button) this.findViewById(R.id.button1);
		btn1.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		AlarmManager alarm = (AlarmManager) this
				.getSystemService(Context.ALARM_SERVICE);

		switch (arg0.getId()) {
		case R.id.button1:
			Intent intent = new Intent(Ex15_AlarmActivity.this,
					AlarmReceive.class);
			PendingIntent pender = PendingIntent.getBroadcast(
					Ex15_AlarmActivity.this, 0, intent, 0);

			EditText edit1 = (EditText) this.findViewById(R.id.edit1);
			int year = Integer.valueOf(edit1.getText().toString());
			EditText edit2 = (EditText) this.findViewById(R.id.edit2);
			int month = Integer.valueOf(edit2.getText().toString());
			EditText edit3 = (EditText) this.findViewById(R.id.edit3);
			int day = Integer.valueOf(edit3.getText().toString());
			EditText edit4 = (EditText) this.findViewById(R.id.edit4);
			int hour = Integer.valueOf(edit4.getText().toString());
			EditText edit5 = (EditText) this.findViewById(R.id.edit5);
			int minute = Integer.valueOf(edit5.getText().toString());

			Calendar calendar = Calendar.getInstance();
			calendar.set(year, month - 1, day, hour, minute);

			alarm.set(AlarmManager.RTC, calendar.getTimeInMillis(), pender);

			/*
			 * Toast.makeText(this, calendar.get(Calendar.YEAR)+
			 * "/"+calendar.get(Calendar.MONTH)+
			 * "/"+calendar.get(Calendar.DAY_OF_MONTH)+
			 * "/"+calendar.get(Calendar.HOUR)+
			 * "/"+calendar.get(Calendar.MINUTE) , Toast.LENGTH_SHORT).show();
			 */
			break;
		}

	}
}