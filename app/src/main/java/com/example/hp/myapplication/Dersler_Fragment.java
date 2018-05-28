package com.example.hp.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dersler_Fragment extends Fragment {


    ArrayList<Dersler> dersler=new ArrayList<Dersler>();
    public Dersler_Fragment() {
        // Required empty public constructor
        Dersler ders1 = new Dersler();
        ders1.setCaption("Harfleri Tanıyalım.");
        ders1.setDescription("Harfleri zihinde tutmak için egzersizler.");
        Dersler ders2 = new Dersler();
        ders2.setCaption("asgasdgasdf.");
        ders2.setDescription("sfgasfgafds.");

        dersler.add(ders1);
        dersler.add(ders2);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dersler_, container, false);
        ListView listView=(ListView) view.findViewById(R.id.derslerListView);
        listView.setAdapter(new DerslerListViewAdapter(getContext(),dersler));
        return  view;
    }

}
