package com.example.matanbaryosef.myapplication;

import android.system.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;



//import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    Button buttonTakePicture, buttonNext, buttonSetting ;
    ImageView displayImage1, displayImage2, displayImage3;
    RatingBar ratingBar1, ratingBar2, ratingBar3;
    final int DEF_FONT_SIZE = 15, MAX_FONT = 25;
    int fontSize, imageCounter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        int fontSize = DEF_FONT_SIZE;
//        String newSetting = Setting.getDefaults("fontSize", this);

//        try {
//            fontSize = Integer.parseInt(newSetting); // Parsing fontSizeLabel to int
//        } catch (Exception e) { // Do nothing }

            buttonTakePicture = (Button) findViewById(R.id.takePictureButton);
            buttonNext = (Button) findViewById(R.id.buttonNext);
            buttonSetting = (Button) findViewById(R.id.buttonSetting);

//            fontSize = fontSize >= MAX_FONT ? MAX_FONT : fontSize;
//
//            buttonTakePicture.setTextSize(fontSize);
//            buttonNext.setTextSize(fontSize);
//            buttonSetting.setTextSize(fontSize);


            ratingBar1 = (RatingBar) findViewById(R.id.ratingBar);
            ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
            ratingBar3 = (RatingBar) findViewById(R.id.ratingBar3);
            displayImage1 = (ImageView) findViewById(R.id.imageView1);
            displayImage2 = (ImageView) findViewById(R.id.imageView2);
            displayImage3 = (ImageView) findViewById(R.id.imageView3);


            buttonNext.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, ChosenImage.class));
                }
            });

            buttonSetting.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, Setting.class));
                }
            });

            buttonTakePicture.setOnClickListener(new OnClickListener() { // Opens the camera
                public void onClick(View v) {
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    startActivity(intent);
                }
            });
        }
    public void onClick(View v) {

    }
}
