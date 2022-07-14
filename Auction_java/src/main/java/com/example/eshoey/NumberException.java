package com.example.eshoey;

import javafx.scene.control.Alert;

/**
 * metoda vlastneho exceptionu
 */

public class NumberException extends Exception{
    public NumberException (String str)
    {
        super(str);
    }
}
