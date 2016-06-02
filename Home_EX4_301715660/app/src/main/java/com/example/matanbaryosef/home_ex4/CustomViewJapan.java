package com.example.matanbaryosef.home_ex4;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;


/**
 * Created by matanbaryosef on 01/06/2016.
 */

public class CustomViewJapan extends CustomViewFlag {

    private final static int SCORE_SIZE = 50;

    public CustomViewJapan (Context context) {
        super(context);
        initView(null);
    }
    public CustomViewJapan (Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        scorePaint.setTextSize(SCORE_SIZE);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(width/2, height/2, height/3, flagPaint);
        canvas.drawText(scoreString, width/9, 2*height/3, scorePaint);

    }

    public void scoreUp() {
        score = score + 1;
        scoreString = Integer.toString(score);
        invalidate();
    }
}