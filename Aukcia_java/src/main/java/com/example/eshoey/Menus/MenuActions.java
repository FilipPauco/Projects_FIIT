package com.example.eshoey.Menus;

import javafx.event.ActionEvent;
import java.io.IOException;

public interface MenuActions {

    void userLogOut(javafx.event.ActionEvent actionEvent) throws IOException;
    void goAbout(ActionEvent event)throws IOException;
    void goAuction(javafx.event.ActionEvent actionEvent) throws IOException;

}
