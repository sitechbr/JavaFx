package com.example.javafx;

import com.example.javafx.dao.Alerts;
import com.example.javafx.dao.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.javafx.dao.Database.*;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        createNewDatabase();
        createNewTable();
        //createDefaultUsers();
        //cheakCredential("user1","password1");
        if (true) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 300);
            stage.setTitle("My autorization app!");
            stage.setScene(scene);
            stage.show();
        } else {
            Alerts.error(
                    "Database error",
                    "Could not load database",
                    "Error loading SQLite database. See log. Quitting..."
            ).showAndWait();
        }
    }

    public static void main(String[] args) {
        launch();
    }



}
