package com.example.matanbaryosef.home_ex4;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public final String TAG = getClass().getSimpleName();
    private final static int GAME_PLAY_TIME = 90000;
    private final static int GAME_PLAY_EXTRA_TIME = 15000;
    private final static int DELAY = 1000;
    private int scoreIsrael = 0;
    private int scoreJapan = 0;
    TextView scoreStr;
    CustomViewIsrael israelView;
    CustomViewJapan japanView;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreStr = (TextView) findViewById(R.id.mTextField);
        israelView = (CustomViewIsrael)findViewById(R.id.israelFlagView);
        japanView = (CustomViewJapan)findViewById(R.id.japanFlagView);

        new CountDownTimer(GAME_PLAY_TIME, DELAY) { // Timer for 90 seconds game

            public void onTick(long millisUntilFinished) {
                scoreStr.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (scoreIsrael == scoreJapan) {
                    scoreStr.setText("Over Time");
                    tie();
                } else if (scoreIsrael > scoreJapan) {
                    scoreStr.setText("Game over!");
                    israelView.setScore("Win!");
                    japanView.setScore("Lose!");
                } else {
                    scoreStr.setText("Game over!");
                    japanView.setScore("Win!");
                    israelView.setScore("Lose!");
                }
            }
        }.start();
    }

    public void tie() {
        new CountDownTimer(GAME_PLAY_EXTRA_TIME, DELAY) { // Timer for 90 seconds game

            public void onTick(long millisUntilFinished) {
                scoreStr.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (scoreIsrael == scoreJapan) {
                    scoreStr.setText("Tie!");
                    israelView.setScore("Tie!");
                    japanView.setScore("Tie!");
                } else if (scoreIsrael > scoreJapan) {
                    israelView.setScore("Win!");
                    japanView.setScore("Lose!");
                } else {
                    japanView.setScore("Win!");
                    israelView.setScore("Lose!");
                }
                scoreStr.setText("Game over!");
            }
        }.start();
    }
}