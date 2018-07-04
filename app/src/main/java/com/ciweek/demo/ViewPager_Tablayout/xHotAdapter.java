package com.ciweek.demo.ViewPager_Tablayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ciweek.demo.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class xHotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnBannerListener {
    private final List<String> list;
    private final Context context;
    private static final int HEAD_VIEW = 0;//头布局
    private static final int BODY_VIEW = 1;//内容布局
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    public xHotAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
        initBanner();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View view = null;
        ViewHolder holder = null;
        if(HEAD_VIEW==viewType){
            view =mInflater.inflate(R.layout.banner, parent,false);
             holder =new HeadViewHolder(view);
            return holder;
        }
//
        if(BODY_VIEW==viewType){
             view =mInflater.inflate(R.layout.item, parent,false);
             holder=new BodyViewHolder(view);
            return holder;
        }
       return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(holder instanceof HeadViewHolder){
            ((HeadViewHolder) holder).banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //设置图片加载器，图片加载器在下方
            ((HeadViewHolder) holder).banner.setImageLoader(new MyLoader());
            //设置图片网址或地址的集合
            ((HeadViewHolder) holder).banner.setImages(list);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            ((HeadViewHolder) holder).banner.setBannerAnimation(Transformer.Tablet);
            //设置轮播图的标题集合
//            ((HeadViewHolder) holder).banner.setBannerTitles(list_title);
            //设置轮播间隔时间
            ((HeadViewHolder) holder).banner.setDelayTime(3000);
            //设置是否为自动轮播，默认是“是”。
            ((HeadViewHolder) holder).banner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            ((HeadViewHolder) holder).banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
//                    .setOnBannerListener(this)
                    //必须最后调用的方法，启动轮播图。
                    .start();



        }

        if(holder instanceof BodyViewHolder){
            ((BodyViewHolder) holder).textView.setText("nihao");
        }
    }
    //根据不同类型 返回 不同的布局
    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return HEAD_VIEW;
        }else{
            return BODY_VIEW;
        }
    }


    @Override
    public int getItemCount() {
        return list.size()+1;
    }
//
    class HeadViewHolder extends RecyclerView.ViewHolder{
         Banner banner;


        public HeadViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);

        }
    }


    class BodyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public BodyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);


        }
    }




    private void initBanner() {
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
    }


    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+position+"张轮播图");
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }





}
