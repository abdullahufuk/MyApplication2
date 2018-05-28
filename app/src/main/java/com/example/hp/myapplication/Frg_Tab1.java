package com.example.hp.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frg_Tab1 extends Fragment {


    GridView gridView;

    public Frg_Tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_frg__tab1, container, false);
        gridView=view.findViewById(R.id.gridViewPage1);
        GridViewAdapterPage1 gridViewAdapterPage1=new GridViewAdapterPage1(getContext());
        gridView.setAdapter(gridViewAdapterPage1);
        return view;
    }

}
