package com.clintwn.glpimanager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.net.http.AndroidHttpClient;
import android.util.Log;

public class AccountService
{
	
	private static final String TAG = "AccountService";
	
	private String glpiHostname;
	private String glpifirstName;
	private String glpiSurname;
	private int glpiAccountId;

	public String getGlpiHostname()
	{
		return glpiHostname;
	}

	public String getGlpifirstName()
	{
		return glpifirstName;
	}

	public String getGlpiSurname()
	{
		return glpiSurname;
	}

	public int getGlpiAccountId()
	{
		return glpiAccountId;
	}

	AndroidHttpClient httpClient = AndroidHttpClient.newInstance("android");
	
	public void authenticate(String username, String password, String hostname)
	{
		Log.d(TAG,">>>authenticate");
		this.glpiHostname = hostname;
		JSONObject result = new JSONObject();
		
		String url = "http://" + hostname + "/glpi/plugins/webservices/rest.php?method=glpi.doLogin" +
			"&login_name=" + URLEncoder.encode(username) + "&login_password=" + URLEncoder.encode(password);
		
		HttpGet httpget = new HttpGet(url);
		try
		{
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();			
			result = this.parseRequest(entity);
			glpifirstName = result.getString("firstname");
			glpiSurname = result.getString("realname");
			glpiAccountId = result.getInt("id");
		} catch (ClientProtocolException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
		
		Log.d(TAG,"<<<authenticate");
	}
	
	public void getMyInfo()
	{

		String url = "http://" + glpiHostname + "/glpi/plugins/webservices/rest.php?method=glpi.getMyInfo"; 
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response;
		try
		{
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			JSONObject result = this.parseRequest(entity);			
			Log.d(TAG,result.getString("phone"));
		} catch (ClientProtocolException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
	}
	
	private JSONObject parseRequest(HttpEntity entity) throws JSONException, IOException
	{
		InputStream in = new BufferedInputStream(entity.getContent());
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		JSONObject parser = (JSONObject) new JSONTokener(reader.readLine()).nextValue();
		return parser;
	}
}
