package Ex05_TabTest.org;

//import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class Ex05_TabTestActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost mTab = getTabHost();
        
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.main, mTab.getTabContentView());
        inflater.inflate(R.layout.main1, mTab.getTabContentView());
        
        TabHost.TabSpec spec;
        spec = mTab.newTabSpec("Tab1");
        spec.setIndicator("",getResources().getDrawable(R.drawable.icon));
        spec.setContent(R.id.main);
        mTab.addTab(spec);
        
        mTab.addTab(mTab.newTabSpec("Tab").setIndicator("Tab 02").setContent(R.id.nuber2));
        mTab.addTab(mTab.newTabSpec("Tab").setIndicator("Tab 03").setContent(R.id.nuber3));   
    }
}