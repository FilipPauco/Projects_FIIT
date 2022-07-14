package com.example.eshoey;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

/**
 * Spustenie Aplikacie, main a GUI
 */
public class HelloApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        stage.setTitle("E-shoey");
        Image image = new Image(getClass().getResourceAsStream("9769813.jpg"));
        stage.getIcons().add(image);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    public void changeScene2(Scene s) throws IOException{
        stg.setScene(s);
    }

    public static void main(String[] args) {
        launch(args);
    }


}