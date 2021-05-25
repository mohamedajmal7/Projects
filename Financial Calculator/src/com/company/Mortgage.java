package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Math.pow;

public class Mortgage{
    public static Pane mortgagePane() {
        Stage window1 = new Stage();
        window1.setTitle("Mortgage Calculator");

        Label homePrice=new Label("Property Value ($)");  //labels and textfields for mortgage
        homePrice.setLayoutX(60);
        homePrice.setLayoutY(60);
        homePrice.setPrefSize(100,10);

        TextField txtPv=new TextField();
        txtPv.setLayoutX(220);
        txtPv.setLayoutY(60);
        txtPv.setPrefWidth(110);

        Label downPayment=new Label("Down Payment ($)");
        downPayment.setLayoutX(60);
        downPayment.setLayoutY(90);

        TextField txtDP=new TextField();
        txtDP.setLayoutX(220);
        txtDP.setLayoutY(90);
        txtDP.setPrefWidth(110);


        Label loanterm=new Label("Loan Term (Years)");
        loanterm.setLayoutX(60);
        loanterm.setLayoutY(120);

        TextField txtLT=new TextField();
        txtLT.setLayoutX(220);
        txtLT.setLayoutY(120);
        txtLT.setPrefWidth(110);

        Label inRate=new Label("Interest Rate (%)");
        inRate.setLayoutX(60);
        inRate.setLayoutY(150);

        TextField txtIrate=new TextField();
        txtIrate.setLayoutX(220);
        txtIrate.setLayoutY(150);
        txtIrate.setPrefWidth(110);

        // output display labels
        Label mPay = new Label();
        mPay.setLayoutX(450);
        mPay.setLayoutY(60);
        mPay.setStyle("-fx-background-color: white;-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");


        Label hPrice = new Label();
        hPrice.setLayoutX(450);
        hPrice.setLayoutY(90);
        hPrice.setStyle("-fx-background-color: white;-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");


        Label lAmt = new Label();
        lAmt.setLayoutX(450);
        lAmt.setLayoutY(120);
        lAmt.setStyle("-fx-background-color: white;-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");


        Label dPayment = new Label();
        dPayment.setLayoutX(450);
        dPayment.setLayoutY(150);
        dPayment.setStyle("-fx-background-color: white;-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");


        Label totMortPay = new Label();
        totMortPay.setLayoutX(450);
        totMortPay.setLayoutY(180);
        totMortPay.setStyle("-fx-background-color: white;-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");


        Label totInt = new Label();
        totInt.setLayoutX(450);
        totInt.setLayoutY(210);
        totInt.setStyle("-fx-background-color: white;-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");

        //calculate button
        Button btnCalM=new Button("Calculate");
        btnCalM.setLayoutX(220);
        btnCalM.setLayoutY(210);
        btnCalM.setPrefWidth(110);
        btnCalM.setOnAction(e -> {
            try{
            double n=12;  //logic of calculation with variables
            double val1 = Double.parseDouble(txtPv.getText());
            double val2 = Double.parseDouble(txtLT.getText());
            double val3 = Double.parseDouble(txtIrate.getText());
            double val4=  Double.parseDouble(txtDP.getText());
            double val5=  val1-val4;

            double res1;
            res1=((val3/n)/100* val5)/(1 - pow((1 +(val3/n)/100 ), -n*val2));
            mPay.setText("Monthly Payment Value  :"+String.format("%.2f",res1)+"$");
            hPrice.setText("Property Value"+"                 "+":"+String.valueOf(val1)+"$");
            dPayment.setText("Down Payment"+"                 "+":"+String.valueOf(val4)+"$");
            double res2;
            res2=res1*(n*val2);
            totMortPay.setText("Total Mortgage Payment :"+String.format("%.2f",res2)+"$");
            totInt.setText("total interest Value             :"+String.valueOf(String.format("%.2f",res2-val5))+"$");
            lAmt.setText("Loan Amount                    :"+String.valueOf(val5)+"$");
            } catch (Exception prompt){
                mPay.setText("Please enter Integer values only.!");

            }

        });

        //back button to return home page
        Button BackBtnM=new Button("Back");
        BackBtnM.setLayoutY(240);
        BackBtnM.setLayoutX(220);
        BackBtnM.setPrefWidth(53);
        BackBtnM.setOnAction(e -> {
            window1.close();
            Main.show();

        });
            //help button
        Button help_btn = new Button("Help");
        help_btn.setLayoutX(10);
        help_btn.setLayoutY(10);
        help_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help.helpM();
            }
        });
            //button to clear texts and textfields and labels
        Button clearBtnM = new Button("Clear");
        clearBtnM.setLayoutX(275);
        clearBtnM.setLayoutY(240);
        clearBtnM.setPrefWidth(53);

        clearBtnM.setOnAction(event -> {
            txtDP.clear();
            txtPv.clear();
            txtIrate.clear();
            txtLT.clear();
            dPayment.setText("");
            lAmt.setText("");
            mPay.setText("");
            totInt.setText("");
            totMortPay.setText("");
            hPrice.setText("");
        });

        Image imageMort = new Image("image7.jpg");
        ImageView mortImg=new ImageView(imageMort);
        mortImg.setFitWidth(800);
        mortImg.setFitHeight(500);
        Group root6= new Group();


        Button btn1 = new Button("1");
        btn1.setLayoutX(170);
        btn1.setLayoutY(350);
        btn1.setPrefSize(20,20);
        btn1.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");



        Button btn2 = new Button("2");
        btn2.setLayoutX(210);
        btn2.setLayoutY(350);
        btn2.setPrefSize(20,20);
        btn2.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn3 = new Button("3");
        btn3.setLayoutX(250);
        btn3.setLayoutY(350);
        btn3.setPrefSize(20,20);
        btn3.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");



        Button btn4 = new Button("4");
        btn4.setLayoutX(170);
        btn4.setLayoutY(390);
        btn4.setPrefSize(20,20);
        btn4.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn5 = new Button("5");
        btn5.setLayoutX(210);
        btn5.setLayoutY(390);
        btn5.setPrefSize(2,20);
        btn5.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn6 = new Button("6");
        btn6.setLayoutX(250);
        btn6.setLayoutY(390);
        btn6.setPrefSize(20,20);
        btn6.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7 = new Button("7");
        btn7.setLayoutX(170);
        btn7.setLayoutY(430);
        btn7.setPrefSize(20,20);
        btn7.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8 = new Button("8");
        btn8.setLayoutX(210);
        btn8.setLayoutY(430);
        btn8.setPrefSize(20,20);
        btn8.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9 = new Button("9");
        btn9.setLayoutX(250);
        btn9.setLayoutY(430);
        btn9.setPrefSize(20,20);
        btn9.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndot = new Button(".");
        btndot.setLayoutX(290);
        btndot.setLayoutY(350);
        btndot.setPrefSize(30,20);
        btndot.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0 = new Button("0");
        btn0.setLayoutX(290);
        btn0.setLayoutY(430);
        btn0.setPrefSize(20,20);
        btn0.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btnminus = new Button("-");
        btnminus.setLayoutX(290);
        btnminus.setLayoutY(390);
        btnminus.setPrefSize(30,20);
        btnminus.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtPv.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"1");
                }
            });
            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"2");
                }
            });
            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"3");
                }
            });
            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"4");
                }
            });
            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"9");
                }
            });
            btndot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+".");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"0");
                }
            });
            btnminus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPv.setText(txtPv.getText()+"-");
                }
            });
        });

        txtIrate.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"1");
                }
            });
            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"2");
                }
            });
            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"3");
                }
            });
            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"4");
                }
            });
            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"9");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"0");
                }
            });
            btndot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+".");
                }
            });
            btnminus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIrate.setText(txtIrate.getText()+"-");
                }
            });

        });

        //setting set on actions for buttons in keyboard(text field3)
        txtLT.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"1");
                }
            });
            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"2");
                }
            });
            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"3");
                }
            });
            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"4");
                }
            });
            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"9");
                }
            });
            btndot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+".");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"0");
                }
            });
            btnminus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLT.setText(txtLT.getText()+"-");
                }
            });

        });

        txtDP.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"1");
                }
            });
            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"2");
                }
            });
            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"3");
                }
            });

            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"4");
                }
            });

            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"9");
                }
            });
            btndot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+".");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"0");
                }
            });
            btnminus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtDP.setText(txtDP.getText()+"-");
                }
            });

        });

//////
        Pane mortgagePane = new Pane();
        mortgagePane.getChildren().addAll(mortImg,txtPv,clearBtnM,help_btn,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btndot,btnminus,txtDP,txtLT,homePrice, downPayment,txtIrate, loanterm, inRate,btnCalM,BackBtnM,hPrice,lAmt,dPayment,totMortPay,totInt,mPay);

        Scene scene = new Scene(mortgagePane, 800, 500);
        window1.setScene(scene);
        window1.show();

        return mortgagePane;
    }
}
