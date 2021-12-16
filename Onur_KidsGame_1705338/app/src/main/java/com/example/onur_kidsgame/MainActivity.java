package com.example.onur_kidsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Onur Honca Student ID: 1705338
    int QuestionOne;
    int QuestionTwo;
    //Setting Max Number of combined numbers for question
    int MaxQuestion = 9;
    //int Answer;

    //Random Number Generator
    Random RNG = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Run Ask questions and Get/Set button parameters
        Askquestion();
        GetSetButtons();
        //Make Images movable
        MakeImagesMovable();

    }
    public void MakeImagesMovable()
    {
        ImageView apple_one = (ImageView) findViewById(R.id.apple_one);
        apple_one.setOnTouchListener(Touch_Handler);

        ImageView apple_two = (ImageView) findViewById(R.id.apple_two);
        apple_two.setOnTouchListener(Touch_Handler);

        ImageView apple_three = (ImageView) findViewById(R.id.apple_three);
        apple_three.setOnTouchListener(Touch_Handler);

        ImageView apple_four = (ImageView) findViewById(R.id.apple_four);
        apple_four.setOnTouchListener(Touch_Handler);

        ImageView apple_five = (ImageView) findViewById(R.id.apple_five);
        apple_five.setOnTouchListener(Touch_Handler);

        ImageView apple_six = (ImageView) findViewById(R.id.apple_six);
        apple_six.setOnTouchListener(Touch_Handler);

        ImageView apple_seven = (ImageView) findViewById(R.id.apple_seven);
        apple_seven.setOnTouchListener(Touch_Handler);

        ImageView apple_eight = (ImageView) findViewById(R.id.apple_eight);
        apple_eight.setOnTouchListener(Touch_Handler);
        ImageView apple_nine = (ImageView) findViewById(R.id.apple_nine);
        apple_nine.setOnTouchListener(Touch_Handler);


    }
    public void GetSetButtons() {
        //Set Buttons and Reference them from the view
        Button Button_One = (Button) findViewById(R.id.Button_One);
        Button Button_Two = (Button) findViewById(R.id.Button_Two);
        Button Button_Three = (Button) findViewById(R.id.Button_Three);
        Button Button_Four = (Button) findViewById(R.id.Button_Four);
        Button Button_Five = (Button) findViewById(R.id.Button_Five);
        Button Button_Six = (Button) findViewById(R.id.Button_Six);
        Button Button_Seven = (Button) findViewById(R.id.Button_Seven);
        Button Button_Eight = (Button) findViewById(R.id.Button_Eight);
        Button Button_Nine = (Button) findViewById(R.id.Button_Nine);
        Button Reset_Box = (Button) findViewById(R.id.Reset_Box);

        //Set Button Texts
        Button_One.setText("1");
        Button_Two.setText("2");
        Button_Three.setText("3");
        Button_Four.setText("4");
        Button_Five.setText("5");
        Button_Six.setText("6");
        Button_Seven.setText("7");
        Button_Eight.setText("8");
        Button_Nine.setText("9");
        Reset_Box.setText("Redo");

        //Button Clicks
        // Setting answers based on button clicks
        Button_One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkans(1);
            }
        });
        Button_Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkans(2);
            }
        });
        Button_Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Checkans(3);
            }
        });
        Button_Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Answer = 4;
                Checkans(4);
            }
        });
        Button_Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Answer = 5;
                Checkans(5);
            }
        });
        Button_Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Answer = 6;
                Checkans(6);
            }
        });
        Button_Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Answer = 7;
                Checkans(7);
            }
        });
        Button_Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Answer = 8;
                Checkans(8);
            }
        });
        Button_Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Answer = 9;
                Checkans(9);
            }
        });
        //Reset Button
        Reset_Box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Askquestion();
            }
        });
    }

    void Checkans(int Ans) {
        if (Ans == QuestionOne + QuestionTwo) {
                        RightAns();
        }
        else
        {
            WrongAns();

        }


    }

   private void RightAns() {
        Button QuestionBox = (Button) findViewById(R.id.Question_Box);
       QuestionBox.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               EndScreen();
           }
       });
        QuestionBox.setText("Correct! Click to submit");


    }
    private void WrongAns() {
        Button QuestionBox = (Button) findViewById(R.id.Question_Box);
        QuestionBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndScreen();
            }
        });
        QuestionBox.setText("Wrong Answer, Click redo to try again");


    }
    public void EndScreen() {
        Intent intent = new Intent(this,EndScreenActivity.class);
        startActivity(intent);
    }

    private void Askquestion() {
        // Find Question box in App and set parameters
        Button QuestionBox = (Button) findViewById(R.id.Question_Box);
        QuestionOne = RNG.nextInt(MaxQuestion);
        QuestionTwo = RNG.nextInt(MaxQuestion - QuestionOne);

        QuestionBox.setText(QuestionOne + "+" + QuestionTwo + "?");


    }

    private View.OnTouchListener Touch_Handler = new View.OnTouchListener() {
        float Dirx, DirY;

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Dirx = view.getX() - event.getRawX();
                    DirY = view.getY() - event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    view.animate()
                            .x(event.getRawX() + Dirx)
                            .y(event.getRawY() + DirY)
                            .setDuration(0)
                            .start();
                    break;
                default:
                    return false;
            }
            return true;
        }
    };
}

//Onur Honca Student ID: 1705338
