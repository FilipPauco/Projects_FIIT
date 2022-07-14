package com.example.eshoey;

import com.example.eshoey.Details;
import com.example.eshoey.HelloApplication;
import com.example.eshoey.Item;
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

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class TableViewController extends Auction_user implements Initializable, Container {

    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item,Integer> idCol;
    @FXML
    private TableColumn<Item,String> brandCol;
    @FXML
    private TableColumn<Item,String> typeCol;
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
    private TextField password;
    @FXML
    private Button submitB;
    @FXML
    private Button deleteB;
    @FXML
    private Button detailB;
    @FXML
    private Button back;
    @FXML
    private ChoiceBox<String> quantityText;
    @FXML
    private ChoiceBox<String> typeText;
    @FXML
    private ChoiceBox<String> sellerChoice;

    int id = 0;

    public void iterating(){

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        String line = null;
        String namen = "";
        String pass = "";
        Path path = Paths.get("filename.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){
            int i=0;
            while ((line = reader.readLine()) != null) {
                if(i==0)
                    namen = line;
                else
                    pass = line;
                i++;
            }
            //System.out.println("Welcome - "+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] options = {"1","2","3","4","5","6","7","8","9","10"};
        String[] optionType = {"Classic","Sport","Boots","Sport-I","Sport-O"};
        String[] optionSeller = {"S1","S2","S3","S4","S5","S6","S7","S8","S9",namen};
        quantityText.getItems().addAll(options);
        typeText.getItems().addAll(optionType);
        sellerChoice.getItems().addAll(optionSeller);
        showItem();

    }


    public void goBack(javafx.event.ActionEvent actionEvent) throws IOException {
        HelloApplication m = new HelloApplication();
        m.changeScene("MainMenu.fxml");
    }

    @FXML
    private Button bid;

    public void showBid(javafx.event.ActionEvent actionEvent) throws IOException{
        String line = null;
        String namen = "";
        String pass = "";
        Path path = Paths.get("filename.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){
            int i=0;
            while ((line = reader.readLine()) != null) {
                if(i==0)
                    namen = line;
                else
                    pass = line;
                i++;
            }
            //System.out.println("Welcome - "+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sellerChoice.getValue() == null || !password.getText().equals(pass) && !password.getText().equals(sellerChoice.getValue()) ){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data missing");
            alert.setContentText("Please log as seller with password !");
            alert.showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Details.fxml"));
            Parent tableviewParent = loader.load();
            Scene tableViewScene = new Scene(tableviewParent);

            Details controller = loader.getController();
            controller.initData(tableView.getSelectionModel().getSelectedItem());
            controller.inData(sellerChoice.getValue(),typeText.getValue());
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

    public void insertData(ActionEvent actionEvent) {
        if(brandText.getText().isEmpty() || nameText.getText().isEmpty() || quantityText.getValue() == null || sizeText.getText().isEmpty() || priceText.getText().isEmpty() || typeText.getValue() == null || sellerChoice.getValue() == null || password.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data missing");
            alert.setContentText("Fill all information !");
            alert.showAndWait();
        }
        else {
            try {
                String line = null;
                String namen = "";
                String pass = "";
                Path path = Paths.get("filename.txt");
                try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())){
                    int i=0;
                    while ((line = reader.readLine()) != null) {
                        if(i==0)
                            namen = line;
                        else
                            pass = line;
                        i++;
                    }
                    //System.out.println("Welcome - "+name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(sellerChoice.getValue().equals(password.getText()) || password.getText().equals(pass)){
                    display();
                    if(Integer.parseInt(sizeText.getText()) < 50) {
                        Integer.parseInt(sizeText.getText());
                        Double.parseDouble(priceText.getText());
                        insertRecord();
                        brandText.clear();
                        typeText.setValue(null);
                        nameText.clear();
                        sizeText.clear();
                        quantityText.setValue(null);
                        priceText.clear();
                        sellerChoice.setValue(null);

                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("Wrong password for this person: "+sellerChoice.getValue());
                    alert.showAndWait();
                }
            }
            catch (Exception e) {
                System.out.println("Input to size and price must be number!");
            }

        }
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
                itemo = new Item(id,rs.getString("type"),rs.getString("brand"),rs.getString("name"),rs.getInt("size"),rs.getString("quantity"),rs.getDouble("price"),rs.getString("owner"));
                itemList.add(itemo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;

    }
    public void display() throws NumberException {
        Size size = new Size(Integer.parseInt(sizeText.getText()));
        int jj = 0;
        try {
            boolean a = validateSize(Integer.parseInt(sizeText.getText()));
        }
        catch (NumberException e){
            System.out.println("Caught exception "+e);
        }
        if(jj == 0) {
            Item itemm = new Item(typeText.getValue(), brandText.getText(), nameText.getText(), size, quantityText.getValue(), Double.parseDouble(priceText.getText()),sellerChoice.getValue());
            //ItemSport s = new ItemSport("Sport");
            itemm.setType(typeText.getValue());
            itemm.setBrand(brandText.getText());
            itemm.setName(nameText.getText());
            itemm.setSizo(Integer.parseInt(sizeText.getText()));
            itemm.setQuantity(quantityText.getValue());
            itemm.setPrice(Double.parseDouble(priceText.getText()));
            itemm.setSeller(sellerChoice.getValue());

            try {
                FileOutputStream fileOut = new FileOutputStream("ItemList.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(itemm);
                out.close();
                fileOut.close();
               // System.out.println("Serialized data is saved in ItemList.ser");
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }

    private boolean validateSize(int size) throws NumberException{
        boolean i;
        if(size >= 50){
            throw new NumberException("Size too big !");
            // System.out.println("Hello world");
        }
        else
            return false;
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


    @Override
    public Iterator createIterator() {
        return null;
    }
}
