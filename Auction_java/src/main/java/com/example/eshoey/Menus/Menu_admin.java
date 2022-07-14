package com.example.eshoey.Menus;

import com.example.eshoey.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Menu_admin implements MenuActions {
    @FXML
    private Button logout;
    @FXML
    private Button back;
    @FXML
    private Button about;


    public void userLogOut(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Login.fxml");

    }

    public void goAbout(ActionEvent event)throws IOException{
        HelloApplication n = new HelloApplication();
        n.changeScene("About.fxml");
    }

    @FXML
    private Button auctions;

    public void goAuction(javafx.event.ActionEvent actionEvent) throws IOException{
        HelloApplication m = new HelloApplication();
        m.changeScene("Auction_admin.fxml");
    }

    public void goInfo(ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("AdminInfo.fxml");
    }
}
