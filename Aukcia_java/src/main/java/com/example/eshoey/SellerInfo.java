package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Classa pre spracovanie informacii GUI predajcu
 */

public class SellerInfo {
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

    public void Submit(ActionEvent actionEvent) {
        try {
            Adress adress = new Adress(mesto.getText(),Integer.parseInt(byt.getText()),Integer.parseInt(psc.getText()));
            SellerData s = new SellerData(meno.getText(),adress,cislo.getText());
            Singleton x = Singleton.Singleton();
            Singleton y = Singleton.Singleton();
            Singleton v = Singleton.Singleton();
            Singleton w = Singleton.Singleton();
            Singleton z = Singleton.Singleton();
            y.s = (y.s).toLowerCase();
            System.out.println("Name - "+meno.getText()+ x.s);
            System.out.println("City - "+mesto.getText()+y.s);
            System.out.println("House number - "+byt.getText()+ v.s);
            System.out.println("ZIP - "+psc.getText()+w.s);
            x.s = (x.s).toUpperCase();
            System.out.println("Phone number - "+cislo.getText()+z.s);
            meno.clear();
            mesto.clear();
            byt.clear();
            psc.clear();
            cislo.clear();
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
        m.changeScene("MainMenu.fxml");
    }
}
