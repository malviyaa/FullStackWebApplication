package com.cs442.amalviy1.freefood_at_iit.Pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankit on 11/7/16.
 */
public class ListPojo {
    public  static ArrayList<DisplayPojo> arrayItem=null;
    public static ArrayList commentlist=null;



    public static ArrayList getCommentlist() {
        return commentlist;
    }

    public static void setCommentlist(ArrayList commentlist1) {
       commentlist = commentlist1;
    }

    public static ArrayList<DisplayPojo> getArrayItem() {
        return arrayItem;
    }

    public static void setArrayItem(ArrayList<DisplayPojo> arrayItem1) {


       arrayItem = arrayItem1;
    }
}
