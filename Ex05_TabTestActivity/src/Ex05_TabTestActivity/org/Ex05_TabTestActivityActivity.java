package Ex05_TabTestActivity.org;

//import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Ex05_TabTestActivityActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        TabHost tabhost = getTabHost();
        tabhost.addTab(tabhost.newTabSpec("tag").setIndicator("Hello",getResources().getDrawable(id)).setContent(new Intent(Ex05_TabTestActivityActivity.this, Hello.class)));
        tabhost.addTab(tabhost.newTabSpec("tag1").setIndicator("연락처추가").setContent(new Intent(this, Ex04_Registration.class)));
        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("계산기").setContent(new Intent(this, Ex05_Calulator.class)));
        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("계산기").setContent(new Intent(this, Ex05_Calulator.class)));
        tabhost.addTab(tabhost.newTabSpec("tag2").setIndicator("계산기").setContent(new Intent(this, Ex05_Calulator.class)));
        
        
        
    }
    
}