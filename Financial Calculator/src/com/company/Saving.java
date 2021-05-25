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

public class Saving {
    public static TabPane tabPane2() {
        Stage window = new Stage();
        window.setTitle("Simple Saving calculator");

        //Financial cal
        Tab tab6 = new Tab("Final Value");
        Tab tab7 = new Tab("Start Principal");
        Tab tab8= new Tab("Interest");
        Tab tab9 = new Tab("Number of periods");
        Tab tab10 = new Tab("Help");

        Button btn1 = new Button("1");
        btn1.setLayoutX(170);
        btn1.setLayoutY(350);
        btn1.setPrefSize(20,20);
        btn1.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        // TabPane
        TabPane tabPane2 = new TabPane();
        tabPane2.getTabs().addAll(tab6);
        tabPane2.getTabs().addAll(tab7);
        tabPane2.getTabs().addAll(tab8);
        tabPane2.getTabs().addAll(tab9);
        tabPane2.getTabs().add(tab10);
        tabPane2.setTabMaxWidth(700); // Increase the width of the tab
        tabPane2.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE); // Removing close button in tabs

        // Label of Future value Tab
        Label NoOfPeriods6 = new Label("Periods (years)");
        NoOfPeriods6.setLayoutX(110);
        NoOfPeriods6.setLayoutY(60);

        Label sp6 = new Label("Start Principal ($)");
        sp6.setLayoutX(110);
        sp6.setLayoutY(90);

        Label interest6 = new Label("I/Y (interest) (%)");
        interest6.setLayoutX(110);
        interest6.setLayoutY(120);

        Label rFv2 = new Label();
        rFv2.setLayoutX(140);
        rFv2.setLayoutY(255);
        rFv2.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
        // rFv.setPrefSize(150,30);

        //TextField of Future value
        TextField txtN6 = new TextField();
        txtN6.setLayoutX(280);
        txtN6.setLayoutY(60);
        txtN6.setPrefWidth(80);

        TextField txtSp6 = new TextField();
        txtSp6.setLayoutX(280);
        txtSp6.setLayoutY(90);
        txtSp6.setPrefWidth(80);

        TextField txtIy6 = new TextField();
        txtIy6.setLayoutX(280);
        txtIy6.setLayoutY(120);
        txtIy6.setPrefWidth(80);

        // Button of Future Value
        Button calBtn6=new Button("Calculate");
        calBtn6.setLayoutX(280);
        calBtn6.setLayoutY(180);
        calBtn6.setPrefWidth(80);

        calBtn6.setOnAction(e -> { //set on action for Fv calculation
            try{
            double n=12;
            double t = Double.parseDouble(txtN6.getText());
            double P = Double.parseDouble(txtSp6.getText());
            double r = Double.parseDouble(txtIy6.getText())/100;
            double res1;
            res1= P*pow((1+(r/12)),(12*t));
            rFv2.setText("Future Value : "+String.format("%.2f",res1)+"$");
            } catch (Exception prompt){
                rFv2.setText("Please enter Integer values only.!");

            }
        });

        Button BackBtn6=new Button("Back");
        BackBtn6.setLayoutY(210);
        BackBtn6.setLayoutX(280);
        BackBtn6.setOnAction(e -> {
            window.close();
            Main.show();
        });
        Button clearBtnFV = new Button("Clear");
        clearBtnFV.setLayoutX(320);
        clearBtnFV.setLayoutY(210);
        clearBtnFV.setOnAction(event -> {
            txtN6.clear();
            txtSp6.clear();
            txtIy6.clear();
            rFv2.setText("");
        });

        Image image6 = new Image("image8.jpg");
        ImageView FVImg=new ImageView(image6);   //background image6
        FVImg.setFitWidth(500);
        FVImg.setFitHeight(500);
        Group root= new Group();

        Button btn1CF = new Button("1");
        btn1CF.setLayoutX(170);
        btn1CF.setLayoutY(350);
        btn1CF.setPrefSize(20,20);
        btn1CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2CF = new Button("2");
        btn2CF.setLayoutX(210);
        btn2CF.setLayoutY(350);
        btn2CF.setPrefSize(20,20);
        btn2CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn3CF = new Button("3");
        btn3CF.setLayoutX(250);
        btn3CF.setLayoutY(350);
        btn3CF.setPrefSize(20,20);
        btn3CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4CF = new Button("4");
        btn4CF.setLayoutX(170);
        btn4CF.setLayoutY(390);
        btn4CF.setPrefSize(20,20);
        btn4CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn5CF = new Button("5");
        btn5CF.setLayoutX(210);
        btn5CF.setLayoutY(390);
        btn5CF.setPrefSize(2,20);
        btn5CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn6CF = new Button("6");
        btn6CF.setLayoutX(250);
        btn6CF.setLayoutY(390);
        btn6CF.setPrefSize(20,20);
        btn6CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7CF = new Button("7");
        btn7CF.setLayoutX(170);
        btn7CF.setLayoutY(430);
        btn7CF.setPrefSize(20,20);
        btn7CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8CF = new Button("8");
        btn8CF.setLayoutX(210);
        btn8CF.setLayoutY(430);
        btn8CF.setPrefSize(20,20);
        btn8CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9CF = new Button("9");
        btn9CF.setLayoutX(250);
        btn9CF.setLayoutY(430);
        btn9CF.setPrefSize(20,20);
        btn9CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndotCF = new Button(".");
        btndotCF.setLayoutX(290);
        btndotCF.setLayoutY(350);
        btndotCF.setPrefSize(30,20);
        btndotCF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0CF = new Button("0");
        btn0CF.setLayoutX(290);
        btn0CF.setLayoutY(430);
        btn0CF.setPrefSize(20,20);
        btn0CF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btnminusCF = new Button("-");
        btnminusCF.setLayoutX(290);
        btnminusCF.setLayoutY(390);
        btnminusCF.setPrefSize(30,20);
        btnminusCF.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtIy6.setOnMouseClicked( event -> {
            btn1CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"1");
                }
            });
            btn4CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"4");
                }
            });

            btn3CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"3");
                }
            });

            btn2CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"2");
                }
            });
            btn5CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"5");
                }
            });
            btn6CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"6");
                }
            });
            btn7CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"7");
                }
            });
            btn8CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"8");
                }
            });
            btn9CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"9");
                }
            });
            btndotCF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+".");
                }
            });
            btn0CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"0");
                }
            });
            btnminusCF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy6.setText(txtIy6.getText()+"-");
                }
            });

        });

        txtN6.setOnMouseClicked( event -> {
            btn1CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"1");
                }
            });

            btn4CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"4");
                }
            });

            btn3CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"3");
                }
            });

            btn2CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"2");
                }
            });
            btn5CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"5");
                }
            });
            btn6CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"6");
                }
            });
            btn7CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"7");
                }
            });
            btn8CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"8");
                }
            });
            btn9CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"9");
                }
            });
            btn0CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"0");
                }
            });
            btndotCF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+".");
                }
            });
            btnminusCF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN6.setText(txtN6.getText()+"-");
                }
            });
        });
        //setting set on actions for buttons
        txtSp6.setOnMouseClicked( event -> {
            btn1CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"1");
                }
            });

            btn4CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"4");
                }
            });

            btn3CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"3");
                }
            });

            btn2CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"2");
                }
            });
            btn5CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"5");
                }
            });
            btn6CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"6");
                }
            });
            btn7CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"7");
                }
            });
            btn8CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"8");
                }
            });
            btn9CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"9");
                }
            });
            btndotCF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+".");
                }
            });
            btn0CF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"0");
                }
            });
            btnminusCF.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp6.setText(txtSp6.getText()+"-");
                }
            });
        });

        Pane FVPane2 = new Pane();    //FV tab pane creation and adding childrens
        FVPane2.getChildren().addAll(FVImg,rFv2,NoOfPeriods6,clearBtnFV, sp6,btndotCF,btnminusCF,btn0CF,btn9CF,btn8CF,btn7CF,btn6CF,btn5CF,btn4CF,btn3CF,btn2CF,btn1CF, interest6,txtN6,txtSp6,txtIy6,calBtn6,BackBtn6);
        tab6.setContent(FVPane2);

        //Label of I/Y UI
        Label fv8 = new Label("FV (Future Value)");
        fv8.setLayoutX(110);
        fv8.setLayoutY(60);

        Label NoOfPeriods8 = new Label("Periods (Years)");
        NoOfPeriods8.setLayoutX(110);
        NoOfPeriods8.setLayoutY(90);

        Label sp8 = new Label("Start Principal");
        sp8.setLayoutX(110);
        sp8.setLayoutY(120);

        Label rIrate2= new Label();
        rIrate2.setLayoutX(150);
        rIrate2.setLayoutY(255);
        rIrate2.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift");
        // rIrate.setPrefSize(150,30);

        //TextField of I/Y
        TextField txtFv8 = new TextField();
        txtFv8.setLayoutX(270);
        txtFv8.setLayoutY(60);
        txtFv8.setPrefWidth(80);

        TextField txtN8= new TextField();
        txtN8.setLayoutX(270);
        txtN8.setLayoutY(90);
        txtN8.setPrefWidth(80);

        TextField txtSp8= new TextField();
        txtSp8.setLayoutX(270);
        txtSp8.setLayoutY(120);
        txtSp8.setPrefWidth(80);

        Button calBtn8=new Button("Calculate");
        calBtn8.setLayoutX(270);
        calBtn8.setLayoutY(180);
        calBtn8.setPrefWidth(80);

        Button BackBtn8=new Button("Back");
        BackBtn8.setLayoutY(210);
        BackBtn8.setLayoutX(270);
        BackBtn8.setOnAction(e -> {
            window.close();
            Main.show();
        });
        Button clearBtnI = new Button("Clear");
        clearBtnI.setLayoutX(310);
        clearBtnI.setLayoutY(210);
        clearBtnI.setOnAction(event -> {
            txtN6.clear();
            txtSp6.clear();
            txtIy6.clear();
            rFv2.setText("");
        });

        Image image8 = new Image("image9.jpg");
        ImageView IYImg=new ImageView(image8);
        IYImg.setFitWidth(500);
        IYImg.setFitHeight(500);
        Group root2= new Group();

        Button btn1CI = new Button("1");
        btn1CI.setLayoutX(170);
        btn1CI.setLayoutY(350);
        btn1CI.setPrefSize(20,20);
        btn1CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2CI = new Button("2");
        btn2CI.setLayoutX(210);
        btn2CI.setLayoutY(350);
        btn2CI.setPrefSize(20,20);
        btn2CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn3CI = new Button("3");
        btn3CI.setLayoutX(250);
        btn3CI.setLayoutY(350);
        btn3CI.setPrefSize(20,20);
        btn3CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4CI = new Button("4");
        btn4CI.setLayoutX(170);
        btn4CI.setLayoutY(390);
        btn4CI.setPrefSize(20,20);
        btn4CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn5CI = new Button("5");
        btn5CI.setLayoutX(210);
        btn5CI.setLayoutY(390);
        btn5CI.setPrefSize(2,20);
        btn5CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn6CI = new Button("6");
        btn6CI.setLayoutX(250);
        btn6CI.setLayoutY(390);
        btn6CI.setPrefSize(20,20);
        btn6CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7CI = new Button("7");
        btn7CI.setLayoutX(170);
        btn7CI.setLayoutY(430);
        btn7CI.setPrefSize(20,20);
        btn7CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8CI = new Button("8");
        btn8CI.setLayoutX(210);
        btn8CI.setLayoutY(430);
        btn8CI.setPrefSize(20,20);
        btn8CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9CI = new Button("9");
        btn9CI.setLayoutX(250);
        btn9CI.setLayoutY(430);
        btn9CI.setPrefSize(20,20);
        btn9CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndotCI = new Button(".");
        btndotCI.setLayoutX(290);
        btndotCI.setLayoutY(350);
        btndotCI.setPrefSize(30,20);
        btndotCI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0CI = new Button("0");
        btn0CI.setLayoutX(290);
        btn0CI.setLayoutY(430);
        btn0CI.setPrefSize(20,20);
        btn0CI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btnminusCI = new Button("-");
        btnminusCI.setLayoutX(290);
        btnminusCI.setLayoutY(390);
        btnminusCI.setPrefSize(30,20);
        btnminusCI.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtSp8.setOnMouseClicked( event -> {
            btn1CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"1");
                }
            });
            btn4CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"4");
                }
            });

            btn3CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"3");
                }
            });

            btn2CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"2");
                }
            });
            btn5CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"5");
                }
            });
            btn6CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"6");
                }
            });
            btn7CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"7");
                }
            });
            btn8CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"8");
                }
            });
            btn9CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"9");
                }
            });
            btndotCI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+".");
                }
            });
            btn0CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"0");
                }
            });
            btnminusCI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp8.setText(txtSp8.getText()+"-");
                }
            });

        });


        txtN8.setOnMouseClicked( event -> {
            btn1CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"1");
                }
            });

            btn4CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"4");
                }
            });

            btn3CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"3");
                }
            });

            btn2CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"2");
                }
            });
            btn5CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"5");
                }
            });
            btn6CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"6");
                }
            });
            btn7CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"7");
                }
            });
            btn8CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"8");
                }
            });
            btn9CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"9");
                }
            });
            btn0CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"0");
                }
            });
            btndotCI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+".");
                }
            });
            btnminusCI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN8.setText(txtN8.getText()+"-");
                }
            });

        });
        //setting set on actions for buttons
        txtFv8.setOnMouseClicked( event -> {
            btn1CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"1");
                }
            });

            btn4CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"4");
                }
            });

            btn3CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"3");
                }
            });

            btn2CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"2");
                }
            });
            btn5CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"5");
                }
            });
            btn6CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"6");
                }
            });
            btn7CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"7");
                }
            });
            btn8CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"8");
                }
            });
            btn9CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"9");
                }
            });
            btndotCI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+".");
                }
            });
            btn0CI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"0");
                }
            });
            btnminusCI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv8.setText(txtFv8.getText()+"-");
                }
            });
        });

        Pane IYPane2 = new Pane();
        IYPane2.getChildren().addAll(IYImg,rIrate2,fv8,clearBtnI,btndotCI,btnminusCI,btn0CI,btn9CI,btn8CI,btn7CI,btn6CI,btn5CI,btn4CI,btn3CI,btn2CI,btn1CI,NoOfPeriods8,sp8,txtFv8,txtN8,txtSp8,calBtn8,BackBtn8);
        tab8.setContent(IYPane2);

        calBtn8.setOnAction(e -> {

            try{
            double n=12;
            double t = Double.parseDouble(txtN8.getText());
            double P = Double.parseDouble(txtSp8.getText());

            double A = Double.parseDouble(txtFv8.getText());

            double res1;
            res1= (n * ((Math.pow((A / P), (1/(n * t)))) - 1))*100;
            rIrate2.setText("interest Rate : "+String.format("%.2f",res1)+"%");
            } catch (Exception prompt){
                rIrate2.setText("Please enter Integer values only.!");

            }
        });

        //Label of NoOfPeriods
        Label fv9 = new Label("Future Value ($)");
        fv9.setLayoutX(110);
        fv9.setLayoutY(60);

        Label sp9 = new Label("Start Principal ($)");
        sp9.setLayoutX(110);
        sp9.setLayoutY(90);

        Label interest9 = new Label("Interest(%)");
        interest9.setLayoutX(110);
        interest9.setLayoutY(120);

        Label rnop2 = new Label();
        rnop2.setLayoutX(130);
        rnop2.setLayoutY(255);
        rnop2.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
        //rnop.setPrefSize(150,30);

        //TextField of NoOfPeriods
        TextField txtFv9 = new TextField();
        txtFv9.setLayoutX(270);
        txtFv9.setLayoutY(60);
        txtFv9.setPrefWidth(80);

        TextField txtSp9= new TextField();
        txtSp9.setLayoutX(270);
        txtSp9.setLayoutY(90);
        txtSp9.setPrefWidth(80);

        TextField txtIy9= new TextField();
        txtIy9.setLayoutX(270);
        txtIy9.setLayoutY(120);
        txtIy9.setPrefWidth(80);

        Button calBtn9=new Button("Calculate");
        calBtn9.setLayoutX(270);
        calBtn9.setLayoutY(180);
        calBtn9.setPrefWidth(80);

        Button BackBtn9=new Button("Back");
        BackBtn9.setLayoutY(210);
        BackBtn9.setLayoutX(270);
        BackBtn9.setOnAction(e -> {
            window.close();
            Main.show();
        });
        Button clearBtnT = new Button("Clear");
        clearBtnT.setLayoutX(310);
        clearBtnT.setLayoutY(210);
        clearBtnT.setOnAction(event -> {
            txtFv9.clear();
            txtIy9.clear();
            txtSp9.clear();
            rnop2.setText("");
        });

        Image image9 = new Image("image5.jpg");
        ImageView NOPImg=new ImageView(image9);
        NOPImg.setFitWidth(500);
        NOPImg.setFitHeight(500);
        Group root3= new Group();

        //keypad buttons followd by on action
        Button btn1CN = new Button("1");
        btn1CN.setLayoutX(170);
        btn1CN.setLayoutY(350);
        btn1CN.setPrefSize(20,20);
        btn1CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn2CN = new Button("2");
        btn2CN.setLayoutX(210);
        btn2CN.setLayoutY(350);
        btn2CN.setPrefSize(20,20);
        btn2CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn3CN = new Button("3");
        btn3CN.setLayoutX(250);
        btn3CN.setLayoutY(350);
        btn3CN.setPrefSize(20,20);
        btn3CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn4CN = new Button("4");
        btn4CN.setLayoutX(170);
        btn4CN.setLayoutY(390);
        btn4CN.setPrefSize(20,20);
        btn4CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn5CN = new Button("5");
        btn5CN.setLayoutX(210);
        btn5CN.setLayoutY(390);
        btn5CN.setPrefSize(2,20);
        btn5CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn6CN = new Button("6");
        btn6CN.setLayoutX(250);
        btn6CN.setLayoutY(390);
        btn6CN.setPrefSize(20,20);
        btn6CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7CN = new Button("7");
        btn7CN.setLayoutX(170);
        btn7CN.setLayoutY(430);
        btn7CN.setPrefSize(20,20);
        btn7CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8CN = new Button("8");
        btn8CN.setLayoutX(210);
        btn8CN.setLayoutY(430);
        btn8CN.setPrefSize(20,20);
        btn8CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9CN = new Button("9");
        btn9CN.setLayoutX(250);
        btn9CN.setLayoutY(430);
        btn9CN.setPrefSize(20,20);
        btn9CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndotCN = new Button(".");
        btndotCN.setLayoutX(290);
        btndotCN.setLayoutY(350);
        btndotCN.setPrefSize(30,20);
        btndotCN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0CN = new Button("0");
        btn0CN.setLayoutX(290);
        btn0CN.setLayoutY(430);
        btn0CN.setPrefSize(20,20);
        btn0CN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btnminusCN = new Button("-");
        btnminusCN.setLayoutX(290);
        btnminusCN.setLayoutY(390);
        btnminusCN.setPrefSize(30,20);
        btnminusCN.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtFv9.setOnMouseClicked( event -> {
            btn1CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"1");
                }
            });
            btn4CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"4");
                }
            });

            btn3CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"3");
                }
            });

            btn2CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"2");
                }
            });
            btn5CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"5");
                }
            });
            btn6CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"6");
                }
            });
            btn7CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"7");
                }
            });
            btn8CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"8");
                }
            });
            btn9CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"9");
                }
            });
            btndotCN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+".");
                }
            });
            btn0CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"0");
                }
            });
            btnminusCN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv9.setText(txtFv9.getText()+"-");
                }
            });

        });
        txtIy9.setOnMouseClicked( event -> {
            btn1CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"1");
                }
            });

            btn4CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"4");
                }
            });

            btn3CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"3");
                }
            });

            btn2CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"2");
                }
            });
            btn5CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"5");
                }
            });
            btn6CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"6");
                }
            });
            btn7CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"7");
                }
            });
            btn8CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"8");
                }
            });
            btn9CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"9");
                }
            });
            btn0CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"0");
                }
            });
            btndotCN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+".");
                }
            });
            btnminusCN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy9.setText(txtIy9.getText()+"-");
                }
            });

        });
        txtSp9.setOnMouseClicked( event -> {
            btn1CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"1");
                }
            });

            btn4CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"4");
                }
            });

            btn3CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"3");
                }
            });

            btn2CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"2");
                }
            });
            btn5CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"5");
                }
            });
            btn6CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"6");
                }
            });
            btn7CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"7");
                }
            });
            btn8CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"8");
                }
            });
            btn9CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"9");
                }
            });
            btndotCN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+".");
                }
            });
            btn0CN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"0");
                }
            });
            btnminusCN.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtSp9.setText(txtSp9.getText()+"-");
                }
            });
        });

        Pane noOfPeriods2 = new Pane();
        noOfPeriods2.getChildren().addAll(NOPImg,fv9,clearBtnT,rnop2,sp9,interest9,btndotCN,btnminusCN,btn0CN,btn1CN,btn2CN,btn3CN,btn9CN,btn8CN,btn7CN,btn6CN,btn5CN,btn4CN,txtFv9,txtSp9,txtIy9,calBtn9,BackBtn9);
        tab9.setContent(noOfPeriods2);

        calBtn9.setOnAction(e -> {    //on action for calculate button
            try{
            double n=12;
            double r = Double.parseDouble(txtIy9.getText())/100;
            double P = Double.parseDouble(txtSp9.getText());
            double A = Double.parseDouble(txtFv9.getText());
            double res2;
            res2=log(A/P)/(n*(log(1+(r/n))));
            rnop2.setText("Number of Periods : "+String.format("%.2f",res2)+"Years");
            } catch (Exception prompt){
                rnop2.setText("Please enter Integer values only.!");

            }
        });

        //Label of Start principal
        Label Fv7 = new Label("Future Value ($)");
        Fv7.setLayoutX(110);
        Fv7.setLayoutY(60);

        Label NoOfPeriods7 = new Label("No of Periods (Years)");
        NoOfPeriods7.setLayoutX(110);
        NoOfPeriods7.setLayoutY(90);

        Label interest7 = new Label("Interest (%)");
        interest7.setLayoutX(110);
        interest7.setLayoutY(120);

        Label rstartPri2= new Label();
        rstartPri2.setLayoutX(130);
        rstartPri2.setLayoutY(255);
        rstartPri2.setStyle("-fx-font-weight: bold;-fx-font-size: 16;-fx-font-family: Bahnschrift ");
        //rstartPri.setPrefSize(150,30);

        //TextField of Start Principal
        TextField txtFv7 = new TextField();
        txtFv7.setLayoutX(270);
        txtFv7.setLayoutY(60);
        txtFv7.setPrefWidth(80);

        TextField txtN7= new TextField();
        txtN7.setLayoutX(270);
        txtN7.setLayoutY(90);
        txtN7.setPrefWidth(80);

        TextField txtIy7= new TextField();
        txtIy7.setLayoutX(270);
        txtIy7.setLayoutY(120);
        txtIy7.setPrefWidth(80);

        Button calBtn7=new Button("Calculate");
        calBtn7.setLayoutX(270);
        calBtn7.setLayoutY(180);
        calBtn7.setPrefWidth(80);
        calBtn7.setOnAction(e -> {
                //calculations for start principal value
            try{
            double n=12;
            double r = Double.parseDouble(txtIy7.getText())/100;
            double t = Double.parseDouble(txtN7.getText());
            double A = Double.parseDouble(txtFv7.getText());
            double res1;
            res1=A/(pow((1+(r/n)),(n*t)));
            rstartPri2.setText("Start Principal Value : "+String.format("%.2f",res1)+"$");
            } catch (Exception prompt){
                rstartPri2.setText("Please enter Integer values only.!");

            }
        });

        Button BackBtn7=new Button("Back");
        BackBtn7.setLayoutY(210);
        BackBtn7.setLayoutX(270);
        BackBtn7.setOnAction(e -> { window.close();Main.show(); });

        Button clearBtnS = new Button("Clear");
        clearBtnS.setLayoutX(310);
        clearBtnS.setLayoutY(210);
        clearBtnS.setOnAction(event -> {
            txtN7.clear();
            txtFv7.clear();
            txtIy7.clear();
            rstartPri2.setText("");
        });

        ImageView sPImg=new ImageView("image7.jpg");
        sPImg.setFitWidth(500);
        sPImg.setFitHeight(500);
        Group root4= new Group();

        Button btn1CS = new Button("1");
        btn1CS.setLayoutX(170);
        btn1CS.setLayoutY(350);
        btn1CS.setPrefSize(20,20);
        btn1CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");



        Button btn2CS = new Button("2");
        btn2CS.setLayoutX(210);
        btn2CS.setLayoutY(350);
        btn2CS.setPrefSize(20,20);
        btn2CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn3CS = new Button("3");
        btn3CS.setLayoutX(250);
        btn3CS.setLayoutY(350);
        btn3CS.setPrefSize(20,20);
        btn3CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");



        Button btn4CS = new Button("4");
        btn4CS.setLayoutX(170);
        btn4CS.setLayoutY(390);
        btn4CS.setPrefSize(20,20);
        btn4CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn5CS = new Button("5");
        btn5CS.setLayoutX(210);
        btn5CS.setLayoutY(390);
        btn5CS.setPrefSize(2,20);
        btn5CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btn6CS = new Button("6");
        btn6CS.setLayoutX(250);
        btn6CS.setLayoutY(390);
        btn6CS.setPrefSize(20,20);
        btn6CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn7CS = new Button("7");
        btn7CS.setLayoutX(170);
        btn7CS.setLayoutY(430);
        btn7CS.setPrefSize(20,20);
        btn7CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn8CS = new Button("8");
        btn8CS.setLayoutX(210);
        btn8CS.setLayoutY(430);
        btn8CS.setPrefSize(20,20);
        btn8CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn9CS = new Button("9");
        btn9CS.setLayoutX(250);
        btn9CS.setLayoutY(430);
        btn9CS.setPrefSize(20,20);
        btn9CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btndotCS = new Button(".");
        btndotCS.setLayoutX(290);
        btndotCS.setLayoutY(350);
        btndotCS.setPrefSize(30,20);
        btndotCS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        Button btn0CS = new Button("0");
        btn0CS.setLayoutX(290);
        btn0CS.setLayoutY(430);
        btn0CS.setPrefSize(20,20);
        btn0CS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");


        Button btnminusCS = new Button("-");
        btnminusCS.setLayoutX(290);
        btnminusCS.setLayoutY(390);
        btnminusCS.setPrefSize(30,20);
        btnminusCS.setStyle("-fx-base: #018ABe; -fx-font-weight: bold; -fx-font-size:4mm;");

        txtIy7.setOnMouseClicked( event -> {
            btn1CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"1");
                }
            });
            btn4CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"4");
                }
            });

            btn3CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"3");
                }
            });

            btn2CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"2");
                }
            });
            btn5CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"5");
                }
            });
            btn6CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"6");
                }
            });
            btn7CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"7");
                }
            });
            btn8CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"8");
                }
            });
            btn9CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"9");
                }
            });
            btndotCS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+".");
                }
            });
            btn0CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"0");
                }
            });
            btnminusCS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtIy7.setText(txtIy7.getText()+"-");
                }
            });

        });


        txtN7.setOnMouseClicked( event -> {
            btn1CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"1");
                }
            });

            btn4CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"4");
                }
            });

            btn3CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"3");
                }
            });

            btn2CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"2");
                }
            });
            btn5CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"5");
                }
            });
            btn6CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"6");
                }
            });
            btn7CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"7");
                }
            });
            btn8CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"8");
                }
            });
            btn9CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"9");
                }
            });
            btn0CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"0");
                }
            });
            btndotCS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+".");
                }
            });
            btnminusCS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtN7.setText(txtN7.getText()+"-");
                }
            });

        });

        //setting set on actions for buttons in keyboard(text field3)
        txtFv7.setOnMouseClicked( event -> {
            btn1CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"1");
                }
            });

            btn4CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"4");
                }
            });

            btn3CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"3");
                }
            });

            btn2CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"2");
                }
            });
            btn5CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"5");
                }
            });
            btn6CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"6");
                }
            });
            btn7CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"7");
                }
            });
            btn8CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"8");
                }
            });
            btn9CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"9");
                }
            });
            btndotCS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+".");
                }
            });
            btn0CS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"0");
                }
            });
            btnminusCS.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtFv7.setText(txtFv7.getText()+"-");
                }
            });

        });

        Pane startPrinciple2 = new Pane();
        startPrinciple2.getChildren().addAll(sPImg,rstartPri2,Fv7,btn0CS,btn1CS,btn2CS,btn3CS,clearBtnS,btn4CS,btn5CS,btn6CS,btn7CS,btn8CS,btn9CS,btndotCS,btnminusCS,NoOfPeriods7,interest7,txtFv7,txtN7,txtIy7,calBtn7,BackBtn7);
        tab7.setContent(startPrinciple2);

        Pane Help = new Pane();    //help tab
        tab10.setContent(com.company.Help.helpS());

        Scene scene = new Scene(tabPane2, 500, 500);
        window.setScene(scene);
        window.show();

        return tabPane2;

    }

}


