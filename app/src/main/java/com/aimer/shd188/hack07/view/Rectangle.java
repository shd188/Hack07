package com.aimer.shd188.hack07.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by shd188 on 15/6/22.
 */
public class Rectangle extends View {

    private DrawView mDrawView;
    private Paint mInnerPaint;
    private RectF mDrawRect;

    public static final int MAX_SIZE = 40;
    private static final int ALPHA = 255;
    private int mCoordX = 0;
    private int mCoordY = 0;
    private int mRealSize = 40;
    private int mSpeedX = 3;
    private int mSpeedY = 3;

    private boolean goRight = true;
    private boolean goDown = true;

    public Rectangle(Context context, DrawView drawView) {
        super(context);
        mDrawView = drawView;

        mInnerPaint = new Paint();
        mDrawRect = new RectF();

        mInnerPaint.setARGB(ALPHA, 255, 0, 0);
        mInnerPaint.setAntiAlias(true);
    }

    public void setARGB(int a, int r, int g, int b) {
        mInnerPaint.setARGB(a, r, g, b);
    }

    public void setX(int newValue) {
        mCoordX = newValue;
    }

    public int get_X() {
        return mCoordX;
    }

    public void setY(int newValue) {
        mCoordY = newValue;
    }

    public int get_Y() {
        return mCoordY;
    }

    public void move() {
        moveTo(mSpeedX, mSpeedY);
    }

    private void moveTo(int speedX, int speedY) {
        if (mCoordX > (mDrawView.width - MAX_SIZE)) {
            goRight = false;
        }

        if (mCoordX < 0) {
            goRight = true;
        }

        if (mCoordY > (mDrawView.height - MAX_SIZE)) {
            goDown = false;
        }

        if (mCoordY < 0) {
            goDown = true;
        }

        if (goRight) {
            mCoordX += speedX;
        } else {
            mCoordX -= speedX;
        }

        if (goDown) {
            mCoordY += speedY;
        } else {
            mCoordY -= speedY;
        }
    }

    public void setSpeedX(int speedX) {
        mSpeedX = speedX;
    }

    public int getSpeedX() {
        return mSpeedX;
    }

    public void setSpeedY(int speedY) {
        mSpeedY = speedY;
    }

    public int getSpeedY() {
        return mSpeedY;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mDrawRect.set(mCoordX, mCoordY, mCoordX + mRealSize, mCoordY + mRealSize);
        canvas.drawRoundRect(mDrawRect, 0, 0, mInnerPaint);
    }

    public void setSize(int newSize) {
        mRealSize = newSize;
    }

    public int getSize() {
        return mRealSize;
    }
}


