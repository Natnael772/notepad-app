package com.example.assignmentnotepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    Scene sceneLogin;
    Scene sceneNotepad;
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

                MenuBar menu = new MenuBar();
                Menu file = new Menu("File");
                Menu edit = new Menu("Edit");
                Menu help = new Menu("Help");

                MenuItem openItem = new MenuItem("Open");
                MenuItem saveItem = new MenuItem("Save");
                MenuItem saveAsItem = new MenuItem("Save As");
                MenuItem exitItem = new MenuItem("Exit");

                file.getItems().addAll(openItem,saveItem,saveAsItem,exitItem);
                menu.getMenus().addAll(file,edit,help);

                TextArea blankArea = new TextArea();
                VBox layoutNotepad = new VBox(50d);
                layoutNotepad.getChildren().addAll(menu,blankArea);
                sceneNotepad = new Scene(layoutNotepad,500,430);


                FileChooser fileChooser = new FileChooser();

                //1. Open functionality
                openItem.setOnAction(e1->{
                    fileChooser.setTitle("Open file");
                    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text or files", "*.txt, *.pdf"));

                    File selectedFile = fileChooser.showOpenDialog(stage);


                });

                //2. Save functionality
                saveItem.setOnAction(e2->{


                });


                stage.setScene(sceneNotepad);
                stage.setTitle("Notepad");
                stage.show();

            }

        });




        //Layout
        VBox layout1 = new VBox(10);
        layout1.setPadding(new Insets(10d));
        layout1.getChildren().addAll(introLabel, userLabel,userArea,pwdLabel,pwdArea,btnLogin,btnExit);
        sceneLogin = new Scene(layout1,500,430);
        stage.setScene(sceneLogin);
        stage.setTitle("Notepad Application");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}