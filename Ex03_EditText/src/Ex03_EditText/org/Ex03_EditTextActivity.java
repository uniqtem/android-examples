package Ex03_EditText.org;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class Ex03_EditTextActivity extends Activity implements  OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) this.findViewById(R.id.Button1);
        button.setOnClickListener(this);
        Button buuton1 = (Button) this.findViewById(R.id.Button2);
        buuton1.setOnClickListener(this);
       
    }
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	     EditText editText = (EditText) this.findViewById(R.id.Edit1);
	     TextView textView = (TextView) this.findViewById(R.id.TextView1);
		switch (arg0.getId()){
		case R.id.Button1:
			String a11=editText.getText().toString();
			textView.setText(a11);
			break;
		case R.id.Button2:
			editText.setText("");
			textView.setText("");
			break;
		}
		
			
	}
}