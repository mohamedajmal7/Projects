package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class compound2  {


    public static Pane compoundPane() {

        Stage window3 = new Stage();
        window3.setTitle("Compound Interest Calculator");

        Label APrice=new Label("Input Interest");
        APrice.setLayoutX(60);
        APrice.setLayoutY(50);

        TextField txtAP=new TextField();
        txtAP.setLayoutX(40);
        txtAP.setLayoutY(100);
        txtAP.setPrefWidth(120);

        Label Loanterm=new Label("Compound");
        Loanterm.setLayoutX(230);
        Loanterm.setLayoutY(50);

        ComboBox txtcomp=new ComboBox();
        txtcomp.setLayoutX(200);
        txtcomp.setLayoutY(100);
        txtcomp.setValue("Monthly");
        txtcomp.setPrefWidth(110);
        txtcomp.getItems().addAll("Monthly","Yearly");



        Label intRate=new Label("Output Interest");
        intRate.setLayoutX(390);
        intRate.setLayoutY(50);



        Label downPymnt=new Label("Compound");
        downPymnt.setLayoutX(540);
        downPymnt.setLayoutY(50);

        ComboBox txtcomp2=new ComboBox();
        txtcomp2.setLayoutX(520);
        txtcomp2.setLayoutY(100);
        txtcomp2.setValue("Monthly");
        txtcomp2.setPrefWidth(110);
        txtcomp2.getItems().addAll("Monthly","Yearly");


        Label tradeInVal=new Label("");
        tradeInVal.setLayoutX(390);
        tradeInVal.setLayoutY(100);

        Label equal=new Label("=");
        equal.setLayoutX(350);
        equal.setLayoutY(100);


        Button btnCalL1=new Button("Calculate");
        btnCalL1.setLayoutX(300);
        btnCalL1.setLayoutY(180);

        Button BackBtnLC=new Button("Back");
        BackBtnLC.setLayoutY(180);
        BackBtnLC.setLayoutX(230);
        BackBtnLC.setOnAction(e -> {
            window3.close();
            Main.show();

        });

        Image imageComp = new Image("image11.jpg");
        ImageView compImg=new ImageView(imageComp);
        compImg.setFitWidth(500);
        compImg.setFitHeight(500);
        Group root6= new Group();
        Button help_btn = new Button("Help");
        help_btn.setLayoutX(10);
        help_btn.setLayoutY(10);
        help_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Help.helpS();
            }
        });


        Pane compoundPane=new Pane();
        compoundPane.getChildren().addAll(compImg,APrice,txtAP,help_btn,Loanterm,txtcomp,txtcomp2,intRate,downPymnt,equal,tradeInVal,BackBtnLC,btnCalL1);

        Scene scene=new Scene(compoundPane,700,300);

        //VBox vb4=new VBox(compoundPane);
        //Scene sc4 =new Scene(vb4);
        window3.setScene(scene);
        window3.show();

        return compoundPane;



    }

}
