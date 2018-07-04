package com.ciweek.demo.Person;

import android.util.Log;

import com.ciweek.demo.interfaceP.CallBack;

public class Wang implements CallBack {

    private Li li;



    //问问题
    public void ask(Li li){
        this.li=li;
        Log.e("1+1=","==");
    }

    @Override
    public void solve(String result) {
        li.asw();
    }
}
