package com.example.android.bookview;

import android.provider.UserDictionary;

/**
 * Created by ROHAN on 05-07-2017.
 */

public class custom {
    private String bookname;
    private String author;

    public custom(String a,String b){
        bookname=a;
        author=b;
    }

    public String getbook(){return bookname;}
    public String getauthor(){return author;}

}
