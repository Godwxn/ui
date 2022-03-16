package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class add {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Title;

    @FXML
    private TextField geners;

    @FXML
    private Label result;

    @FXML
    private void addrec() {
        String title, Geners;
        title = Title.getText();
        Geners = geners.getText();
        db d = new db();
        if (d.update(title, Geners)) {
            result.setText("Add Successfully");
            return;
        }
        result.setText("Error while adding the data");
    }

    @FXML
    private void search() throws IOException {
        App.setRoot("search");
    }

    // $2b$12$UREFwsRUoyF0CRqGNK0LzO0HM/jLhgUCNNIJ9RJAqMUQ74crlJ1Vu
    // sean_bean@gameofthron.es
    @FXML
    void initialize() {
        assert Title != null : "fx:id=\"Title\" was not injected: check your FXML file 'add.fxml'.";
        assert geners != null : "fx:id=\"geners\" was not injected: check your FXML file 'add.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'add.fxml'.";

    }

}
