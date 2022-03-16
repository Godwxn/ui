package com.moso;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class searchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Plot;

    @FXML
    private Label Title;

    @FXML
    private TextField TitleTex;

    @FXML
    private void search() {
        String title;
        db db1 = new db();
        title = TitleTex.getText();
        System.out.println(title);
        String[] retun = db1.find(title);
        System.out.println(retun[0]);
        System.out.println(retun[1]);
        Title.setText(retun[0]);
        Plot.setText(retun[1]);
    }

    @FXML
    private void searchtoadd() throws IOException {
        App.setRoot("add");
    }

    @FXML
    void initialize() {
        assert Plot != null : "fx:id=\"Plot\" was not injected: check your FXML file 'search.fxml'.";
        assert Title != null : "fx:id=\"Title\" was not injected: check your FXML file 'search.fxml'.";
        assert TitleTex != null : "fx:id=\"TitleTex\" was not injected: check your FXML file 'search.fxml'.";

    }

}
