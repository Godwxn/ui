package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class confirmController {

    airline air;
    int totalprice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label DepatureTimeLable;

    @FXML
    private Label FlightDurationLable;

    @FXML
    private Label FlightNameLable;

    @FXML
    private Label FlightNumberLable;

    @FXML
    private Label NoOfPassanger;

    @FXML
    private Label TotalPriceText;

    @FXML
    void back(ActionEvent event) throws IOException {
        App.setRoot("airline");
    }

    @FXML
    void book(ActionEvent event) {
        // TODO
        db db = new db();
        db.book(air, NoOfPassanger.getText(), totalprice);
    }

    public void initData(airline Airline, String noOfPassanger) {
        air = Airline;
        FlightNameLable.setText(Airline.getAirline());
        FlightNumberLable.setText(Airline.getFight_number());
        FlightDurationLable.setText(Airline.getTravel_time());
        DepatureTimeLable.setText(Airline.getDepature_time());
        totalprice = Integer.parseInt(Airline.getPrice()) * Integer.parseInt(noOfPassanger);
        NoOfPassanger.setText(noOfPassanger);
        TotalPriceText.setText(String.valueOf(totalprice));
    }

    @FXML
    void initialize() {
        assert DepatureTimeLable != null
                : "fx:id=\"DepatureTimeLable\" was not injected: check your FXML file 'confirm.fxml'.";
        assert FlightDurationLable != null
                : "fx:id=\"FlightDurationLable\" was not injected: check your FXML file 'confirm.fxml'.";
        assert FlightNameLable != null
                : "fx:id=\"FlightNameLable\" was not injected: check your FXML file 'confirm.fxml'.";
        assert FlightNumberLable != null
                : "fx:id=\"FlightNumberLable\" was not injected: check your FXML file 'confirm.fxml'.";
        assert NoOfPassanger != null : "fx:id=\"NoOfPassanger\" was not injected: check your FXML file 'confirm.fxml'.";
        assert TotalPriceText != null
                : "fx:id=\"TotalPriceText\" was not injected: check your FXML file 'confirm.fxml'.";

    }

}
