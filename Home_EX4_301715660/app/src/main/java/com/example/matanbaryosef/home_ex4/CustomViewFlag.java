package com.example.matanbaryosef.home_ex4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by matanbaryosef on 01/06/2016.
 */



public class CustomViewFlag extends View {
    public int top, left, width, height;
    public int score;
    public String scoreString;

    public int flagBackgroundColor;
    public int flagMainColor;
    public int scoreColor;
    public int scoreSize;

    public Paint flagPaint;
    public Paint scorePaint;
    public TypedArray customViewAttr;

    public final String TAG = getClass().getSimpleName();

    public GestureDetector gestureDetector;

    public CustomViewFlag (Context context) {
        super(context);
        initView(context, null);
    }
    public CustomViewFlag (Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        customViewAttr = getContext().obtainStyledAttributes(attrs, R.styleable.CustomViewFlag);
        flagBackgroundColor = customViewAttr.getColor(R.styleable.CustomViewFlag_flagBackgroundColor, Color.WHITE); // init background flag color
        flagMainColor = customViewAttr.getColor(R.styleable.CustomViewFlag_flagMainColor, Color.BLACK); // init main flag color
        scoreColor = customViewAttr.getColor(R.styleable.CustomViewFlag_scoreColor, Color.BLACK); // init score label color
        scoreSize = customViewAttr.getDimensionPixelSize(R.styleable.CustomViewFlag_scoreSize, 0);
        customViewAttr.recycle();

        setBackgroundColor(flagBackgroundColor);
        flagPaint = new Paint();
        flagPaint.setColor(flagMainColor);

        scorePaint = new Paint();
        scorePaint.setTextSize(scoreSize);
        scorePaint.setColor(scoreColor);
        scoreString = "0";
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    // Getters & Setters //
    public int getScore() {
        return score;
    }

    public void setScore(String scoreStr) {
        this.scoreString = scoreStr;
        invalidate();
    }
    // Getters & Setters //

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        left = getPaddingLeft();
        top = getPaddingTop();
        width = w - (getPaddingLeft() + getPaddingRight());
        height = h - (getPaddingBottom() + getPaddingTop());
    }

    public boolean onTouchEvent(MotionEvent event){
        return gestureDetector.onTouchEvent(event);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        public boolean onDown(MotionEvent event) {
            return true;
        }
        public void onLongPress(MotionEvent event) { // Long press
            super.onLongPress(event);
            score = 0;
            scoreString = Integer.toString(score);
            setScore(scoreString);
        }
        public boolean onDoubleTap(MotionEvent event) { // Double tap
            score += 1;
            scoreString = Integer.toString(score);
            setScore(scoreString);
            return true;
        }
    }
}


