package ksappcenter.ex.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FileIO extends Activity implements OnClickListener {
	EditText mEdit;
	String mSDPath;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mEdit = (EditText)findViewById(R.id.text1);
        Button btn1 = (Button)findViewById(R.id.btnsave);
        btn1.setOnClickListener(this);
        Button btn2 = (Button)findViewById(R.id.btnload);
        btn2.setOnClickListener(this);
        Button btn3 = (Button)findViewById(R.id.btnloadres);
        btn3.setOnClickListener(this);
        Button btn4 = (Button)findViewById(R.id.btndelete);
        btn4.setOnClickListener(this);
        
        findViewById(R.id.btnsavesd).setOnClickListener(this);
        findViewById(R.id.btnloadsd).setOnClickListener(this);
        
        String ext = Environment.getExternalStorageState();
        if(ext.equals(Environment.MEDIA_MOUNTED)){
        	mSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }else{
        	mSDPath = Environment.MEDIA_UNMOUNTED;
        }
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnsave:
			try{
				FileOutputStream fos = 
						openFileOutput("test.txt", Context.MODE_WORLD_READABLE);
				fos.write(mEdit.getText().toString().getBytes());
				mEdit.setText("");
				fos.close();
				Toast.makeText(this, "Write Success", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(this, "Write Fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btnload:
			try{
				FileInputStream fis = openFileInput("test.txt");
				byte[] data = new byte[fis.available()];
				while(fis.read(data) != -1){;}
				fis.close();
				mEdit.setText(new String(data));
				Toast.makeText(this, "Read Success", Toast.LENGTH_SHORT).show();
			}
			catch(FileNotFoundException e){
				Toast.makeText(this, "File Not Found", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(this, "Read Fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btndelete:
			if(deleteFile("test.txt")){
				Toast.makeText(this, "Delete Success", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "Delete Fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btnloadres:
			try{
				InputStream fis = 
						getResources().openRawResource(R.raw.testres);
				byte[] data = new byte[fis.available()];
				while(fis.read(data) != -1){;}
				fis.close();
				mEdit.setText(new String(data));
				Toast.makeText(this, "Read Success", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(this, "Read Fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btnsavesd:
			File dir = new File(mSDPath + "/dir");
			dir.mkdir();
			File file = new File(mSDPath + "/dir/testsd.txt");
			
			try{
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(mEdit.getText().toString().getBytes());
				fos.close();
				Toast.makeText(this, "Write Success (SDCard)", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(this, "Write Fail (SDCard)", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btnloadsd:
			try{
				FileInputStream fis = new FileInputStream(mSDPath + "/dir/testsd.txt");
				byte[] data = new byte[fis.available()];
				while(fis.read(data) != -1){;}
				fis.close();
				mEdit.setText(new String(data));
				Toast.makeText(this, "Read Success (SDCard)", Toast.LENGTH_SHORT).show();
			}
			catch(FileNotFoundException e){
				Toast.makeText(this, "File Not Found (SDCard)", Toast.LENGTH_SHORT).show();
			}
			catch(Exception e){
				Toast.makeText(this, "Read Fail (SDCard)", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}
}