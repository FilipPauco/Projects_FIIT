package tree;

public class Node {
    int data;
    int height;
    Node right;
    Node left;

    public Node(int data){
        this.data = data;
        this.height = 1;
    }
}
