package com.example.eshoey;

import com.example.eshoey.AuctionBuyerLegal;
import com.example.eshoey.Details;
/**
 * Classa pre sukromnu osobu
 */
public class Private extends AuctionBuyerPrivate{

    /**
     * Polymorfizmus pre vypis ceny sukromnej osoby
     */
   @Override
   public String message(double value){
       return "Auction ended with "+value+" €";
    }



}
