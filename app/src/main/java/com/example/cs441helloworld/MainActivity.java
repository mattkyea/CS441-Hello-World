package com.example.cs441helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

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
        moveButton = (Button) findViewById(R.id.rotate_button);
        capsButton =(Button) findViewById(R.id.caps_button);

    }

    //all of my functions modify the text based on what the button says
    //most toggle between the default and the modifier
    //some are random (color toggles between black and random color)

    //called when color button is pressed
    public void onColorClick(View view) {
        int currentColor = helloText.getTextColors().getDefaultColor();//how to access color from ColorStateList
        if(currentColor == 0xFF000000){//text is black, make random color from random num
            //from https://stackoverflow.com/questions/11094823/java-how-to-generate-a-random-hexadecimal-value-within-specified-range-of-value/48170421
            Random randomGenerator = new Random();
            //colors are just ORGB values - opacity, red, green, blue, each is a 2-digit hex number
            //FF for opacity means its 100% opaque, and we can see it
            //so when generating random numbers, I ensure we can see it (lowest possible number is 0xFF000000 - opaque black)
            int randomHexInt = randomGenerator.nextInt(0xFFFFFF) + 0xFF000000;//generates a random number between 0xFF000000 and 0xFFFFFFFF (opaque black to opaque white)
            helloText.setTextColor(randomHexInt);
        }else { //text isn't opaque black - the default - so reset it
            helloText.setTextColor(0xFF000000);
        }
    }

    //called when bold button is pressed
    public void onBoldClick(View view) {
        //text can be bold, italics, both, or neither
        //but to make both, we need special modifier of Typeface.BOLD_ITALICS, thus requiring a check for each possible case
        if(helloText.getTypeface().getStyle() == Typeface.BOLD_ITALIC){//italics and bold
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
        }else if(helloText.getTypeface().getStyle() == Typeface.BOLD && helloText.getTypeface().getStyle() != Typeface.ITALIC){//bold, not italics
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
        }else if(helloText.getTypeface().getStyle() != Typeface.BOLD && helloText.getTypeface().getStyle() == Typeface.ITALIC){//italics, not bold
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        }else{//not bold or italics
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        }
    }

    //called when italics button is pressed
    public void onItalicsClick(View view) {
        //same as above, but with toggling italics and leaving bold as is
        if(helloText.getTypeface().getStyle() == Typeface.BOLD_ITALIC){//bold and italics
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        }else if(helloText.getTypeface().getStyle() == Typeface.BOLD && helloText.getTypeface().getStyle() != Typeface.ITALIC){//bold, not italics
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        }else if(helloText.getTypeface().getStyle() != Typeface.BOLD && helloText.getTypeface().getStyle() == Typeface.ITALIC){//italics, not bold
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
        }else{//not bold or italics
            helloText.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
        }
    }
    //called when rotate button is pressed
    public void onRotateClick(View view) {
        //pick random x, y, z to rotate the text to
        if(helloText.getRotationX() ==0 && helloText.getRotationY() ==0 && helloText.getRotation() == 0){//at default - no rotation
            //pick 3 random numbers between 0 and 360 so set as rotation values
            Random randomGenerator = new Random();
            helloText.setRotationX(randomGenerator.nextInt(360));
            helloText.setRotationY(randomGenerator.nextInt(360));
            helloText.setRotation(randomGenerator.nextInt(360));
        }else{//otherwise we're in some random position, reset
            helloText.setRotationX(0);
            helloText.setRotationY(0);
            helloText.setRotation(0);
        }
    }

    //called when caps button is pressed
    public void onCapsClick(View view) {
        if(helloText.isAllCaps() == true) {//if text is caps
            helloText.setAllCaps(false);//switch to lowercase
        }else {//text isn't caps, make it caps
            helloText.setAllCaps(true);
        }
    }
}