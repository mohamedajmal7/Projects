package com.company;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Help {
    public static Label helpS() {
        //help view in simple saving cal
        Label text2 = new Label("This is a calculator which calculates Future value, No  of periods, Start Principal, interest rate and monthly payment as of your need. We have deigned this calculator in order to calculate each of them separately when the other parameters are provided in required form. in addition to this, we have designed a on-screen keypad which will be more easy for the user to do the calculations.   ");
        text2.setMaxWidth(480);
        text2.setWrapText(true);
        text2.setLayoutX(10);
        text2.setTextAlignment(TextAlignment.JUSTIFY);
        text2.setStyle("-fx-font-weight: bold;-fx-font-size: 15;-fx-font-family: Bahnschrift ");

        return text2;
    }


    public static Pane helpL() {
        //help view in Loan cal
        Stage window3 = new Stage();
        window3.setTitle("Calculator");

        Label text3 = new Label("Loan calculator will produce you the monthly payment that should be paid for the number of years ,total payment value which will be paid back  and the  total interest value that is paid.   ");
        text3.setMaxWidth(480);
        text3.setWrapText(true);
        text3.setLayoutX(10);
        text3.setTextAlignment(TextAlignment.JUSTIFY);
        text3.setStyle("-fx-font-weight: bold;-fx-font-size: 15;-fx-font-family: Bahnschrift ");

        Pane helpl=new Pane();
        helpl.getChildren().addAll(text3);

        Scene scene3 = new Scene(helpl, 500, 500);
        window3.setScene(scene3);
        window3.show();

        return helpl;
    }
    public static Pane helpM() {
        Stage window4 = new Stage();
        window4.setTitle("help");
        Label text4 = new Label("The Mortgage Calculator helps estimate the monthly payment which the buyer should pay. In this calculator the payment is calculated monthly. this calculator will produce you actual loan amount, total mortgage payment and total interest Value in addition to monthly payment.");
        text4.setMaxWidth(480);
        text4.setWrapText(true);
        text4.setLayoutX(10);
        text4.setTextAlignment(TextAlignment.JUSTIFY);
        text4.setStyle("-fx-font-weight: bold;-fx-font-size: 15;-fx-font-family: Bahnschrift ");

        Pane helpm=new Pane();
        helpm.getChildren().addAll(text4);

        Scene scene4 = new Scene(helpm, 500, 500);
        window4.setScene(scene4);
        window4.show();

        return helpm;
    }

    public static Label helpC() {
        //help vie in compound calc
        Label text5 = new Label("This is a calculator which is designed to calculate Future value, monthly payment, number of terms,start principal separately when the relevant parameters are provided. here, in addition to simple saving calculator there is a monthly payment which will be included in the calculation in end of the terms. ");
        text5.setMaxWidth(480);
        text5.setWrapText(true);
        text5.setLayoutX(20);
        text5.setTextAlignment(TextAlignment.JUSTIFY);
        text5.setStyle("-fx-font-weight: bold;-fx-font-size: 15;-fx-font-family: Bahnschrift ");

        return text5;
    }
}
