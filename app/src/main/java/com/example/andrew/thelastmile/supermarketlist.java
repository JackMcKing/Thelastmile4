package com.example.andrew.thelastmile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by imand on 2015/11/29.
 */
public class supermarketlist extends SQLiteOpenHelper {
    public supermarketlist(Context context) {
        super(context, "supermarket", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE list(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT DEFAULT NONE,number INT,price INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}











