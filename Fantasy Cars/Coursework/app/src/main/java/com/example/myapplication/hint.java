package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class hint extends AppCompatActivity {


    public static final ArrayList<Integer> randI = new ArrayList<>();

    public int cars[] = {
            R.drawable.audi1, R.drawable.audi2, R.drawable.audi3,
            R.drawable.audi4, R.drawable.audi5, R.drawable.benz1, R.drawable.benz2, R.drawable.benz3, R.drawable.benz4,
            R.drawable.benz5, R.drawable.bmw1, R.drawable.bmw2, R.drawable.bmw3,R.drawable.bmw4, R.drawable.bmw5,
            R.drawable.ford1, R.drawable.ford2, R.drawable.ford3,R.drawable.ford4,R.drawable.ford5,
            R.drawable.rr1, R.drawable.rr2, R.drawable.rr3, R.drawable.rr4,R.drawable.rr5,
            R.drawable.honda1, R.drawable.honda2, R.drawable.honda3, R.drawable.honda4, R.drawable.honda5, R.drawable.toyota1,
            R.drawable.toyota2, R.drawable.toyota3, R.drawable.toyota5
    };

    //reference - (STACKOVERFLOW) https://stackoverflow.com/questions/39962816/get-random-images-in-android-studio


    boolean submitWord;
    Random ran = new Random();
    int random;
    TextView correctText;
    TextView txtType;
    String y = "";
    String x = "";
    Button identifyBtn;
    ImageView hintImage;
    String correctWords;
    EditText userInput;
    TextView blankText;

    int attempts;
    TextView timerShow;
    int timerSwitch2;
    boolean message2;




    @Override

    protected void onSaveInstanceState(Bundle state) {

        super.onSaveInstanceState(state);
        state.putInt("randW", random);
        state.putBoolean("submit", submitWord);
        state.putBoolean("message2", message2);
        state.putInt("timerSwitch2", timerSwitch2);

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hint);
        hintImage = findViewById(R.id.identify_1);
        userInput = (EditText) findViewById(R.id.editText);
        blankText = (TextView) findViewById(R.id.textView4);
        correctText = (TextView) findViewById(R.id.textView5);
        txtType = (TextView) findViewById(R.id.textView6);
        identifyBtn = (Button) findViewById(R.id.button5);
        timerShow = (TextView) findViewById(R.id.textView_timer2);





        if (randI.size() > 35) {
            finish();
        }


        submitWord = false;

        int v = ran.nextInt(35);

        while (randI.contains(v)) {
            v = ran.nextInt(35);
        }

        random = v;

        randI.add(random);


        if (savedInstanceState != null) {
            this.random = savedInstanceState.getInt("randI");
            this.submitWord = savedInstanceState.getBoolean("submit");
            this.message2 = savedInstanceState.getBoolean("message2");

        }

        hintImage = findViewById(R.id.identify_1);
        identifyBtn = findViewById(R.id.button5);

        correctWords = getBrand(random);

        hintImage.setImageResource(cars[random]);




        final ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < correctWords.length(); i++) {
            if (Character.isWhitespace(correctWords.toLowerCase().charAt(i))) {
                x = x.concat(" ");
            } else {
                x = x.concat(" _");
            }
        }

        for (int i = 0; i < correctWords.length(); i++) {
            if (Character.isWhitespace(correctWords.toLowerCase().charAt(i))) {
                y = y.concat(" ");
            } else {
                y = y.concat(" " + correctWords.charAt(i));
            }
        }


        final char[] char1Array = x.toCharArray();
        final char[] carNCharArray = y.toCharArray();

        blankText.setText(x);


        identifyBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String letter = userInput.getText().toString().toLowerCase();
                correctWords=correctWords.toLowerCase();

                if (correctWords.contains(letter)) {
                    correctText.setText("CORRECT!");
                    correctText.setTextColor(Color.GREEN);


                } else if (!correctWords.contains(y)) {
                    attempts++;
                    correctText.setText("WRONG!");
                    correctText.setTextColor(Color.RED);
                }

                if (attempts >= 3) {
                    txtType.setText(y);
                    txtType.setTextColor(Color.YELLOW);

                }



                for (int i = 0; i < carNCharArray.length; i++) {
                    if (carNCharArray[i] == letter.charAt(0)) {

                        indexList.add(i);

                    }
                }


                for (int i = 0; i < indexList.size(); i++) {
                    char1Array[indexList.get(i)] = letter.charAt(0);

                }

                int count = 0;

                indexList.clear();
                blankText.setText("");


                for (int i = 0; i < carNCharArray.length; i++) {

                    String y = String.valueOf(char1Array[i]);

                    blankText.append(y);
                    System.out.print(char1Array[i]);
                    if (y.equals("_")) {
                        count++;
                    }
                }


                if (attempts >= 3) {
                    identifyBtn.setText("Next");
                    identifyBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(getIntent());
                            finish();
                        }
                    });
                }

                userInput.setText("");
            }
        });


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



    public void submitWord(View view) {

    }



    private class AppTimeCounter extends CountDownTimer {

        public AppTimeCounter(long millisInFuture, long countDownInterval) {

            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timerSwitch2 = timerSwitch2 - 1000;
            timerShow.setText(String.valueOf(timerSwitch2 / 1000));
        }

        @Override
        public void onFinish() {
            if (!submitWord) {
                String letter = userInput.getText().toString();
                if (letter.equals(correctWords)) {

                    correctText.setText("CORRECT!");
                    correctText.setTextColor(Color.GREEN);


                } else {

                    correctText.setText("WRONG!");
                    correctText.setTextColor(RED);

                    txtType.setText(correctWords);
                    txtType.setTextColor(YELLOW);


                }

                identifyBtn.setText("Next");
                identifyBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(getIntent());
                        finish();
                    }
                });


            }
        }
    }
}