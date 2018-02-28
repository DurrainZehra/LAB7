package com.example.point.lab7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by POINT on 2/27/2018.
 */

public class CustomAdapter extends ArrayAdapter {

    public static LayoutInflater layoutInflater = null;

    public class ViewHolder {
        TextView txtUserName;
        TextView txtUserEmail;
        TextView txtUserMobile;
    }

    public CustomAdapter(Context context, int resource, ArrayList<DataModel> list) {
        super(context, resource, list);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();


        DataModel data = (DataModel) getItem(position);

        View rowView;
        rowView = layoutInflater.inflate(R.layout.custom_row_layout, null);
        viewHolder.txtUserName = (TextView) rowView.findViewById(R.id.txtName);
        viewHolder.txtUserEmail = (TextView) rowView.findViewById(R.id.txtEmail);
        viewHolder.txtUserMobile = (TextView) rowView.findViewById(R.id.txtMobile);
        viewHolder.txtUserName.setText(data.getUsername());
        viewHolder.txtUserEmail.setText(data.getUseremail());
        viewHolder.txtUserMobile.setText(data.getUsermobile());
        return rowView;
    }
}