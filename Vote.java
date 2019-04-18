package com.example.voting_system;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Vote extends SQLiteOpenHelper {
    public Vote(Context context) {
        super(context, "vote.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table votes(ROLL_NO TEXT,NAME TEXT,CONDIDATE_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists all_student");
        onCreate(sqLiteDatabase);
    }
}
