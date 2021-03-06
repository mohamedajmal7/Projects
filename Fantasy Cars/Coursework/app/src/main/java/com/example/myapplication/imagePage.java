package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class imagePage extends AppCompatActivity {
    public static final ArrayList<Integer> randInts = new ArrayList<>();

    public int cars[] = {
            R.drawable.audi1, R.drawable.audi2, R.drawable.audi3,
            R.drawable.audi4, R.drawable.audi5, R.drawable.benz1, R.drawable.benz2, R.drawable.benz3, R.drawable.benz4,
            R.drawable.benz5, R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw4, R.drawable.bmw5,
            R.drawable.bmw3, R.drawable.ford1, R.drawable.ford2, R.drawable.ford3,R.drawable.ford4,R.drawable.ford5,
            R.drawable.rr1, R.drawable.rr2, R.drawable.rr3, R.drawable.rr4,R.drawable.rr5,
            R.drawable.honda1, R.drawable.honda2, R.drawable.honda3, R.drawable.honda4, R.drawable.honda5, R.drawable.toyota1,
            R.drawable.toyota2, R.drawable.toyota3, R.drawable.toyota5
    };

    Random rand = new Random();
    ImageView v1;
    Spinner Brandspinner;
    CountDownTimer AppCountDownTimer;
    int timerTime;
    TextView timeShowText;
    Button identifyTheMake;
    int random;
    boolean submitPressed;
    boolean finished = false;
    String correctMake;
    boolean message;

    TextView output;
    TextView wrongOutput;

    //---------save the instance state here------------//
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("randInt", random);
        outState.putInt("timerTime",timerTime);
        outState.putBoolean("submitPressed", submitPressed);
        outState.putBoolean("finishedYet", finished);
        outState.putBoolean("message", message);
        outState.putString("correctBrand", correctMake);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_page);

        if (randInts.size() > 28) {
            finish();
        }
        message = getIntent().getExtras().getBoolean("switchBool");
        submitPressed = false;
        int x = rand.nextInt(30);
        while (randInts.contains(x)) {
            x = rand.nextInt(30);
        }

        random = x;
        randInts.add(random);
        timerTime=11000;
        if (savedInstanceState != null) {
            this.random = savedInstanceState.getInt("randInt");
            this.timerTime = savedInstanceState.getInt("timerTime");
            this.submitPressed = savedInstanceState.getBoolean("submitPressed");
            this.message = savedInstanceState.getBoolean("message");
            this.finished = savedInstanceState.getBoolean("finished");
        }
        v1 = findViewById(R.id.identifyImageView);
        identifyTheMake = findViewById(R.id.submitMake);
        output=findViewById(R.id.output_text);
        wrongOutput=findViewById(R.id.wrongOutput);

        timeShowText=findViewById(R.id.timeText);

        correctMake = getBrand(random);
        v1.setImageResource(cars[random]);
        ArrayAdapter<CharSequence> names=ArrayAdapter.createFromResource(this,R.array.brand_names, android.R.layout.simple_spinner_item);
        names.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Brandspinner=findViewById(R.id.breedSpinner);

                // the timer should start only if the toggle button is on

        if (message) {
            timeShowText.setText(String.valueOf(timerTime / 1000));
            AppCountDownTimer = new AppCountDownTimer(timerTime, 1000);
            AppCountDownTimer.start();
        }else {

        }
        if (Brandspinner!=null){
            Brandspinner.setAdapter(names);
        }

        if (submitPressed){
            identifyTheMake.setText("Next");
        }
    }


    private String getBrand(int num){
        String make;
        if(-1<num && num<5){
            make="Audi";
        }else if(4<num && num<10){
            make="Mercedes Benz";
        }else if(9<num && num<15){
            make="BMW";
        }else if(14<num && num<20){
            make="Ford";
        }else if(19<num && num<25){
            make="Rolls Royce";
        }else if(24<num && num<30){
            make="Honda";
        }else{
            make="Toyota";
        }
        return make;
    }
    public void clickSubmit(View w){
        if (message){
            finished=true;

        }
        if (!submitPressed){
            Brandspinner.setEnabled(false);
            if (message) {
                AppCountDownTimer.cancel();
            }
            identifyTheMake.setText("Next");
            String text=Brandspinner.getSelectedItem().toString();
            if (text.equals(correctMake)){
                AppCountDownTimer.cancel();
                output.setText("Correct");
                output.setTextColor(Color.GREEN);
            }else{
                output.setText("Wrong");
                output.setTextColor(Color.RED);
                wrongOutput.setText(correctMake);
                wrongOutput.setTextColor(Color.YELLOW);
            }
            submitPressed=true;
        }else{
            Intent intent = new Intent(imagePage.this, imagePage.class);  // if the same button is clicked again, which means the user wants to go to the next question
            intent.putExtra("switchBool", message);
            submitPressed=false;
            startActivity(intent);
        }

    }

    //
    public class AppCountDownTimer extends CountDownTimer {      // this is the timer class which extends from countdown timer

        public AppCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {     // I'm each tick, it takes is taken
            timerTime=timerTime-1000;

            timeShowText.setText(String.valueOf(timerTime/1000));
        }

        @Override
        public void onFinish() {  // when the time is finished, answer whatever you say have selected should be evaluated


            if(!finished){
                finished=true;
                Brandspinner.setEnabled(false);
                identifyTheMake.setText("Next");

                String text = Brandspinner.getSelectedItem().toString(); //get the selected item as text
                if (text.equals(correctMake)) {
                    output.setText("Correct");
                    output.setTextColor(Color.GREEN);
                }else {
                    output.setText("Wrong");
                    output.setTextColor(Color.RED);
                    wrongOutput.setText(correctMake);
                    wrongOutput.setTextColor(Color.YELLOW);
                }

                submitPressed = true;
            }
        }
    }
}