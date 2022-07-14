package com.example.eshoey;

import java.io.Serializable;


/**
 * Classa pre hlavny item z hierarchie, gettery, settery
 */
public class Item implements Serializable {
    private String brand;
    private String name;
    Size size;
    private int sizo;
    private double price;
    private String quantity;
    private int id;
    private String type;
    private String seller;


    public Item(int id,String brand, String name, Size size,String quantity,double price) {
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public Item(int id,String type,String brand, String name, Size size,String quantity,double price) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }
    public Item(String brand, String name, Size size,String quantity,double price) {
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }
    public Item(String type,String brand, String name, Size size,String quantity,double price) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public Item(int id, String type, String brand, String name, int sizo, String quantity, double price) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.sizo = sizo;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public Item(String type, String brand, String name, Size size, String quantity, double price, String seller) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.seller = seller;
    }

    public Item(int id, String type, String brand, String name, int sizo, String quantity, double price, String seller) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.sizo = sizo;
        this.quantity = quantity;
        this.price = price;
        this.seller = seller;
        this.id = id;
    }


    public String getBrand() {
        return brand;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }



    public void setSize(Size size) {
        this.size = size;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getI() {
        return id;
    }

    public void setI(int id) {
        this.id = id;
    }

    public int getSizo(){return sizo;}
    public void setSizo(int sizo){
        this.sizo = sizo;
    }

    public String getType(){return type;}
    public void setType(String type){this.type = type;}

    public String getSeller(){return seller;}
    public void setSeller(String seller){this.seller = seller;}

    public void getMessage(){
        System.out.println("We are classic type of shoes");
    }

    /**
     * funkcia pre vyuzitie polymorfizmus
     * @param s
     * @return
     */
    public double info(String s){
            double a = 1;
            System.out.println("Average usability with average performance");
            return a;
    }

}
