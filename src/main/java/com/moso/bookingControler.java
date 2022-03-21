package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class bookingControler {

        airline Air;

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private ChoiceBox<String> noOfPassangerchoice;

        @FXML
        private Label DepatureTimeLable;

        @FXML
        private Label FlightDurationLable;

        @FXML
        private Label FlightNameLable;

        @FXML
        private Label FlightNumberLable;

        @FXML
        public void next(ActionEvent event) throws IOException {
                // TODO
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("confirm.fxml"));
                Parent confirmscene = loader.load();

                Scene ConfirmScene = new Scene(confirmscene);

                confirmController controller = loader.getController();
                controller.initData(Air, noOfPassangerchoice.getValue());

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(ConfirmScene);
                window.show();
        }

        @FXML
        private void back() throws IOException {
                App.setRoot("airline");
        }

        public void initData(airline Airline) {
                Air = Airline;
                FlightNameLable.setText(Airline.getAirline());
                FlightNumberLable.setText(Airline.getFight_number());
                FlightDurationLable.setText(Airline.getTravel_time());
                DepatureTimeLable.setText(Airline.getDepature_time());
                System.out.println(Airline.getPrice());
                noOfPassangerchoice.getItems().setAll("1", "2", "3", "4", "5");
        }

        @FXML
        void initialize() {
                assert noOfPassangerchoice != null
                                : "fx:id=\"AdultChoiceBox\" was not injected: check your FXML file 'booking.fxml'.";
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
