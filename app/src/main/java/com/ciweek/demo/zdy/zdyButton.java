package com.ciweek.demo.zdy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;


import com.ciweek.demo.interfaceP.StateChange;


public class zdyButton extends View {
    boolean state=true;


    StateChange stateChange;

    public zdyButton(Context context) {
        super(context);
        init(context);
    }

    public zdyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public zdyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }


    //2 . 暴露方法
    //状态改变 相应事件
    public  void setStateChange(StateChange stateChange){
        this.stateChange=stateChange;

    }

    private void init(Context context) {
        //3. 设置点击事件
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                stateChange.StateChange(state);
                state=!state;
            }
        });
    }


}
