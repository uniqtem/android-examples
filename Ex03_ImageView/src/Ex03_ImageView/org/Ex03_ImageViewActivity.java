package Ex03_ImageView.org;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Ex03_ImageViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        int val=0;
        for(int i=1; i<=100; i++){
        	val+=i;
        }
        
        String val1=Integer.toString(val);
        TextView textView = (TextView) this.findViewById(R.id.textview1);
        textView.setText("ImageView 1~100까지 더한합 = "+val1);
        
        ImageView image =(ImageView)this.findViewById(R.id.imageview1);
        //image.setImageResource(R.drawable.icon);
        //image.setImageResource(R.drawable.picture1);
        //image.setImageResource(R.drawable.picture2);
        ///image.setImageResource(R.drawable.picture3);
        		
        
    }
}