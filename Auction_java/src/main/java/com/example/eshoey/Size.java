package com.example.eshoey;

import java.io.Serializable;

/**
 * Tato classa sluzi na vyuzitie agregacie v itemoch
 */
public class Size implements Serializable {
    private int size;

    public Size(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
