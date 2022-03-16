package com.moso;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class bookingControler {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> AdultChoiceBox;

    @FXML
    private ChoiceBox<String> ChildChoiceBox;

    @FXML
    private Label DepatureTimeLable;

    @FXML
    private Label FlightDurationLable;

    @FXML
    private Label FlightNameLable;

    @FXML
    private Label FlightNumberLable;

    public void initData(airline Airline) {
        FlightNameLable.setText(Airline.getAirline());
        FlightNumberLable.setText(Airline.getFight_number());
        FlightDurationLable.setText(Airline.getTravel_time());
        DepatureTimeLable.setText(Airline.getDepature_time());
        AdultChoiceBox.getItems().setAll("1", "2", "3", "4", "5");
        ChildChoiceBox.getItems().setAll("1", "2", "3", "4", "5");
    }

    @FXML
    void initialize() {
        assert AdultChoiceBox != null
                : "fx:id=\"AdultChoiceBox\" was not injected: check your FXML file 'booking.fxml'.";
        assert ChildChoiceBox != null
                : "fx:id=\"ChildChoiceBox\" was not injected: check your FXML file 'booking.fxml'.";
        assert DepatureTimeLable != null
                : "fx:id=\"DepatureTimeLable\" was not injected: check your FXML file 'booking.fxml'.";
        assert FlightDurationLable != null
                : "fx:id=\"FlightDurationLable\" was not injected: check your FXML file 'booking.fxml'.";
        assert FlightNameLable != null
                : "fx:id=\"FlightNameLable\" was not injected: check your FXML file 'booking.fxml'.";
        assert FlightNumberLable != null
                : "fx:id=\"FlightTimeLable\" was not injected: check your FXML file 'booking.fxml'.";
    }

}
