package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.Serializable;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST = 1;
    private Button imageButton;
    private ImageView imageView;
    int flag = 0;
    Switch switchButton;
    boolean switchOn=false;

    @Override
    protected void onSaveInstanceState(Bundle outState) {      //on orientation change, save the switch on status
        super.onSaveInstanceState(outState);
        outState.putBoolean("switchOn",switchOn);    // to save one orientation change
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Button identifyTheMake = findViewById(R.id.identifyCarMakeBtn);
        identifyTheMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, imagePage.class);
                intent.putExtra("switchBool", switchOn);
                startActivity(intent);
            }
        });

        Button hint = findViewById(R.id.hintsBtn);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, hint.class);
                intent.putExtra("switchBool", switchOn);
                startActivity(intent);
            }
        });

        Button idetifyTheCar = findViewById(R.id.identifyCarImageBtn);
        idetifyTheCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, idenityTheCarImage.class);
                intent.putExtra("switchBool", switchOn);  // the status of the timer is pass through an extra, whether it is on or not
                startActivity(intent);
            }
        });

        Button advanced = findViewById(R.id.advancedLevelBtn);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Advanced.class);
                intent.putExtra("switchBool", switchOn);  // the status of the timer is pass through an extra, whether it is on or not
                startActivity(intent);
            }
        });
        switchButton=findViewById(R.id.timer_switch);     // to check whether the toggle button is on
        switchButton.setChecked(switchOn);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean on) {     // if the doggie button is switched on this meeting will be called and the status will be safe to the boolean variable
                switchOn=on;
            }
        });

    }

//    public void identifyCarMakeMethod(View view) {
//
//        Intent intent=new Intent(this,imagePage.class);
//
//
//                imageView = (ImageView) findViewById(R.id.imageView3);
//                imageButton = (Button) findViewById(R.id.identifyCarMakeBtn);
//                intent.putExtra(EXTRA_MESSAGE, (Serializable) imageView);
//                startActivityForResult(intent,REQUEST);
//
//                if (flag == 0) {
//                    imageView.setImageResource(R.drawable.audi1);
//                    flag = 1;
//                } else if (flag == 1) {
//                    imageView.setImageResource(R.drawable.audi2);
//                    flag = 0;
//                }
//
//            }



}