package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label title_lb;
    @FXML
    private Label revisions_lb;
    @FXML
    private Label userinput_lb;

    @FXML
    private Button search_btn;

    @FXML
    private TextField title_tb;
    @FXML
    private TextArea results_ta;
    public void onButtonClick(ActionEvent event) {
    }
}
