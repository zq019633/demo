package com.ciweek.demo.Permission;

import android.Manifest;
import android.content.Context;

public  class Check {
    private static Context context;


    public Check(Context context) {
       this.context=context;
    }

    public static void Permission(){
        Acp.getInstance(context).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_PHONE_STATE
                                , Manifest.permission.SEND_SMS)
                        .setDeniedMessage("nihao")
                        /*以下为自定义提示语、按钮文字
                        .setDeniedMessage()
                        .setDeniedCloseBtn()
                        .setDeniedSettingBtn()
                        .setRationalMessage()
                        .setRationalBtn()*/
                        .build(),
                null);
    }


}
