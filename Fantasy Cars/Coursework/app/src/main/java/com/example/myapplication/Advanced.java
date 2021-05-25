package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class  Advanced extends AppCompatActivity {


    public int cars[] = {
            R.drawable.audi1, R.drawable.audi2, R.drawable.audi3,
            R.drawable.audi4, R.drawable.audi5, R.drawable.benz1, R.drawable.benz2, R.drawable.benz3, R.drawable.benz4,
            R.drawable.benz5, R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3,R.drawable.bmw4, R.drawable.bmw5,
            R.drawable.ford1, R.drawable.ford2, R.drawable.ford3,R.drawable.ford4,R.drawable.ford5,
            R.drawable.rr1, R.drawable.rr2, R.drawable.rr3, R.drawable.rr4,R.drawable.rr5,
            R.drawable.honda1, R.drawable.honda2, R.drawable.honda3, R.drawable.honda4, R.drawable.honda5, R.drawable.toyota1,
            R.drawable.toyota2, R.drawable.toyota3, R.drawable.toyota5
    };
    private  static  final ArrayList<Integer> randInts=new ArrayList<>();
    Random rand=new Random();
    public static int userChoice=-1;
    int num1;
    int num2;
    int num3;
    int score;
    int correctGuess1;
    int correctGuess2;
    int correctGuess3;


    private boolean clickedSubmit;
    boolean message;
    Button submitBtn;
    boolean finishedYet=false;
    CountDownTimer AppCountDownTimer;
    int timerTime2;
    TextView scoreText;
    TextView timeShow2;
    EditText userText1;
    EditText userText2;
    EditText userText3;
    int noOfClick;
    TextView out1;
    TextView out2;
    TextView out3;



    @Override
    protected void onSaveInstanceState(Bundle outState) {  // to see each instance to use when the orientation changes
        super.onSaveInstanceState(outState);

        outState.putInt("num1",num1);
        outState.putInt("num2",num2);
        outState.putInt("num3",num3);
        outState.putInt("correctAnswer1",correctGuess1);
        outState.putInt("correctAnswer2",correctGuess2);
        outState.putInt("correctAnswer3",correctGuess3);
        outState.putInt("timerTime2",timerTime2);

        outState.putBoolean("submitClicked",clickedSubmit);

        outState.putBoolean("finishedYet",finishedYet);
        outState.putBoolean("message",message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        if (randInts.size()>34){
            finish();
        }
        message = getIntent().getExtras().getBoolean("switchBool");  // to check whether the timer is on or not


        num1=randInt();
        randInts.add(num1);

        num2=randInt();
        while (num1/10==num2/10){
            num2=randInt();
        }
        randInts.add(num2);

        while(num1/10==num3/10 || num2/10==num3/10){
            num3 = randInt();
        }
        randInts.add(num3);



        final ImageView v1 = findViewById(R.id.advancedImage1);
        final ImageView v2 = findViewById(R.id.advancedImage2);
        final ImageView v3 = findViewById(R.id.advancedImage3);


        timerTime2=21000;

        if(savedInstanceState!= null) {        // if there is an instance saved, it will save them back
            this.num1 = savedInstanceState.getInt("num1");
            this.num2 = savedInstanceState.getInt("num2");
            this.num3 = savedInstanceState.getInt("num3");
            this.correctGuess1 = savedInstanceState.getInt("correctGuess1");
            this.correctGuess2 = savedInstanceState.getInt("correctGuess2");
            this.correctGuess3 = savedInstanceState.getInt("correctGuess3");

            this.clickedSubmit=savedInstanceState.getBoolean("submitClicked");
            this.timerTime2 = savedInstanceState.getInt("timerTime2");
            this.message=savedInstanceState.getBoolean("message");
            this.finishedYet=savedInstanceState.getBoolean("finishedYet");
        }


        correctGuess3=num3;
        correctGuess2=num2;
        correctGuess1=num1;



        if (message) {
            timeShow2 = findViewById(R.id.timeShow);
            timeShow2.setText(String.valueOf(timerTime2 / 1000));
            AppCountDownTimer = new AppCountDownTimer(timerTime2, 1000);
            AppCountDownTimer.start();
        }



        v1.setImageResource(cars[num1]);
        v2.setImageResource(cars[num2]);
        v3.setImageResource(cars[num3]);

        submitBtn=findViewById(R.id.advancedSubmitBtn);
    }


    private String getBrand(int num){
        String brand;
        if(-1<num && num<5){
            brand="Audi";
        }else if(4<num && num<10){
            brand="Mercedes Benz";
        }else if(9<num && num<15){
            brand="BMW";
        }else if(14<num && num<20){
            brand="Ford";
        }else if(19<num && num<25){
            brand="Rolls Royce";
        }else if(24<num && num<30){
            brand="Honda";
        }else{
            brand="Toyota";
        }
        return brand;
    }

    public int randInt(){    // to generate a random Number which is not used already
        int x = rand.nextInt(34);

        while(randInts.contains(x)){
            x=rand.nextInt(34);
        }
        return x;
    }
    public void findCorrectImage(View view) {
        //did this to do the thing when orientation changes


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

    }

    public void clickSubmit(View w){
        noOfClick++;

       // System.out.println(noOfClick+"CLICKS");
        if (message){
            finishedYet=true;
            AppCountDownTimer.cancel();
        }
        if (!clickedSubmit){


            userText1=findViewById(R.id.advancedText1);
            userText2=findViewById(R.id.advancedText2);
            userText3=findViewById(R.id.advancedText3);


            String correctMake1= getBrand(correctGuess1);
            String correctMake2=getBrand(correctGuess2);
            String correctMake3=getBrand(correctGuess3);

            ArrayList<EditText> inputList = new ArrayList<>();
            ArrayList<String> carList = new ArrayList<>();

            inputList.add(userText1);
            inputList.add(userText2);
            inputList.add(userText3);

            carList.add(correctMake1);
            carList.add(correctMake2);
            carList.add(correctMake3);
            scoreText=findViewById(R.id.scoreText);
            out1=findViewById(R.id.image1Out);
            out2=findViewById(R.id.image2Out);
            out3=findViewById(R.id.image3Out);


            for (int i = 0; i < inputList.size(); i++) {
                EditText e = inputList.get(i);
                String f = carList.get(i);


                if (e.getText().toString().equalsIgnoreCase(carList.get(i))) {

                    e.setEnabled(false);
                    e.setTextColor(GREEN);


                    score++;
                    scoreText.setText(score + "/3 ");

                    if (score==3) {
                        submitBtn.setText("Next");
                        submitBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                                startActivity(getIntent());
                            }
                        });
                        clickedSubmit=true;
                    }

                }else {
                    e.setTextColor(RED);
                    if (noOfClick==3) {
                        submitBtn.setText("Next");
                        if (!userText1.getText().toString().equalsIgnoreCase(correctMake1)){
                            userText1.setText("Wrong");
                            userText1.setTextColor(RED);
                            out1.setText(correctMake1);
                            out1.setTextColor(YELLOW);

                        }
                        if (!userText2.getText().toString().equalsIgnoreCase(correctMake2)){
                            userText2.setText("Wrong");
                            userText2.setTextColor(RED);
                            out2.setText(correctMake2);
                            out2.setTextColor(YELLOW);

                        }
                        if (!userText3.getText().toString().equalsIgnoreCase(correctMake3)){
                            userText3.setText("Wrong");
                            userText3.setTextColor(RED);
                            out3.setText(correctMake3);
                            out3.setTextColor(YELLOW);

                        }
                        submitBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                                startActivity(getIntent());
                            }
                        });
                        clickedSubmit=true;
                    }

                    clickedSubmit=false;
                    score=0;
                }



            }

        }

        else  {
            Intent intent = new Intent(Advanced.this, Advanced.class);  // if the same button is clicked again, which means the user wants to go to the next question
            intent.putExtra("switchBool", message);
            clickedSubmit=false;
            startActivity(intent);
        }

    }


    public class AppCountDownTimer extends CountDownTimer {      // this is the timer class which extends from countdown timer

        public AppCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {     // I'm each tick, it takes is taken
            timerTime2=timerTime2-1000;

            timeShow2.setText(String.valueOf(timerTime2/1000));
        }

        @Override
        public void onFinish() {  // when the time is finished, answer whatever you say have selected should be evaluated
            if(!finishedYet){
                finishedYet=true;
                submitBtn.setText("Next");
                userText1=findViewById(R.id.advancedText1);
                userText2=findViewById(R.id.advancedText2);
                userText3=findViewById(R.id.advancedText3);


                String correctMake1= getBrand(correctGuess1);
                String correctMake2=getBrand(correctGuess2);
                String correctMake3=getBrand(correctGuess3);

                ArrayList<EditText> inputList = new ArrayList<>();
                ArrayList<String> carList = new ArrayList<>();

                inputList.add(userText1);
                inputList.add(userText2);
                inputList.add(userText3);

                carList.add(correctMake1);
                carList.add(correctMake2);
                carList.add(correctMake3);
                scoreText=findViewById(R.id.scoreText);
                out1=findViewById(R.id.image1Out);
                out2=findViewById(R.id.image2Out);
                out3=findViewById(R.id.image3Out);


                for (int i = 0; i < inputList.size(); i++) {
                    EditText e = inputList.get(i);
                    String f = carList.get(i);



                    if (e.getText().toString().equalsIgnoreCase(carList.get(i))) {

                        e.setEnabled(false);
                        e.setTextColor(GREEN);


                        score++;
                        scoreText.setText(score + "/3 ");

                        if (score==3) {
                            submitBtn.setText("Next");
                            submitBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            clickedSubmit=true;
                        }

                    }else {
                        e.setTextColor(RED);

                        submitBtn.setText("Next");
                        if (!userText1.getText().toString().equalsIgnoreCase(correctMake1)){
                            userText1.setText("Wrong");
                            userText1.setTextColor(RED);
                            out1.setText(correctMake1);
                            out1.setTextColor(YELLOW);

                        }
                        if (!userText2.getText().toString().equalsIgnoreCase(correctMake2)){
                            userText2.setText("Wrong");
                            userText2.setTextColor(RED);
                            out2.setText(correctMake2);
                            out2.setTextColor(YELLOW);

                        }
                        if (!userText3.getText().toString().equalsIgnoreCase(correctMake3)){
                            userText3.setText("Wrong");
                            userText3.setTextColor(RED);
                            out3.setText(correctMake3);
                            out3.setTextColor(YELLOW);

                        }
                            submitBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    finish();
                                    startActivity(getIntent());
                                }
                            });
                            clickedSubmit=true;
                            score=0;
                    }

                }
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(getIntent());
                    }
                });

            }
        }
    }
}