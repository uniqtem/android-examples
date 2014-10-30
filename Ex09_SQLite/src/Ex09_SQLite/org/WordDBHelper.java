package Ex09_SQLite.org;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class WordDBHelper extends SQLiteOpenHelper {

	public WordDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {// table 생성
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE dic(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "eng TEXT, han TEXT);");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) { // DB 갱신
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE");
		onCreate(db);

	}

}
