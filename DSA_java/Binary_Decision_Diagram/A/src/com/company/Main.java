package com.company;
import java.time.Instant;
import java.util.*;
import static java.lang.System.exit;
                                        // Made with love by Quentinn //
public class Main {

    public static void main(String[] args) throws Exception {
        BDD bdd = new BDD();
        Node root = null;
        try {
            while(true){
                System.out.println("Zadaj cislo funkcie, ktoru chces vykonat [0] - Ukoncit || [1] - BDD_create || [2] - BDD_use");
                Scanner scanner = new Scanner(System.in);
                int value = scanner.nextInt();
                switch(value){
                    case 0:
                            System.out.println("Program ukonceny !");
                            exit(0);
                        break;
                    case 1:
                            scanner.nextLine();
                            System.out.println("A - Nenegovana hodnota || a - Negovana hodnota || Rozmedzie premennych A az M vratane");
                            System.out.println("Zadaj funkciu vo formate napr: A*b+C");
                            String funkcia = scanner.nextLine();
                            System.out.println("Zadaj poradie premennych (je potrebne zadat vsetky premennne, ktore boli zadane vyssie)");
                            String poradie = scanner.nextLine();
                            char c[] = new char[poradie.length()];
                            for(int i=0;i<poradie.length();i++){
                                c[i] = poradie.charAt(i);
                            }
                            root = bdd.Bdd(funkcia,c);
                        continue;
                    case 2:
                            if(root == null){
                                System.out.println("Najskor je potrebne vytvorit diagram !");
                                break;
                            }
                            scanner.nextLine();
                            System.out.println("Zadaj ciselne hodnoty pre VSETKY premenne ('0','1')");
                            String hodnoty = scanner.nextLine();
                            char ch[] = new char[hodnoty.length()];
                            int i = 0;
                            for(i=0;i<hodnoty.length();i++){
                                ch[i] = hodnoty.charAt(i);
                            }
                            String vysledok = bdd.Bdd_use(root,ch);

                            //String odpoved = vysledok == "1" ? "Vysledok pre tuto cestu je: "+vysledok : "Vysledok pre tuto cestu je: "+vysledok;
                            System.out.println("    -----***********-----");
                            System.out.println("Vysledok pre tuto cestu je: "+vysledok);
                            System.out.println("    -----***********-----");
                        continue;
                    default:
                            System.out.println("Pre toto cislo neexistuje funkcia !");
                        continue;
                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("Vstup musi byt cislo !");
        }




 /*
                        // Random Testovac //

        String s = random();
        s = s.replace("+", "+");
        s = s.replace("*", "*");
        s = s.replace("a", "A");
        s = s.replace("b", "B");
        s = s.replace("c", "C");
        s = s.replace("d", "D");
        s = s.replace("e", "E");
        s = s.replace("f", "F");
        s = s.replace("g", "G");
        s = s.replace("h", "H");
        s = s.replace("i", "I");
        s = s.replace("j", "J");
        s = s.replace("k", "K");
        s = s.replace("l", "L");
        s = s.replace("m", "M");
        s = s.replace("n", "N");
        s = s.replace("o", "O");
        s = s.replace("p", "P");
        s = s.replace("r", "R");
        s = s.replace("s", "S");
        s = s.replace("t", "T");
        s = s.replace("u", "U");
        s = s.replace("v", "V");
        s = s.replace("x", "X");
        s = s.replace("y", "Y");
        s = s.replace("z", "Z");


        char a[] = s.toCharArray();
        Arrays.sort(a);
        String abc= "";
        for(int l = 0; l < a.length; l++) {
            if(abc.indexOf(a[l]) == -1) // check if a char already exist, if not exist then return -1
                abc = abc+a[l];      // add new char
        }
        abc = abc.replace("+","");
        abc = abc.replace("*","");
        char array[] = abc.toCharArray();
        //System.out.println(s);
        //System.out.println(array);
        Node root = null;
        long s1 = Instant.now().toEpochMilli();
        root = bdd.Bdd(s,array);
        long s2 = Instant.now().toEpochMilli();
        Random random = new Random();
        int num;

        char hodnoty[] = new char[array.length];
        for(int j=0;j<array.length;j++){
            num = random.nextInt(2);
            if(num == 0)
                hodnoty[j] = '0';
            else
                hodnoty[j] = '1';
        }
        System.out.println("\t"+ Arrays.toString(hodnoty));
        long start = Instant.now().toEpochMilli();
        // M+C*K*B*F = 10
        String vysledok = "";
        for(int k = 0;k<1000000;k++)
            vysledok = bdd.Bdd_use(root,hodnoty);
        String odpoved = vysledok == "1" ? "Result should be: "+vysledok : "Result should be: "+vysledok;
        System.out.println(odpoved);
        long end = Instant.now().toEpochMilli();
        long time = end - start;
        System.out.println("Time: "+time+" ms");

 */
    }
    public static String random(){
        String s = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpRrSsTtUuVvXxYyZz";
        Random r = new Random();
        char a;
        int p;
        StringBuilder sb = new StringBuilder(1000);
        for (int j = 0; j < 1000; j++) {
            p = r.nextInt(2)+1;
            a = s.charAt(r.nextInt(s.length()));
            sb.append(a);
            if(p == 1)
                sb.append("+");
            else
                sb.append("*");
        }
        String b = String.valueOf(sb);
        b = sb.substring(0, sb.length() - 1);
        return b;
    }
}
