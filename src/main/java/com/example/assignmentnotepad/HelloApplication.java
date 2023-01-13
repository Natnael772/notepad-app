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

import java.io.*;

public class HelloApplication extends Application {
    Scene sceneLogin;
    Scene sceneNotepad;
    String lineRead;
    String fileName;
    String fileLocation="";

    File file;

    @Override
    public void start(Stage stage) throws IOException {

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
                Menu fileMenu = new Menu("File");
                Menu editMenu = new Menu("Edit");
                Menu helpmenu = new Menu("Help");

                MenuItem openItem = new MenuItem("Open");
                MenuItem saveItem = new MenuItem("Save");
                MenuItem saveAsItem = new MenuItem("Save As");
                MenuItem exitItem = new MenuItem("Exit");

                fileMenu.getItems().addAll(openItem,saveItem,saveAsItem,exitItem);
                menu.getMenus().addAll(fileMenu,editMenu,helpmenu);

                TextArea blankArea = new TextArea();
                VBox layoutNotepad = new VBox(50d);
                layoutNotepad.getChildren().addAll(menu,blankArea);
                sceneNotepad = new Scene(layoutNotepad,500,430);


                FileChooser fileChooser = new FileChooser();

                //1. Open functionality
                openItem.setOnAction(e1->{
                    fileChooser.setTitle("Open file");
                    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text files", "*.txt"),
                            new FileChooser.ExtensionFilter("PDF files", "*.pdf"));

                    file = fileChooser.showOpenDialog(stage);


                    if(file!=null){

                        fileName = file.getName();
                        fileLocation = file.getAbsolutePath();
                        stage.setTitle(fileName);

                        System.out.println(fileName);
                        System.out.println(fileLocation);
                        BufferedReader reader=null;

                        try {
                            reader=new BufferedReader(new FileReader(fileLocation));

                            //Reading operation
                            while (true) {
                                if ((lineRead = reader.readLine()) != null) {
                                    blankArea.setText(lineRead);

                                }
                                else break;
                            }
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }


                });

                //2. Save functionality
                saveItem.setOnAction(e2->{
                    fileChooser.setTitle("Save");
                    String textToSave = blankArea.getText();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text file (.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);

                    //If the file isnot saved before
                    if(fileLocation.isBlank()) {
                        System.out.println("The file isnot saved before");
                        file = fileChooser.showSaveDialog(stage);
                        fileLocation = file.getAbsolutePath();
                        System.out.println(fileLocation);
                        System.out.println(file);


                        if (file != null) {

                            try {
                                System.out.println(textToSave);
                                PrintWriter writer = new PrintWriter(file);
                                writer.println(textToSave);
                                writer.close();
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }

                        //If the file is already saved before
                        else {
                            file = new File(fileLocation);
                            PrintWriter writer = null;
                            try {
                                writer = new PrintWriter(file);
                                writer.println(textToSave);
                                System.out.println("Saved");
                                writer.close();
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }


                        }
                });

                //3. Save as functionality
                saveAsItem.setOnAction(e3->{
                    String textToSave = blankArea.getText();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text file (.txt)", "*.txt");
                    fileChooser.getExtensionFilters().add(extFilter);
                    file = fileChooser.showSaveDialog(stage);
                    fileLocation = file.getAbsolutePath();
                    System.out.println(fileLocation);
                    System.out.println(file);

                    if (file != null) {

                        try {
                            System.out.println(textToSave);
                            PrintWriter writer = new PrintWriter(file);
                            writer.println(textToSave);
                            writer.close();
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                });


                //4. Exit functionality (Returning back to login page)
                exitItem.setOnAction(e4->{
                    userArea.clear();
                    pwdArea.clear();
                    btnLogin.setFocusTraversable(false);
                    stage.setTitle("Login page");
                    stage.setScene(sceneLogin);
                    stage.show();
                });

                stage.setScene(sceneNotepad);
                stage.setTitle("Notepad");
                stage.show();

            }

        });

        //Exit functionality (Closing the Program)
        btnExit.setOnAction(e->{
            System.exit(0);
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
