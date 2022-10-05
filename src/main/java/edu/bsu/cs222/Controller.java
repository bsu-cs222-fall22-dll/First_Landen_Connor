package edu.bsu.cs222;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
    public void onButtonClick(ActionEvent event) throws IOException {
        userinput_lb.setText(title_tb.getText());
        String userInput = title_tb.getText();

        RevisionParser revisionParser = new RevisionParser();

        InputStream inputStream0 = revisionParser.encodedUrl(userInput);
        Redirects redirects = new Redirects();
        System.out.println(redirects.checkRedirect(inputStream0));

        InputStream inputStream = revisionParser.encodedUrl(userInput);
        ArrayList<String> usersList = revisionParser.parseUsers(inputStream);

        InputStream inputStream1 = revisionParser.encodedUrl(userInput);
        ArrayList<String> timestampsList = revisionParser.parseTimestamp(inputStream1);

        Formatter formatter = new Formatter();
        formatter.formatted(usersList, timestampsList);
        int count = 0;
        for (String user : usersList) {
            String Line = user + "\t\t" + timestampsList.get(count);
            results_ta.appendText(Line);
            results_ta.appendText("\n");
            count += 1;
        }
    }
}
