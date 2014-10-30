package com.fyltech.android.AlarmManagerDemo;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AlarmManagerDemo extends Activity {
    private Context context;
    private Button btnSet;
    private Button btnCancel;
   
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        context = this;
        
        btnSet = (Button) findViewById(R.id.btnStart);
        btnSet.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
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
                Intent intent = new Intent(context, AlarmService.class);
                ComponentName cpn = context.startService(intent);
            }
        });
        
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                
            }
        });
        

    }
}