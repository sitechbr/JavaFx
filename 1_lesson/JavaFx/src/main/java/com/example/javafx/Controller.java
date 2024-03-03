package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
            System.out.printf("l: %s\n" +
                    "p: %s\n" +
                    "el: %s\n" +
                    "ep: %s\n",
                    login,password,etalon_user,etalon_password);
            if(Objects.equals(login, etalon_user) && Objects.equals(password, etalon_password)) {
                System.out.printf("Loggin success");
            }
        });

        exitButton.setOnAction(actionEvent  -> {
            System.out.println("Button exit is pressed");
        });

    }

}
