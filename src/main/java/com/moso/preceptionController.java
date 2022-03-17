package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class preceptionController {

        db db1 = new db();

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn<med, String> afternoonCol;

        @FXML
        private TextField condtionText;

        @FXML
        private TextField idText;

        @FXML
        private TextField nameText;

        @FXML
        private TableColumn<med, String> eveningCol;

        @FXML
        private TableColumn<med, String> medNameCol;

        @FXML
        private TableView<med> medTableView;

        @FXML
        private TableColumn<med, String> morningCol;

        @FXML
        private TableColumn<med, String> nightCol;

        @FXML
        private TextField noofdaysText;

        @FXML
        private TextField medNameTextField;

        @FXML
        private TextField dosageTextField;

        @FXML
        private Button precBtn;

        @FXML
        private Button searchBtn;

        @FXML
        private Button searchBtn1;

        @FXML
        private Button addBtn;

        @FXML
        void precribe(ActionEvent event) {

                ObservableList<med> md = medTableView.getItems();
                for (med med : md) {
                        System.out.println(med.getMedName() +
                                        med.getMorning() +
                                        med.getEvening() +
                                        med.getAfternoon() +
                                        med.getNight());
                }
                // db1.prescribe(nameText.getText(),
                // idText.getText(),
                // condtionText.getText(),
                // noofdaysText.getText());
        }

        @FXML
        void add(ActionEvent event) {
                String medname = medNameTextField.getText();
                char[] dos = new char[4];
                char[] age = new char[4];
                dos = dosageTextField.getText().toUpperCase().toCharArray();
                for (int i = 0; i < dos.length; i++) {
                        age[i] = dos[i];
                }
                for (int i = dos.length; i < age.length; i++) {
                        age[i] = ' ';
                }
                int[] dosages = new int[4];
                if (age[0] == 'M')
                        dosages[0] = 1;
                if (age[0] == 'A' || age[1] == 'A')
                        dosages[1] = 1;
                if (age[0] == 'E' || age[1] == 'E' || age[2] == 'E')
                        dosages[2] = 1;
                if (age[0] == 'N' || age[1] == 'N' || age[2] == 'N' || age[3] == 'N')
                        dosages[3] = 1;
                medTableView.getItems().add(getmed(medname, dosages));
        }

        @FXML
        void switchToFind(ActionEvent event) throws IOException {
                App.setRoot("find");
        }

        @FXML
        private void getPatient() {
                Document patient = db1.getPatient(idText.getText());
                nameText.setText(patient.getString("Name"));
                condtionText.setText(patient.getString("medical_histroy"));
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
                assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'preception.fxml'.";
                medTableView.setPlaceholder(new Label("Enter medicine data"));
                medNameCol.setCellValueFactory(new PropertyValueFactory<med, String>("medName"));
                morningCol.setCellValueFactory(new PropertyValueFactory<med, String>("morning"));
                afternoonCol.setCellValueFactory(new PropertyValueFactory<med, String>("afternoon"));
                eveningCol.setCellValueFactory(new PropertyValueFactory<med, String>("evening"));
                nightCol.setCellValueFactory(new PropertyValueFactory<med, String>("night"));
                // idText.textProperty().addListener((observable, oldValue, newValue) ->
                // getPatient(newValue));
        }

        public med getmed(String medname, int[] dosage) {
                return new med(medname, dosage[0] + "", dosage[1] + "", dosage[2] + "", dosage[3] + "");
        }

}
