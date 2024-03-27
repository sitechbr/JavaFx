package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import static com.example.javafx.dao.Database.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize() {
        System.out.println("Start app");
        openConfiguration conf = new openConfiguration();
        String etalon_user = conf.DEFAULT_USER;
        String etalon_password = conf.DEFAULT_PASSWORD;
        authButton.setOnAction(actionEvent -> {
            System.out.println("Button auth is pressed");

            String login = loginField.getText();
            String password = passwordField.getText();
            cheakCredential(login,password);
            System.out.printf("l: %s\n" +
                    "p: %s\n" +
                    "el: %s\n" +
                    "ep: %s\n",
                    login,password,etalon_user,etalon_password);
            if(cheakCredential(login,password)) {
                System.out.printf("Loggin success");
                authButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("hello-view2.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                //authButton.getScene().getWindow().
            }



        });

        exitButton.setOnAction(actionEvent  -> {
            System.out.println("Button exit is pressed");
        });

    }

}
