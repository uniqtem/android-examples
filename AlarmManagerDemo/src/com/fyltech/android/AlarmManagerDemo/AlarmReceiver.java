package com.fyltech.android.AlarmManagerDemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/*
 * 시스템 알람에서 Broadcast 했을때 Receiver
 */
public class AlarmReceiver extends BroadcastReceiver 
{
    @Override
    public void onReceive(Context ctx, Intent intent) {
        String action = intent.getAction();
        String Start = intent.getExtras().getString("DateTime");
        
        Toast.makeText(ctx, "intent.getAction() = \r\n" + action + "\r\n" +
        		"Start = " + Start, Toast.LENGTH_LONG).show();
        
        
        
        // 등록 알람일 경우 스누즈 알람을 만든다.
        if(action.equals(AlarmService.RECEIVE_ALARM_ACTION))
        {
            Intent intentAlarm = new Intent(AlarmService.RECEIVE_ALARM_SNOOZE_ACTION);
            Bundle bundle = new Bundle();
    
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.add(Calendar.SECOND, 10);  // 10초뒤에 스누즈 알람
            
            SimpleDateFormat dateFormatSql = new SimpleDateFormat("yyyy-MM-dd kk:mm.ss");        
            String sDateTime = dateFormatSql.format(calendar.getTime());
            
            bundle.putString("DateTime", sDateTime);
            intentAlarm.putExtras(bundle);
            
            PendingIntent sender = PendingIntent.getBroadcast(ctx, 0, intentAlarm, 0);
            
            AlarmManager alarm = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
            
            long lTriggerAtTime = calendar.getTimeInMillis();
            //long interval = 60 * 1000;
            
            // 단발성 알람을 등록한다.
            alarm.set(AlarmManager.RTC_WAKEUP, lTriggerAtTime, sender);        
        }
    }
}
