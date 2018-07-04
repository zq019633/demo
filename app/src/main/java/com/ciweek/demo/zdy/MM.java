package com.ciweek.demo.zdy;

import com.ciweek.demo.interfaceP.Call;

public class MM {
    private Call call;

    public MM(){
    }
    //暴露方法
    public void setCallPhone(Call call){
        this.call=call;
    }




    public void dosomesthing(){
        call.callPhone("小明该吃饭了");
    }








}
