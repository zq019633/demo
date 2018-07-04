package com.ciweek.demo.ViewPager_Tablayout.ButtonFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciweek.demo.R;
import com.ciweek.demo.ViewPager_Tablayout.AFragmentAdapter;
import com.ciweek.demo.ViewPager_Tablayout.HotFragment;
import com.ciweek.demo.ViewPager_Tablayout.NewsFragment;

import java.util.ArrayList;

public class AFragment extends Fragment {
    private TabLayout vpTop;
    private ViewPager viewPager;
    private ArrayList<String> title;
    private ArrayList<Fragment> fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, null);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        vpTop = view.findViewById(R.id.tbTop);
        viewPager=view.findViewById(R.id.vp);
        initData();


        viewPager.setAdapter(new AFragmentAdapter(getChildFragmentManager(),fragments,title));
        viewPager.setOffscreenPageLimit(2);
        vpTop.setupWithViewPager(viewPager);




    }

    private void initData() {
        fragments=new ArrayList<>();
        fragments.add(new HotFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());


        title=new ArrayList<>();
        title.add("推荐");
        title.add("新闻");
        title.add("热点");
        title.add("美食");
        title.add("短视频");
        title.add("图片");
        title.add("世界杯");
        title.add("社会");
        title.add("故事");
        title.add("股票");

    }
}
