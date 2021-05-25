package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.graphics.Color.RED;

public class idenityTheCarImage extends AppCompatActivity {

    public int cars[] = {
            R.drawable.audi1, R.drawable.audi2, R.drawable.audi3,
            R.drawable.audi4, R.drawable.audi5, R.drawable.benz1, R.drawable.benz2, R.drawable.benz3, R.drawable.benz4,
            R.drawable.benz5, R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3,R.drawable.bmw4, R.drawable.bmw5,
              R.drawable.ford1, R.drawable.ford2, R.drawable.ford3,R.drawable.ford4,R.drawable.ford5,
            R.drawable.rr1, R.drawable.rr2, R.drawable.rr3, R.drawable.rr4,R.drawable.rr5,
            R.drawable.honda1, R.drawable.honda2, R.drawable.honda3, R.drawable.honda4, R.drawable.honda5, R.drawable.toyota1,
            R.drawable.toyota2, R.drawable.toyota3, R.drawable.toyota5
    };

    private  static  final ArrayList<Integer>randInts=new ArrayList<>();
    Random rand=new Random();
    public static int userChoice=-1;
    int num1;
    int num2;
    int num3;
    int correctGuess;
    int brandName;
    TextView correct;
    TextView wrong;
    private boolean clickedSubmit;
    boolean message;
    Button submitBtn;
    boolean finishedYet=false;
    CountDownTimer AppCountDownTimer;
    int timerTime2;
    TextView timeShow;
    ImageView i1;
    ImageView i2;
    ImageView i3;

    @Override
    protected void onSaveInstanceState(Bundle outState) {  // to see each instance to use when the orientation changes
        super.onSaveInstanceState(outState);
        outState.putInt("num1",num1);
        outState.putInt("num2",num2);
        outState.putInt("num3",num3);
        outState.putInt("correctAnswer",correctGuess);
        outState.putInt("timerTime2",timerTime2);
        outState.putInt("name",brandName);
        outState.putBoolean("submitClicked",clickedSubmit);

        outState.putBoolean("finishedYet",finishedYet);
        outState.putBoolean("message",message);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idenity_the_car_image);

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

        brandName=rand.nextInt(4);

        final ImageView v1 = findViewById(R.id.carImage1);
        final ImageView v2 = findViewById(R.id.carImage2);
        final ImageView v3 = findViewById(R.id.carImage3);

        timerTime2=11000;

        if(savedInstanceState!= null) {        // if there is an instance saved, it will save them back
            this.num1 = savedInstanceState.getInt("num1");
            this.num2 = savedInstanceState.getInt("num2");
            this.num3 = savedInstanceState.getInt("num3");
            this.correctGuess = savedInstanceState.getInt("correctGuess");
            this.brandName = savedInstanceState.getInt("brandName");
            this.clickedSubmit=savedInstanceState.getBoolean("submitClicked");
            this.timerTime2 = savedInstanceState.getInt("timerTime2");
            this.message=savedInstanceState.getBoolean("message");
            this.finishedYet=savedInstanceState.getBoolean("finishedYet");
        }

        if (brandName==1){
            correctGuess=num1;
        }else if (brandName==2){
            correctGuess=num2;
        }else{
            correctGuess=num3;
        }
        String brand = getBrand(correctGuess);
        if (message) {
            timeShow = findViewById(R.id.timeText2);
            timeShow.setText(String.valueOf(timerTime2 / 1000));
            AppCountDownTimer = new AppCountDownTimer(timerTime2, 1000);
            AppCountDownTimer.start();
        }
        TextView textView = findViewById(R.id.brandNametext);
        textView.setText(brand);


        v1.setImageResource(cars[num1]);
        v2.setImageResource(cars[num2]);
        v3.setImageResource(cars[num3]);

        submitBtn=findViewById(R.id.guessTheCarSubmitBtn);

    }


    private String getBrand(int num){
        String brand;
        if(-1<num && num<5){
            brand="Audi";
        }else if(4<num && num<11){
            brand="Mercedes Benz";
        }else if(9<num && num<16){
            brand="BMW";
        }else if(14<num && num<21){
            brand="Ford";
        }else if(19<num && num<25){
            brand="Rolls Royce";
        }else if(24<num && num<31){
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


    public void click1(View view) {
        userChoice = num1;
        if(message) {
            AppCountDownTimer.cancel();
        }
        if (userChoice == correctGuess){
            correct = (TextView) findViewById(R.id.guessTheCaroutput);
            correct.setText("CORRECT!");
            correct.setTextColor(Color.GREEN);// if the user select the correct answer

        } else {
            wrong = (TextView) findViewById(R.id.guessTheCaroutput);
            wrong.setText("WRONG!" );
            wrong.setTextColor(RED);
        }
        i1 = (ImageView) findViewById(R.id.carImage1);
        i2 = (ImageView) findViewById(R.id.carImage2);
        i3 = (ImageView) findViewById(R.id.carImage3);
        i1.setEnabled(false);
        i2.setEnabled(false);
        i3.setEnabled(false);




        submitBtn.setEnabled(true);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

    }


    public void click2(View view) {
        userChoice = num2;
        if(message) {
            AppCountDownTimer.cancel();
        }
        if (userChoice == correctGuess){
            correct = (TextView) findViewById(R.id.guessTheCaroutput);
            correct.setText("CORRECT!");
            correct.setTextColor(Color.GREEN);// if the user select the correct answer

        } else {
            wrong = (TextView) findViewById(R.id.guessTheCaroutput);
            wrong.setText("WRONG! " );
            wrong.setTextColor(Color.RED);
        }
        i1 = (ImageView) findViewById(R.id.carImage1);
        i2 = (ImageView) findViewById(R.id.carImage2);
        i3 = (ImageView) findViewById(R.id.carImage3);
        i1.setEnabled(false);
        i2.setEnabled(false);
        i3.setEnabled(false);
        submitBtn.setEnabled(true);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }


    public void click3(View view) {
        userChoice = num3;
        if(message) {
            AppCountDownTimer.cancel();
        }
        if (userChoice == correctGuess){
            correct = (TextView) findViewById(R.id.guessTheCaroutput);
            correct.setText("CORRECT!");
            correct.setTextColor(Color.GREEN);// if the user select the correct answer

        } else {
            wrong = (TextView) findViewById(R.id.guessTheCaroutput);
            wrong.setText("WRONG!");
            wrong.setTextColor(Color.RED);
        }
        i1 = (ImageView) findViewById(R.id.carImage1);
        i2 = (ImageView) findViewById(R.id.carImage2);
        i3 = (ImageView) findViewById(R.id.carImage3);
        i1.setEnabled(false);
        i2.setEnabled(false);
        i3.setEnabled(false);
        submitBtn.setEnabled(true);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    public class AppCountDownTimer extends CountDownTimer {      // this is the timer class which extends from countdown timer

        public AppCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {     // I'm each tick, it takes is taken
            timerTime2=timerTime2-1000;
            // progress bar is set to the new value
            timeShow.setText(String.valueOf(timerTime2/1000));
        }

        @Override
        public void onFinish() {  // when the time is finished, answer whatever you say have selected should be evaluated

            i1 = (ImageView) findViewById(R.id.carImage1);
            i2 = (ImageView) findViewById(R.id.carImage2);
            i3 = (ImageView) findViewById(R.id.carImage3);

            if(!finishedYet){
                finishedYet=true;
                correct = (TextView) findViewById(R.id.guessTheCaroutput);
                //wrong = (TextView) findViewById(R.id.guessTheCaroutput);
                submitBtn.setText("Next");
                correct.setText("Out Of Time");
                correct.setTextColor(Color.RED);
                i1.setEnabled(false);
                i2.setEnabled(false);
                i3.setEnabled(false);

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
