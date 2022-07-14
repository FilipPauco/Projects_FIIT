package com.example.eshoey;

/**
 * Táto classa ukladá informácie o predajcovi
 */
public class SellerData extends UserData{
   private Adress adress;
   private String cislo;

    public SellerData(String meno, Adress adress, String cislo) {
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
        acc = 1;
        System.out.println("You have almost full access !");
    }

}
