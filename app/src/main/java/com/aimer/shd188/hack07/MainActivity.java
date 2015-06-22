package com.aimer.shd188.hack07;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;

import com.aimer.shd188.hack07.view.DrawView;


public class MainActivity extends Activity {

    private DrawView mDrawView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //获取屏幕的宽和高
        Display display=getWindowManager().getDefaultDisplay();
        mDrawView=new DrawView(this);
        mDrawView.width=display.getWidth();
        mDrawView.height=display.getHeight();

        setContentView(mDrawView);
    }


}
