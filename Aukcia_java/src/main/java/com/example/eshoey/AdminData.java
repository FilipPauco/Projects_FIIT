package com.example.eshoey;

/**
 * Táto classa ukladá informácie o adminovi
 */

public class AdminData extends UserData{
    public int id;

    public AdminData(String meno, int id) {
        super(meno);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * metoda access - polymorfizmus
     */

    @Override
    public void access(){
        acc = 1.25;
        System.out.println("You have special access to all features");
    }
}
