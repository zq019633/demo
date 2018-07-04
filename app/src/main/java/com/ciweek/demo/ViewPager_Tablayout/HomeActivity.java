package com.ciweek.demo.ViewPager_Tablayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;



import com.ciweek.demo.R;
import com.ciweek.demo.ViewPager_Tablayout.ButtonFragment.AFragment;
import com.ciweek.demo.ViewPager_Tablayout.ButtonFragment.CarFragment;
import com.ciweek.demo.ViewPager_Tablayout.ButtonFragment.MeFragment;
import com.ciweek.demo.ViewPager_Tablayout.ButtonFragment.MsgFragment;
import com.ciweek.demo.ViewPager_Tablayout.ButtonFragment.WtFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private NoScrollViewPager vp;
    private TabLayout tb;
    private TabLayout tbTop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
    }

    private void initData() {
        List<Fragment> fragments=new ArrayList<>();
        List<String> title=new ArrayList<>();
        title.add("首页");
        title.add("微淘");
        title.add("消息");
        title.add("购物车");
        title.add("我的");

        fragments.add(new AFragment());
        fragments.add(new WtFragment());
        fragments.add(new MsgFragment());
        fragments.add(new CarFragment());
        fragments.add(new MeFragment());

        MyPageAdataer myPageAdataer=new MyPageAdataer(getSupportFragmentManager(),title,fragments);
        vp.setAdapter(myPageAdataer);
        tb.setupWithViewPager(vp);


        for (int i=0;i<tb.getTabCount();i++){
            TabLayout.Tab tab = tb.getTabAt(i);
            Drawable d=null;
            switch (i){
                case 0:
                    d=getResources().getDrawable(R.drawable.homeselect);
                    break;
                case 1:
                    d=getResources().getDrawable(R.drawable.wtselect);
                    break;
                case 2:
                    d=getResources().getDrawable(R.drawable.msgselect);
                    break;
                case 3:
                    d=getResources().getDrawable(R.drawable.carselect);
                    break;
                case 4:
                    d=getResources().getDrawable(R.drawable.meselect);
                    break;
            }
            tab.setIcon(d);
        }

    }

    private void initView() {
        vp=(NoScrollViewPager) findViewById(R.id.vp);

        tb=(TabLayout) findViewById(R.id.tb);

    }
}
