package com.libirsoft.herba;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class SQL_layer extends SQLiteOpenHelper {
    public SQL_layer(@Nullable Context context) {


        super(context, "ToDo_database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String sql = " create table toDo (id integer primary key autoincrement , date TEXT, todo Text, isdone integer)";
        DB.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists toDo");


    }

}
