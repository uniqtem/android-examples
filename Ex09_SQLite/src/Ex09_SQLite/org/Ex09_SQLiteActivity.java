package Ex09_SQLite.org;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Ex09_SQLiteActivity extends Activity implements OnClickListener {
	WordDBHelper mHelper;
	EditText mText;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btn1 = (Button) this.findViewById(R.id.button1);
		btn1.setOnClickListener(this);
		Button btn2 = (Button) this.findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		Button btn3 = (Button) this.findViewById(R.id.button3);
		btn3.setOnClickListener(this);
		Button btn4 = (Button) this.findViewById(R.id.button4);
		btn4.setOnClickListener(this);

		mHelper = new WordDBHelper(this, "EngDic.db", null, 1);// EngDic로 저장

		mText = (EditText) this.findViewById(R.id.edittext);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		SQLiteDatabase db;
		ContentValues row; // lecord값
		switch (arg0.getId()) {
		case R.id.button1:// insert
			db = mHelper.getWritableDatabase();
			// SQL
			db.execSQL("INSERT INTO dic VALUES(null, 'boy' , '소녀');");

			/*
			 * //insert method row = new ContentValues(); row.put("eng", "boy");
			 * row.put("han", "소녀"); db.insert("dic",null,row);
			 */
			mHelper.close();
			mText.setText("Insert Success");
			break;
		case R.id.button2:// delete
			db = mHelper.getWritableDatabase();
			db.execSQL("DELETE FROM dic");

			mHelper.close();
			mText.setText("Delete Success");
			break;
		case R.id.button3: // update
			db = mHelper.getWritableDatabase();
			db.execSQL("UPDATE dic SET han='소년' WHERE eng='boy';");

			mHelper.close();
			mText.setText("Upgrade Success");
			break;
		case R.id.button4: // select
			db = mHelper.getReadableDatabase();
			Cursor cursor;

			cursor = db.rawQuery("SELECT eng, hanFROM dic", null); // return이
																	// 있어서
																	// rawQuery로

			String result = "";
			while (cursor.moveToNext()) {
				String eng = cursor.getString(0);
				String han = cursor.getString(1);
				result = result + eng + han + " = " + han + "\n";
			}

			if (result.length() == 0) {
				mText.setText("Empty Set");
			} else {
				mText.setText(result);
			}

			cursor.close();
			mHelper.close();
			break;

		}

	}

}