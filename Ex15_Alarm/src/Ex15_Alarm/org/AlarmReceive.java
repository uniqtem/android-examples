package Ex15_Alarm.org;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AlarmReceive extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "Alarm Received!", Toast.LENGTH_LONG).show();

		NotificationManager notifier = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);

		Notification notify = new Notification(R.drawable.icon, "text",
				System.currentTimeMillis());

		Intent intent2 = new Intent(context, Ex15_AlarmActivity.class);
		PendingIntent pender = PendingIntent
				.getActivity(context, 0, intent2, 0);

		notify.setLatestEventInfo(context, "alimtitle", "hackjang", pender);

		notify.flags |= Notification.FLAG_AUTO_CANCEL;
		notify.vibrate = new long[] { 200, 200, 500, 300 };
		// notify.sound=Uri.parse("file:/");
		notify.number++;

		notifier.notify(1, notify);

	}

}
