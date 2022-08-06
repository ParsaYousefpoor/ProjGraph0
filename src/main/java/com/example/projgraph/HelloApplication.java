package com.example.projgraph;

import Source.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static User user;

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 480);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Login/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Instant!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        User user1 = new UserNormal("Parsa","AmirMc","12345678");
        user1.setPassrecov("mamad");
        User user2 = new UserBusiness("Parsa","AmirMc123","12345678");
        user2.setPassrecov("mamad");
        launch();
    }

    public static String numToStr(int a) {
        String temp = "";
        if (a < 1000) {
            temp = Integer.toString(a);
        } else if (a < 1000000) {
            int b = a / 1000;
            temp = Integer.toString(b);
            temp += "K";
        } else if (a < 1000000000) {
            int b = a / 1000000;
            temp = Integer.toString(b);
            temp += "M";
        }
        return temp;
    }
}