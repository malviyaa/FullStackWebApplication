package com.cs442.amalviy1.freefood_at_iit.ui;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cs442.amalviy1.freefood_at_iit.Pojo.DisplayPojo;
import com.cs442.amalviy1.freefood_at_iit.Pojo.IdstorePojo;
import com.cs442.amalviy1.freefood_at_iit.Pojo.ListPojo;
import com.cs442.amalviy1.freefood_at_iit.Pojo.Token_Pojo;
import com.cs442.amalviy1.freefood_at_iit.R;
import com.mysql.jdbc.Statement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ankit on 11/27/16.
 */
public class CommentPop extends Activity {


    Context context;
    Connection conn;
    Statement stmt;
    File file;
    DateFormat dateFormat;
    Date date;
    String photoName;
    static java.sql.PreparedStatement ps = null;
    static java.sql.PreparedStatement token_ps = null;
    int i=1;
    ArrayList<DisplayPojo> listofitems = new ArrayList<DisplayPojo>();
    private Handler handler;
    private ProgressDialog dialog;
    List<String> listvalues= new ArrayList<String>();
    ArrayList<String> listCollection= new ArrayList<String>();
    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_up_comments);
        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.9));

        dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait!!");
        dialog.setCancelable(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.show();

        new Thread() {
            public void run() {
                // Do operation here.


                try {
                    dbConnection();




                    Log.d( "loop "+IdstorePojo.id,"  ds" );
                    ps = conn.prepareStatement("SELECT * from comments where id="+"'"+IdstorePojo.id+"'");

                    ResultSet rs = ps.executeQuery();
                    Log.d( "loop2 "+IdstorePojo.id,"  ds" );
                    while (rs.next()) {
                        Log.d(" print inner "+rs.getString("user_comment"),"   ");
                        listCollection.add(rs.getString("user_comment"));



                    }
//                    Log.d( "This is Final size "+ListPojo.getArrayItem().size(),"=========================" );
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                //                and then mark handler to notify to main thread to  remove  progressbar
                handler.sendEmptyMessage(0);

                //    Or if you want to access UI elements here then

                runOnUiThread(new Runnable() {

                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), PopWindowComment.class);

                        startActivity(intent);

                    }
                });

            }
        }.start();

        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                dialog.dismiss();
            };
        };

  ListPojo.setCommentlist(listCollection);



        //  ListView text= (ListView) findViewById(R.id.commentlist);


    }




    private  void  dbConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://ankit1.c9vfq8had7xm.us-west-2.rds.amazonaws.com:3306/android?user=ankit1&password=ankitankit");
        // stmt = (Statement) conn.createStatement();
        conn.setAutoCommit(false);

    }


}
