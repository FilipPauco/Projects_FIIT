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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
/**
 * Aukcia admina
 */
public class Auction_admin extends Auction_user implements Initializable {
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
    private ChoiceBox<String> typeText;
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
    private ChoiceBox<String> quantityText;
    @FXML
    private ChoiceBox<String> sellerChoice;

    public String[] optionSeller = {"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10"};
    public String[] optionType = {"Classic","Sport","Boots","Sport-I","Sport-O"};
    public String[] options = {"1","2","3","4","5","6","7","8","9","10"};
    int id = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        quantityText.getItems().addAll(options);
        typeText.getItems().addAll(optionType);
        sellerChoice.getItems().addAll(optionSeller);
        showItem();

    }


    @FXML
    private Button back;

    @Override
    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MainMenu_admin.fxml");
    }

    @Override
    public void showBid(ActionEvent actionEvent) throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Details_admin.fxml"));
            Parent tableviewParent = loader.load();
            Scene tableViewScene = new Scene(tableviewParent);

            DetailsAdmin controller = loader.getController();
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
        insertRecord();
        brandText.clear();
        nameText.clear();
        sizeText.clear();
        quantityText.setValue(null);
        priceText.clear();
        /*try{
            if(brandText.getText().isEmpty() || nameText.getText().isEmpty() || nameText.getText().isEmpty() || sizeText.getText().isEmpty() || priceText.getText().isEmpty()){
                i = 0;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data missing");
                alert.setContentText("Fill all spaces !");
                alert.showAndWait();
                brandText.clear();
                nameText.clear();
                quantityText.valueProperty().set(null);
                sizeText.clear();
                priceText.clear();
            }
            String size_a = sizeText.getText();
            String quantity_a = quantityText.getValue();
            String price_a = priceText.getText();

            Item newItem = new Item(j,brandText.getText(), nameText.getText(),Integer.parseInt(size_a),Integer.parseInt(quantity_a),Double.parseDouble(price_a));
            j++;
            tableView.getItems().add(newItem);
            brandText.clear();
            nameText.clear();
            quantityText.valueProperty().set(null);
            sizeText.clear();
            priceText.clear();

    }
        catch (RuntimeException e){
            if(i == 1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data missing");
                alert.setContentText("Please input correct values !");
                alert.showAndWait();
                brandText.clear();
                nameText.clear();
                sizeText.clear();
                quantityText.valueProperty().set(null);
                priceText.clear();
            }
            i = 1;
        }

        String size_a = sizeText.getText();
        String quantity_a = quantityText.getValue();
        String price_a = priceText.getText();
        j = 1;
        ItemDat.insertItem(j,brandText.getText(), nameText.getText(),Integer.parseInt(size_a),Integer.parseInt(quantity_a),Double.parseDouble(price_a));

        j++;
        */
    }


    /**
     * Vymazanie aukcie
     * @param actionEvent
     * @throws IOException
     */
    public void delete(ActionEvent actionEvent) throws IOException{
        Item item =tableView.getSelectionModel().getSelectedItem();
        String query = "DELETE FROM item WHERE name = '" + item.getName()+"' ";
        //id = 0;
        executeQuery(query);
        showItem();
    }

    @Override
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

    @Override
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


    private void insertRecord(){
        id = 0;
        String query = "INSERT INTO item VALUES (" + id + ",'" + typeText.getValue() + "','" + brandText.getText() + "','" + nameText.getText() + "',"+sizeText.getText() + ",'"+quantityText.getValue()+"',"+priceText.getText() + ",'"+sellerChoice.getValue()+"')";
        executeQuery(query);
        showItem();
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


}
