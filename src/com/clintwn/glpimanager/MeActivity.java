package com.clintwn.glpimanager;

import android.app.Activity;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.TextView;

public class MeActivity extends Activity { 
	
	public MyResultReceiver receiver;
	
	
	private TextView glpiAccountIdText;
	private TextView glpiNameText;	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        Bundle extras = getIntent().getExtras();
        glpiAccountIdText = (TextView) findViewById(R.id.glpiAccountId);
        glpiNameText = (TextView) findViewById(R.id.glpiName);
        glpiAccountIdText.setText("Account ID: " + Integer.toString(extras.getInt("glpiAccountId")));
        glpiNameText.setText(extras.getString("glpiFirstName") + " " + extras.getString("glpiSurname"));
        
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_me, menu);
//        return true;
//    }

    
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    
    
}

