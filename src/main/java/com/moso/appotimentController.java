package com.moso;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class appotimentController {

    db db1 = new db();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AgeText;

    @FXML
    private TextField AppoiIdText;

    @FXML
    private TextField BloodText;

    @FXML
    private Button MakeAppoiBtn;

    @FXML
    private TextField MedicalHisText;

    @FXML
    private TextField PhoneText;

    @FXML
    private Button addBtn;

    @FXML
    private TextField idText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField symptomsText;

    @FXML
    void addPatient(ActionEvent event) {
        db1.addPatients(nameText.getText(), idText.getText(),
                MedicalHisText.getText(), PhoneText.getText(), AgeText.getText(), BloodText.getText());

    }

    @FXML
    void MakeAppointment(ActionEvent event) {
        db1.MakeAppointment(AppoiIdText.getText(), symptomsText.getText());
    }

    @FXML
    void initialize() {
        assert AgeText != null : "fx:id=\"AgeText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert AppoiIdText != null : "fx:id=\"AppoiIdText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert BloodText != null : "fx:id=\"BloodText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert MakeAppoiBtn != null
                : "fx:id=\"MakeAppoiBtn\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert MedicalHisText != null
                : "fx:id=\"MedicalHisText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert PhoneText != null : "fx:id=\"PhoneText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'appotiment.fxml'.";
        assert symptomsText != null
                : "fx:id=\"symptomsText\" was not injected: check your FXML file 'appotiment.fxml'.";

    }

}
