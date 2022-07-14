package com.example.eshoey;

/**
 * Classa pre jeden z itemov hierarchie
 */
public class ItemSport extends Item{
    private String type;
    public ItemSport(int id, String brand, String name, Size size, String quantity, double price, String type) {
        super(id, brand, name, size, quantity, price);
        this.type = "Sport";
    }

    public String getType() {
        return type;
    }

    @Override
    public void getMessage(){
        System.out.println("We are sport type of shoes !");
    }

    /**
     *  Typ materialu, je specifikovany vhodnostou pouzitia // polymorfizmus
     * @param material
     * @return
     */
    @Override
    public double info(String material){
        double a = 1;
        if(material.equals("Leather")){
            System.out.println("Not suitable");
            a = 0;
            return a;
        }
        else if (material.equals("Knit")){
            System.out.println("Very useful");
            a = 2;
            return a;
        }
        else{
            System.out.println("Average usability");
            return a;
        }

    }
}
