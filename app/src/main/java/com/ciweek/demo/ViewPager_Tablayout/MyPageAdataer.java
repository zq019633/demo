package com.ciweek.demo.ViewPager_Tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyPageAdataer extends FragmentPagerAdapter {

    private final List<String> title;
    private final List<Fragment> fragments;

    public MyPageAdataer(FragmentManager fm, List<String> title, List<Fragment> fragments) {
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
        return title.get(position);
    }
}
