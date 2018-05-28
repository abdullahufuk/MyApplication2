package com.example.hp.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GridViewAdapterPage2 extends BaseAdapter {
    Context context;

    public GridViewAdapterPage2(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_view_adapter_page2, null);
            viewHolder = new ViewHolder();
            viewHolder.harfView = convertView.findViewById(R.id.harfImageView2);
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
