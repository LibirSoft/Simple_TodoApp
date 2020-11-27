package com.libirsoft.herba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper {
    SQLiteDatabase db;
    SQL_layer sql_layer;


    public DbHelper(Context c) {
        sql_layer = new SQL_layer(c);
    }

    public void openDB() {
        db = sql_layer.getWritableDatabase();
    }

    public void closeDB() {
        sql_layer.close();
    }

    public void insertData(String todo, String date) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("todo", todo);
        contentValues.put("isdone", 0);
        db.insert("toDo", null, contentValues);
    }

    public ArrayList<To_DO> getValue_list() {

        ArrayList<To_DO> to_do_list = new ArrayList<To_DO>();
        String collumns[] = {"id", "date", "todo", "isdone"};
        Cursor cursor = db.query("toDo", collumns, null, null, null, null, null);
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String date = cursor.getString(1);
            String todo = cursor.getString(2);
            int isdone = cursor.getInt(3);
            Log.d("data id", "" + id);
            Log.d("data date", date);
            Log.d("data todo", todo);
            Log.d("data isdone", "" + isdone);
            To_DO to_do = new To_DO();
            to_do.setDATE(date);
            to_do.setTODO(todo);
            to_do.setISDONE(isdone);
            to_do_list.add(to_do);
        }
        return to_do_list;
    }
}
