package com.example.hp.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class PopupActivity extends Activity {

    private int[] images;
    private String []isimler;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custompopup);

        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.87),(int)(height*.70));

        images = getIntent().getExtras().getIntArray("images");
        isimler=getIntent().getExtras().getStringArray("isimler");

        final TextSwitcher textSwitcher=(TextSwitcher)findViewById(R.id.textSwitcher);

        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        ImageButton leftButton = (ImageButton) findViewById(R.id.left_nav);
        ImageButton rightButton = (ImageButton) findViewById(R.id.right_nav);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                ImageView imageView = new ImageView(getApplicationContext());

                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(images[counter]);

                return imageView;
            }
        });


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter >= 1) {
                    counter--;
                    imageSwitcher.setInAnimation(getApplicationContext(), R.anim.slide_in_left);
                    imageSwitcher.setOutAnimation(getApplicationContext(), R.anim.slide_out_left);

                    imageSwitcher.setImageResource(images[counter]);

                    textSwitcher.setInAnimation(getApplicationContext(),R.anim.slide_in_left);
                    textSwitcher.setOutAnimation(getApplicationContext(),R.anim.slide_out_left);
                    textSwitcher.setText(isimler[counter]);

                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (counter < images.length-1) {
                    counter++;
                    imageSwitcher.setInAnimation(getApplicationContext(), R.anim.slide_in_right);
                    imageSwitcher.setOutAnimation(getApplicationContext(), R.anim.slide_out_right);
                    imageSwitcher.setImageResource(images[counter]);

                    textSwitcher.setInAnimation(getApplicationContext(),R.anim.slide_in_right);
                    textSwitcher.setOutAnimation(getApplicationContext(),R.anim.slide_out_right);
                    textSwitcher.setText(isimler[counter]);

                }
            }
        });


        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView myText = new TextView(getApplicationContext());
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(26);
                myText.setTextColor(Color.GRAY);
                myText.setText(isimler[counter]);
                return myText;
            }
        });

        // Declare the in and out animations and initialize them

    }
}
