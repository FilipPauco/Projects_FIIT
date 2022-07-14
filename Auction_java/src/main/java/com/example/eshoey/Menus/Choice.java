package com.example.eshoey.Menus;

import com.example.eshoey.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.IOException;

/**
 * Classa pre GUI, vyber osoby
 */
public class Choice {
    @FXML
    private RadioButton b1;
    @FXML
    private RadioButton b2;
    @FXML
    private Button back;
    @FXML
    private Button continueB;
    public void goBack(ActionEvent actionEvent) throws IOException {
        HelloApplication a = new HelloApplication();
        a.changeScene("Login.fxml");
    }

    public void continueTo(ActionEvent actionEvent) throws IOException{
        if(b1.isSelected()) {
            HelloApplication a = new HelloApplication();
            a.changeScene("Auction_BuyerPrivate.fxml");
        }
        else if(b2.isSelected()) {
            HelloApplication a = new HelloApplication();
            a.changeScene("Auction_buyerLegal.fxml");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please, choose an option !");
            alert.showAndWait();
        }
    }


    public void goInfo(ActionEvent actionEvent) throws IOException {
        HelloApplication a = new HelloApplication();
        a.changeScene("BuyerLInfo.fxml");
    }

    public void goInfo1(ActionEvent actionEvent) throws IOException {
        HelloApplication a = new HelloApplication();
        a.changeScene("BuyerInfo.fxml");
    }
}
