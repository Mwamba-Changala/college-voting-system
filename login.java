package com.example.voting_system;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
Button b1,b2;
 //   DatabaseHelper db;
    //Vote db3;
    Vote db4;
EditText e1,e2,e3;
String roll_no,password,unique_code,unique_code1,roll_no1;
    String user_id,pass,name;
TextView t1;
    Cursor c1,c2,c3;
int flag=0,check=0,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Vote dbHelper3=new Vote(this);
      //  db=new DatabaseHelper(this);
        final DatabaseHelper dbHelper=new DatabaseHelper(this);
        final DatabaseHelper1 dbHelper1=new DatabaseHelper1(this);
        b1=(Button)findViewById(R.id.login);
        t1=(TextView) findViewById(R.id.register);
        e1=(EditText)findViewById(R.id.login_id);
        e2=(EditText)findViewById(R.id.password);
        e3=(EditText)findViewById(R.id.unique_code);
        db4=new Vote(this);
       // final Vote dbHelper3=new Vote(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user_id=e1.getText().toString();
                pass=e2.getText().toString();
                unique_code=e3.getText().toString();
            //if(user_id=="" || pass=="")
            //{
                if(user_id.matches(""))
                   e1.setError("Plz enter roll no");
                else if(pass.matches(""))
                    e2.setError("Plz enter password");
            //}
            else {
                if (user_id.equals("1111") && pass.equals("1111")) {
                    Intent nt2 = new Intent(Login.this, Dashboard.class);
                    startActivity(nt2);
                } else {

                    try {



                        SQLiteDatabase db4 = dbHelper3.getReadableDatabase();
                        String projection4[] = {"roll_no", "name", "condidate_name"};
                        //String projection[] = {"id", "roll_no", "name", "email", "password"};
                       c1 = db4.query("votes", projection4, null, null, null, null, null);



                        while (c1.moveToNext()) {
                            // buffer.append("id:" + c.getString(0) + "\n");
                            // buffer1.append("roll_no: " + c1.getString(0) + "\n");
                            //buffer1.append("name: " + c1.getString(1) + "\n");
                            roll_no1 = c1.getString(0);
                            if (roll_no1.equals(unique_code)) {
                                j++;
                                break;
                            }
                        }
                        if (j > 0) {
                            Toast.makeText(Login.this, "Already you have voted" + j, Toast.LENGTH_LONG).show();
                            j=0;
                        }



                        else {


                        SQLiteDatabase db1 = dbHelper.getReadableDatabase();

                        String projection[] = {"roll_no", "name", "email", "password"};
                       c2 = db1.query("student", projection, null, null, null, null, null);

                        while (c2.moveToNext()) {

                            roll_no = c2.getString(0);
                            name = c2.getString(1);
                            password = c2.getString(3);
                            SQLiteDatabase db2 = dbHelper1.getReadableDatabase();
                            String projection1[] = {"roll_no", "name", "division", "unique_code"};
                            String whereClause = roll_no;
                            c3 = db2.query("all_student", projection1, whereClause, null, null, null, null);
                            c3.moveToFirst();
                            //  unique_code1=c.moveToFirst();
                            // while (c1.moveToNext()) {
                            unique_code1 = c3.getString(3);
                            //  }
                            if (user_id.equals(roll_no) && pass.equals(password)) {




                                flag = flag + 1;
                                break;

                            }

                        }


                        //      }

                        if (flag > 0) {
                            Intent i = new Intent(Login.this, Main2Activity.class);
                            i.putExtra("a1", roll_no);
                            i.putExtra("a2", name);
                            startActivity(i);
                            Toast.makeText(Login.this, "Unique code is  = " + unique_code1, Toast.LENGTH_LONG).show();
                            flag=0;

                        }  else {

                            Toast.makeText(Login.this, "Please Enter Valid roll no and password = " + flag, Toast.LENGTH_LONG).show();
                        }
                    }


                                //    showMessage("Data", buffer1.toString());
                                }
                                catch (Exception ee){
                                    Toast.makeText(Login.this,ee.toString(),Toast.LENGTH_LONG).show();
                                }


                            }


                        }
           }
        });
       t1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent nt1=new Intent(Login.this,MainActivity.class);
               startActivity(nt1);
           }
       });
    }
    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
