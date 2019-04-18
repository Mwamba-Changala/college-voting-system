package com.example.voting_system;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    DatabaseHelper db;
    DatabaseHelper1 db2;
    AlertDialog.Builder builder;
    Condidate db3;
    Vote db4;
    private String m_Text = "";
    AlertDialog.Builder builder2;
    String condidate_name,condidate_name1;
    public int i=0,j,k=0;
    final StringBuffer buffer1 = new StringBuffer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        b3=(Button)findViewById(R.id.btn3);
        b4=(Button)findViewById(R.id.btn4);
        b5=(Button)findViewById(R.id.btn5);
        b6=(Button)findViewById(R.id.btn6);
        b7=(Button)findViewById(R.id.btn7);
        b8=(Button)findViewById(R.id.btn8);
        b9=(Button)findViewById(R.id.btn9);
        b10=(Button)findViewById(R.id.btn10);
        db=new DatabaseHelper(this);
        db2=new DatabaseHelper1(this);
        db3=new Condidate(this);
        db4=new Vote(this);

        builder2 = new AlertDialog.Builder(this);
        final DatabaseHelper dbHelper=new DatabaseHelper(this);
        final DatabaseHelper1 dbHelper2=new DatabaseHelper1(this);
        final Vote dbHelper3=new Vote(this);

        final Condidate dbHelper4 = new Condidate(this);
      //  SQLiteDatabase db3 = dbHelper4.getWritableDatabase();
       // builder1.setMessage("Confirmation Box").setTitle("Are you sure?");

        builder = new AlertDialog.Builder(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go=new Intent(Dashboard.this,AddStudents.class);
                startActivity(go);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //final Condidate dbHelper4=new Condidate(this);
                    SQLiteDatabase db4 = dbHelper4.getWritableDatabase();
                    String projection[] = {"name"};
                    //String projection[] = {"id", "roll_no", "name", "email", "password"};
                    Cursor c = db4.query("condidates", projection, null, null, null, null, null);

                 //   final StringBuffer buffer = new StringBuffer();

                    while (c.moveToNext()) {
                        // buffer.append("id:" + c.getString(0) + "\n");
                     condidate_name= c.getString(0);


                        SQLiteDatabase db5 = dbHelper3.getReadableDatabase();
                        String projection4[] = {"roll_no", "name", "condidate_name"};
                        //String projection[] = {"id", "roll_no", "name", "email", "password"};
                        Cursor c1 = db5.query("votes", projection4, null, null, null, null, null);


                        while (c1.moveToNext()) {
                            // buffer.append("id:" + c.getString(0) + "\n");
                           // buffer1.append("roll_no: " + c1.getString(0) + "\n");
                            //buffer1.append("name: " + c1.getString(1) + "\n");
                            condidate_name1= c1.getString(2);
                            if(condidate_name.equals(condidate_name1))
                            {
                                i++;
                            }
                            // buffer.append("unique_code:" + c.getString(3) + "\n");

                        }
                        buffer1.append(condidate_name+" = "+i+"\n\n");
                        i=0;
                    }


                    showMessage("Condidate Name and there's vote", buffer1.toString());
                }
                catch (Exception ee){
                    Toast.makeText(Dashboard.this,ee.toString(),Toast.LENGTH_LONG).show();
                }
//////////////

                try {
//                    SQLiteDatabase db3 = dbHelper3.getReadableDatabase();
//                    String projection[] = {"roll_no", "name", "condidate_name"};
//                    //String projection[] = {"id", "roll_no", "name", "email", "password"};
//                    Cursor c1 = db3.query("votes", projection, null, null, null, null, null);
//
//                    final StringBuffer buffer1 = new StringBuffer();
//                    while (c1.moveToNext()) {
//                        // buffer.append("id:" + c.getString(0) + "\n");
//                        buffer1.append("roll_no: " + c1.getString(0) + "\n");
//                        buffer1.append("name: " + c1.getString(1) + "\n");
//                        buffer1.append("condidate_name: " + c1.getString(2) + "\n");
//                       // buffer.append("unique_code:" + c.getString(3) + "\n");
//
//                    }


                   // showMessage("Data", buffer1.toString());
                }
                catch (Exception ee){
                    Toast.makeText(Dashboard.this,ee.toString(),Toast.LENGTH_LONG).show();
                }



//                Intent go=new Intent(Dashboard.this,AddStudents.class);
//                startActivity(go);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    SQLiteDatabase db2 = dbHelper2.getReadableDatabase();
                    String projection[] = {"roll_no", "name", "division", "unique_code"};
                    //String projection[] = {"id", "roll_no", "name", "email", "password"};
                    Cursor c = db2.query("all_student", projection, null, null, null, null, null);

                    final StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext()) {
                        // buffer.append("id:" + c.getString(0) + "\n");
                        buffer.append("roll_no:" + c.getString(0) + "\n");
                        buffer.append("name:" + c.getString(1) + "\n");
                        buffer.append("division:" + c.getString(2) + "\n");
                        buffer.append("unique_code:" + c.getString(3) + "\n");

                    }


                    showMessage("Data", buffer.toString());
                }
                catch (Exception ee){
                    Toast.makeText(Dashboard.this,ee.toString(),Toast.LENGTH_LONG).show();
                }
//                Intent go=new Intent(Dashboard.this,AddStudents.class);
//                startActivity(go);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                try {
                    SQLiteDatabase db = dbHelper.getReadableDatabase();
                    String projection[] = {"roll_no", "name", "email", "password"};
                    //String projection[] = {"id", "roll_no", "name", "email", "password"};
                    Cursor c = db.query("student", projection, null, null, null, null, null);

                    final StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext()) {
                        // buffer.append("id:" + c.getString(0) + "\n");
                        buffer.append("roll_no:" + c.getString(0) + "\n");
                        buffer.append("name:" + c.getString(1) + "\n");
                        buffer.append("email:" + c.getString(2) + "\n");
                        buffer.append("password:" + c.getString(3) + "\n");

                    }


                    showMessage("Registered Students List", buffer.toString());
                }
                catch (Exception ee){
                    Toast.makeText(Dashboard.this,ee.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

//                Toast.makeText(Main2Activity.this,
//                        rb.getText(), Toast.LENGTH_SHORT).show();

                    builder2.setMessage("Confirmation Box").setTitle("Are you sure?");


                    //Toast.makeText(Main2Activity.this,rb.getText(), Toast.LENGTH_SHORT).show();
                    builder2.setMessage("Are you sure ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();



                                    try {
                                        SQLiteDatabase db2 = dbHelper2.getReadableDatabase();
                                        db2.execSQL("DELETE FROM ALL_STUDENT");
                                        db2.close();
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
                                        Intent ad=new Intent(Dashboard.this,Dashboard.class);
                                        startActivity(ad);
                                    } catch (Exception ee){
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL All_Student "+ee.toString(), Toast.LENGTH_LONG).show();
                                    }




                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
//                                    Toast.makeText(getApplicationContext(), "you choose no action",
//                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder2.create();
                    //Setting the title manually
                    alert.setTitle("Delete All Students");
                    alert.show();
                    //    }

                } catch (Exception ae) {
                    Toast.makeText(Dashboard.this, ae.toString(), Toast.LENGTH_SHORT).show();
                }







//                try {
//                    SQLiteDatabase db2 = dbHelper2.getReadableDatabase();
//                    db2.execSQL("DELETE FROM ALL_STUDENT");
//                    db2.close();
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
//                } catch (Exception ee){
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL All_Student "+ee.toString(), Toast.LENGTH_LONG).show();
//                }
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

//                Toast.makeText(Main2Activity.this,
//                        rb.getText(), Toast.LENGTH_SHORT).show();

                    builder2.setMessage("Confirmation Box").setTitle("Are you sure?");


                    //Toast.makeText(Main2Activity.this,rb.getText(), Toast.LENGTH_SHORT).show();
                    builder2.setMessage("Are you sure ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();


                                    try {
                                        SQLiteDatabase db = dbHelper.getReadableDatabase();
                                        db.execSQL("DELETE FROM STUDENT");
                                        db.close();
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();

                                        Intent ad=new Intent(Dashboard.this,Dashboard.class);
                                        startActivity(ad);
                                    }
                                    catch (Exception ee){
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL Student "+ee.toString(), Toast.LENGTH_LONG).show();
                                    }




                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
//                                    Toast.makeText(getApplicationContext(), "you choose no action",
//                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder2.create();
                    //Setting the title manually
                    alert.setTitle("Delete Registered Students");
                    alert.show();
                    //    }

                } catch (Exception ae) {
                    Toast.makeText(Dashboard.this, ae.toString(), Toast.LENGTH_SHORT).show();
                }






//                try {
//                    SQLiteDatabase db = dbHelper.getReadableDatabase();
//                    db.execSQL("DELETE FROM STUDENT");
//                    db.close();
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
//                }
//                catch (Exception ee){
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL Student "+ee.toString(), Toast.LENGTH_LONG).show();
//                }
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputbox();

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
show();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

//                Toast.makeText(Main2Activity.this,
//                        rb.getText(), Toast.LENGTH_SHORT).show();

                    builder2.setMessage("Confirmation Box").setTitle("Are you sure?");


                    //Toast.makeText(Main2Activity.this,rb.getText(), Toast.LENGTH_SHORT).show();
                    builder2.setMessage("Are you sure ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();


                                    try {
                                        SQLiteDatabase db3 = dbHelper4.getReadableDatabase();
                                        db3.execSQL("DELETE FROM condidates");
                                        db.close();
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
                                        Intent ad=new Intent(Dashboard.this,Dashboard.class);
                                        startActivity(ad);
                                    }
                                    catch (Exception ee){
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL Student "+ee.toString(), Toast.LENGTH_LONG).show();
                                    }



                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
//                                    Toast.makeText(getApplicationContext(), "you choose no action",
//                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder2.create();
                    //Setting the title manually
                    alert.setTitle("Delete Condidates list");
                    alert.show();
                    //    }

                } catch (Exception ae) {
                    Toast.makeText(Dashboard.this, ae.toString(), Toast.LENGTH_SHORT).show();
                }






//                try {
//                    SQLiteDatabase db3 = dbHelper4.getReadableDatabase();
//                    db3.execSQL("DELETE FROM condidates");
//                    db.close();
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
//                }
//                catch (Exception ee){
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL Student "+ee.toString(), Toast.LENGTH_LONG).show();
//                }
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

//                Toast.makeText(Main2Activity.this,
//                        rb.getText(), Toast.LENGTH_SHORT).show();

                    builder2.setMessage("Confirmation Box").setTitle("Are you sure?");


                    //Toast.makeText(Main2Activity.this,rb.getText(), Toast.LENGTH_SHORT).show();
                    builder2.setMessage("Are you sure ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    finish();




                                    try {
                                        SQLiteDatabase db4 = dbHelper3.getReadableDatabase();
                                        db4.execSQL("DELETE FROM VOTES");
                                        db4.close();
                                        buffer1.delete(0, buffer1.length());
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
                                        Intent ad=new Intent(Dashboard.this,Dashboard.class);
                                        startActivity(ad);
                                    } catch (Exception ee){
                                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL All_Student "+ee.toString(), Toast.LENGTH_LONG).show();
                                    }





                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
//                                    Toast.makeText(getApplicationContext(), "you choose no action",
//                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder2.create();
                    //Setting the title manually
                    alert.setTitle("Clear Results");
                    alert.show();
                    //    }

                } catch (Exception ae) {
                    Toast.makeText(Dashboard.this, ae.toString(), Toast.LENGTH_SHORT).show();
                }


//inputbox1();


//                try {
//                    SQLiteDatabase db4 = dbHelper3.getReadableDatabase();
//                    db4.execSQL("DELETE FROM VOTES");
//                    db4.close();
//                        buffer1.delete(0, buffer1.length());
//                        Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
//                } catch (Exception ee){
//                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL All_Student "+ee.toString(), Toast.LENGTH_LONG).show();
//                }
            }
        });
    }
















    public void inputbox()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add new condidate name");

// Set up the input
        final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
      //  input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                insert(m_Text);

              //  Toast.makeText(Dashboard.this, "entered value is "+m_Text, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

   // public void inputbox1()
  //  {

//        try {
//
////                Toast.makeText(Main2Activity.this,
////                        rb.getText(), Toast.LENGTH_SHORT).show();
//
//            builder.setMessage("Confirmation Box").setTitle("Are you sure?");
//
//
//               //Toast.makeText(Main2Activity.this,rb.getText(), Toast.LENGTH_SHORT).show();
//                builder.setMessage("Are you sure ?")
//                        .setCancelable(false)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                finish();
//                                try {
//                                    SQLiteDatabase db4 = dbHelper3.getReadableDatabase();
//                                    db4.execSQL("DELETE FROM VOTES");
//                                    db4.close();
//                                    buffer1.delete(0, buffer1.length());
//                                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL", Toast.LENGTH_LONG).show();
//                                } catch (Exception ee){
//                                    Toast.makeText(Dashboard.this, "DELETE SUCCESSFUL All_Student "+ee.toString(), Toast.LENGTH_LONG).show();
//                                }
//
//
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                //  Action for 'NO' Button
//                                dialog.cancel();
////                                    Toast.makeText(getApplicationContext(), "you choose no action",
////                                            Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                //Creating dialog box
//                AlertDialog alert = builder.create();
//                //Setting the title manually
//                alert.setTitle("Confirmation Box");
//                alert.show();
//        //    }
//
//        } catch (Exception ae) {
//            Toast.makeText(Main2Activity.this, ae.toString(), Toast.LENGTH_SHORT).show();
//        }


 //   }






    public void insert(String abc)
    {try {
        String name = abc;
        final Condidate dbHelper4 = new Condidate(this);
        SQLiteDatabase db3 = dbHelper4.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);

        final long row = db3.insert("condidates", null, values);
        //System.out.println("row number is "+ row);
        //  String msg=String.valueOf(row);
        // Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
        Toast.makeText(Dashboard.this, "successfully Add", Toast.LENGTH_LONG).show();
    }
    catch (Exception ee){
        Toast.makeText(Dashboard.this,ee.toString(),Toast.LENGTH_LONG).show();
    }
    }
    public void show()
    {
        try {
            final Condidate dbHelper4=new Condidate(this);
            SQLiteDatabase db3 = dbHelper4.getWritableDatabase();
            String projection[] = {"name"};
            //String projection[] = {"id", "roll_no", "name", "email", "password"};
            Cursor c = db3.query("condidates", projection, null, null, null, null, null);

            final StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                // buffer.append("id:" + c.getString(0) + "\n");
                buffer.append(c.getString(0) + "\n");

            }


            showMessage("Condidate List", buffer.toString());
        }
        catch (Exception ee){
            Toast.makeText(Dashboard.this,ee.toString(),Toast.LENGTH_LONG).show();
        }
    }
    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
