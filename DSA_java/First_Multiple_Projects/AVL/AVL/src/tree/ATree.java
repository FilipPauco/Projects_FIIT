package tree;

public class ATree {
    Node root = null;

    public int height(Node node){
        if (node != null)
            return node.height;
        else{
            return 0;
        }
    }

    public int max(int num1, int num2){
        int num;
        num = num1 > num2 ? num1 : num2;
        return num;
    }

    public int min(int num1, int num2){
        int num;
        num = num1 > num2 ? num1: num2;
        return num;
    }

    public Node min(Node node){
        Node tempomary = node;
        while(tempomary.left != null){
            tempomary = tempomary.left;
        }
        return tempomary;

    }

    public Node rR(Node node){
        Node left_n = node.left;
        Node right_s = left_n.right;
        left_n.right = node;
        node.left = right_s;
        node.height= 1 + max(height(node.left),height(node.right));
        left_n.height = 1+max(height(left_n.left),height(node.right));
        return left_n ;
    }

    public Node lR(Node node){
        Node right_n = node.right;
        Node left_s = right_n.left;
        right_n.left = node;
        node.right = left_s;
        node.height = 1+max(height(node.left),height(node.right));
        right_n.height = 1+max(height(right_n.left), height(right_n.right));
        return right_n;
    }

    public int balance(Node node){
        if(node != null){
            return height(node.left) - height(node.right);
        }
        else{
            return 0;
        }
    }

    public Node insert(Node node, int data){
        int value;
        if(node != null){
            if(node.data > data){
                node.left = insert(node.left, data);
            }
            else if(node.data < data){
                node.right = insert(node.right, data);
            }
            else if(node.data == data){
                return node;
            }

            node.height = 1 + max(height(node.left), height(node.right));
            value = balance(node);

            if(value > 1 && data > node.left.data){
                node.left = lR(node.left);
                return rR(node);
            }
            if(value > 1 && data < node.left.data){
                return rR(node);
            }
            if(value < -1 && data < node.right.data){
                node.right = rR(node.right);
                return lR(node);
            }
            if(value < -1 && data > node.right.data){
                return lR(node);
            }
            return node;
        }
       return new Node(data);
    }
    void post(Node node){
        if (node == null){
            return;
        }
        else{
            post(node.left);
            post(node.right);
            System.out.print(node.data + " ");
        }
    }

    void search(Node node,int a){
        if(node == null){
            System.out.println("Prvok sa nenachadza v strome !");
            return;
        }
        if(node.data == a){
            System.out.println("Prvok bol najedny !");
            }
        if(node.data > a){
            search(node.left, a);
        }
        if(node.data < a){
            search(node.right, a);
        }
    }

    public Node deleteNode(Node node, int data){
        Node temp = null;

        if(node != null){
            if(node.data > data){
                node.left = deleteNode(node.left,data);
            }
            else if(node.data < data){
                node.right = deleteNode(node.right,data);
            }
            else{
                if((node.left == null) || (node.right == null)){
                    if(node.right != null){
                        temp = node.right;
                    }
                    else if(node.left != null){
                        temp = node.left;
                    }
                    if(temp == null){
                        temp = node;
                        node = null;
                    }
                    else{
                        node = temp;
                    }
                    temp = null;
                }
                else{
                    temp = min(node.right);
                    node.data = temp.data;
                    node.right = deleteNode(node.right, temp.data);
                }
            }
            if(node == null){
                return node;
            }
            node.height = 1+max(height(node.left),height(node.right));
            int value = balance(node);

            if(value > 1 && balance(node.left) >= 0){
                return rR(node);
            }
            if(value > 1 && balance(node.left) < 0){
                node.left = lR(node.left);
                return rR(node);
            }

            if(value < -1 && balance(node.right) <= 0){
                return lR(node);
            }

            if(value < -1 && balance(node.right) > 0){
                node.right = rR(node.right);
                return lR(node);
            }

            return node;
        }
        else{
            return node;
        }
    }

    boolean repetition = true;
    public void delete(Node node, int data){
        if(this.root == null){
            return;
        }
        else{
            this.root = deleteNode(this.root, data);
        }
    }
}
