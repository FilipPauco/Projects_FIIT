package com.company;

public class tree {
    Node root;
    Node father;
    Node grandfather;
    Node uncle;
    int x;
    int c;

    public Node input(Node root, Node node){
        if(root != null){
            if(root.data > node.data){
                root.left = input(root.left,node);
                root.left.ancestor = root;
            }
            if(root.data < node.data){
                root.right = input(root.right,node);
                root.right.ancestor = root;
            }
            return root;

        }
        else{
            return node;
        }
    }

    public int max(int a,int b){
        int c = a > b ? a : b;
        return c;
    }

    public void lR(Node node){
        Node right = node.right;
        node.right = right.left;
        right.ancestor = node;

        if(node.right != null){
            node.right.ancestor =node;
        }

        if(node.ancestor != null){
            if(node == node.ancestor.left){
                node.ancestor.left = right;
            }
            else{
                node.ancestor.right = right;
            }
        }
        else{
            this.root = right;
        }
        right.left = node;
        node.ancestor = right;

    }

    public void rR(Node node){
        Node left = node.left;
        node.left = left.right;
        left.ancestor = node.ancestor;

        if(node.left != null){
            node.left.ancestor = node;
        }

        if(node.ancestor != null){
            if(node.ancestor.left == node){
               node.ancestor.left = left;
            }
            else{
                node.ancestor.right = left;
            }
        }
        else{
            this.root = left;
        }
        left.right = node;
        node.ancestor = left;
    }

    public void coloring(Node node){
        while(node != this.root && node.color != 1 && node.ancestor.color == 0){
            father = node.ancestor;
            grandfather = father.ancestor;
            if(father == grandfather.left){
                uncle = grandfather.right;
                if(uncle != null && uncle.color == 0){
                    max(node.data,root.data);
                    grandfather.color = 0;
                    father.color = 1;
                    uncle.color = 1;
                    node = grandfather;
                }
                else{
                    if(node == father.right){
                        max(node.data,root.data);
                        lR(father);
                        node = father;
                        father = node.ancestor;
                    }
                    rR(grandfather);
                        x = father.color;
                        father.color = grandfather.color;
                        grandfather.color = x;
                        node = father;
                }
            }
            else{
                uncle = grandfather.left;
                if(uncle != null && uncle.color == 0){
                    max(node.data,root.data);
                    grandfather.color = 0;
                    father.color = 1;
                    uncle.color = 1;
                    node = grandfather;
                }
                else{
                    if(node == father.left){
                        max(node.data,root.data);
                        rR(father);
                        node = father;
                        father = node.ancestor;
                    }
                    max(node.data,root.data);
                    lR(grandfather);
                    x = father.color;
                    father.color = grandfather.color;
                    grandfather.color = x;
                    node = father;

                }
            }
        }
    }
    public void post(Node root){
        if (root != null){
            post(root.left);
            post(root.right);
            System.out.print(root.data+"  ");
        }
        else{
            return;
        }
    }

    public void search(Node root,int data){
        if(root == null){
            System.out.println("Prvok nebol bol najdeny");
            return;
        }
        if(data < root.data){
            search(root.left,data);
        }
        if(data > root.data){
            search(root.right,data);
        }
        if(root.data == data){
            System.out.println("Prvok "+data+" bol najdeny");
            return;
        }

    }

    public void insert(int data){
        Node node = new Node(data);
        this.root = input(this.root,node);
        coloring(node);
        this.root.color = 1;
    }

}
