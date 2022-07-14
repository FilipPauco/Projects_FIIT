package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Table<T,D>{
    public int j;
    public int big;
    public int number;
    int index1;
    int index2;
    int index3;
    int hc;
    int hc2;
    int hc3;
    public ArrayList<Node<T,D>> array;

    public Table(){
        Node empty = null;
        number = 10;
        array = new ArrayList<>();
        big = 0;

        for(j=0;j<number;j++){
            array.add(empty);
        }
    }

    public final int hashCode(T text) {
        int hashcodee = 1;
        int num = 11;
        char[] array = text.toString().toCharArray();
        for (char c : array) {
            hashcodee = hashcodee * num + c;
        }
        return Math.abs(hashcodee);

    }

    public  D delete(T text){

        hc = hashCode(text);
        index1 = Math.abs(hc % number);

        Node<T,D> firstNode = array.get(index1);
        Node<T,D> node = null;
        while(firstNode != null){
            if(firstNode.text.equals(text) && hc == firstNode.hashCode) {
                System.out.print("Zaznam s hodnotou "+firstNode.data+" bol vymazany z linked listu");
                print(text);
                break;
            }
            node = firstNode;
            firstNode = firstNode.next;

        }
        if(firstNode == null) {
            System.out.println("Zaznam nebol najdeny");
            return null;
        }
        big--;
        if(node != null)
            node.next = firstNode.next;
        else
            array.set(index1,firstNode.next);
        System.out.print("Zaznam s hodnotou "+firstNode.data+" bol vymazany ! ");
        print(text);
        return firstNode.data;
    }

    public D search(T text){
        hc2 = hashCode(text);
        index2 = Math.abs(hc2 % number);
        Node<T,D> firstNode = array.get(index2);

        while(firstNode != null){
            if(firstNode.text.equals(text) && firstNode.hashCode == hc2) {
                System.out.print("Data boli najdene s klucom - ");
                print(text);
                return firstNode.data;
                }
            firstNode = firstNode.next;
            if(firstNode == null) {
                return null;
            }
        }
        System.out.println("Data neboli najdene ! ");
        return null;
    }

    public void insert(T text, D data){
        Node empty = null;
        hc3 = hashCode(text);
        index3 = Math.abs(hc3 % number);

        Node<T,D> firstNode = array.get(index3);

        while(firstNode != null){
            T tempText = firstNode.text;
            D tempData = firstNode.data;
            if(firstNode.text.equals(text) && firstNode.hashCode == hc3){
                firstNode.data = data;
                System.out.println("Dany prvok sa tu uz nachadza, upravili sme jeho hodnotu na "+data);
                return;
            }
            firstNode = firstNode.next;
        }

        big = 1 + big;
        firstNode = array.get(index3);
        Node<T,D> node = new Node<T,D>(text,data,hc3);
        node.next = firstNode;
        array.set(index3, node);
        System.out.print("Zaznam bol pridany ");
        print(text,data);

        if((float)big / number >= 0.7){
            ArrayList<Node<T,D>> a = array;
            array = new ArrayList<>();
            number = 2 * number;
            big = 0;
            j = 0;
            while(j<number){
                array.add(empty);
                j++;
            }
            for(Node<T,D> head : a){
                while(head !=null){
                    insert(head.text,head.data);
                    head = head.next;
                }
            }
        }
    }

    public void print(T text,D data){
        if(text == null || data == null)
            return;
        else
            System.out.println("{Text:"+text+" | Data:"+data+"}");
    }

    public void print(T text){
        if(text == null)
            return;
        else
            System.out.println("{Text:"+text+"}");
    }

}
