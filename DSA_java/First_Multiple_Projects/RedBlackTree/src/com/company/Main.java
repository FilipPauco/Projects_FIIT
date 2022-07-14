package com.company;
import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        tree redBlack = new tree();
        int choice;
        Scanner scanner = new Scanner(System.in);
        int numbers;
        int i;
        int number;
        Random random = new Random();

        try {
            while(true){
                System.out.println("Ktoru operaciu chces vykonat ? \n [1] - insert \n [2] - search \n [3] - delete \n [4] - display \n [0] - ukoncenie programu");
                choice = scanner.nextInt();
                switch(choice){
                    case 0:
                        System.out.println("Ukoncil si program");
                        System.exit(0);
                    case 1:
                        System.out.println("Kolko prvkov chces vlozit ?");
                        numbers = scanner.nextInt();
                        System.out.println("Vloz "+numbers+" cisel");
                        for(i=0;i<numbers;i++){
                            number = scanner.nextInt();
                            redBlack.insert(number);
                        }
                        continue;
                    case 2:
                        System.out.println("Zvolil si moznost pre vyhladanie, zadaj cislo prvku");
                        numbers = scanner.nextInt();
                        redBlack.search(redBlack.root,numbers);
                        continue;
                    case 3:
                        System.out.println("Delete chyba");
                        continue;
                    case 4:
                        System.out.println("Vybral si moznost pre zobrazenie stromu");
                        redBlack.post(redBlack.root);
                        System.out.print("\n");
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
         /*
        long start = Instant.now().toEpochMilli();
        for (i = 0; i < 5000000; i++) {
            int x = random.nextInt(100000000)+1;
            redBlack.insert(x);
        }
         for (i = 0; i < 5000000; i++) {
            int y = random.nextInt(100000000)+1;
            redBlack.search(redBlack.root,y);
        }


        long end = Instant.now().toEpochMilli();
        long time = end - start;
        System.out.println("Vysledny cas je: "+time+" milisekund");
*/
    }
}
