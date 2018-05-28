package com.example.hp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DerslerListViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<Dersler> derslerArrayList;

    public DerslerListViewAdapter(Context context,ArrayList<Dersler> derslerArrayList) {
        this.context = context;
        this.derslerArrayList=derslerArrayList;

    }

    @Override
    public int getCount() {
        return derslerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.dersler_listview_item, null, false);
            viewHolder.textViewCaption = (TextView) convertView.findViewById(R.id.textViewCaption);
            viewHolder.textViewCaption.setText(derslerArrayList.get(position).getCaption());
            viewHolder.textViewDescription = (TextView) convertView.findViewById(R.id.textViewDescription);
            viewHolder.textViewDescription.setText(derslerArrayList.get(position).getDescription());
            convertView.setTag(viewHolder);


        } else
            viewHolder = (ViewHolder) convertView.getTag();
        return convertView;
    }

    class ViewHolder {

        TextView textViewCaption;
        TextView textViewDescription;

    }
}
