package com.company;

public class Node {
    int height;
    int data;
    int color = 0; //red = 0 black = 1
    Node ancestor;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.color = color;
    }
}
