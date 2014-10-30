package com.fyltech.android.AlarmManagerDemo;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String action = intent.getAction();
        
        Toast.makeText(context, "intent.getAction() = " + action, Toast.LENGTH_LONG).show();
        
        /*
         * 알람 서비스 시작(시스템 알람 등록)
         * 시스템 알람에 등록하는 부분을 반드시 서비스로 만들 필요는 없지만
         * 전원을 on/off 시키면 시스템에 등록된 알람이 clear 된다.
         * 따라서 전원이 on 될때 Activity 필요없이 시스템 알람에 다시 등록하기 위하여
         * 서비스로 만들어 놓는다. 
         */
        
        /*
         * 서비스로 만들어진 알람 등록을 실행한다.
         */
        Intent intentAlarm = new Intent(context, AlarmService.class);
        ComponentName cpn = context.startService(intentAlarm);
    }
    
}
