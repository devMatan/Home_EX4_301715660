package com.example.matanbaryosef.home_ex4;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by matanbaryosef on 01/06/2016.
 */

public class CustomViewIsrael extends CustomViewFlag {

    private final static int STROKE_WIDTH = 15;
    private final static int SCORE_SIZE = 50;

    public CustomViewIsrael (Context context) {
        super(context);
        initView(null);
    }
    public CustomViewIsrael (Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        flagPaint.setStrokeWidth(STROKE_WIDTH);
        scorePaint.setTextSize(SCORE_SIZE);
        scoreString = "0";
        score = getScore();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // The line above and beneath the shield of david
        canvas.drawLine(left, top + (height/8) , width, top + (height/8), flagPaint); // x1, y1, x2, y2
        canvas.drawLine(left, top + 7*(height/8), width, + 7*(height/8), flagPaint);

        // 1st triangle
        canvas.drawLine(width/2 + 3, height/3 - height/9 , width/3 + 3, 2*height/3, flagPaint);
        canvas.drawLine(width/3 - 3, 2*height/3  , 2*width/3 - 3, 2*height/3, flagPaint);
        canvas.drawLine(width/2, height/3 - height/9 + 3 , 2*width/3, 2*height/3 + 3, flagPaint);

        // 2nd triangle
        canvas.drawLine(width/2 + 3, 2*height/3 + height/9 , width/3 + 3, height/3, flagPaint);
        canvas.drawLine(width/2, 2*height/3 + height/9 , 2*width/3, height/3, flagPaint);
        canvas.drawLine(width/3, height/3, 2*width/3, height/3, flagPaint);

        score = getScore();
        canvas.drawText(scoreString , width/9, 2*height/3, scorePaint);
    }

    public void scoreUp() {
        score = score + 1;
        scoreString = Integer.toString(score);
        invalidate();
    }
}