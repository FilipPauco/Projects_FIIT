package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Classa pre spracovanie informacii GUI kupcu
 */

public class BuyerLInfo {
    @FXML
    private TextField meno;
    @FXML
    private TextField mesto;
    @FXML
    private TextField byt;
    @FXML
    private TextField psc;
    @FXML
    private TextField cislo;
    @FXML
    private TextField ico;

    public void Submit(ActionEvent actionEvent) {
        try {
            Adress adress = new Adress(mesto.getText(),Integer.parseInt(byt.getText()),Integer.parseInt(psc.getText()));
            BuyerLData s = new BuyerLData(meno.getText(),adress,cislo.getText(),ico.getText());
            System.out.println("Buyer-Legal data has been added !");
            meno.clear();
            mesto.clear();
            byt.clear();
            psc.clear();
            cislo.clear();
            ico.clear();
        }
        catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please check format of your input !");
            alert.showAndWait();
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Person_choice.fxml");
    }
}
