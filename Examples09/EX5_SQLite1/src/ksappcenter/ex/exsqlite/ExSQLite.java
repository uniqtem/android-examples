package ksappcenter.ex.exsqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class ExSQLite extends Activity implements OnClickListener {
	WordDBHelper mHelper;
	EditText mText;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exsqlite);
        
        mHelper = new WordDBHelper(this, "EngDic.db", null, 1); //SQLiteOpenHelper 클래스 생성
        
        mText = (EditText)findViewById(R.id.text1);
        
        findViewById(R.id.insert).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.select).setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		SQLiteDatabase db;
		ContentValues row; //record
		
		switch(v.getId()){
		case R.id.insert:
			db = mHelper.getWritableDatabase();
			
			//SQL
			db.execSQL("INSERT INTO dic VALUES(null, 'girl', '소녀');");;
			
			//insert method
			row = new ContentValues(); //레코드에 포함된 필드이름과 값 (map)
			row.put("eng", "boy"); // (attribute, Value)
			row.put("han", "소녀");
			db.insert("dic", null, row);
			
			mHelper.close();
			mText.setText("Insert Success");
			break;
			
		case R.id.delete:
			db = mHelper.getWritableDatabase();
			
			db.execSQL("DELETE FROM dic");
			//db.delete("dic", null, null);
			
			mHelper.close();
			mText.setText("Delete Success");
			break;
			
		case R.id.update:
			db = mHelper.getWritableDatabase();
			
			db.execSQL("UPDATE dic SET han='소년' WHERE eng='boy';");
			//row = new ContentValues();
			//row.put("han", "소년");
			//db.update("dic", row, "eng='boy'", null);
			
			mHelper.close();
			mText.setText("Upgrade Success");
			break;
			
		case R.id.select:
			db = mHelper.getReadableDatabase();
			Cursor cursor; //결과셋에서의 현재 레코드 위치 (초기값=첫레코드이전값)
			
			cursor = db.rawQuery("SELECT eng, han FROM dic", null);
			//cursor = db.query("dic", new String[]{"eng", "han"}, null, null, null, null, null);
			
			String result = "";
			while(cursor.moveToNext()){
				String eng = cursor.getString(0);
				String han = cursor.getString(1);
				result = result + eng + " = " + han + "\n";				
			}
			
			if(result.length() == 0){
				mText.setText("Empty Set");
			} else{
				mText.setText(result);
			}
			
			cursor.close();
			mHelper.close();
			break;
		}
		
	}
}