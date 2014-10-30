package Ex09_FileIO.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class Ex09_FileIOActivity extends Activity implements OnClickListener {
	EditText mEdit;
	String mSDPath;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mEdit = (EditText) this.findViewById(R.id.edittext1);

		Button btn1 = (Button) this.findViewById(R.id.button1);
		btn1.setOnClickListener(this);

		Button btn2 = (Button) this.findViewById(R.id.button2);
		btn2.setOnClickListener(this);

		Button btn3 = (Button) this.findViewById(R.id.button3);
		btn3.setOnClickListener(this);

		Button btn4 = (Button) this.findViewById(R.id.button4);
		btn4.setOnClickListener(this);

		Button btn5 = (Button) this.findViewById(R.id.button5);
		btn5.setOnClickListener(this);

		Button btn6 = (Button) this.findViewById(R.id.button6);
		btn6.setOnClickListener(this);

		String ext = Environment.getExternalStorageState(); // sd 카드 경로
															// String에저장
		if (ext.equals(Environment.MEDIA_MOUNTED)) {
			mSDPath = Environment.getExternalStorageDirectory()
					.getAbsolutePath();
		} else {
			mSDPath = Environment.MEDIA_UNMOUNTED;
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.button1:

			try {
				FileOutputStream fos = openFileOutput("test.txt",
						Context.MODE_WORLD_READABLE);
				fos.write(mEdit.getText().toString().getBytes());
				mEdit.setText("");
				fos.close();
				Toast.makeText(this, "write Success", Toast.LENGTH_SHORT)
						.show();
			} catch (Exception e) {
				Toast.makeText(this, "write fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button2:// 로드
			try {
				FileInputStream fis = openFileInput("test.txt");
				byte[] data = new byte[fis.available()];
				while (fis.read(data) != -1) {
					;
				}// -1 전체 다읽은거
				fis.close();
				mEdit.setText(new String(data));// String으로 바꿔서 출력해야함. String생성자
			} catch (FileNotFoundException e) {
				Toast.makeText(this, "file not found", Toast.LENGTH_SHORT)
						.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "Read Fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button3:// 딜리트
			if (deleteFile("test.txt")) {
				Toast.makeText(this, "delete success", Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(this, "delete fail", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.button4:// load
			try {
				InputStream fis = getResources().openRawResource(R.raw.testrow);
				byte[] data = new byte[fis.available()];
				while (fis.read(data) != -1) {
					;
				}
				fis.close();
				mEdit.setText(new String(data));
				Toast.makeText(this, "Read Success", Toast.LENGTH_SHORT).show();
			} catch (Exception e) {
				Toast.makeText(this, "Read Fail", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.button5:// sdcard저장
			File dir = new File(mSDPath + "/dir");// 디렉토리 다 파일로 취급한다.linux는 /다
			dir.mkdir();
			File file = new File(mSDPath + "/dir/testsd.txt");

			try {
				FileOutputStream fos = new FileOutputStream(file);
				fos.write(mEdit.getText().toString().getBytes());
				fos.close();
				Toast.makeText(this, "Write Success", Toast.LENGTH_SHORT)
						.show();
			} catch (Exception e) {
				Toast.makeText(this, "Write fail(SDCard)", Toast.LENGTH_SHORT)
						.show();
			}
			break;
		case R.id.button6:
			try {
				FileInputStream fis = new FileInputStream(mSDPath
						+ "/dir/testsd.txt");
				byte[] data = new byte[fis.available()];
				while (fis.read(data) != -1) {
					;
				}// -1 전체 다읽은거
				fis.close();
				mEdit.setText(new String(data));
				Toast.makeText(this, "read Success", Toast.LENGTH_SHORT).show();
			} catch (FileNotFoundException e) {
				Toast.makeText(this, "file not found", Toast.LENGTH_SHORT)
						.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				Toast.makeText(this, "Read Fail", Toast.LENGTH_SHORT).show();
			}
			break;
		}

	}
}