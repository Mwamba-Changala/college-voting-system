package com.example.voting_system;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
    DatabaseHelper db;
    DatabaseHelper1 db2;
    EditText e1,e2,e3,e4,e5;
    AlertDialog.Builder builder;
    String a1,a2,a3,a4,a5;
    ImageView img1;
    int flag1=0;
    String roll_number, name, unique_code;

TextView t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.stu_id);
        e2=(EditText)findViewById(R.id.stu_UserName);
        e3=(EditText)findViewById(R.id.stu_email);
        e4=(EditText)findViewById(R.id.stu_pass);
        e5=(EditText)findViewById(R.id.stu_pass1);
        b1=(Button)findViewById(R.id.sign_up);
        t1=(TextView)findViewById(R.id.sing_in1);
        t2=(TextView)findViewById(R.id.sing_in);
        img1=(ImageView)findViewById(R.id.getvalue);
       // t1=(TextView) findViewById(R.id.sing_in1);
        final DatabaseHelper dbHelper=new DatabaseHelper(this);
        final DatabaseHelper1 dbHelper2=new DatabaseHelper1(this);
        builder = new AlertDialog.Builder(this);

img1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
//        try {
//            SQLiteDatabase db1 = dbHelper.getReadableDatabase();
//            String projection[] = {"roll_no", "name", "email", "password"};
//            //String projection[] = {"id", "roll_no", "name", "email", "password"};
//            Cursor c = db1.query("student", projection, null, null, null, null, null);
//
//            final StringBuffer buffer = new StringBuffer();
//            while (c.moveToNext()) {
//                // buffer.append("id:" + c.getString(0) + "\n");
//            buffer.append("roll_no:" + c.getString(0) + "\n");
//            buffer.append("name:" + c.getString(1) + "\n");
//            buffer.append("email:" + c.getString(2) + "\n");
//            buffer.append("password:" + c.getString(3) + "\n");
//
////                buffer.append("id:" + c.getString(0) + "\n");
////                buffer.append("roll_no:" + c.getString(1) + "\n");
////                buffer.append("name:" + c.getString(2) + "\n");
////                buffer.append("email:" + c.getString(3) + "\n");
////                buffer.append("password:" + c.getString(4) + "\n");
//            }
//
//
//            showMessage("Data", buffer.toString());
//        }
//        catch (Exception ee){
//            Toast.makeText(MainActivity.this,ee.toString(),Toast.LENGTH_LONG).show();
//        }
    }
});

t2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

//        SQLiteDatabase db2 = dbHelper.getReadableDatabase();
//            db2.execSQL("DELETE FROM STUDENT");
//            db2.close();
//        Toast.makeText(MainActivity.this,"DELETE SUCCESSFUL",Toast.LENGTH_LONG).show();
    }
});




// ----------------fetch single row value-----------------------------
//        try {
//    SQLiteDatabase db1 = dbHelper.getReadableDatabase();
//    String projection[] = {"roll_no", "name", "email", "password"};
//    Cursor c = db1.query("student", projection, null, null, null, null, null);
//    c.moveToPosition(1);
//    a1 = c.getString(0);
//    a2 = c.getString(1);
//   a3 = c.getString(2);
//   a4 = c.getString(3);
//}
//catch (Exception ad){
//    Toast.makeText(MainActivity.this,ad.toString(),Toast.LENGTH_LONG).show();
//}
        // ----------------fetch single row value-----------------------------


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // if (e1.getText().toString().matches("") || e2.getText().toString().matches("") || e3.getText().toString().matches("") || e4.getText().toString().matches("") || e5.getText().toString().matches("")) {
                    if (e1.getText().toString().matches(""))
                        e1.setError("Enter roll no, Plz!");
                    else if (e2.getText().toString().matches(""))
                        e2.setError("Enter name, Plz!");
                    else if (e3.getText().toString().matches(""))
                        e3.setError("Enter email, Plz!");
                    else if (e4.getText().toString().matches(""))
                        e4.setError("Enter password, Plz!");
                    else if(e5.getText().toString().matches(""))
                        e5.setError("Enter confirm password, Plz!");

                    // e1.setError("Enter your roll no, Plz!");


                  //  Toast.makeText(MainActivity.this, "please fill all the details", Toast.LENGTH_LONG).show();
                //}
                else {
                    if(e4.getText().toString().equals(e5.getText().toString())) {

                        try {
                            SQLiteDatabase db2 = dbHelper2.getReadableDatabase();
                            String projection[] = {"roll_no", "name", "division", "unique_code"};
                            //String projection[] = {"id", "roll_no", "name", "email", "password"};
                            Cursor c1 = db2.query("all_student", projection, null, null, null, null, null);

                           // final StringBuffer buffer = new StringBuffer();
                            while (c1.moveToNext()) {
                                // buffer.append("id:" + c.getString(0) + "\n");
                                roll_number = c1.getString(0);
                                name = c1.getString(1);
                                if(roll_number.matches(e1.getText().toString())&&name.matches(e2.getText().toString()))
                                {
                                        flag1=1;
                                        break;
                                }
//                                else {
//                                    Toast.makeText(MainActivity.this, "you are not valid user", Toast.LENGTH_LONG).show();
//                                }
                            }
                    if (flag1>0)
                    {

                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("roll_no", e1.getText().toString());
                        values.put("name", e2.getText().toString());
                        values.put("email", e3.getText().toString());
                        values.put("password", e4.getText().toString());
                        final long row = db.insert("student", null, values);
                        //System.out.println("row number is "+ row);
                        //  String msg=String.valueOf(row);
                        // Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "you are not valid user", Toast.LENGTH_LONG).show();
                    }
                           // showMessage("Data", buffer.toString());
                        }
                        catch (Exception ee){
                            Toast.makeText(MainActivity.this,ee.toString(),Toast.LENGTH_LONG).show();
                        }







//
//                        SQLiteDatabase db = dbHelper.getWritableDatabase();
//                        ContentValues values = new ContentValues();
//                        values.put("roll_no", e1.getText().toString());
//                        values.put("name", e2.getText().toString());
//                        values.put("email", e3.getText().toString());
//                        values.put("password", e4.getText().toString());
//                        final long row = db.insert("student", null, values);
//                        //System.out.println("row number is "+ row);
//                        //  String msg=String.valueOf(row);
//                        // Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
//                        Toast.makeText(MainActivity.this, "registration successful", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "password not match", Toast.LENGTH_LONG).show();
                    }

                }
            }  //else
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(MainActivity.this,Login.class);
                startActivity(ab);
            }
        });



    }
//
//    public void viewAll()
//    {
//
//
//    }
    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    //        public void deleteRow(String value)
//        {
//            SQLiteDatabase db = this.getWritableDatabase();
//            db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+COlUMN_NAME+"='"+value+"'");
//            db.close();
//        }
//

}
