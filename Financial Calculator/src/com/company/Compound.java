package com.company;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Compound {
    public static Pane tabPane() {
        Stage window = new Stage();
        window.setTitle("Compound Saving calculator");

        //Financial cal
        Tab tab1 = new Tab("Final Value");
        Tab tab2 = new Tab("Payment");
        Tab tab4 = new Tab("Number of periods");
        Tab tab5 = new Tab("Start Principal");
        Tab tab11=new Tab("Help");

        // TabPane
        TabPane tabPane = new TabPane();
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab4);
        tabPane.getTabs().add(tab5);
        tabPane.getTabs().add(tab11);
        tabPane.setTabMaxWidth(700); // Increase the width of the tab
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Removing close button in tabs

        // Label of Future value Tab
        Label NoOfPeriods1 = new Label("Periods (Years)");
        NoOfPeriods1.setLayoutX(110);
        NoOfPeriods1.setLayoutY(60);

        Label sp1 = new Label("Start Principal ($)");
        sp1.setLayoutX(110);
        sp1.setLayoutY(90);

        Label interest1 = new Label("intrest (%)");
        interest1.setLayoutX(110);
        interest1.setLayoutY(120);

        Label pmt1 = new Label("PMT (Annuity Payment)($)");
        pmt1.setLayoutX(110);
        pmt1.setLayoutY(150);

        Label rFv = new Label();
        rFv.setLayoutX(120);
        rFv.setLayoutY(255);
        rFv.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
        //rFv.setPrefSize(150,30);

        //TextField of Future value
        TextField txtN1 = new TextField();
        txtN1.setLayoutX(280);
        txtN1.setLayoutY(60);
        txtN1.setPrefWidth(80);

        TextField txtSp1 = new TextField();
        txtSp1.setLayoutX(280);
        txtSp1.setLayoutY(90);
        txtSp1.setPrefWidth(80);

        TextField txtIy1 = new TextField();
        txtIy1.setLayoutX(280);
        txtIy1.setLayoutY(120);
        txtIy1.setPrefWidth(80);

        TextField txtPmt1 = new TextField();
        txtPmt1.setLayoutX(280);
        txtPmt1.setLayoutY(150);
        txtPmt1.setPrefWidth(80);

        // Button of Future Value
        Button calBtn=new Button("Calculate");
        calBtn.setLayoutX(280);
        calBtn.setLayoutY(180);
        calBtn.setPrefWidth(80);
        calBtn.setOnAction(e -> {
            try {
            double n=12;
            double t = Double.parseDouble(txtN1.getText());
            double P = Double.parseDouble(txtSp1.getText());
            double r = Double.parseDouble(txtIy1.getText())/100;
            double PMT = Double.parseDouble(txtPmt1.getText());
                double A;
                A=(P * Math.pow((1 + (r / n)), (n * t))) + (PMT * ((Math.pow((1 + (r / n)), (n * t)) - 1) / (r/n)));
                rFv.setText("The Future Value : "+String.format("%.2f",A)+"$");
            } catch (Exception prompt){
                rFv.setText("Please enter Integer values only.!");
            }
        });

        Button BackBtn=new Button("Back");
        BackBtn.setLayoutY(210);
        BackBtn.setLayoutX(280);
        BackBtn.setOnAction(e -> {
            window.close();
            Main.show();
        });

        Button clearBtn1 = new Button("Clear");
        clearBtn1.setLayoutX(320);
        clearBtn1.setLayoutY(210);
        clearBtn1.setOnAction(event -> {
            txtN1.clear();
            txtSp1.clear();
            txtPmt1.clear();
            txtIy1.clear();
            rFv.setText("");
        });

        Image image = new Image("image8.jpg");
        ImageView FVImg=new ImageView(image);   //background image
        FVImg.setFitWidth(500);
        FVImg.setFitHeight(500);
        Group root= new Group();

        ///keypad buttons
        Button btn1f = new Button("1");
        btn1f.setLayoutX(170);
        btn1f.setLayoutY(350);
        btn1f.setPrefSize(20,20);
        btn1f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2f = new Button("2");
        btn2f.setLayoutX(210);
        btn2f.setLayoutY(350);
        btn2f.setPrefSize(20,20);
        btn2f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn3f = new Button("3");
        btn3f.setLayoutX(250);
        btn3f.setLayoutY(350);
        btn3f.setPrefSize(20,20);
        btn3f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4f = new Button("4");
        btn4f.setLayoutX(170);
        btn4f.setLayoutY(390);
        btn4f.setPrefSize(20,20);
        btn4f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn5f = new Button("5");
        btn5f.setLayoutX(210);
        btn5f.setLayoutY(390);
        btn5f.setPrefSize(2,20);
        btn5f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn6f = new Button("6");
        btn6f.setLayoutX(250);
        btn6f.setLayoutY(390);
        btn6f.setPrefSize(20,20);
        btn6f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7f = new Button("7");
        btn7f.setLayoutX(170);
        btn7f.setLayoutY(430);
        btn7f.setPrefSize(20,20);
        btn7f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8f = new Button("8");
        btn8f.setLayoutX(210);
        btn8f.setLayoutY(430);
        btn8f.setPrefSize(20,20);
        btn8f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9f = new Button("9");
        btn9f.setLayoutX(250);
        btn9f.setLayoutY(430);
        btn9f.setPrefSize(20,20);
        btn9f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndotf = new Button(".");
        btndotf.setLayoutX(290);
        btndotf.setLayoutY(350);
        btndotf.setPrefSize(30,20);
        btndotf.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0f = new Button("0");
        btn0f.setLayoutX(290);
        btn0f.setLayoutY(430);
        btn0f.setPrefSize(20,20);
        btn0f.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btnminusf = new Button("-");
        btnminusf.setLayoutX(290);
        btnminusf.setLayoutY(390);
        btnminusf.setPrefSize(30,20);
        btnminusf.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtSp1.setOnMouseClicked( event -> {
            btn1f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"1");
                }
            });
            btn4f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"4");
                }
            });

            btn3f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"3");
                }
            });

            btn2f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"2");
                }
            });
            btn5f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"5");
                }
            });
            btn6f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"6");
                }
            });
            btn7f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"7");
                }
            });
            btn8f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"8");
                }
            });
            btn9f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"9");
                }
            });
            btndotf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+".");
                }
            });
            btn0f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"0");
                }
            });
            btnminusf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp1.setText(txtSp1.getText()+"-");
                }
            });

        });

        txtN1.setOnMouseClicked( event -> {
            btn1f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"1");
                }
            });

            btn4f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"4");
                }
            });

            btn3f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"3");
                }
            });
            btn2f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"2");
                }
            });
            btn5f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"5");
                }
            });
            btn6f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"6");
                }
            });
            btn7f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"7");
                }
            });
            btn8f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"8");
                }
            });
            btn9f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"9");
                }
            });
            btn0f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"0");
                }
            });
            btndotf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+".");
                }
            });
            btnminusf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN1.setText(txtN1.getText()+"-");
                }
            });

        });
        txtPmt1.setOnMouseClicked( event -> {
            btn1f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"1");
                }
            });
            btn4f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"4");
                }
            });

            btn3f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"3");
                }
            });

            btn2f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"2");
                }
            });
            btn5f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"5");
                }
            });
            btn6f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"6");
                }
            });
            btn7f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"7");
                }
            });
            btn8f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"8");
                }
            });
            btn9f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"9");
                }
            });
            btndotf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+".");
                }
            });
            btn0f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"0");
                }
            });
            btnminusf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt1.setText(txtPmt1.getText()+"-");
                }
            });

        });

        txtIy1.setOnMouseClicked( event -> {
            btn1f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"1");
                }
            });

            btn4f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"4");
                }
            });

            btn3f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"3");
                }
            });

            btn2f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"2");
                }
            });
            btn5f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"5");
                }
            });
            btn6f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"6");
                }
            });
            btn7f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"7");
                }
            });
            btn8f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"8");
                }
            });
            btn9f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"9");
                }
            });
            btn0f.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"0");
                }
            });
            btndotf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+".");
                }
            });
            btnminusf.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy1.setText(txtIy1.getText()+"-");
                }
            });

        });

        Pane FVPane = new Pane();    //FV tab pane
        FVPane.getChildren().addAll(FVImg,clearBtn1,btn0f,btn1f,btn2f,btn3f,btn4f,btn5f,btn6f,btn7f,btn8f,btn9f,btndotf,btnminusf,rFv,NoOfPeriods1, sp1, interest1, pmt1,txtN1,txtSp1,txtIy1,txtPmt1,calBtn,BackBtn);
        tab1.setContent(FVPane);

        //Label of PMT
        Label fv2 = new Label("Future Value ($)");
        fv2.setLayoutX(110);
        fv2.setLayoutY(60);

        Label NoOfPeriods2 = new Label("Period (Years)");
        NoOfPeriods2.setLayoutX(110);
        NoOfPeriods2.setLayoutY(90);

        Label sp2 = new Label("Start Principal ($)");
        sp2.setLayoutX(110);
        sp2.setLayoutY(120);

        Label interest2 = new Label("Intrest (%)");
        interest2.setLayoutX(110);
        interest2.setLayoutY(150);

        Label rPMT = new Label();
        rPMT.setLayoutX(120);
        rPMT.setLayoutY(255);
        rPMT.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");


        Label rPMT2 = new Label();
        rPMT2.setLayoutX(120);
        rPMT2.setLayoutY(295);
        rPMT2.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
       // rPMT.setPrefSize(150,30);

        // TextField of PMT
        TextField txtFv2 = new TextField();
        txtFv2.setLayoutX(270);
        txtFv2.setLayoutY(60);
        txtFv2.setPrefWidth(80);

        TextField txtN2= new TextField();
        txtN2.setLayoutX(270);
        txtN2.setLayoutY(90);
        txtN2.setPrefWidth(80);

        TextField txtSp2= new TextField();
        txtSp2.setLayoutX(270);
        txtSp2.setLayoutY(120);
        txtSp2.setPrefWidth(80);

        TextField txtIy2= new TextField();
        txtIy2.setLayoutX(270);
        txtIy2.setLayoutY(150);
        txtIy2.setPrefWidth(80);

        Button calBtn1=new Button("Calculate");
        calBtn1.setLayoutX(270);
        calBtn1.setLayoutY(180);
        calBtn1.setPrefWidth(80);
        calBtn1.setOnAction(e -> {
            try {

            double n=12;
            double t = Double.parseDouble(txtN2.getText());
            double P = Double.parseDouble(txtSp2.getText());
            double r = Double.parseDouble(txtIy2.getText())/100;
            double A = Double.parseDouble(txtFv2.getText());
            double CI=P*pow((1+(r/12)),(12*t));

            double res1;
            res1= (A-(P*pow((1+(r/n)),(n*t))))/((pow((1+(r/n)),(n*t))-1)/(r/n));
            rPMT.setText("The PMT Value (Monthly) : "+String.format("%.2f",res1)+"$");
            rPMT2.setText("The PMT Value (yearly) : "+String.format("%.2f",res1*12)+"$");
            } catch (Exception prompt){
                rPMT.setText("Please enter Integer values only.!");

            }
        });


        Button BackBtn1=new Button("Back");
        BackBtn1.setLayoutY(210);
        BackBtn1.setLayoutX(270);
        BackBtn1.setOnAction(e -> {
            window.close();
            Main.show();

        });

        Button clearBtn2 = new Button("Clear");
        clearBtn2.setLayoutX(310);
        clearBtn2.setLayoutY(210);
        clearBtn2.setOnAction(event -> {

            txtN2.clear();
            txtSp2.clear();
            txtFv2.clear();
            txtIy2.clear();
            rPMT.setText("");
        });

        Image image1 = new Image("image8.jpg");
        ImageView paymentImg=new ImageView(image1);
        paymentImg.setFitWidth(500);
        paymentImg.setFitHeight(500);
        Group root1= new Group();

        Button btn1p = new Button("1");
        btn1p.setLayoutX(170);
        btn1p.setLayoutY(350);
        btn1p.setPrefSize(20,20);
        btn1p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2p = new Button("2");
        btn2p.setLayoutX(210);
        btn2p.setLayoutY(350);
        btn2p.setPrefSize(20,20);
        btn2p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn3p = new Button("3");
        btn3p.setLayoutX(250);
        btn3p.setLayoutY(350);
        btn3p.setPrefSize(20,20);
        btn3p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4p = new Button("4");
        btn4p.setLayoutX(170);
        btn4p.setLayoutY(390);
        btn4p.setPrefSize(20,20);
        btn4p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn5p = new Button("5");
        btn5p.setLayoutX(210);
        btn5p.setLayoutY(390);
        btn5p.setPrefSize(2,20);
        btn5p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn6p = new Button("6");
        btn6p.setLayoutX(250);
        btn6p.setLayoutY(390);
        btn6p.setPrefSize(20,20);
        btn6p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7p = new Button("7");
        btn7p.setLayoutX(170);
        btn7p.setLayoutY(430);
        btn7p.setPrefSize(20,20);
        btn7p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8p = new Button("8");
        btn8p.setLayoutX(210);
        btn8p.setLayoutY(430);
        btn8p.setPrefSize(20,20);
        btn8p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9p = new Button("9");
        btn9p.setLayoutX(250);
        btn9p.setLayoutY(430);
        btn9p.setPrefSize(20,20);
        btn9p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndotp = new Button(".");
        btndotp.setLayoutX(290);
        btndotp.setLayoutY(350);
        btndotp.setPrefSize(30,20);
        btndotp.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0p = new Button("0");
        btn0p.setLayoutX(290);
        btn0p.setLayoutY(430);
        btn0p.setPrefSize(20,20);
        btn0p.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btnminusp = new Button("-");
        btnminusp.setLayoutX(290);
        btnminusp.setLayoutY(390);
        btnminusp.setPrefSize(30,20);
        btnminusp.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtFv2.setOnMouseClicked( event -> {
            btn1p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"1");
                }
            });
            btn4p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"4");
                }
            });

            btn3p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"3");
                }
            });

            btn2p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"2");
                }
            });
            btn5p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"5");
                }
            });
            btn6p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"6");
                }
            });
            btn7p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"7");
                }
            });
            btn8p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"8");
                }
            });
            btn9p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"9");
                }
            });
            btndotp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+".");
                }
            });
            btn0p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"0");
                }
            });
            btnminusp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv2.setText(txtFv2.getText()+"-");
                }
            });

        });

        txtIy2.setOnMouseClicked( event -> {
            btn1p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"1");
                }
            });
            btn4p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"4");
                }
            });

            btn3p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"3");
                }
            });

            btn2p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"2");
                }
            });
            btn5p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"5");
                }
            });
            btn6p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"6");
                }
            });
            btn7p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"7");
                }
            });
            btn8p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"8");
                }
            });
            btn9p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"9");
                }
            });
            btndotp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+".");
                }
            });
            btn0p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"0");
                }
            });
            btnminusp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy2.setText(txtIy2.getText()+"-");
                }
            });

        });

        txtSp2.setOnMouseClicked( event -> {
            btn1p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"1");
                }
            });
            btn4p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"4");
                }
            });

            btn3p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"3");
                }
            });

            btn2p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"2");
                }
            });
            btn5p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"5");
                }
            });
            btn6p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"6");
                }
            });
            btn7p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"7");
                }
            });
            btn8p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"8");
                }
            });
            btn9p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"9");
                }
            });
            btndotp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+".");
                }
            });
            btn0p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"0");
                }
            });
            btnminusp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp2.setText(txtSp2.getText()+"-");
                }
            });

        });
        txtN2.setOnMouseClicked( event -> {
            btn1p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"1");
                }
            });
            btn4p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"4");
                }
            });

            btn3p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"3");
                }
            });

            btn2p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"2");
                }
            });
            btn5p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"5");
                }
            });
            btn6p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"6");
                }
            });
            btn7p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"7");
                }
            });
            btn8p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"8");
                }
            });
            btn9p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"9");
                }
            });
            btndotp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+".");
                }
            });
            btn0p.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"0");
                }
            });
            btnminusp.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN2.setText(txtN2.getText()+"-");
                }
            });

        });

        Pane paymentPane =new Pane();  //payment
        paymentPane.getChildren().addAll(paymentImg,rPMT,rPMT2,btn0p,btn1p,btn2p,btn3p,btn4p,btn5p,btn6p,btn7p,btn8p,btn9p,btndotp,btnminusp,clearBtn2,fv2,NoOfPeriods2,sp2,interest2,txtFv2,txtN2,txtSp2,txtIy2,BackBtn1,calBtn1);
        tab2.setContent(paymentPane);


        //Label of NoOfPeriods
        Label fv4 = new Label("Future Value ($)");
        fv4.setLayoutX(110);
        fv4.setLayoutY(60);

        Label sp4 = new Label("Start Principal ($)");
        sp4.setLayoutX(110);
        sp4.setLayoutY(90);

        Label interest4 = new Label("Interest (%)");
        interest4.setLayoutX(110);
        interest4.setLayoutY(120);

        Label pmt4 = new Label("PMT (Annuity Payment)($)");
        pmt4.setLayoutX(110);
        pmt4.setLayoutY(150);

        //output label for no of periods
        Label rnop = new Label();
        rnop.setLayoutX(170);
        rnop.setLayoutY(255);
        rnop.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
        //rnop.setPrefSize(150,30);

        //TextField of NoOfPeriods
        TextField txtFv4 = new TextField();
        txtFv4.setLayoutX(270);
        txtFv4.setLayoutY(60);
        txtFv4.setPrefWidth(80);

        TextField txtSp4= new TextField();
        txtSp4.setLayoutX(270);
        txtSp4.setLayoutY(90);
        txtSp4.setPrefWidth(80);

        TextField txtIy4= new TextField();
        txtIy4.setLayoutX(270);
        txtIy4.setLayoutY(120);
        txtIy4.setPrefWidth(80);

        TextField txtPmt4 = new TextField();
        txtPmt4.setLayoutX(270);
        txtPmt4.setLayoutY(150);
        txtPmt4.setPrefWidth(80);

        Button calBtn3=new Button("Calculate");
        calBtn3.setLayoutX(270);
        calBtn3.setLayoutY(180);
        calBtn3.setPrefWidth(80);
        calBtn3.setOnAction(e -> {
            //on action for calculate button
            try {
            double n=12;
            double r = Double.parseDouble(txtIy4.getText())/100;
            double P = Double.parseDouble(txtSp4.getText());
            double PMT = Double.parseDouble(txtPmt4.getText());
            double A = Double.parseDouble(txtFv4.getText());
            double res4;
            res4=log((A+(PMT*12/r))/(P+(PMT*12/r)))/(log(1+(r/12))*12);
            rnop.setText("No of Period : "+String.format("%.2f",res4)+"Years");
            } catch (Exception prompt){
                rnop.setText("Please enter Integer values only.!");

            }
        });

        Button BackBtn3=new Button("Back");
        BackBtn3.setLayoutY(210);
        BackBtn3.setLayoutX(270);
        BackBtn3.setOnAction(e -> {
            window.close();
            Main.show();
        });


        Button clearBtn4 = new Button("Clear");
        clearBtn4.setLayoutX(310);
        clearBtn4.setLayoutY(210);
        clearBtn4.setOnAction(event -> {
            txtFv4.clear();
            txtSp4.clear();
            txtPmt4.clear();
            txtIy4.clear();
            rnop.setText("");
        });

        Image image3 = new Image("image5.jpg");
        ImageView NOPImg=new ImageView(image3);
        NOPImg.setFitWidth(500);
        NOPImg.setFitHeight(500);
        Group root3= new Group();

        Button btn1t = new Button("1");
        btn1t.setLayoutX(170);
        btn1t.setLayoutY(350);
        btn1t.setPrefSize(20,20);
        btn1t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2t = new Button("2");
        btn2t.setLayoutX(210);
        btn2t.setLayoutY(350);
        btn2t.setPrefSize(20,20);
        btn2t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn3t = new Button("3");
        btn3t.setLayoutX(250);
        btn3t.setLayoutY(350);
        btn3t.setPrefSize(20,20);
        btn3t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4t = new Button("4");
        btn4t.setLayoutX(170);
        btn4t.setLayoutY(390);
        btn4t.setPrefSize(20,20);
        btn4t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn5t = new Button("5");
        btn5t.setLayoutX(210);
        btn5t.setLayoutY(390);
        btn5t.setPrefSize(2,20);
        btn5t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn6t = new Button("6");
        btn6t.setLayoutX(250);
        btn6t.setLayoutY(390);
        btn6t.setPrefSize(20,20);
        btn6t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7t = new Button("7");
        btn7t.setLayoutX(170);
        btn7t.setLayoutY(430);
        btn7t.setPrefSize(20,20);
        btn7t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8t = new Button("8");
        btn8t.setLayoutX(210);
        btn8t.setLayoutY(430);
        btn8t.setPrefSize(20,20);
        btn8t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9t = new Button("9");
        btn9t.setLayoutX(250);
        btn9t.setLayoutY(430);
        btn9t.setPrefSize(20,20);
        btn9t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndott = new Button(".");
        btndott.setLayoutX(290);
        btndott.setLayoutY(350);
        btndott.setPrefSize(30,20);
        btndott.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0t = new Button("0");
        btn0t.setLayoutX(290);
        btn0t.setLayoutY(430);
        btn0t.setPrefSize(20,20);
        btn0t.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btnminust = new Button("-");
        btnminust.setLayoutX(290);
        btnminust.setLayoutY(390);
        btnminust.setPrefSize(30,20);
        btnminust.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtPmt4.setOnMouseClicked( event -> {
            btn1t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"1");
                }
            });
            btn4t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"4");
                }
            });

            btn3t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"3");
                }
            });

            btn2t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"2");
                }
            });
            btn5t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"5");
                }
            });
            btn6t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"6");
                }
            });
            btn7t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"7");
                }
            });
            btn8t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"8");
                }
            });
            btn9t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"9");
                }
            });
            btndott.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+".");
                }
            });
            btn0t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"0");
                }
            });
            btnminust.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt4.setText(txtPmt4.getText()+"-");
                }
            });

        });

        txtIy4.setOnMouseClicked( event -> {
            btn1t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"1");
                }
            });
            btn4t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"4");
                }
            });

            btn3t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"3");
                }
            });

            btn2t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"2");
                }
            });
            btn5t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"5");
                }
            });
            btn6t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"6");
                }
            });
            btn7t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"7");
                }
            });
            btn8t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"8");
                }
            });
            btn9t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"9");
                }
            });
            btndott.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+".");
                }
            });
            btn0t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"0");
                }
            });
            btnminust.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy4.setText(txtIy4.getText()+"-");
                }
            });

        });

        txtSp4.setOnMouseClicked( event -> {
            btn1t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"1");
                }
            });
            btn4t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"4");
                }
            });

            btn3t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"3");
                }
            });

            btn2t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"2");
                }
            });
            btn5t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"5");
                }
            });
            btn6t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"6");
                }
            });
            btn7t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"7");
                }
            });
            btn8t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"8");
                }
            });
            btn9t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"9");
                }
            });
            btndott.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+".");
                }
            });
            btn0t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"0");
                }
            });
            btnminust.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp4.setText(txtSp4.getText()+"-");
                }
            });

        });

        txtFv4.setOnMouseClicked( event -> {
            btn1t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"1");
                }
            });
            btn4t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"4");
                }
            });

            btn3t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"3");
                }
            });

            btn2t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"2");
                }
            });
            btn5t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"5");
                }
            });
            btn6t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"6");
                }
            });
            btn7t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"7");
                }
            });
            btn8t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"8");
                }
            });
            btn9t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"9");
                }
            });
            btndott.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+".");
                }
            });
            btn0t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"0");
                }
            });
            btnminust.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv4.setText(txtFv4.getText()+"-");
                }
            });

        });

        Pane noOfPeriods = new Pane();
        noOfPeriods.getChildren().addAll(NOPImg,fv4,rnop,btn0t,btn1t,btn2t,btn3t,btn4t,btn5t,btn6t,btn7t,btn8t,btn9t,btnminust,btndott,clearBtn4,sp4,interest4,pmt4,txtFv4,txtSp4,txtIy4,txtPmt4,calBtn3,BackBtn3);
        tab4.setContent(noOfPeriods);

        //Label of Start principal
        Label fv5 = new Label("Future Value ($)");
        fv5.setLayoutX(110);
        fv5.setLayoutY(60);

        Label NoOfPeriods5 = new Label("No of Periods (Years)");
        NoOfPeriods5.setLayoutX(110);
        NoOfPeriods5.setLayoutY(90);

        Label interest5 = new Label("Interest (%)");
        interest5.setLayoutX(110);
        interest5.setLayoutY(120);

        Label pmt5 = new Label("PMT (Annuity Payment)($)");
        pmt5.setLayoutX(110);
        pmt5.setLayoutY(150);

        Label rstartPri= new Label();
        rstartPri.setLayoutX(100);
        rstartPri.setLayoutY(255);
        rstartPri.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
        //rstartPri.setPrefSize(150,30);

        //TextField of Start Principal
        TextField txtFv5 = new TextField();
        txtFv5.setLayoutX(270);
        txtFv5.setLayoutY(60);
        txtFv5.setPrefWidth(80);

        TextField txtN5= new TextField();
        txtN5.setLayoutX(270);
        txtN5.setLayoutY(90);
        txtN5.setPrefWidth(80);

        TextField txtIy5= new TextField();
        txtIy5.setLayoutX(270);
        txtIy5.setLayoutY(120);
        txtIy5.setPrefWidth(80);

        TextField txtPmt5 = new TextField();
        txtPmt5.setLayoutX(270);
        txtPmt5.setLayoutY(150);
        txtPmt5.setPrefWidth(80);

        Button calBtn4=new Button("Calculate");
        calBtn4.setLayoutX(270);
        calBtn4.setLayoutY(180);
        calBtn4.setPrefWidth(80);
        calBtn4.setOnAction(e -> {
            try{
            double n=12;
            double r = Double.parseDouble(txtIy5.getText())/100;
            double t = Double.parseDouble(txtN5.getText());
            double PMT = Double.parseDouble(txtPmt5.getText());
            double A = Double.parseDouble(txtFv5.getText());
            double res5;
            res5= (A-(PMT*((pow((1+(r/n)),(n*t))-1)/(r/n))))/(pow((1+(r/n)),(n*t)));
            rstartPri.setText("The Start Principal Value Is "+String.format("%.2f",res5)+"$");
            } catch (Exception prompt){
                rstartPri.setText("Please enter Integer values only.!");

            }
        });

        Button BackBtn4=new Button("Back");
        BackBtn4.setLayoutY(210);
        BackBtn4.setLayoutX(270);
        BackBtn4.setOnAction(e -> {
            window.close();
            Main.show();
        });

        Button clearBtn5 = new Button("Clear");
        clearBtn5.setLayoutX(310);
        clearBtn5.setLayoutY(210);
        clearBtn5.setOnAction(event -> {
            txtFv5.clear();
            txtN5.clear();
            txtPmt5.clear();
            txtIy5.clear();
            rstartPri.setText("");
        });

        Image image4 = new Image("image10.jpeg");
        ImageView sPImg=new ImageView(image4);
        sPImg.setFitWidth(500);
        sPImg.setFitHeight(500);
        Group root4= new Group();

        Button btn1s = new Button("1");
        btn1s.setLayoutX(170);
        btn1s.setLayoutY(350);
        btn1s.setPrefSize(20,20);
        btn1s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2s = new Button("2");
        btn2s.setLayoutX(210);
        btn2s.setLayoutY(350);
        btn2s.setPrefSize(20,20);
        btn2s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn3s = new Button("3");
        btn3s.setLayoutX(250);
        btn3s.setLayoutY(350);
        btn3s.setPrefSize(20,20);
        btn3s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4s = new Button("4");
        btn4s.setLayoutX(170);
        btn4s.setLayoutY(390);
        btn4s.setPrefSize(20,20);
        btn4s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn5s = new Button("5");
        btn5s.setLayoutX(210);
        btn5s.setLayoutY(390);
        btn5s.setPrefSize(2,20);
        btn5s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn6s = new Button("6");
        btn6s.setLayoutX(250);
        btn6s.setLayoutY(390);
        btn6s.setPrefSize(20,20);
        btn6s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7s = new Button("7");
        btn7s.setLayoutX(170);
        btn7s.setLayoutY(430);
        btn7s.setPrefSize(20,20);
        btn7s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8s = new Button("8");
        btn8s.setLayoutX(210);
        btn8s.setLayoutY(430);
        btn8s.setPrefSize(20,20);
        btn8s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9s = new Button("9");
        btn9s.setLayoutX(250);
        btn9s.setLayoutY(430);
        btn9s.setPrefSize(20,20);
        btn9s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndots = new Button(".");
        btndots.setLayoutX(290);
        btndots.setLayoutY(350);
        btndots.setPrefSize(30,20);
        btndots.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0s = new Button("0");
        btn0s.setLayoutX(290);
        btn0s.setLayoutY(430);
        btn0s.setPrefSize(20,20);
        btn0s.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btnminuss = new Button("-");
        btnminuss.setLayoutX(290);
        btnminuss.setLayoutY(390);
        btnminuss.setPrefSize(30,20);
        btnminuss.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtPmt5.setOnMouseClicked( event -> {
            btn1s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"1");
                }
            });
            btn4s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"4");
                }
            });

            btn3s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"3");
                }
            });

            btn2s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"2");
                }
            });
            btn5s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"5");
                }
            });
            btn6s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"6");
                }
            });
            btn7s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"7");
                }
            });
            btn8s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"8");
                }
            });
            btn9s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"9");
                }
            });
            btndots.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+".");
                }
            });
            btn0s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"0");
                }
            });
            btnminuss.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPmt5.setText(txtPmt5.getText()+"-");
                }
            });

        });

        txtIy5.setOnMouseClicked( event -> {
            btn1s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"1");
                }
            });

            btn4s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"4");
                }
            });

            btn3s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"3");
                }
            });

            btn2s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"2");
                }
            });
            btn5s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"5");
                }
            });
            btn6s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"6");
                }
            });
            btn7s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"7");
                }
            });
            btn8s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"8");
                }
            });
            btn9s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"9");
                }
            });
            btn0s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"0");
                }
            });
            btndots.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+".");
                }
            });
            btnminuss.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy5.setText(txtIy5.getText()+"-");
                }
            });

        });

        //setting set on actions for buttons
        txtN5.setOnMouseClicked( event -> {
            btn1s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"1");
                }
            });

            btn4s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"4");
                }
            });

            btn3s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"3");
                }
            });

            btn2s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"2");
                }
            });
            btn5s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"5");
                }
            });
            btn6s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"6");
                }
            });
            btn7s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"7");
                }
            });
            btn8s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"8");
                }
            });
            btn9s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"9");
                }
            });
            btndots.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+".");
                }
            });
            btn0s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"0");
                }
            });
            btnminuss.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN5.setText(txtN5.getText()+"-");
                }
            });

        });

        txtFv5.setOnMouseClicked( event -> {
            btn1s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"1");
                }
            });

            btn4s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"4");
                }
            });

            btn3s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"3");
                }
            });

            btn2s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"2");
                }
            });
            btn5s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"5");
                }
            });
            btn6s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"6");
                }
            });
            btn7s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"7");
                }
            });
            btn8s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"8");
                }
            });
            btn9s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"9");
                }
            });
            btndots.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+".");
                }
            });
            btn0s.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"0");
                }
            });
            btnminuss.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv5.setText(txtFv5.getText()+"-");
                }
            });

        });

        Pane startPrincipal = new Pane();
        startPrincipal.getChildren().addAll(sPImg,rstartPri,btn0s,btn1s,btn2s,btn3s,btn4s,btn5s,btn6s,btn7s,btn8s,btn9s,btndots,btnminuss,clearBtn5,fv5,NoOfPeriods5,interest5,pmt5,txtFv5,txtN5,txtIy5,txtPmt5,calBtn4,BackBtn4);
        tab5.setContent(startPrincipal);

        Pane Help = new Pane();    //help tab
        tab11.setContent(com.company.Help.helpC());

        Pane Final=new Pane();
        Final.getChildren().addAll(startPrincipal,noOfPeriods,FVPane,paymentPane);

        Scene scene = new Scene(tabPane, 500, 500);
        window.setScene(scene);
        window.show();

        return Final;
    }
}
