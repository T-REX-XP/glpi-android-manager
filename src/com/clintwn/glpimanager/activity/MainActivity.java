package com.clintwn.glpimanager.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.clintwn.glpimanager.Preferences;
import com.clintwn.glpimanager.R;
import com.clintwn.glpimanager.domain.User;

public class MainActivity extends Activity
{
	
	private static final String TAG = "MainActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d(TAG,">>>onCreate");
		setContentView(R.layout.activity_main);

		Cursor c = getContentResolver().query(User.SimpleUsers.CONTENT_URI, null, null, null, null);
		try
		{
			c.getString(0);
		} catch (Exception e)
		{
			Log.d(TAG,"theres nothing here: " + e);
		}
		Log.d(TAG,"<<<onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menu_settings:
	        	Intent preferences = new Intent(getBaseContext(),Preferences.class);
	        	startActivity(preferences);
	            return true;	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}