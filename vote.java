package com.example.voting_system;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    AlertDialog.Builder builder;
    Button v1;
    RadioGroup rg;
    RadioButton rb;
    TextView t1, t2;

    RadioGroup rgp;
    Vote db;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v1 = (Button) findViewById(R.id.vote);
       // rg = (RadioGroup) findViewById(R.id.radioGroup);
        t1 = (TextView) findViewById(R.id.rollNo);
        //  t1=(TextView)findViewById(R.id.rollNo);
        t2 = (TextView) findViewById(R.id.name);

        db = new Vote(this);
        final Vote dbHelper = new Vote(this);
        builder = new AlertDialog.Builder(this);

        // get selected radio button from radioGroup

        Intent intent = getIntent();
        String stu_id = intent.getStringExtra("a1");
        String stu_name = intent.getStringExtra("a2");
        // Toast.makeText(Main2Activity.this, stu_id+stu_pass, Toast.LENGTH_SHORT).show();
        t1.setText(stu_id);
        t2.setText(stu_name);
        final Condidate dbHelper4 = new Condidate(this);
        SQLiteDatabase db3 = dbHelper4.getWritableDatabase();

        try {

            String projection[] = {"name"};
            //String projection[] = {"id", "roll_no", "name", "email", "password"};
            Cursor c = db3.query("condidates", projection, null, null, null, null, null);

            final StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                // buffer.append("id:" + c.getString(0) + "\n");
              //  buffer.append(c.getString(0) + "\n");



                 rgp = (RadioGroup) findViewById(R.id.radio_group);

                    RadioButton rbn = new RadioButton(this);
                    rbn.setId(View.generateViewId());
                    rbn.setText(c.getString(0));
                    rbn.setTextSize(18);
                    rgp.addView(rbn);



            }


          //  showMessage("Condidate List", buffer.toString());
        }
        catch (Exception ee){
            Toast.makeText(Main2Activity.this,ee.toString(),Toast.LENGTH_LONG).show();
        }
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

//                Toast.makeText(Main2Activity.this,
//                        rb.getText(), Toast.LENGTH_SHORT).show();

                    builder.setMessage("Confirmation Box").setTitle("Are you sure?");

                    int selectedId = rgp.getCheckedRadioButtonId();
                    rb = (RadioButton) findViewById(selectedId);
                    if(selectedId==-1){
                        Toast.makeText(Main2Activity.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Main2Activity.this,rb.getText(), Toast.LENGTH_SHORT).show();
                        builder.setMessage("Are you sure ?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        finish();
                                        try {
                                           // int selectedId = rg.getCheckedRadioButtonId();

                                            // find the radiobutton by returned id
                                            //rb = (RadioButton) findViewById(selectedId);
                                            // Toast.makeText(Main2Activity.this, rb.getText(), Toast.LENGTH_SHORT).show();


                                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                                            ContentValues values = new ContentValues();
                                            values.put("roll_no", t1.getText().toString());
                                            values.put("name", t2.getText().toString());
                                            values.put("condidate_name", rb.getText().toString());
                                            //values.put("unique_code", e4.getText().toString());
                                            final long row = db.insert("votes", null, values);
                                            //System.out.println("row number is "+ row);
                                            //  String msg=String.valueOf(row);
                                            // Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
                                            //  Toast.makeText(Main2Activity.this, "addition successful", Toast.LENGTH_LONG).show();

                                            Intent it = new Intent(Main2Activity.this, Login.class);
                                            startActivity(it);


                                        } catch (Exception e) {
                                            Toast.makeText(Main2Activity.this, e.toString(), Toast.LENGTH_SHORT).show();
//                                            Intent ad = new Intent(Main2Activity.this, Main2Activity.class);
//                                            startActivity(ad);
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
                        AlertDialog alert = builder.create();
                        //Setting the title manually
                        alert.setTitle("Confirmation Box");
                        alert.show();
                    }} catch (Exception ae) {
                    Toast.makeText(Main2Activity.this, ae.toString(), Toast.LENGTH_SHORT).show();
                    }



                    //Setting message manually and performing action on button click
//                    builder.setMessage("Are you sure ?")
//                            .setCancelable(false)
//                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    finish();
//                                    try {
//                                        int selectedId = rg.getCheckedRadioButtonId();
//
//                                        // find the radiobutton by returned id
//                                        rb = (RadioButton) findViewById(selectedId);
//                                        // Toast.makeText(Main2Activity.this, rb.getText(), Toast.LENGTH_SHORT).show();
//
//
//                                        SQLiteDatabase db = dbHelper.getWritableDatabase();
//                                        ContentValues values = new ContentValues();
//                                        values.put("roll_no", t1.getText().toString());
//                                        values.put("name", t2.getText().toString());
//                                        values.put("condidate_name", rb.getText().toString());
//                                        //values.put("unique_code", e4.getText().toString());
//                                        final long row = db.insert("votes", null, values);
//                                        //System.out.println("row number is "+ row);
//                                        //  String msg=String.valueOf(row);
//                                        // Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
//                                        //  Toast.makeText(Main2Activity.this, "addition successful", Toast.LENGTH_LONG).show();
//
//                                        Intent it = new Intent(Main2Activity.this, Login.class);
//                                        startActivity(it);
//
//
//                                    } catch (Exception e) {
//                                        Toast.makeText(Main2Activity.this,
//                                                "Please select any condidate", Toast.LENGTH_SHORT).show();
//                                        Intent ad = new Intent(Main2Activity.this, Main2Activity.class);
//                                        startActivity(ad);
//                                    }
//
//
//                                }
//                            })
//                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    //  Action for 'NO' Button
//                                    dialog.cancel();
////                                    Toast.makeText(getApplicationContext(), "you choose no action",
////                                            Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                    //Creating dialog box
//                    AlertDialog alert = builder.create();
//                    //Setting the title manually
//                    alert.setTitle("Confirmation Box");
//                    alert.show();
//                } catch (Exception ae) {
//
//                }

            }


        });











    }


}
