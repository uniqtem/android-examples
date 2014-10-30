package ksappcenter.ex.exsqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;


public class WordDBHelper extends SQLiteOpenHelper {

	public WordDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		//super(context, "EngWord.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE dic(_id INTEGER PRIMARY KEY AUTOINCREMENT, eng TEXT, han TEXT);");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS dic");
		onCreate(db);
	}
}