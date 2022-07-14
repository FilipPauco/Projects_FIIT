package com.example.eshoey;

/**
 * Navrhovy vzor singleton
 */
class Singleton {
    private static Singleton single_instance = null;
    public String s;
    private Singleton()
    {

        s = " Has has been added to seller's data ! ";
    }

    public static Singleton Singleton()
    {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}