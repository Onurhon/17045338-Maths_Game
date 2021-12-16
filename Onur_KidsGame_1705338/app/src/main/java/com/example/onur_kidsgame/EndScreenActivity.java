package com.example.onur_kidsgame;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.ImageView;

import com.example.onur_kidsgame.databinding.ActivityEndScreenBinding;


public class EndScreenActivity extends AppCompatActivity {
    //Onur Honca Student ID: 1705338
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        MakeObjectsMove();
        Restart();





    }

    public  void MakeObjectsMove()
    {
     //   ImageView apple_nine = (ImageView) findViewById(R.id.apple_nine);
     //   apple_nine.setOnTouchListener(Touch_Handler);


    }



    public void Restart()
    {
        //finds the restart button and sets variables to it
        Button Restart_Button = (Button) findViewById(R.id.Restart_Button);
        Restart_Button.setText("GO AGAIN");

        Restart_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                restart();
            }
        });


    }
    //loads the previous level
    public  void restart()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
//drag handler

    };


//Onur Honca Student ID: 1705338

