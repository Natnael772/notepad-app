package com.example.assignmentnotepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
        PasswordField pwdArea = new PasswordField();
        pwdArea.setPrefHeight(32d);

        Button btnLogin = new Button("Login");
        btnLogin.setStyle("-fx-background-color: blue;");
        btnLogin.setStyle("fx-color:black;");
        btnLogin.setPrefHeight(35d);
        Button btnExit = new Button("Exit");
        btnExit.setPrefHeight(35d);


        //ERROR Label
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-inner-color:red;");
        errorLabel.setTextFill(Color.rgb(255, 0, 0));
        //display none initially
        errorLabel.setStyle("-fx-display:none;");


        //Login functionality
        btnLogin.setOnAction(e->{
            String username = "natty";
            String password = "123";
            String userinput = userArea.getText();
            String pwdInput = pwdArea.getText();


            //Authentication
            if(username.equals(userinput) && password.equals(pwdInput)){
                System.out.println(userinput);
                System.out.println(pwdInput);

            }

        });




        //Layout
        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10d));
        layout1.getChildren().addAll(introLabel, userLabel,userArea,pwdLabel,pwdArea,btnLogin,btnExit);
        scene = new Scene(layout1,500,430);
        stage.setScene(scene);
        stage.setTitle("Notepad Application");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}