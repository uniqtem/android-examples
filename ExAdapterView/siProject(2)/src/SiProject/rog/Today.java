package SiProject.rog;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Today extends Activity {
	Cursor cursor;
	SimpleCursorAdapter adapter;
	ListView list;
	MyDBHelper mDBHelper;
	SQLiteDatabase db;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.today);
  mDBHelper = new MyDBHelper(this, "Today.db", null, 1);
  SQLiteDatabase db = mDBHelper.getWritableDatabase();

  cursor = db.rawQuery("SELECT * FROM today", null);

  adapter = new SimpleCursorAdapter(this, 
  		android.R.layout.simple_list_item_2, 
  		cursor, 
  		new String[] {"title", "date"}, 
  		new int[] {android.R.id.text1, android.R.id.text2});
  
  ListView list = (ListView)findViewById(R.id.list1);
  list.setAdapter(adapter);
}
public boolean onCreateOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu);
	MenuItem item = menu.add(0,1,0, "DB 전부 삭제");
	return true;
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	super.onOptionsItemSelected(item);
	
	switch(item.getItemId()){
	case 1:

		db = mDBHelper.getWritableDatabase();
		db.execSQL("DELETE FROM today");
		//db.delete("dic", null, null);
		  cursor = db.rawQuery("SELECT * FROM today", null);

		  adapter = new SimpleCursorAdapter(this, 
		  		android.R.layout.simple_list_item_2, 
		  		cursor, 
		  		new String[] {"title", "date"}, 
		  		new int[] {android.R.id.text1, android.R.id.text2});
		  
		  adapter.notifyDataSetChanged();
		  ListView list = (ListView)findViewById(R.id.list1);
		  list.setAdapter(adapter);
		  
		
		mDBHelper.close();
	

	
	}
	
	return true;
}
}
