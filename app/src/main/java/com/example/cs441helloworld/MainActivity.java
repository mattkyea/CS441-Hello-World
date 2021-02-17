package com.example.cs441helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloText;
    Button colorButton;
    Button boldButton;
    Button italicsButton;
    Button moveButton;
    Button capsButton;
    int numOfPresses = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the IDs set in activity_main.xml to set the variables here
        helloText = (TextView) findViewById(R.id.hello_text);
        boldButton = (Button) findViewById(R.id.bold_button);
        colorButton = (Button) findViewById(R.id.color_button);
        italicsButton = (Button) findViewById(R.id.italics_button);
        moveButton = (Button) findViewById(R.id.move_button);
        capsButton =(Button) findViewById(R.id.caps_button);

    }

    //called when button is pressed
    public void onColorClick(View view) {
        //make random color from random num
        helloText.setTextColor(0xFFFFFF00);
    }

    //called when button is pressed
    public void onBoldClick(View view) {
        helloText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
    }

    //called when button is pressed
    public void onItalicsClick(View view) {
        helloText.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
    }
    //called when button is pressed
    public void onMoveClick(View view) {
        //figure out how
    }

    //called when button is pressed
    public void onCapsClick(View view) {
        helloText.setAllCaps(true);
    }
}