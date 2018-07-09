package com.ciweek.demo.ViewPager_Tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

public class AFragmentAdapter extends FragmentPagerAdapter {
    private final ArrayList<String> title;
    private final ArrayList<Fragment> fragments;

    public AFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> title) {
        super(fm);
        this.title=title;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.e("位置","位置"+position);
        return title.get(position);
    }
}
