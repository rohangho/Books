package com.example.android.bookview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ROHAN on 05-07-2017.
 */

public class adapter extends ArrayAdapter<custom> {
    public adapter(Activity context, ArrayList<custom> books) {
        super(context, 0, books);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        custom current=getItem(position);

        TextView nameTextView = (TextView) listView.findViewById(R.id.name);

        nameTextView.setText(current.getbook());

        TextView numberTextView = (TextView) listView.findViewById(R.id.author);
        numberTextView.setText(current.getauthor());

        return listView;

    }
}

