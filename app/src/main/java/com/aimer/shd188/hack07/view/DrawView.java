package com.aimer.shd188.hack07.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by shd188 on 15/6/22.
 */
public class DrawView extends View {
    private Rectangle mRectangle;
    public int width;
    public int height;

    public DrawView(Context context) {
        super(context);

        mRectangle=new Rectangle(context,this);
        mRectangle.setARGB(255,255,0,0);
        mRectangle.setSpeedX(3);
        mRectangle.setSpeedY(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRectangle.move();
        mRectangle.onDraw(canvas);

        invalidate();
    }
}
