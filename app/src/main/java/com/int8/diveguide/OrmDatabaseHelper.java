package com.int8.diveguide;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class OrmDatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "diveGuide.db";
    // Any time you make changes to your database objects, you may have to increase the database version.
    private static final int DATABASE_VERSION = 1;
 
    private Dao<PersistentLocation, Integer> locationsDao = null;
    private RuntimeExceptionDao<PersistentLocation, Integer> locationsRuntimeDao = null;
 
    public OrmDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, PersistentLocation.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
 
        // Create some initial data in the database for Breakwater, Monterey, CA.
        RuntimeExceptionDao<PersistentLocation, Integer> dao = getLocationsDataDao();
        dao.create(new PersistentTargetLocation("South Beach", 36.609723, -121.894727).getPersistentLocation());
        dao.create(new PersistentTargetLocation("The Barge", 36.610633, -121.890150).getPersistentLocation());
        dao.create(new PersistentTargetLocation("End of the Wall", 36.608561, -121.889647).getPersistentLocation());
        dao.create(new PersistentTargetLocation("Wall Elbow", 36.609508, -121.892790).getPersistentLocation());
        dao.create(new PersistentTargetLocation("Metridium Fields", 36.612703, -121.892886).getPersistentLocation());
        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate");
    }
 
    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, PersistentLocation.class, true);
            // After we drop the old databases, we create the new ones.
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }
 
    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
     * value.
     */
    public Dao<PersistentLocation, Integer> getCommentsDao() throws SQLException {
        if (locationsDao == null) {
            locationsDao = getDao(PersistentLocation.class);
        }
        return locationsDao;
    }
 
    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<PersistentLocation, Integer> getLocationsDataDao() {
        if (locationsRuntimeDao == null) {
            locationsRuntimeDao = getRuntimeExceptionDao(PersistentLocation.class);
        }
        return locationsRuntimeDao;
    }
 
    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        locationsDao = null;
    }
}
