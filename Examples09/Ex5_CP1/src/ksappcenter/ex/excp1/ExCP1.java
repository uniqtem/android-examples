package ksappcenter.ex.excp1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ExCP1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite2);
        
        // 연락처 콘텐츠 획득
        Cursor cursor = getContentResolver()
        				.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        
        //커서의 수명주기를 액티비티가 관리
        startManagingCursor(cursor);
        
        Log.d("cp", "aaa1");
        
        //원하는 열의 속성이름 획득
        int nameIdx = cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
        Log.d("cp", "nameIdx="+nameIdx);
        int idIdx = cursor.getColumnIndexOrThrow(ContactsContract.Contacts._ID);
        Log.d("cp", "idIdx="+idIdx);
             
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, 
        		android.R.layout.simple_list_item_2, 
        		cursor, 
        		new String[] {"DISPLAY_NAME", "_ID"}, 
        		new int[] {android.R.id.text1, android.R.id.text2});

        ListView list = (ListView)findViewById(R.id.list1);
        list.setAdapter(adapter);
    }
}