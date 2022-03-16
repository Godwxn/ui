package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class findController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> afternoonCol;

    @FXML
    private Button backBtn;

    @FXML
    private TableColumn<?, ?> eveningCol;

    @FXML
    private TextField idText;

    @FXML
    private TableColumn<med, String> medNameCol;

    @FXML
    private TableView<med> medTableView;

    @FXML
    private TableColumn<?, ?> morningCol;

    @FXML
    private TextField nameText;

    @FXML
    private TableColumn<?, ?> nightCol;

    @FXML
    private Button searchBtn;

    @FXML
    private void back() throws IOException {
        App.setRoot("preception");
    }

    @FXML
    private void search() {
        db db1 = new db();
        String med = db1.findMed(nameText.getText(),
                idText.getText());
        String[] medName = med.split(",");
        for (String md : medName) {
            System.out.println(md);
        }
        medTableView.setItems(getmed(medName));
    }

    @FXML
    void initialize() {
        assert afternoonCol != null : "fx:id=\"afternoonCol\" was not injected: check your FXML file 'find.fxml'.";
        assert backBtn != null : "fx:id=\"backBtn\" was not injected: check your FXML file 'find.fxml'.";
        assert eveningCol != null : "fx:id=\"eveningCol\" was not injected: check your FXML file 'find.fxml'.";
        assert idText != null : "fx:id=\"idText\" was not injected: check your FXML file 'find.fxml'.";
        assert medNameCol != null : "fx:id=\"medNameCol\" was not injected: check your FXML file 'find.fxml'.";
        assert medTableView != null : "fx:id=\"medTableView\" was not injected: check your FXML file 'find.fxml'.";
        assert morningCol != null : "fx:id=\"morningCol\" was not injected: check your FXML file 'find.fxml'.";
        assert nameText != null : "fx:id=\"nameText\" was not injected: check your FXML file 'find.fxml'.";
        assert nightCol != null : "fx:id=\"nightCol\" was not injected: check your FXML file 'find.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'find.fxml'.";
        medTableView.setPlaceholder(new Label("No Medicine record display"));
        medNameCol.setCellValueFactory(new PropertyValueFactory<med, String>("medName"));

    }

    public ObservableList<med> getmed(String[] arr) {
        ObservableList<med> medicine = FXCollections.observableArrayList();
        medicine.add(new med(arr[0]));
        medicine.add(new med(arr[1]));
        return medicine;
    }

}
