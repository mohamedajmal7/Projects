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

import java.awt.event.MouseEvent;

public class Loan  {
    public static Pane LoanP(){
        Stage windowL = new Stage();
        windowL.setTitle("Loan Calculator");

        //creating labels and textfeilds for loan calculator
        Label loan_amountL = new Label("Loan Amount ($) ");
        loan_amountL.setLayoutX(110);
        loan_amountL.setLayoutY(70);

        TextField txtloanAmntL = new TextField();
        txtloanAmntL.setLayoutX(270);
        txtloanAmntL.setLayoutY(70);
        txtloanAmntL.setPrefWidth(100);


        Label loantermL = new Label("Loan Term (Years)");
        loantermL.setLayoutX(110);
        loantermL.setLayoutY(100);

        TextField txtLoantrmL = new TextField();
        txtLoantrmL.setLayoutX(270);
        txtLoantrmL.setLayoutY(100);
        txtLoantrmL.setPrefWidth(100);


        Label IntRateL = new Label("Interest Rate (%)");
        IntRateL.setLayoutX(110);
        IntRateL.setLayoutY(130);

        TextField txtIntRtL = new TextField();
        txtIntRtL.setLayoutX(270);
        txtIntRtL.setLayoutY(130);
        txtIntRtL.setPrefWidth(100);

        //Labels for output in Loan calculator
        Label rpaymentEvMonth = new Label();
        rpaymentEvMonth.setLayoutX(110);
        rpaymentEvMonth.setLayoutY(230);
        rpaymentEvMonth.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");

        Label rtotpay = new Label();
        rtotpay.setLayoutX(110);
        rtotpay.setLayoutY(260);
        rtotpay.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");  //styling for Label and text in Output

        Label rtotIntrest = new Label("");
        rtotIntrest.setLayoutX(110);
        rtotIntrest.setLayoutY(290);
        rtotIntrest.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");

        Button BackBtnL3=new Button("Back");
        BackBtnL3.setLayoutY(190);
        BackBtnL3.setLayoutX(270);
        BackBtnL3.setPrefWidth(48);
        BackBtnL3.setOnAction(e -> {
            windowL.close();
            Main.show();
        });
        Button clearBtnL = new Button("Clear");
        clearBtnL.setLayoutX(320);
        clearBtnL.setLayoutY(190);
        clearBtnL.setPrefWidth(48);


        clearBtnL.setOnAction(event -> {
            txtIntRtL.clear();
            txtloanAmntL.clear();
            txtLoantrmL.clear();
            rpaymentEvMonth.setText("");
            rtotIntrest.setText("");
            rtotpay.setText("");
        });

        Button btnCalAL3=new Button("Calculate");
        btnCalAL3.setLayoutX(270);
        btnCalAL3.setLayoutY(160);
        btnCalAL3.setPrefWidth(100);
        btnCalAL3.setOnAction(e -> {      //button action for calculation
            try{
            double val1 = Double.parseDouble(txtloanAmntL.getText());
            double val2 = Double.parseDouble(txtLoantrmL.getText());
            double val3 = Double.parseDouble(txtIntRtL.getText());
            int n=12;
            double monthlyPayment;
            double totalPayment;
            double totalIntrest;
            monthlyPayment=  ((val3/n)/100* val1)/(1 - Math.pow((1 +(val3/n)/100 ), -n*val2));
            rpaymentEvMonth.setText("Monthly payment Value : "+String.format("%.2f",monthlyPayment)+"$");
            totalPayment= (monthlyPayment * val2 * n);
            rtotpay.setText("Total Payment Value       :  "+String.format("%.2f",totalPayment)+"$");
            totalIntrest=totalPayment-val1;
            rtotIntrest.setText("Total interest Value         : "+String.format("%.2f",totalIntrest)+"$");
            } catch (Exception prompt){
                rtotIntrest.setText("Please enter Integer values only.!");

            }
        });

        Button help_btnl = new Button("Help");
        help_btnl.setLayoutX(10);
        help_btnl.setLayoutY(10);
        help_btnl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help.helpL();
            }
        });
        //buttons for keypad
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

        txtloanAmntL.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"1");
                }
            });
            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"4");
                }
            });

            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"3");
                }
            });

            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"2");
                }
            });
            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"9");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+".");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"0");
                }
            });
            btnminus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtloanAmntL.setText(txtloanAmntL.getText()+"-");
                }
            });

        });


        txtLoantrmL.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"1");
                }
            });

            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"4");
                }
            });

            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"3");
                }
            });

            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"2");
                }
            });
            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"9");
                }
            });
            btndot.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+".");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtLoantrmL.setText(txtLoantrmL.getText()+"0");
                }
            });
            btnminus.setOnAction(event1 -> txtLoantrmL.setText(txtLoantrmL.getText()+"-"));

        });

        //setting set on actions for buttons
        txtIntRtL.setOnMouseClicked( event -> {
            btn1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"1");
                }
            });

            btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"4");
                }
            });

            btn3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"3");
                }
            });

            btn2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"2");
                }
            });
            btn5.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"5");
                }
            });
            btn6.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"6");
                }
            });
            btn7.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"7");
                }
            });
            btn8.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"8");
                }
            });
            btn9.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"9");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+".");
                }
            });
            btn0.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"0");
                }
            });
            btnminus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIntRtL.setText(txtIntRtL.getText()+"-");
                }
            });

        });

        Image image = new Image("images.jpg");
        ImageView LoanImg=new ImageView(image);
        LoanImg.setFitWidth(500);
        LoanImg.setFitHeight(500);
        Group root= new Group();

        Pane LoanP=new Pane();          //this pane will have every element thats should be in Loan calculator
        LoanP.getChildren().addAll(LoanImg,help_btnl,btn1,btn4,btn3,btn2,btn5,btn6,btn7,btn8,btn9,btndot,btn0,btnminus,clearBtnL,txtloanAmntL,loan_amountL,loantermL,IntRateL,btnCalAL3,BackBtnL3,txtIntRtL,txtLoantrmL,rpaymentEvMonth,rtotIntrest,rtotpay);

        Scene scene = new Scene(LoanP, 500, 500);
        windowL.setScene(scene);
        windowL.show();

        return LoanP ;
    }
}
