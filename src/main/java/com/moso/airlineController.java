package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mongodb.client.MongoCursor;

import org.bson.Document;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class airlineController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bookbtn;

    @FXML
    private ComboBox<String> cabClass;

    @FXML
    private TextField depCity;

    @FXML
    private TextField depDate;

    @FXML
    private TextField desCity;

    @FXML
    private Button searchBtn;

    @FXML
    private TableColumn<airline, String> flightNameCol;

    @FXML
    private TableColumn<airline, String> flightNumberCol;

    @FXML
    private TableView<airline> flightTableView;

    @FXML
    private TableColumn<airline, String> DepaturTimeCol;

    @FXML
    private TableColumn<airline, String> TravelTimecol;

    @FXML
    private void switchToBook() throws IOException {
        App.setRoot("booking");
    }

    @FXML
    private void search() {
        db db1 = new db();
        MongoCursor<Document> cursor = db1.findAir();
        try {
            while (cursor.hasNext()) {
                Document info = cursor.next();
                flightTableView.setItems(getairline(info.getString("fight_number"), info.getString("Airline"),
                        info.getString("depature_time"),
                        info.getString("travel_time")));
            }
        } finally {
            cursor.close();
        }
    }

    @FXML
    void initialize() {
        assert DepaturTimeCol != null
                : "fx:id=\"DepaturTimeCol\" was not injected: check your FXML file 'airline.fxml'.";
        assert TravelTimecol != null : "fx:id=\"TravelTimecol\" was not injected: check your FXML file 'airline.fxml'.";
        assert bookbtn != null : "fx:id=\"bookbtn\" was not injected: check your FXML file 'airline.fxml'.";
        assert cabClass != null : "fx:id=\"cabClass\" was not injected: check your FXML file 'airline.fxml'.";
        assert depCity != null : "fx:id=\"depCity\" was not injected: check your FXML file 'airline.fxml'.";
        assert depDate != null : "fx:id=\"depDate\" was not injected: check your FXML file 'airline.fxml'.";
        assert desCity != null : "fx:id=\"desCity\" was not injected: check your FXML file 'airline.fxml'.";
        assert flightNameCol != null : "fx:id=\"flightNameCol\" was not injected: check your FXML file 'airline.fxml'.";
        assert flightNumberCol != null
                : "fx:id=\"flightNumberCol\" was not injected: check your FXML file 'airline.fxml'.";
        assert flightTableView != null
                : "fx:id=\"flightTableView\" was not injected: check your FXML file 'airline.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'airline.fxml'.";
        cabClass.getItems().addAll("Economy", "First Class", "Buissness Class");
        flightNameCol.setCellValueFactory(new PropertyValueFactory<airline, String>("Airline"));
        flightNumberCol.setCellValueFactory(new PropertyValueFactory<airline, String>("fight_number"));
        DepaturTimeCol.setCellValueFactory(new PropertyValueFactory<airline, String>("depature_time"));
        TravelTimecol.setCellValueFactory(new PropertyValueFactory<airline, String>("travel_time"));
    }

    public ObservableList<airline> getairline(String fight_no, String Airline, String dep_time, String tra_time) {
        ObservableList<airline> airline = FXCollections.observableArrayList();
        airline.add(new airline(fight_no, Airline, dep_time, tra_time));
        return airline;
    }

}
