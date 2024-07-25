package DSA_Java.DataStructure.Tree;

public class Node {
    int data;
    Node right;
    Node left;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public Node(int data, Node right, Node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

}
