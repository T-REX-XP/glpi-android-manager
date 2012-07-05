package com.clintwn.glpimanager;

import java.util.ArrayList;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public class QueryService extends IntentService
{

	public QueryService()
	{
		super("QueryService");
	}

	@Override
	protected void onHandleIntent(Intent intent)
	{
		final ResultReceiver receiver = intent.getParcelableExtra("receiver");

		String command = intent.getStringExtra("command");
		Bundle b = new Bundle();

		if (command.equals("query"))
		{
			// get some data
			ArrayList<String> results = new ArrayList<String>();
			b.putStringArrayList("results", results);
			receiver.send(0, b);
		}
		this.stopSelf();
	}

}

