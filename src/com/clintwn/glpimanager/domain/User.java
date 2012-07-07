package com.clintwn.glpimanager.domain;

import android.net.Uri;
import android.provider.BaseColumns;

public class User
{
	public static final class SimpleUsers implements BaseColumns 
	{ 
		private SimpleUsers(){}
		public static final String AUTHORITY = "com.clintwn.glpimanager";			
		public static final String USER_TABLE_NAME = "users";
		public static final Uri USERS_URI = Uri.parse("content://" + AUTHORITY + "/" + USER_TABLE_NAME);		
		public static final Uri CONTENT_URI = USERS_URI;
		
		public static final String NAME = "name";
		public static final String FIRST_NAME = "firstname";
		public static final String EMAIL = "email";
		public static final String PHONE = "phone";
		public static final String DISPLAY_NAME = "displayname";
		public static final String USER_ID = "user_id";
		public static final String LOCATION_ID = "location_id";
		public static final String LOCATION_NAME = "location_name";
		public static final String URI = "uri";
	}
}
