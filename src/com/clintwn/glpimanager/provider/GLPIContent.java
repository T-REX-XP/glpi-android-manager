package com.clintwn.glpimanager.provider;

import static com.clintwn.glpimanager.domain.User.SimpleUsers.AUTHORITY;
import static com.clintwn.glpimanager.domain.User.SimpleUsers.USER_TABLE_NAME;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import com.clintwn.glpimanager.domain.User;

public class GLPIContent extends ContentProvider {
    public GLPIContent() {
    }
    
	private static final String DB_NAME = "glpi_database.db";
    private static final int DATABASE_VERSION = 2;
//    private static final String COMPUTER_TABLE_NAME = "computer";
//    private static final String TICKET_TABLE_NAME = "ticket";
    private DatabaseHelper mOpenHelper;
    private static final String TAG = "GLPIContent";
    private static final UriMatcher sUriMatcher;
    
    private static final int USERS = 1;
    private static final int USER_ID = 2;    
    
    static {
    	sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    	sUriMatcher.addURI(AUTHORITY, "users", USERS);
    	sUriMatcher.addURI(AUTHORITY, "users/#", USER_ID);
    }
    

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
    	throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
    	Log.d(TAG,">>>onCreate");
    	mOpenHelper = new DatabaseHelper(getContext(),DB_NAME,null,DATABASE_VERSION);
    	Log.d(TAG,"<<<onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
    	int match = sUriMatcher.match(uri);
    	Cursor c;
    	SQLiteDatabase mDb;
    	mDb = mOpenHelper.getReadableDatabase();
    	
    	switch(match){
    	case USERS:
    		c = mDb.query(USER_TABLE_NAME, null, null, null, null, null, null);
    		c.setNotificationUri(getContext().getContentResolver(),User.SimpleUsers.CONTENT_URI);
    		break;
    	case USER_ID:
    		c = mDb.query(USER_TABLE_NAME, null, User.SimpleUsers._ID + " = " + 
    				(!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), 
    				selectionArgs, null, null, null);
    		c.setNotificationUri(getContext().getContentResolver(), User.SimpleUsers.CONTENT_URI);
    		break;
    	default:
    		throw new IllegalArgumentException("unsupported uri: " + uri);
    	}
        //throw new UnsupportedOperationException("Not yet implemented");
    	return c;
        
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
 
    	
    }

