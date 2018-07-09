package com.ciweek.demo.ViewPager_Tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ciweek.demo.R;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class NewsFragment extends Fragment  {
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);
        return view;
        }


}
