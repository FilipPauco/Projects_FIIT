package com.company;

public class Hashtable {
    private Data[] table;
    private static final Data TOMBSTONE = null;

    public Hashtable(int size){
        this.table = new Data[size];
    }

    public void insert(Data data){
        int j = data.hashCode() % table.length;
        int k = 1;
        while(table[j] != null){
            j = (data.hashCode() + (k*k)) % table.length;
            k++;
            if(k > 5000000){
                throw new RuntimeException("Nie je priestor !");
            }
        }
        System.out.println(data);
        table[j] = data;
    }

    public Data delete(Data data){
        int j = data.hashCode() % table.length;
        int k = 1;
        while (table[j] != null){
            if(table[j] == data){
                table[j] = TOMBSTONE;
            }
        }
        //System.out.println(data);
        return data;
    }

    public Data search(String data){

        return search(new Data(data));
    }
    public Data delete(String data){

        return delete(new Data(data));
    }

    public Data search(Data data){
        int j = data.hashCode() % table.length;
        int k = 1;
        while(table[j] != null && !table[j].equals(data)){
            j = (data.hashCode() + (k*k)) % table.length;
            k++;
        }

        return table[j];
    }

    public void print(){
        int i;
        for(i=0;i<table.length;i++){
            if(table[i] !=null)
            System.out.println(table[i]);
        }
    }

}
