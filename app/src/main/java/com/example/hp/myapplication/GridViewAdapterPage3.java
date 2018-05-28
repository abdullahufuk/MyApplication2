package com.example.hp.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;

public class GridViewAdapterPage3 extends BaseAdapter {

    Context context;

    public GridViewAdapterPage3(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 9;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_view_adapter_page3, null);
            viewHolder = new ViewHolder();
            viewHolder.harfView = convertView.findViewById(R.id.harfImageView3);
            viewHolder.harfView.setImageResource(R.drawable.kuran);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();


        return convertView;
    }

    public class ViewHolder {

        ImageView harfView;
    }

}
