package com.clintwn.glpimanager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{
	
	private static final String TAG = "MainActivity";
	
	public AccountService accountService = new AccountService();

	private TextView usernameText;
	private TextView passwordText;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.d(TAG,">>>onCreate");
		setContentView(R.layout.activity_main);
		usernameText = (TextView) findViewById(R.id.usernameText);
		passwordText = (TextView) findViewById(R.id.passwordText);
		
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
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.menu_settings:
	        	Intent preferences = new Intent(getBaseContext(),Preferences.class);
	        	startActivity(preferences);
	            return true;	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	public void login(View view)
	{
		Log.d(TAG,">>>login");
		String username = usernameText.getText().toString();
		String password = passwordText.getText().toString();
		
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String hostname = settings.getString("glpiHostname","");
		if (username.length()==0){
			username = settings.getString("glpiUsername","");			
		}
		if (password.length()==0){
			password = settings.getString("glpiPassword", "");
		}
		accountService.authenticate(username, password, hostname);			
		Intent meActivity = new Intent(getBaseContext(),MeActivity.class);
		meActivity.putExtra("glpiAccountId",accountService.getGlpiAccountId());
		meActivity.putExtra("glpiFirstName", accountService.getGlpifirstName());
		meActivity.putExtra("glpiSurname", accountService.getGlpiSurname());
		accountService.getMyInfo();		
		this.startActivity(meActivity);	    
		
		Log.d(TAG,"<<<login");
	}
}