package com.example.eshoey;

/**
 * Táto classa ukladá informácie o userovi
 */
public class UserData {
    private String meno;
    protected double acc;

    public UserData(String meno) {
        this.meno = meno;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    /**
     * metoda access - polymorfizmus
     */
    public void access(){
        acc = 0.5;
        System.out.println("You have restricted access !");
    }
}
