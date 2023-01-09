package com.example.assignmentnotepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
        Label introLabel = new Label("Login to continue");
        introLabel.setAlignment(Pos.CENTER);
        introLabel.setStyle("-fx-color:blue;");
        Label userLabel = new Label("Username");
        TextArea userArea = new TextArea();
        userArea.setPrefHeight(30d);

        Label pwdLabel = new Label("Password");
        TextArea pwdArea = new TextArea();
        pwdArea.setPrefHeight(30d);

        Button login = new Button("Login");
        login.setStyle("-fx-background-color: blue;");
        login.setStyle("fx-color:black;");
        login.setPrefHeight(35d);
        Button exit = new Button("Exit");
        exit.setPrefHeight(35d);


        //ERROR Label
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-inner-color:red;");
        errorLabel.setTextFill(Color.rgb(255, 0, 0));
        //display none initially
        errorLabel.setStyle("-fx-display:none;");


        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10d));
        layout1.getChildren().addAll(introLabel, userLabel,userArea,pwdLabel,pwdArea,login,exit);
        scene = new Scene(layout1,400,600);
        stage.setScene(scene);
        stage.setTitle("Welcome");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}