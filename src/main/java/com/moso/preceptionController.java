package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class preceptionController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn<?, ?> afternoonCol;

        @FXML
        private TextField condtionText;

        @FXML
        private TableColumn<?, ?> eveningCol;

        @FXML
        private TextField idText;

        @FXML
        private TableColumn<?, ?> medNameCol;

        @FXML
        private TableView<?> medTableView;

        @FXML
        private TableColumn<?, ?> morningCol;

        @FXML
        private TextField nameText;

        @FXML
        private TableColumn<?, ?> nightCol;

        @FXML
        private TextField noofdaysText;

        @FXML
        private Button precBtn;

        @FXML
        private Button searchBtn;

        @FXML
        void precribe(ActionEvent event) {
                db db1 = new db();
                db1.prescribe(nameText.getText(),
                                idText.getText(),
                                condtionText.getText(),
                                noofdaysText.getText());
        }

        @FXML
        void switchToFind(ActionEvent event) throws IOException {
                App.setRoot("find");
        }

        @FXML
        void initialize() {
                assert afternoonCol != null
                                : "fx:id=\"afternoonCol\" was not injected: check your FXML file 'preception.fxml'.";
                assert condtionText != null
                                : "fx:id=\"condtionText\" was not injected: check your FXML file 'preception.fxml'.";
                assert eveningCol != null
                                : "fx:id=\"eveningCol\" was not injected: check your FXML file 'preception.fxml'.";
                assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'preception.fxml'.";
                assert medNameCol != null
                                : "fx:id=\"medNameCol\" was not injected: check your FXML file 'preception.fxml'.";
                assert medTableView != null
                                : "fx:id=\"medTableView\" was not injected: check your FXML file 'preception.fxml'.";
                assert morningCol != null
                                : "fx:id=\"morningCol\" was not injected: check your FXML file 'preception.fxml'.";
                assert nameText != null
                                : "fx:id=\"nameText\" was not injected: check your FXML file 'preception.fxml'.";
                assert nightCol != null
                                : "fx:id=\"nightCol\" was not injected: check your FXML file 'preception.fxml'.";
                assert noofdaysText != null
                                : "fx:id=\"noofdaysText\" was not injected: check your FXML file 'preception.fxml'.";
                assert precBtn != null : "fx:id=\"precBtn\" was not injected: check your FXML file 'preception.fxml'.";
                assert searchBtn != null
                                : "fx:id=\"searchBtn\" was not injected: check your FXML file 'preception.fxml'.";
                medTableView.setPlaceholder(new Label("Enter medicine data"));
        }

}
