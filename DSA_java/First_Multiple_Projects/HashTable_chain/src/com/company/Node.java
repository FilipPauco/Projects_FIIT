package com.company;

public class Node<T,D> {
    T text;
    D data;
    int hashCode;

    Node<T,D> next;

    public Node(T text,D data, int hashCode){
        this.text = text;
        this.data = data;
        this.hashCode = hashCode;
    }
}
