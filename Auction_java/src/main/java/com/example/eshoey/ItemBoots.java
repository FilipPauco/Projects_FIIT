package com.example.eshoey;

/**
 * Classa pre jeden z itemov hierarchie
 */
public class ItemBoots extends Item{
    private String type;
    public ItemBoots(int id, String brand, String name, Size size, String quantity, double price, String type) {
        super(id, brand, name, size, quantity, price);
        this.type = "Boots";
    }

    public String getType() {
        return type;
    }

    @Override
    public void getMessage(){
        System.out.println("We are not classic type of shoes, We are boots !");
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
            System.out.println("Very suitable");
            a = 2;
            return a;
        }
        else if (material.equals("Knit")){
            System.out.println("Worse usability");
            a = 0.5;
            return a;
        }
        else{
            System.out.println("Average usability");
            return a;
        }

    }
}
