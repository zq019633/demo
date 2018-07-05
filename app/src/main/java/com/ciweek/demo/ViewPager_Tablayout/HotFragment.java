package com.ciweek.demo.ViewPager_Tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ciweek.demo.R;
import com.ciweek.demo.ViewPager_Tablayout.javaBean.Film;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jcodecraeer.xrecyclerview.XRecyclerView;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HotFragment extends Fragment {

    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private XRecyclerView rv;
    private List<String> list;
    private boolean isUpdate = false;
    private List<Film> userList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hot, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {





        rv = view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        initData();
    }

    private void initData() {
        //请求队列
        RequestQueue mQueue= Volley.newRequestQueue(getContext());

        //创建StringRequest 实例
        StringRequest stringRequest=new StringRequest("http://api.enet.com.cn/ciweek/zhouqiangFilm.json", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("数据","="+response);
                Gson gson=new Gson();

                JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();
                userList = gson.fromJson(jsonArray, new TypeToken<List<Film>>() {}.getType());
                sendAdapter(userList);

                String url= userList.get(0).getBdyUrl();
                Log.e("url","-"+url);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }

        );

        mQueue.add(stringRequest);

    }

    private void sendAdapter(List<Film> userList) {
        list = new ArrayList<>();
        list.add("我是第二块");
        list.add("我是第三块");


        final ArrayList<String> refList = new ArrayList<>();
        refList.add("111");
        refList.add("222");
        refList.add("333");


        final xHotAdapter adapter = new xHotAdapter(getContext(), userList, isUpdate);
        rv.setArrowImageView(R.drawable.home);
        rv.setAdapter(adapter);

        final ArrayList<String> mData=new ArrayList<>();


        //初始化轮播图


        rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "刷新出来了", Toast.LENGTH_SHORT).show();
//                list.clear();
//                list.addAll(refList);


//                list.add(1, "我是下拉出来的");
//                adapter.notifyDataSetChanged();



                // rv.setAdapter(new xHotAdapter(getContext(), list, isUpdate));

                rv.refreshComplete();

            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "上啦 出来了", Toast.LENGTH_SHORT).show();
//                list.add("我是上啦出来的");
                rv.loadMoreComplete();
            }
        });


    }




}
