package com.example.eshoey;

/**
 * Tato classa sluzi na vyuzitie agregacie v typoch osob
 */
public class Adress {
    private String mesto;
    private int byt;
    private int psc;

    public Adress(String mesto, int byt, int psc) {
        this.mesto = mesto;
        this.byt = byt;
        this.psc = psc;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getByt() {
        return byt;
    }

    public void setByt(int byt) {
        this.byt = byt;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }
}
