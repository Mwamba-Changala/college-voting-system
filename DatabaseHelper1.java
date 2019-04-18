package com.example.voting_system;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper1 extends SQLiteOpenHelper {
    public DatabaseHelper1(Context context) {
        super(context, "stud1.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table all_student(ROLL_NO TEXT,NAME TEXT,DIVISION TEXT,UNIQUE_CODE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists all_student");
        onCreate(sqLiteDatabase);
    }
}
