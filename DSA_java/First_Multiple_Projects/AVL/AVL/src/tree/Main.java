package tree;
import java.time.Instant;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ATree a = new ATree();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int i;
        int numbers;
        int number;
        int array[];
        Random random = new Random();

        try {
            while(true){
                System.out.println("Ktoru operaciu chces vykonat ? \n [1] - insert \n [2] - search \n [3] - delete \n [0] - ukoncenie programu");
                choice = scanner.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Ukoncil si program");
                        System.exit(0);
                    case 1:
                        System.out.println("Zvolil si moznost insert");
                        System.out.println("Kolko cisel chces vlozit ?");
                        numbers = scanner.nextInt();
                        System.out.println("Zadaj "+numbers+" cisiel pre vlozenie");
                        for (i=0;i<numbers;i++) {
                            number = scanner.nextInt();
                            a.root = a.insert(a.root, number);
                        }

                        System.out.println("Zoradene podla stromu");
                        a.post(a.root);
                        System.out.print("\n");
                        continue;
                    case 2:
                        System.out.println("Zvolil si moznost search");
                        System.out.println("Zadaj cislo pre vyhladanie");
                        numbers = scanner.nextInt();
                        a.search(a.root,numbers);
                        continue;
                    case 3:
                        System.out.println("Zvolil si moznost delete");
                        System.out.println("Zadaj cislo pre vymazanie");
                        numbers = scanner.nextInt();
                        a.delete(a.root,numbers);

                        System.out.println("Strom po vymazani daneho prvku !");
                        a.post(a.root);
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

    }
}
