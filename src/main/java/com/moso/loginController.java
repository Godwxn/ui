package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField email;

    @FXML
    private TextField pass;

    @FXML
    private void signin(ActionEvent event) throws IOException {
        db db1 = new db();
        String mail, pas;
        mail = email.getText();
        pas = pass.getText();
        if (db1.Login(mail, pas)) {
            App.setRoot("airline");
        }
    }

    @FXML
    void initialize() {
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'login.fxml'.";
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'login.fxml'.";

    }

}