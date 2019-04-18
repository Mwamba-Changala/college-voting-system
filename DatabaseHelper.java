package com.example.voting_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
public DatabaseHelper( Context context) {
        super(context, "stud.db", null, 1);
        }

@Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table student(ROLL_NO TEXT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT)");
        //sqLiteDatabase.execSQL("create table student(ID PRIMARY KEY AUTOINCREMENT,ROLL_NO TEXT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT)");
}

@Override
public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists student");
        onCreate(sqLiteDatabase);
        }
//public Cursor getAllData(){
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor res=db.rawQuery("select * from student",null);
//        return  res;
//        }

        }




/*public class DatabaseHelper extends SQLiteOpenHelper {


    public  static final String DATABASE_NAME="student1";
    public  static final String TABLE_NAME="student_table1";
    public  static final String COL_1="ID";

    public  static final String COL_2="ROLL_NO";
  //  public  static final String COL_3="NAME";
   // public  static final String COL_4="EMAIL";
    //public  static final String COL_5="PASSWORD";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//db.execSQL("create table "+TABLE_NAME+"("+COL_1+")");
       // db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ROLL_NO TEXT,NAME TEXT,EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ROLL_NO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        onCreate(db);
    }



   // public boolean insertData(String roll_no,String name,String email,String password){
        public boolean insertData(String roll_no){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,roll_no);
       // contentValues.put(COL_3,name);
       // contentValues.put(COL_4,email);
       // contentValues.put(COL_5,password);
        db.insert(TABLE_NAME,null,contentValues);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else {
            return true;
        }

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return  res;
    }


}*/
