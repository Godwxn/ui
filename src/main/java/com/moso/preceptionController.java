package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class preceptionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField condtionText;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField noofdaysText;

    @FXML
    private Button precBtn;

    @FXML
    private TextArea precpText;

    @FXML
    private Button searchBtn;

    @FXML
    void precribe(ActionEvent event) {
        db db1 = new db();
        db1.prescribe(nameText.getText(),
                idText.getText(),
                condtionText.getText(),
                noofdaysText.getText(),
                precpText.getText());
    }

    @FXML
    void switchToFind(ActionEvent event) throws IOException {
        App.setRoot("find");
    }

    @FXML
    void initialize() {
        assert condtionText != null
                : "fx:id=\"condtionText\" was not injected: check your FXML file 'preception.fxml'.";
        assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'preception.fxml'.";
        assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'preception.fxml'.";
        assert noofdaysText != null
                : "fx:id=\"noofdaysText\" was not injected: check your FXML file 'preception.fxml'.";
        assert precBtn != null : "fx:id=\"precBtn\" was not injected: check your FXML file 'preception.fxml'.";
        assert precpText != null : "fx:id=\"precpText\" was not injected: check your FXML file 'preception.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'preception.fxml'.";

    }

}
