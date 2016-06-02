package com.example.matanbaryosef.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.view.View;
import android.graphics.Bitmap;


public class ChosenImage extends AppCompatActivity {

    RatingBar topRatedRatingBar;
    ImageView chosenImageView; // Displays the most rated image
    Bitmap bitmap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_image);

//        chosenImageView = (ImageView) findViewById(R.id.chosenImageView);
//        bitmap = (Bitmap) this.getIntent().getParcelableExtra("bitmap"); // Retrieve extended data from the intent
//        chosenImageView.setImageBitmap(bitmap);
//
//        topRatedRatingBar = (RatingBar) findViewById(R.id.topRatedRatingBar);
//        topRatedRatingBar.setRating(getIntent().getExtras().getFloat("rating"));
//        topRatedRatingBar.setIsIndicator(true);
//        topRatedRatingBar.setActivated(true);

//        chosenImageView.setOnClickListener(new View.OnClickListener() { // Listener for top rated image
//            public void onClick(View v) {
//                finish(); // Redirect to Main activity
//            }
//        });

    }
}
