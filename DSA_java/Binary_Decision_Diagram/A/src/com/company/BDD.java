package com.company;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class BDD {
    public Node Bdd(String funkcia,char c[]){
        int pocet=0;
        Node root = new Node(funkcia);

        for (int i=0;i<c.length;i++) {
            pocet =  insert(root,root,c,i,pocet);
        }

        List<String> list = new ArrayList<>();
        pocet = 0;
        System.out.println("V diagrame sa vyskytuju (bez duplikatov) tieto uzly: ");
        System.out.println("    -----***********-----");
        pocet = pocet+ printTree(root,list,pocet);
        pocet++;  // priratam root
        int k = 0;
        int ba = printTree2(root,k);
        double total = Math.pow(2,c.length+1)-1;
        double reduction = Math.round(((total-pocet)*10000.00) / (total*100.00));
        System.out.println("    -----***********-----");
        System.out.println("Celkovy pocet uzlov: "+ (int)total);
        System.out.println("Zjednodusil som: "+ (int)(total-pocet) +" uzlov");
        System.out.println("Pocet (jedinecnych) uzlov po redukcii: "+pocet);
        System.out.println("Miera redukcie je priblizne: "+ reduction +" %");
        System.out.println("    -----***********-----");
        //printLeafNodes(root);
        //printTree(root,list);
        return root;
    }


    public int printTree(Node node,List list,int i){
        if(node == null ){
            return i;
        }
        System.out.println(node.funkcia);

        if(node.left != null && !list.contains(node.left.funkcia)) {
            list.add(node.left.funkcia);
            i =printTree(node.left, list,i);
            i++;
        }

        if(node.right != null && !list.contains(node.right.funkcia)) {
            list.add(node.right.funkcia);
            i = printTree(node.right,list,i);
            i++;
        }

        return i;
    }

    public int printTree2(Node node,int i){

        if(node == null ){
            return i;
        }
        i++;
        //System.out.println(node.funkcia);
        if(node.left != null ) {
            i =printTree2(node.left,i);
        }
        if(node.right != null) {
            i = printTree2(node.right,i);
        }

        return i;
    }

    static void printLeafNodes(Node root) {

        if (root == null)
            return;

        if (root.left == null && root.right == null){

            String a = root.funkcia;
            System.out.print(root.funkcia + " ");
            if(a == "1") {
                System.out.println("- True");
            }
            else
                System.out.println("- False");
            return;
        }

        if (root.left != null)
            printLeafNodes(root.left);

        if (root.right != null)
            printLeafNodes(root.right);
    }

    public int insert(Node node,Node temp,char c[],int i, int pocet){
        if(node.left == null && node.right == null){
            Node another = new Node(node.funkcia);
            Node anotherN = new Node(node.funkcia);


            if(Character.isUpperCase(c[i])) {
                another.funkcia = node.funkcia.replace((Character.toLowerCase(c[i])), '0').replace((Character.toUpperCase(c[i])), '1');
                anotherN.funkcia = node.funkcia.replace((Character.toLowerCase(c[i])), '1').replace((Character.toUpperCase(c[i])), '0');
                simplify(another, anotherN);
                another.funkcia = cutAdditional(another.funkcia);
                anotherN.funkcia = cutAdditional(anotherN.funkcia);

                if(another.funkcia.contains("+1")||another.funkcia.contains("1+"))
                    another.funkcia = "1";
                if(another.funkcia.contains("1*1")||another.funkcia.contains("1*1*1")||another.funkcia.contains("1*1*1*1")||another.funkcia.contains("1*1*1*1*1"))
                    another.funkcia = "1";
                another.funkcia = another.funkcia.replace("+0","");
                another.funkcia = another.funkcia.replace("0+","");

                if(anotherN.funkcia.contains("+1")||anotherN.funkcia.contains("1+"))
                    anotherN.funkcia = "1";
                if(anotherN.funkcia.contains("1*1")||anotherN.funkcia.contains("1*1*1")||anotherN.funkcia.contains("1*1*1*1")||anotherN.funkcia.contains("1*1*1*1*1"))
                    anotherN.funkcia = "1";
                anotherN.funkcia = anotherN.funkcia.replace("+0","");
                anotherN.funkcia = anotherN.funkcia.replace("0+","");

                String cr = String.valueOf(c[i]);
                String crd = cr.toUpperCase();
                String cbd = cr.toLowerCase();
                if(!node.funkcia.equals("0") && !node.funkcia.equals("1") && (node.funkcia.contains(crd) || node.funkcia.contains(cbd))) {
                node.left = search(temp,anotherN.funkcia);
                if(node.left  != null){
                    pocet++;
                    anotherN = null;
                }
                else{
                    node.left= anotherN;
                }

                node.right = search(temp,another.funkcia);
                if(node.right  != null){
                    pocet++;
                    another = null;
                }
                else{
                    node.right = another;
                 }
                }


                i++;

            }
            else{
                    another.funkcia = node.funkcia.replace((Character.toLowerCase(c[i])), '1').replace((Character.toUpperCase(c[i])), '0');
                    anotherN.funkcia = node.funkcia.replace((Character.toLowerCase(c[i])), '0').replace((Character.toUpperCase(c[i])), '1');
                    simplify(another, anotherN);
                    another.funkcia = cutAdditional(another.funkcia);
                    anotherN.funkcia = cutAdditional(anotherN.funkcia);

                if(another.funkcia.contains("+1")||another.funkcia.contains("1+"))
                    another.funkcia = "1";
                another.funkcia = another.funkcia.replace("+0","");
                another.funkcia = another.funkcia.replace("0+","");

                if(anotherN.funkcia.contains("+1")||anotherN.funkcia.contains("1+"))
                    anotherN.funkcia = "1";
                anotherN.funkcia = anotherN.funkcia.replace("+0","");
                anotherN.funkcia = anotherN.funkcia.replace("0+","");

                String cr = String.valueOf(c[i]);
                String crd = cr.toUpperCase();
                String cbd = cr.toLowerCase();
                if(!node.funkcia.equals("0") && !node.funkcia.equals("1") && (node.funkcia.contains(crd) || node.funkcia.contains(cbd))) {
                    node.left = search(temp,anotherN.funkcia);
                    if(node.left  != null){
                        pocet++;
                        anotherN = null;
                    }
                    else{
                        node.left= anotherN;
                    }

                    node.right = search(temp,another.funkcia);
                    if(node.right  != null){
                        another = null;
                    }
                    else{
                        pocet++;
                        node.right = another;
                    }
                }
                    i++;
            }
            return pocet;
        }

        if(node.left != null){
            pocet = insert(node.left,temp,c,i,pocet);
        }
        if(node.right != null){
            pocet = insert(node.right,temp,c,i,pocet);
        }
            return pocet;
    }

    public Node search(Node node,String funkcia) {
        Node result = null;
        if(node.funkcia.equals(funkcia)){
            return node;
        }
        if(result == null && node.left != null){
            result = search(node.left,funkcia);
        }
        if(result == null && node.right != null){
            result = search(node.right,funkcia);
        }

        return result;
    }

    private void simplify(Node another, Node anotherN){
        if(another.funkcia == "0")
            return;
        if(anotherN.funkcia == "0")
            return;

        another.funkcia = another.funkcia.replace("A*1","A");
        another.funkcia = another.funkcia.replace("B*1","B");
        another.funkcia = another.funkcia.replace("C*1","C");
        another.funkcia = another.funkcia.replace("D*1","D");
        another.funkcia = another.funkcia.replace("E*1","E");
        another.funkcia = another.funkcia.replace("F*1","F");
        another.funkcia = another.funkcia.replace("G*1","G");
        another.funkcia = another.funkcia.replace("H*1","H");
        another.funkcia = another.funkcia.replace("I*1","I");
        another.funkcia = another.funkcia.replace("J*1","J");
        another.funkcia = another.funkcia.replace("K*1","K");
        another.funkcia = another.funkcia.replace("L*1","L");
        another.funkcia = another.funkcia.replace("M*1","M");
        another.funkcia = another.funkcia.replace("1*A","A");
        another.funkcia = another.funkcia.replace("1*B","B");
        another.funkcia = another.funkcia.replace("1*C","C");
        another.funkcia = another.funkcia.replace("1*D","D");
        another.funkcia = another.funkcia.replace("1*E","E");
        another.funkcia = another.funkcia.replace("1*F","F");
        another.funkcia = another.funkcia.replace("1*G","G");
        another.funkcia = another.funkcia.replace("1*H","H");
        another.funkcia = another.funkcia.replace("1*I","I");
        another.funkcia =  another.funkcia.replace("1*J","J");
        another.funkcia =  another.funkcia.replace("1*K","K");
        another.funkcia = another.funkcia.replace("1*L","L");
        another.funkcia = another.funkcia.replace("1*M","M");
        another.funkcia = another.funkcia.replace("1*N","N");
        another.funkcia = another.funkcia.replace("1*O","O");
        another.funkcia = another.funkcia.replace("1*P","P");
        another.funkcia = another.funkcia.replace("1*R","R");
        another.funkcia =  another.funkcia.replace("1*S","S");
        another.funkcia =  another.funkcia.replace("1*T","T");
        another.funkcia = another.funkcia.replace("1*U","U");
        another.funkcia = another.funkcia.replace("1*V","V");
        another.funkcia =  another.funkcia.replace("1*X","X");
        another.funkcia = another.funkcia.replace("1*Y","Y");
        another.funkcia = another.funkcia.replace("1*Z","Z");
        another.funkcia = another.funkcia.replace("N*1","N");
        another.funkcia = another.funkcia.replace("O*1","O");
        another.funkcia = another.funkcia.replace("P*1","P");
        another.funkcia = another.funkcia.replace("R*1","R");
        another.funkcia = another.funkcia.replace("S*1","S");
        another.funkcia = another.funkcia.replace("T*1","T");
        another.funkcia = another.funkcia.replace("U*1","U");
        another.funkcia = another.funkcia.replace("V*1","V");
        another.funkcia = another.funkcia.replace("X*1","X");
        another.funkcia = another.funkcia.replace("Y*1","Y");
        another.funkcia = another.funkcia.replace("Z*1","Z");


        another.funkcia = another.funkcia.replace("a*1","a");
        another.funkcia = another.funkcia.replace("b*1","b");
        another.funkcia = another.funkcia.replace("c*1","c");
        another.funkcia = another.funkcia.replace("d*1","d");
        another.funkcia = another.funkcia.replace("e*1","e");
        another.funkcia = another.funkcia.replace("f*1","f");
        another.funkcia = another.funkcia.replace("g*1","g");
        another.funkcia = another.funkcia.replace("h*1","h");
        another.funkcia = another.funkcia.replace("i*1","i");
        another.funkcia = another.funkcia.replace("j*1","j");
        another.funkcia = another.funkcia.replace("k*1","k");
        another.funkcia = another.funkcia.replace("l*1","l");
        another.funkcia = another.funkcia.replace("m*1","m");
        another.funkcia = another.funkcia.replace("1*a","a");
        another.funkcia = another.funkcia.replace("1*b","b");
        another.funkcia = another.funkcia.replace("1*c","c");
        another.funkcia = another.funkcia.replace("1*d","d");
        another.funkcia = another.funkcia.replace("1*e","e");
        another.funkcia = another.funkcia.replace("1*f","f");
        another.funkcia = another.funkcia.replace("1*g","g");
        another.funkcia = another.funkcia.replace("1*h","h");
        another.funkcia = another.funkcia.replace("1*i","i");
        another.funkcia =  another.funkcia.replace("1*j","j");
        another.funkcia =  another.funkcia.replace("1*k","k");
        another.funkcia = another.funkcia.replace("1*l","l");
        another.funkcia = another.funkcia.replace("1*m","m");
        another.funkcia = another.funkcia.replace("1*n","n");
        another.funkcia = another.funkcia.replace("1*o","o");
        another.funkcia = another.funkcia.replace("1*p","p");
        another.funkcia = another.funkcia.replace("1*r","r");
        another.funkcia =  another.funkcia.replace("1*s","s");
        another.funkcia =  another.funkcia.replace("1*t","t");
        another.funkcia = another.funkcia.replace("1*u","u");
        another.funkcia = another.funkcia.replace("1*v","v");
        another.funkcia =  another.funkcia.replace("1*x","x");
        another.funkcia = another.funkcia.replace("1*y","y");
        another.funkcia = another.funkcia.replace("1*z","z");
        another.funkcia = another.funkcia.replace("n*1","n");
        another.funkcia = another.funkcia.replace("o*1","o");
        another.funkcia = another.funkcia.replace("p*1","p");
        another.funkcia = another.funkcia.replace("r*1","r");
        another.funkcia = another.funkcia.replace("s*1","s");
        another.funkcia = another.funkcia.replace("t*1","t");
        another.funkcia = another.funkcia.replace("u*1","u");
        another.funkcia = another.funkcia.replace("v*1","v");
        another.funkcia = another.funkcia.replace("x*1","x");
        another.funkcia = another.funkcia.replace("y*1","y");
        another.funkcia = another.funkcia.replace("z*1","z");

        another.funkcia = another.funkcia.replace("++","+");

        if(another.funkcia.charAt(0) == '+')
            another.funkcia = another.funkcia.replaceFirst("[+]","");
        else if(another.funkcia.charAt(0) == '*')
            another.funkcia = another.funkcia.replaceFirst("[*]","");

        if(another.funkcia.charAt(another.funkcia.length()-1) == '+')
            another.funkcia = another.funkcia.substring(0, another.funkcia.length()-1) + "" + another.funkcia.substring(another.funkcia.length()-1 + 1);
        else if(another.funkcia.charAt(another.funkcia.length()-1) == '*')
            another.funkcia = another.funkcia.substring(0, another.funkcia.length()-1) + "" + another.funkcia.substring(another.funkcia.length()-1 + 1);



        anotherN.funkcia = anotherN.funkcia.replace("A*1","A");
        anotherN.funkcia = anotherN.funkcia.replace("B*1","B");
        anotherN.funkcia = anotherN.funkcia.replace("C*1","C");
        anotherN.funkcia = anotherN.funkcia.replace("D*1","D");
        anotherN.funkcia = anotherN.funkcia.replace("E*1","E");
        anotherN.funkcia = anotherN.funkcia.replace("F*1","F");
        anotherN.funkcia = anotherN.funkcia.replace("G*1","G");
        anotherN.funkcia = anotherN.funkcia.replace("H*1","H");
        anotherN.funkcia = anotherN.funkcia.replace("I*1","I");
        anotherN.funkcia = anotherN.funkcia.replace("J*1","J");
        anotherN.funkcia = anotherN.funkcia.replace("K*1","K");
        anotherN.funkcia = anotherN.funkcia.replace("L*1","L");
        anotherN.funkcia = anotherN.funkcia.replace("M*1","M");
        anotherN.funkcia = anotherN.funkcia.replace("1*A","A");
        anotherN.funkcia = anotherN.funkcia.replace("1*B","B");
        anotherN.funkcia = anotherN.funkcia.replace("1*C","C");
        anotherN.funkcia = anotherN.funkcia.replace("1*D","D");
        anotherN.funkcia = anotherN.funkcia.replace("1*E","E");
        anotherN.funkcia = anotherN.funkcia.replace("1*F","F");
        anotherN.funkcia = anotherN.funkcia.replace("1*G","G");
        anotherN.funkcia = anotherN.funkcia.replace("1*H","H");
        anotherN.funkcia = anotherN.funkcia.replace("1*I","I");
        anotherN.funkcia = anotherN.funkcia.replace("1*J","J");
        anotherN.funkcia = anotherN.funkcia.replace("1*K","K");
        anotherN.funkcia = anotherN.funkcia.replace("1*L","L");
        anotherN.funkcia = anotherN.funkcia.replace("1*M","M");
        anotherN.funkcia = anotherN.funkcia.replace("1*N","N");
        anotherN.funkcia = anotherN.funkcia.replace("1*O","O");
        anotherN.funkcia = anotherN.funkcia.replace("1*P","P");
        anotherN.funkcia = anotherN.funkcia.replace("1*R","R");
        anotherN.funkcia =  anotherN.funkcia.replace("1*S","S");
        anotherN.funkcia =  anotherN.funkcia.replace("1*T","T");
        anotherN.funkcia = anotherN.funkcia.replace("1*U","U");
        anotherN.funkcia = anotherN.funkcia.replace("1*V","V");
        anotherN.funkcia =  anotherN.funkcia.replace("1*X","X");
        anotherN.funkcia = anotherN.funkcia.replace("1*Y","Y");
        anotherN.funkcia = anotherN.funkcia.replace("1*Z","Z");
        anotherN.funkcia = anotherN.funkcia.replace("N*1","N");
        anotherN.funkcia = anotherN.funkcia.replace("O*1","O");
        anotherN.funkcia = anotherN.funkcia.replace("P*1","P");
        anotherN.funkcia = anotherN.funkcia.replace("R*1","R");
        anotherN.funkcia = anotherN.funkcia.replace("S*1","S");
        anotherN.funkcia = anotherN.funkcia.replace("T*1","T");
        anotherN.funkcia = anotherN.funkcia.replace("U*1","U");
        anotherN.funkcia = anotherN.funkcia.replace("V*1","V");
        anotherN.funkcia = anotherN.funkcia.replace("X*1","X");
        anotherN.funkcia = anotherN.funkcia.replace("Y*1","Y");
        anotherN.funkcia = anotherN.funkcia.replace("Z*1","Z");


        anotherN.funkcia = anotherN.funkcia.replace("a*1","a");
        anotherN.funkcia = anotherN.funkcia.replace("b*1","b");
        anotherN.funkcia = anotherN.funkcia.replace("c*1","c");
        anotherN.funkcia = anotherN.funkcia.replace("d*1","d");
        anotherN.funkcia = anotherN.funkcia.replace("e*1","e");
        anotherN.funkcia = anotherN.funkcia.replace("f*1","f");
        anotherN.funkcia = anotherN.funkcia.replace("g*1","g");
        anotherN.funkcia = anotherN.funkcia.replace("h*1","h");
        anotherN.funkcia = anotherN.funkcia.replace("i*1","i");
        anotherN.funkcia = anotherN.funkcia.replace("j*1","j");
        anotherN.funkcia = anotherN.funkcia.replace("k*1","k");
        anotherN.funkcia = anotherN.funkcia.replace("l*1","l");
        anotherN.funkcia = anotherN.funkcia.replace("m*1","m");
        anotherN.funkcia = anotherN.funkcia.replace("1*a","a");
        anotherN.funkcia = anotherN.funkcia.replace("1*b","b");
        anotherN.funkcia = anotherN.funkcia.replace("1*c","c");
        anotherN.funkcia = anotherN.funkcia.replace("1*d","d");
        anotherN.funkcia = anotherN.funkcia.replace("1*e","e");
        anotherN.funkcia = anotherN.funkcia.replace("1*f","f");
        anotherN.funkcia = anotherN.funkcia.replace("1*g","g");
        anotherN.funkcia = anotherN.funkcia.replace("1*h","h");
        anotherN.funkcia = anotherN.funkcia.replace("1*i","i");
        anotherN.funkcia = anotherN.funkcia.replace("1*j","j");
        anotherN.funkcia = anotherN.funkcia.replace("1*k","k");
        anotherN.funkcia = anotherN.funkcia.replace("1*l","l");
        anotherN.funkcia = anotherN.funkcia.replace("1*m","m");
        anotherN.funkcia = anotherN.funkcia.replace("1*n","n");
        anotherN.funkcia = anotherN.funkcia.replace("1*o","o");
        anotherN.funkcia = anotherN.funkcia.replace("1*p","p");
        anotherN.funkcia = anotherN.funkcia.replace("1*r","r");
        anotherN.funkcia =  anotherN.funkcia.replace("1*s","s");
        anotherN.funkcia =  anotherN.funkcia.replace("1*t","t");
        anotherN.funkcia = anotherN.funkcia.replace("1*u","u");
        anotherN.funkcia = anotherN.funkcia.replace("1*v","v");
        anotherN.funkcia =  anotherN.funkcia.replace("1*x","x");
        anotherN.funkcia = anotherN.funkcia.replace("1*y","y");
        anotherN.funkcia = anotherN.funkcia.replace("1*z","z");
        anotherN.funkcia = anotherN.funkcia.replace("n*1","n");
        anotherN.funkcia = anotherN.funkcia.replace("o*1","o");
        anotherN.funkcia = anotherN.funkcia.replace("p*1","p");
        anotherN.funkcia = anotherN.funkcia.replace("r*1","r");
        anotherN.funkcia = anotherN.funkcia.replace("s*1","s");
        anotherN.funkcia = anotherN.funkcia.replace("t*1","t");
        anotherN.funkcia = anotherN.funkcia.replace("u*1","u");
        anotherN.funkcia = anotherN.funkcia.replace("v*1","v");
        anotherN.funkcia = anotherN.funkcia.replace("x*1","x");
        anotherN.funkcia = anotherN.funkcia.replace("y*1","y");
        anotherN.funkcia = anotherN.funkcia.replace("z*1","z");

        anotherN.funkcia = anotherN.funkcia.replace("++","+");

        if(another.funkcia == "")
            another.funkcia = "0";
        if(anotherN.funkcia == "")
            anotherN.funkcia = "0";


        if(anotherN.funkcia.charAt(0) == '+')
            anotherN.funkcia = anotherN.funkcia.replaceFirst("[+]","");
        else if(anotherN.funkcia.charAt(0) == '*')
            anotherN.funkcia = anotherN.funkcia.replaceFirst("[*]","");

        if(anotherN.funkcia.charAt(anotherN.funkcia.length()-1) == '+')
            anotherN.funkcia = anotherN.funkcia.substring(0, anotherN.funkcia.length()-1) + "" + anotherN.funkcia.substring(anotherN.funkcia.length()-1 + 1);
        else if(anotherN.funkcia.charAt(anotherN.funkcia.length()-1) == '*')
            anotherN.funkcia = anotherN.funkcia.substring(0, anotherN.funkcia.length()-1) + "" + anotherN.funkcia.substring(anotherN.funkcia.length()-1 + 1);
    }

    public String cutAdditional(String finalString){
        while(finalString.contains("0*") || finalString.contains("*0")){
            int k =0;
            int c = 0;
            for(int i=0;i<finalString.length();i++){
                if(finalString.charAt(i) == '+')
                    k = i;
                if(finalString.charAt(i) == '0'){
                    c = i;
                    break;
                }
            }
            int d = 0;
            for(int i=c;i<finalString.length();i++){
                if(finalString.charAt(i) == '+'){
                    d = i;
                    break;
                }
            }
            if(k == 0 && d == 0)
                finalString = finalString.substring(0, 0) + "0" + finalString.substring(finalString.length());
            else if(d == 0)
                finalString = finalString.substring(0, k) + "" + finalString.substring(finalString.length());
            else if(k == 0)
                finalString = finalString.substring(0, 0) + "" + finalString.substring(d + 1);
            else
                finalString = finalString.substring(0, k+1) + "" + finalString.substring(d + 1);
        }
        return finalString;
    }

    public String Bdd_use(Node root,char c[]){
        int i;

        for(i=0;i<c.length;i++){
            if(root.right == null || root.left == null)
                break;
            if(c[i] == '1')
                root = root.right;
            if(c[i] == '0')
                root = root.left;
        }
        String cd = root.funkcia;
        return cd;
    }
}
