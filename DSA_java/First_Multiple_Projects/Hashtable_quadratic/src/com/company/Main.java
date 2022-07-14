package com.company;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import java.util.InputMismatchException;

public class Main {
    public class RandomString {

        // function to generate a random string of length n
        static String getAlphaNumericString(int n)
        {

            // chose a Character random from this String
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {

                // generate a random number between
                // 0 to AlphaNumericString variable length
                int index
                        = (int)(AlphaNumericString.length()
                        * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }

            return sb.toString();
        }
    }
    public static void main(String[] args) {
	Hashtable hashTable = new Hashtable(5000000);
    ArrayList<Data> info = new ArrayList<Data>();
    int choice;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int i;
    /*
    try {
        while(true){
            System.out.println("Ktoru operaciu chces vykonat ? \n [1] - insert \n [2] - search \n [3] - delete \n [0] - ukoncenie programu");
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Ukoncil si program");
                    System.exit(0);
                case 1:
                    info.add(new Data(1,"apple"));
                    info.add(new Data(2,"pear"));
                    System.out.println("Vlozene boli tieto polozky:");
                    hashTable.insert(info.get(0));
                    hashTable.insert(info.get(1));
                    System.out.println("\t---");
                    continue;
                case 2:
                    if(hashTable.search("pear") !=null) {
                        System.out.println("Text bol najdeny");
                        System.out.println(hashTable.search("pear"));
                    }
                    else
                        System.out.println("Text nebol najdeny");
                    continue;
                case 3:
                    System.out.println("Odstranene boli tieto polozky:");
                    hashTable.delete(info.get(1));
                    System.out.println("\t---");
                    System.out.println("Polozky po odstraneni");
                    hashTable.print();
                    System.out.println("\t---");
                    continue;
                default:
                    System.out.println("Zly vstup !");
                    continue;
            }
        }
    }
    catch(InputMismatchException x){
        System.out.println("Vstup moze byt len (cele) cislo");
        }
        */

        int n = 15;

        long start = Instant.now().toEpochMilli();
        for (i = 0; i < 5000000; i++) {
            info.add(new Data(i,RandomString.getAlphaNumericString(n)));
            //hashTable.insert(info.get(i));
        }

         /* for (i = 0; i < 5000000; i++) {
             hashTable.delete(RandomString.getAlphaNumericString(n));
            //hashTable.insert(info.get(i));
        }

        for (i = 0; i < 5000000; i++) {
            table.search(RandomString.getAlphaNumericString(n));
        }
        */
        long end = Instant.now().toEpochMilli();
        long time = end - start;
        System.out.println("Vysledny cas je "+time);
    }

}
