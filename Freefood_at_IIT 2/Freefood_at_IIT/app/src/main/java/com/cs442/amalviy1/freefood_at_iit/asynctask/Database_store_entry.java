package com.cs442.amalviy1.freefood_at_iit.asynctask;

import android.os.AsyncTask;
import android.util.Log;

import com.mysql.jdbc.Statement;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Ankit on 11/13/16.
 */
public class Database_store_entry extends AsyncTask<Integer,Void,Object> {

    Connection conn;
    Statement stmt;
    @Override
    protected Object doInBackground(Integer... params) {
        if(params.length==2)
        {
            try {

                enterLikes(params[0],params[1]);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void enterLikes(Integer param, Integer like ) throws SQLException, ClassNotFoundException {

try {
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(
            "jdbc:mysql://ankit1.c9vfq8had7xm.us-west-2.rds.amazonaws.com:3306/android?user=ankit1&password=ankitankit");
    // stmt = (Statement) conn.createStatement();
    String query = "update freefood_post set likes = ? where id = ?";


    PreparedStatement ps = conn.prepareStatement(query);

    ps.setInt(1, like);
    ps.setInt(2, param);
    ps.execute();
    Log.d("In update my sql "+like, "Update "+param);

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
