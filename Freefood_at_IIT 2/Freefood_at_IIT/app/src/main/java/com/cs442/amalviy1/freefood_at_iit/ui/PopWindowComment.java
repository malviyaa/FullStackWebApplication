package com.cs442.amalviy1.freefood_at_iit.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cs442.amalviy1.freefood_at_iit.Pojo.ListPojo;
import com.cs442.amalviy1.freefood_at_iit.R;

import java.util.ArrayList;

/**
 * Created by Ankit on 11/27/16.
 */
public class PopWindowComment extends ListActivity {

    TextView textView;
    ArrayList<String> listCollection= new ArrayList<String>();
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_up_comments);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .9), (int) (height * .9));


        if (ListPojo.commentlist.isEmpty()) {
            textView = (TextView) findViewById(R.id.nocomments);
            textView.setText(" No Comments posted yet");
        } else {

            ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, R.layout.row_pop_details, R.id.listTextComment, ListPojo.commentlist);

            setListAdapter(myAdapter);
        }

    }
    }
