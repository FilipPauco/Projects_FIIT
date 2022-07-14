package com.example.eshoey;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
/**
 * User, moze iba prehliadat dane aukcie
 */
public class DetailsUser implements Initializable {
    private Item selectedItem;

    @FXML
    private Label brand;
    @FXML
    private Label name;
    @FXML
    private Label size;
    @FXML
    private Label quantity;
    @FXML
    private Label actual;
    @FXML
    private Label price;
    @FXML
    private Label sell;
    @FXML
    private Label setError;


    public void initData(Item item){
        selectedItem = item;
        brand.setText(selectedItem.getBrand());
        name.setText(selectedItem.getName());
        size.setText(String.valueOf(selectedItem.getSizo()));
        quantity.setText(selectedItem.getQuantity());
        if(val == 0)
            price.setText(String.valueOf(selectedItem.getPrice()));
        else
            price.setText(String.valueOf(val));
        actual.setText(price.getText());
        sell.setText(selectedItem.getSeller());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Auction_user.fxml");
    }

    int val = 0;
    int k = 5;


}
