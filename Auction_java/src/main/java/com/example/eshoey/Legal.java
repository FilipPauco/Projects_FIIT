package com.example.eshoey;

import com.example.eshoey.AuctionBuyerPrivate;
import com.example.eshoey.Details;
/**
 * Classa pre pravnicku osobu
 */

public class Legal extends AuctionBuyerPrivate {

    /**
     * Polymorfizmus pre vypis ceny pravnickej osoby
     */

    @Override
    public String message(double value){
        return "Auction ended with "+value*0.95+" €";
    }


}
