package com.company;

import java.util.Objects;

public class Data {
    private int data;
    private String text;

    public Data(int data, String text){
        this.data = data;
        this.text = text;
    }

    public Data(String text){
        this.text = text;
    }

    public int getData() {
        return data;
    }

    public String getText() {
        return text;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setText(String text) {
        this.text = text;
    }


    public boolean equals(Object o){
        if(this == o)
            return true;
         else if(o == null || getClass() != o.getClass())
             return false;
         Data d = (Data) o;
         return Objects.equals(text,d.getText());
    }

    public int hashCode() {
        int hash= 1;
        int number = 11;
        char[] array = text.toCharArray();
        for(char c : array){
            hash = hash * number + c;
        }
        return Math.abs(hash);
    }

    public String toString() {
        return "Data{" +
                "data=" + data +
                ", text='" + text + '\'' +
                '}';
    }

}
