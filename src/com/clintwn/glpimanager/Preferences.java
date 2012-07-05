package com.clintwn.glpimanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;

public class Preferences extends PreferenceActivity {
	
	private static final String TAG = "Preferences";
	static SharedPreferences settings;

	String glpi_hostname;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
    	Log.d(TAG,">>>onCreate");
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        Log.d(TAG,"<<<onCreate");
    }
}
