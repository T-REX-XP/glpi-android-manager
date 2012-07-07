package com.clintwn.glpimanager.provider;

import static android.provider.BaseColumns._ID;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.DISPLAY_NAME;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.USER_TABLE_NAME;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.EMAIL;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.FIRST_NAME;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.LOCATION_ID;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.LOCATION_NAME;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.NAME;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.PHONE;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.URI;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.USER_ID;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper

{
	private static final String TAG = "DatabaseHelper";

	public DatabaseHelper(Context context, String name, CursorFactory factory, int version)
	{
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		Log.d(TAG,">>>onCreate");
		createTable(db);
		Log.d(TAG,"<<<onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub

	}

	private void createTable(SQLiteDatabase sqLiteDatabase)
	{
		Log.d(TAG,">>>createTable");
		String qs = "CREATE TABLE " + USER_TABLE_NAME + " (" + 
				_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
				NAME + " TEXT, " + 
				FIRST_NAME + " TEXT, " + 
				EMAIL + " TEXT, " + 
				PHONE + " TEXT, " + 
				DISPLAY_NAME + " TEXT, " + 
				USER_ID + " INTEGER, " + 
				LOCATION_ID + " INTEGER, " + 
				LOCATION_NAME + " TEXT, " + 
				URI + " TEXT);";
		Log.d(TAG,".. Table written");
		try
		{
			sqLiteDatabase.execSQL(qs);
		} catch (Exception e)
		{
			Log.d("GLPIContent", "cant add table, something broke.");
		}
		Log.d(TAG,"<<<createTable");

	}
}
