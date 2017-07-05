package com.example.android.bookview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ROHAN on 05-07-2017.
 */

public class adapter extends ArrayAdapter {
    public adapter(Activity context, ArrayList<custom>books) {
        super(context,0,books);
    }

}
