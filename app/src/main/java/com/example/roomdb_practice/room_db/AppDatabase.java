package com.example.roomdb_practice.room_db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdb_practice.constants.AppConstants;
import com.example.roomdb_practice.model.User;

@Database(entities = {User.class}, version = AppConstants.DB_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "user_database";

    private static AppDatabase instance = null;

    public static synchronized AppDatabase getAppDatabase(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }

        return instance;
    }


    public abstract UserDao getUserDao();
}
