package com.cs442.amalviy1.freefood_at_iit.asynctask;

import android.os.AsyncTask;
import android.text.Editable;
import android.util.Log;

import com.cs442.amalviy1.freefood_at_iit.Pojo.ListPojo;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ankit on 11/13/16.
 */
public class Database_Coments_entry extends AsyncTask<String,Void,Object> {

    Connection conn;
    Statement stmt;
    @Override
    protected Object doInBackground(String... params) {

        if(params.length==2)
        {
            try {

                storecomments(params[0],params[1]);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        else
        {
            getItemComments(params[0]);
        }
        return null;


    }

    private void getItemComments(String param) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://ankit1.c9vfq8had7xm.us-west-2.rds.amazonaws.com:3306/android?user=ankit1&password=ankitankit");
            // stmt = (Statement) conn.createStatement();
            stmt = (Statement) conn.createStatement();
            ArrayList<String> listCollection= new ArrayList<String>();

            String query= "SELECT * from comments where id="+"'"+param+"'";
            Log.d("hello  "+query," ");
            ResultSet rs = stmt.executeQuery("SELECT * from comments where id="+"'"+param+"'");
            while (rs.next()) {
                Log.d(" print  "+rs.getString("user_comment"),"   ");
                listCollection.add(rs.getString("user_comment"));




            }
            ListPojo.setCommentlist(listCollection);

            Log.d("hello  "+ListPojo.getCommentlist()," ");

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }


    }

    private void storecomments(String param, String comment ) throws SQLException, ClassNotFoundException {

try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(
            "jdbc:mysql://ankit1.c9vfq8had7xm.us-west-2.rds.amazonaws.com:3306/android?user=ankit1&password=ankitankit");
    // stmt = (Statement) conn.createStatement();
    stmt = (Statement) conn.createStatement();
    stmt.execute("INSERT INTO comments (id, user_comment) VALUES ('" + Integer.parseInt(param) + "','" + comment + "');");


    conn.close();
}
catch (Exception e)
{
    System.err.println(e.getMessage());
}
    }

    private  void  dbConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://ankit1.c9vfq8had7xm.us-west-2.rds.amazonaws.com:3306/android?user=ankit1&password=ankitankit");
        // stmt = (Statement) conn.createStatement();
        conn.setAutoCommit(false);
    }



}
