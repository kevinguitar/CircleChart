package com.example.circlechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 懷民 on 2017/10/3.
 */

public class Circle extends View {

    private static final int ARC_GAP = 5;

    private int mPadding;
    private int mStrokeArcWidth;
    private int mCenter;
    private int mCircleWidth;
    private int[] mPercentage;
    private int[] mColor;
    private int mColorText;
    private float mCurrentAngle;
    private String mPrice = "930,000";
    private RectF mOval;
    private Paint mPaint;

    public Circle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
        init();
    }

    private void setup() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
    }

    private void init() {
        mPadding = 16;
        mStrokeArcWidth = 26;
        mPercentage = new int[]{55, 35, 10};
        mColor = new int[]{0xFFFFAE29, 0xFF7DE85E, 0xFFFEF901};
        mColorText = 0xFF4F4F4F;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mCircleWidth = w - 2 * mPadding;
        mCenter = w / 2;
        modifyOval();
    }

    public void setData(String price, int[] per, int[] color) {
        if (per.length != color.length)
            throw new RuntimeException("");
        this.mPrice = price;
        this.mPercentage = per;
        this.mColor = color;
        invalidate();
    }

    private void modifyOval() {
        mOval = new RectF();
        mOval.left = mPadding;
        mOval.top = mPadding;
        mOval.right = mPadding + mCircleWidth;
        mOval.bottom = mPadding + mCircleWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCurrentAngle = 270;
        //TODO: 動畫實作
        mPaint.setStrokeWidth(mStrokeArcWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        //mPaint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < mPercentage.length; i++)
            drawArc(canvas, mPercentage[i], mColor[i]);
    }

    private void drawArc(Canvas canvas, int per, int color) {
        float angle = per * 360 / 100f;
        canvas.save();
        mPaint.setColor(color);

        //TODO: 角度若不夠減的處理方式
        canvas.drawArc(mOval, mCurrentAngle + ARC_GAP, angle - 2 * ARC_GAP, false, mPaint);
        mCurrentAngle = mCurrentAngle + angle;
        canvas.restore();
    }

}
