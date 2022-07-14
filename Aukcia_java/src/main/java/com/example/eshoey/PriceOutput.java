package com.example.eshoey;

/**
 * Interface pre itemy
 */
public interface PriceOutput {
    /**
     *  V zavislosi od ceny vypise spravu
     * @param price
     */
    default void say(double price){
        if(price > 500)
            System.out.println("These shoes were really expensive !");
        else if(price > 150)
            System.out.println("These shoes were quite expensive !");
        else
            System.out.println("These shoes were at quite fine price!");
    }
}
