package com.company;

import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

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
	Table<String, Integer> table = new Table<>();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    String s;
    int i;
    int n = 15;
        try {
            while(true){
                System.out.println("Ktoru operaciu chces vykonat ? \n [1] - insert \n [2] - search \n [3] - delete \n [0] - ukoncenie programu");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Ukoncil si program");
                        System.exit(69);
                    case 1:
                        System.out.println("Vloz znaky pre vlozenie");
                        s = scanner.nextLine();
                        s = scanner.nextLine();
                        table.insert(s,2);
                        System.out.println("\t---");
                        continue;
                    case 2:
                        System.out.println("Vloz znaky pre vyhladanie");
                        s = scanner.nextLine();
                        s = scanner.nextLine();
                        table.search(s);
                        continue;
                    case 3:
                        System.out.println("Vloz znaky pre vymazanie");
                        s = scanner.nextLine();
                        s = scanner.nextLine();
                        table.delete(s);
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

       /* long start = Instant.now().toEpochMilli();
        for (i = 0; i < 500000; i++) {
            table.insert(RandomString.getAlphaNumericString(n), 6);
        }
         long start = Instant.now().toEpochMilli();
        for (i = 0; i < 500000; i++) {
            table.search(RandomString.getAlphaNumericString(n));
        }



        long end = Instant.now().toEpochMilli();
        long time = end - start;
     System.out.println("Vysledny cas je "+time);
      */
    }
}
