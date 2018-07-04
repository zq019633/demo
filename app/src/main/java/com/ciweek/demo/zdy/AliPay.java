package com.ciweek.demo.zdy;

import com.ciweek.demo.interfaceP.zdyCallBack;

public class AliPay {
    private zdyCallBack callBack;

    public AliPay(zdyCallBack callBack) {
        this.callBack = callBack;
    }

    //暴露方法
    public void doPay(String i){
        if(i.equals("1")){
            callBack.success();
        }else{
            callBack.fail(i);
        }

    }




}
