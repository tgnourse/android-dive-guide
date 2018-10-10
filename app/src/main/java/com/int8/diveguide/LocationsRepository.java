package com.int8.diveguide;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

public class LocationsRepository {
	private OrmDatabaseHelper db;
    Dao<PersistentLocation, Integer> locationsDao;
 
    public LocationsRepository(Context ctx)
    {
        try {
            DatabaseManager dbManager = new DatabaseManager();
            db = dbManager.getHelper(ctx);
            locationsDao = db.getCommentsDao();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
 
    }
 
    public int create(PersistentLocation location)
    {
        try {
            return locationsDao.create(location);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int update(PersistentLocation comment)
    {
        try {
            return locationsDao.update(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
    public int delete(PersistentLocation comment)
    {
        try {
            return locationsDao.delete(comment);
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return 0;
    }
 
    public List<PersistentLocation> getAll()
    {
        try {
            return locationsDao.queryForAll();
        } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
        }
        return null;
    }
}
