package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static void show() {
        Stage Main = new Stage();
        Main.setTitle("Calculator");

        //button to access in to saving cal
        Button saving_btn = new Button("Compound Calculator");
        saving_btn.setLayoutX(160);
        saving_btn.setLayoutY(160);
        saving_btn.setPrefSize(180,30);
        saving_btn.setStyle("-fx-font-family: Bahnschrift;-fx-font-size:15;-fx-background-color: f99e4c");
        saving_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.close();
                Compound.tabPane();
            }
        });
        //button to access in to mortgage cal
        Button mortgage_Btn = new Button("Mortgage Calculator");
        mortgage_Btn.setLayoutX(160);
        mortgage_Btn.setLayoutY(200);
        mortgage_Btn.setPrefSize(180,30);
        mortgage_Btn.setStyle("-fx-font-family: Bahnschrift;-fx-font-size:15;-fx-background-color: f99e4c");
        mortgage_Btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.close();
                Mortgage.mortgagePane();
            }
        });
        //button to access in to compound cal
        Button compound_btn = new Button("Saving Calculator");
        compound_btn.setLayoutX(160);
        compound_btn.setLayoutY(240);
        compound_btn.setPrefSize(180,30);
        compound_btn.setStyle("-fx-font-family: Bahnschrift;-fx-font-size:15;-fx-background-color: f99e4c");
        compound_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.close();
                Saving.tabPane2();
            }
        });
        //button to access in to loan cal
        Button Loan_btn = new Button("Loan Calculator");
        Loan_btn.setLayoutX(160);
        Loan_btn.setLayoutY(280);
        Loan_btn.setPrefSize(180,30);
        Loan_btn.setStyle("-fx-font-family: Bahnschrift;-fx-font-size:15;-fx-background-color: f99e4c");
        Loan_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main.close();
                Loan.LoanP();
            }
        });

        Label title=new Label("Financial Calculator");
        title.setLayoutX(100);
        title.setLayoutY(80);
        title.setStyle("-fx-font-family: Bahnschrift;-fx-font-size:35;-fx-font-weight: bold; -fx-text-fill: #ff3b3b;");


        //background image for home UI
        Image image = new Image("image4.jpg");
        ImageView homeI=new ImageView(image);
        homeI.setFitHeight(500);
        homeI.setFitWidth(500);
        Group root= new Group();

        Pane one = new Pane(homeI,saving_btn, compound_btn, mortgage_Btn,Loan_btn,title);

        Main.setScene(new Scene(one, 500, 500));
        Main.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root2 = new Pane();
        Main.setScene(new Scene(root2, 500, 500));
        Main.show();
    }

    private static void setScene(Scene scene) {
    }
}