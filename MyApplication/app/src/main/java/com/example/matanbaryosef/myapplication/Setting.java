package com.example.matanbaryosef.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.os.Bundle;
import android.preference.PreferenceManager;


public class Setting extends AppCompatActivity {

    Button buttonSetFontSize;
    int fontSize;
    EditText fontSizeLabel;
    String newFontSize;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        buttonSetFontSize = (Button) findViewById(R.id.buttonSetFontSize);
        fontSizeLabel = (EditText)findViewById(R.id.editTextLabel);

        buttonSetFontSize.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newFontSize = fontSizeLabel.getText().toString(); // resetting the font size to the new one
                Intent newIntent = new Intent();

                setDefaults("fontSize", newFontSize, getApplicationContext()); // Sets the new font value
                newIntent.putExtra("fontSize", newFontSize);
                setResult(RESULT_OK, newIntent);
                finish();
            }
        });
    }
    public static void setDefaults(String key, String value, Context data) { // setter for shared resource
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(data);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getDefaults(String key, Context context) { // getter for shared resources
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}
