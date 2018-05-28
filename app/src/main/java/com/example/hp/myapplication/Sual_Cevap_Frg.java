package com.example.hp.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sual_Cevap_Frg extends Fragment {


    private ProgressBar progressBarCircle;
    private TextView textViewTime;
    private Button btnStart;
    public Sual_Cevap_Frg() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.fragment_sual__cevap__frg, container, false);
        progressBarCircle=view.findViewById(R.id.progressBarCircle);
        textViewTime=view.findViewById(R.id.textViewTime);
        btnStart=view.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });
        progressBarCircle.setMax((int) 60000 / 1000);
        progressBarCircle.setProgress((int) 60000 / 1000);

        view.setBackgroundResource(R.drawable.hexagon_drawable);


        return view;
    }


    CountDownTimer countDownTimer=new CountDownTimer(60000,100) {
        int secondsLeft=0;

        @Override
        public void onTick(long millisUntilFinished) {

            if (Math.round((float)millisUntilFinished / 1000.0f) != secondsLeft)
            {
                secondsLeft = Math.round((float)millisUntilFinished / 1000.0f);
                RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                if(secondsLeft>=10) {
                    layoutParams.setMargins(0, 90, 0, 0);
                    layoutParams.setMarginEnd(95);
                }
                else
                {
                    layoutParams.setMargins(0, 90, 0, 0);
                    layoutParams.setMarginEnd(103);
                }
                textViewTime.setTextSize(20);
                textViewTime.setLayoutParams(layoutParams);
                textViewTime.setText(""+secondsLeft );
                progressBarCircle.setProgress((int) (secondsLeft));
            }
            //Log.i("test","ms="+millisUntilFinished+" till finished="+secondsLeft );

        }

        @Override
        public void onFinish() {

            textViewTime.setVisibility(View.INVISIBLE);
            progressBarCircle.setVisibility(View.INVISIBLE);
        }
    };

    private String msTimeFormatter(long milliSeconds) {

        String ms = String.format("%02d",
                //TimeUnit.MILLISECONDS.toMinutes(milliSeconds) -TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return ms;


    }


}
