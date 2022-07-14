package com.example.eshoey;

public class BuyerPData extends UserData{
    private Adress adress;
    private String cislo;

    public BuyerPData(String meno, Adress adress, String cislo) {
        super(meno);
        this.adress = adress;
        this.cislo = cislo;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getCislo() {
        return cislo;
    }

    public void setCislo(String cislo) {
        this.cislo = cislo;
    }

    /**
     * metoda access - polymorfizmus
     */
    @Override
    public void access(){
        acc = 0.75;
        System.out.println("You have good access with no discount !");
    }
}
