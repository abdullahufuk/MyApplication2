package com.example.hp.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class Harfler_Fragment extends Fragment  {

    ViewPager viewPager;
    public Harfler_Fragment() {
        // Required empty public constructor

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;

            view = inflater.inflate(R.layout.fragment_harfler_, container, false);


            TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

            viewPager = (ViewPager) view.findViewById(R.id.viewpager);
            viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
            viewPager.setAdapter(new MyViewPagerAdapter(getChildFragmentManager()));
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
            viewPager.setCurrentItem(2);

        return view;

    }


    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 2:
                    Frg_Tab1 firstTab=new Frg_Tab1();
                    return firstTab;

                case 1:
                    Frg_Tab2 secondTab=new Frg_Tab2();
                    return  secondTab;
                case 0:
                   Frg_Tab3 thirdTab=new Frg_Tab3();
                    return  thirdTab;
                default:return null;
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
