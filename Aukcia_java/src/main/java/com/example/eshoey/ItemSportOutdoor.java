package com.example.eshoey;

/**
 * Classa pre jeden z itemov hierarchie
 */

public class ItemSportOutdoor extends ItemSport{
    double durability;
    public ItemSportOutdoor(int id, String brand, String name, Size size, String quantity, double price, String type) {
        super(id, brand, name, size, quantity, price,"Sports");
        this.durability = 1.5;
    }
    public double getdurablity() {
        return durability;
    }

    @Override
    public void getMessage(){
        System.out.println("We are not classic type of shoes, We are boots with great durability !");
        System.out.println(getdurablity());
    }

    /**
     *  Typ materialu, je specifikovany vhodnostou pouzitia // polymorfizmus
     * @param material
     * @return
     */
    @Override
    public double info(String material){
        double a = 1;
        if(material.equals("Hikingknit")){
            System.out.println("Best performance type");
            a = 0;
            return a;
        }
        else if (material.equals("Naturegripknit")){
            System.out.println("Great performance type");
            a = 2;
            return a;
        }
        else{
            System.out.println("Average performance type");
            return a;
        }

    }
}
