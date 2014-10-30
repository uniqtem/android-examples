package com.fyltech.android.AlarmManagerDemo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

/*
 * 시스템 알람 메니저에 알람 등록하는 서비스
 */
public class AlarmService extends Service
{
    public static final String RECEIVE_ALARM_ACTION = "android.intent.action.AlarmManagerDemo.RECEIVE_ALARM";
    public static final String RECEIVE_ALARM_SNOOZE_ACTION = "android.intent.action.AlarmManagerDemo.RECEIVE_ALARM_SNOOZE"; 
    
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        Intent intentAlarm = new Intent(RECEIVE_ALARM_ACTION);
        Bundle bundle = new Bundle();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MINUTE, 1);        
        
        SimpleDateFormat dateFormatSql = new SimpleDateFormat("yyyy-MM-dd kk:mm.ss");        
        String sDateTime = dateFormatSql.format(calendar.getTime());
        
        bundle.putString("DateTime", sDateTime);
        intentAlarm.putExtras(bundle);
        
        PendingIntent sender = PendingIntent.getBroadcast(this, 0, intentAlarm, 0);
        
        AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        
        long lTriggerAtTime = calendar.getTimeInMillis();
        long interval = 60 * 1000;
        
        alarm.setRepeating(AlarmManager.RTC_WAKEUP, lTriggerAtTime, interval, sender);
        
        stopSelf();
    }
}