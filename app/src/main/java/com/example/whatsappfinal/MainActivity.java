package com.example.whatsappfinal;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        MyViewPagerAdapter adapter= new MyViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new ChatFragment(),"Chat");
        adapter.addFragment(new StatusFragment(),"Status");
        adapter.addFragment(new CallFragment(),"Call");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    class MyViewPagerAdapter extends FragmentPagerAdapter
    {
        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        MyViewPagerAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
            fragments = new ArrayList<>();
            titles = new ArrayList<>();
        }
        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
        public void addFragment(Fragment f,String t)
        {
            fragments.add(f);
            titles.add(t);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
