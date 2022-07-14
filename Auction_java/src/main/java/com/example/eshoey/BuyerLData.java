package com.example.eshoey;

/**
 * Táto classa ukladá informácie o sukormnikovi - kupcovi
 */
public class BuyerLData extends BuyerPData{
   public String ico;

    public BuyerLData(String meno, Adress adress, String cislo, String ico) {
        super(meno, adress, cislo);
        this.ico = ico;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }


    /**
     * metoda access - polymorfizmus
     */
    @Override
    public void access(){
        acc = 0.75;
        System.out.println("You have good access with 5% discount !");
    }
}
