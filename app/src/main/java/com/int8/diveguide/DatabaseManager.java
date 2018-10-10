package com.int8.diveguide;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import android.content.Context;

public class DatabaseManager {
	 
    private OrmDatabaseHelper databaseHelper = null;
 
    // Gets a helper once one is created ensures it doesn't create a new one.
    public OrmDatabaseHelper getHelper(Context context)
    {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(context, OrmDatabaseHelper.class);
        }
        return databaseHelper;
    }
 
    // Release the helper once usage has ended.
    public void releaseHelper(DatabaseHelper helper)
    {
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
 
}
