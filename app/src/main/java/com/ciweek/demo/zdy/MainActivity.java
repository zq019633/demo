package com.ciweek.demo.zdy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.ciweek.demo.Permission.Check;
import com.ciweek.demo.Person.Li;
import com.ciweek.demo.Person.Wang;
import com.ciweek.demo.R;
import com.ciweek.demo.interfaceP.StateChange;
import com.ciweek.demo.interfaceP.zdyCallBack;

public class MainActivity extends AppCompatActivity implements StateChange {
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AliPay(new zdyCallBack() {
            @Override
            public void success() {
                Toast.makeText(MainActivity.this,"支付成功",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void fail(String errorCode) {
                Toast.makeText(MainActivity.this,"失败"+errorCode,Toast.LENGTH_SHORT).show();

            }
        }).doPay("2");


        int i = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Toast.makeText(MainActivity.this,"权限"+i,Toast.LENGTH_SHORT).show();


        //initCallBack();


//        final MM m=new MM();
//
//        m.setCallPhone(new Call() {
//            @Override
//            public void callPhone(String value) {
//                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        m.dosomesthing();






//        zdyButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_SHORT).show();
//
//            }
//        });


//        4.调用者调用

        zdyButton zdyButton = (zdyButton) findViewById(R.id.zdybt);
        zdyButton.setStateChange(this);





//        nativeP();

        Log.e("进程myPid","="+android.os.Process.myPid());
        Log.e("进程myUid","="+android.os.Process.myUid());

        new Check(this).Permission();

        zdyButton.setStateChange(this);

    }

    private void initCallBack() {
        Li li=new Li();
        Wang wang=new Wang();
        wang.ask(li);



    }




    @Override
    public void StateChange(boolean State) {

                if(State){
//                    Toast.makeText(MainActivity.this,"点击开",Toast.LENGTH_SHORT).show();
                }else{
//                    Toast.makeText(MainActivity.this,"点击关",Toast.LENGTH_SHORT).show();
                }


    }




    private void nativeP() {
        int i = ContextCompat.checkSelfPermission(this, permissions[0]);
        if (i != PackageManager.PERMISSION_GRANTED) {
            // 如果没有授予该权限，就去提示用户请求
            startRequestPermission();
        }else{
            Toast.makeText(this,"申请成功",Toast.LENGTH_SHORT).show();
        }
    }


    private void startRequestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 321);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 321) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    // 判断用户是否 点击了不再提醒。(检测该权限是否还可以申请)
                    boolean b = shouldShowRequestPermissionRationale(permissions[0]);
                    if (!b) {
                        // 用户还是想用我的 APP 的
                        // 提示用户去应用设置界面手动开启权限
                        goToAppSetting();
                    } else
                        goToAppSetting();
//                        finish();
                    Toast.makeText(this, "权限拒绝", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    // 跳转到当前应用的设置界面
    private void goToAppSetting() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 123);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 检查该权限是否已经获取
                int i = ContextCompat.checkSelfPermission(this, permissions[0]);
                // 权限是否已经 授权 GRANTED---授权  DINIED---拒绝
                if (i != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this,"请先申请权限",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "权限获取成功", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }




}
