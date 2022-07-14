package com.example.eshoey;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * Aukcia pravnickeho kupcu
 */
public class AuctionBuyerLegal extends Auction_user implements Initializable {
    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item,Integer> idCol;
    @FXML
    private TableColumn<Item,String> typeCol;
    @FXML
    private TableColumn<Item,String> brandCol;
    @FXML
    private TableColumn<Item,String> nameCol;
    @FXML
    private TableColumn<Item,Integer> sizeCol;
    @FXML
    private TableColumn<Item,String> quantityCol;
    @FXML
    private TableColumn<Item,Double> priceCol;
    @FXML
    private TableColumn<Item,String> sellerColumn;
    @FXML
    private TextField brandText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField sizeText;
    @FXML
    private TextField priceText;
    @FXML
    private Button submitB;
    @FXML
    private Button deleteB;
    @FXML
    private Button detailB;
    @FXML
    private Button back;


    int id = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        showItem();

    }



    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("Person_choice.fxml");
    }

    @FXML
    private Button bid;

    public void showBid(javafx.event.ActionEvent actionEvent) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Details_buyer.fxml"));
            Parent tableviewParent = loader.load();
            Scene tableViewScene = new Scene(tableviewParent);

            DetailsBuyer controller = loader.getController();
            controller.initData(tableView.getSelectionModel().getSelectedItem());
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
        catch (RuntimeException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Choose auction to display !");
            alert.showAndWait();
        }
    }

    public void insertData(ActionEvent actionEvent){

    }


    public void delete(ActionEvent actionEvent) throws IOException{

    }

    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Item> getItemList(){
        ObservableList<Item> itemList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM item";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Item itemo;
            while (rs.next()){
                id++;
                Size sizo;
                sizo = new Size(rs.getInt("size"));
                itemo = new Item(id,rs.getString("type"),rs.getString("brand"),rs.getString("name"),rs.getInt("size"),rs.getString("quantity"),rs.getDouble("price"),rs.getString("owner"));                itemList.add(itemo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;

    }
    public void showItem(){
        ObservableList<Item> list = getItemList();
        typeCol.setCellValueFactory(new PropertyValueFactory<Item,String>("type"));
        brandCol.setCellValueFactory(new PropertyValueFactory<Item,String>("brand"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Item,Integer>("sizo"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Item,String>("quantity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Item,Double>("price"));
        sellerColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("seller"));
        tableView.setItems(list);
    }

    private void insertRecord(){

    }


    private void executeQuery(String query){
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String message(double i){
        return "Auction ended with "+i*0.95+" €";
    }


}
