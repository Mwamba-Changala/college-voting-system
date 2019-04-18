package com.example.voting_system;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddStudents extends AppCompatActivity {
EditText e1,e2,e3,e4;
DatabaseHelper1 db;
TextView t1;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);
        e1=(EditText)findViewById(R.id.stu_id);
        e2=(EditText)findViewById(R.id.stu_UserName);
        e3=(EditText)findViewById(R.id.div);
        e4=(EditText)findViewById(R.id.code);
        b1=(Button)findViewById(R.id.sign_up);
        t1=(TextView)findViewById(R.id.sing_in1);
        db=new DatabaseHelper1(this);
        final DatabaseHelper1 dbHelper=new DatabaseHelper1(this);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(AddStudents.this,Dashboard.class);
                startActivity(ab);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().matches(""))
                    e1.setError("Enter roll no, Plz!");
                else if (e2.getText().toString().matches(""))
                    e2.setError("Enter name, Plz!");
                else if (e3.getText().toString().matches(""))
                    e3.setError("Enter Division, Plz!");
                else if (e4.getText().toString().matches(""))
                    e4.setError("Enter Unique Code, Plz!");
//                else if(e5.getText().toString().matches(""))
//                    e5.setError("Enter confirm password, Plz!");

                    // e1.setError("Enter your roll no, Plz!");


                    //  Toast.makeText(MainActivity.this, "please fill all the details", Toast.LENGTH_LONG).show();
                    //}
                else {

                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("roll_no", e1.getText().toString());
                        values.put("name", e2.getText().toString());
                        values.put("division", e3.getText().toString());
                        values.put("unique_code", e4.getText().toString());
                        final long row = db.insert("all_student", null, values);
                        //System.out.println("row number is "+ row);
                        //  String msg=String.valueOf(row);
                        // Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                        Toast.makeText(AddStudents.this, "addition successful", Toast.LENGTH_LONG).show();



                }
            }
        });
    }
}
