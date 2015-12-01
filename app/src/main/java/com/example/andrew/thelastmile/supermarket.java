package com.example.andrew.thelastmile;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.SimpleCursorAdapter;

public class
        supermarket extends ListActivity{

    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket);

        supermarketlist db = new supermarketlist(this);
        SQLiteDatabase dbWrite = db.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name","卫龙大礼包");
        cv.put("number", 999);
        cv.put("price", 100);
        dbWrite.insert("list", null, cv);
        dbWrite.close();


        SQLiteDatabase dbRead = db.getReadableDatabase();
        Cursor c = dbRead.query("list",null,null,null,null,null,null);
        adapter = new SimpleCursorAdapter(this,R.layout.activity_listlayout,c,new String[]{"name"},new int[]{R.id.listTVCommodity});
        setListAdapter(adapter);


    }
}
