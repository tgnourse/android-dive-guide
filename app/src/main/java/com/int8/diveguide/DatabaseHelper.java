package com.int8.diveguide;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
  public static final String TABLE_POINTS = "points";
  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_NAME = "name";
  public static final String COLUMN_TIME = "time";
  public static final String COLUMN_LONGITUDE = "longitude";
  public static final String COLUMN_LATITUDE = "latitude";

  private static final String DATABASE_NAME = "points.db";
  private static final int DATABASE_VERSION = 1;

  // Create the tables in this database.
  private static final String DATABASE_CREATE = "create table " + TABLE_POINTS + "(" +
		  COLUMN_ID + " integer primary key autoincrement, " +
		  COLUMN_LONGITUDE + " integer, " +
		  COLUMN_LATITUDE + " integer, " +
		  COLUMN_TIME + " datetime, " +
		  COLUMN_NAME + " text not null);";

  public DatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    database.execSQL(DATABASE_CREATE);
    
    // TODO(tgnourse): Load the database with some starter data.
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    throw new UnsupportedOperationException("Upgrades from " + oldVersion + " to " + newVersion + " not supported.");
  }

} 
