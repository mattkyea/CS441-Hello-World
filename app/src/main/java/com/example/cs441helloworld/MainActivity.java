package com.example.cs441helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloText;
    Button helloButton;
    int numOfPresses = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the IDs set in activity_main.xml to set the variables here
        helloText = (TextView) findViewById(R.id.hello_text);
        helloButton = (Button) findViewById(R.id.hello_button);

    }

    //called when button is pressed
    public void onHelloClick(View view){
        switch(numOfPresses){
            case 1:
                System.out.println("case 1");
                helloText.setTextSize(64);
                break;
            case 2:
                System.out.println("case 2");
                helloText.setAllCaps(true);
                break;
            case 3:
                System.out.println("case 3");
                helloText.setTextColor(0xFFFFFF00);//maybe add random number for color
                break;
            case 4:
                System.out.println("case 4");
                helloText.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                break;
        }
        numOfPresses++;
    }
}