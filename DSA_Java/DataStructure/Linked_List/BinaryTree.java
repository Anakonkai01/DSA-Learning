package DSA_Java.DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

// Thuật toán chèn một nút vào Cây nhị phân:
// Kiểm tra xem có nút nào trong cây nhị phân bị thiếu con trái hay không. Nếu một nút như vậy tồn tại thì hãy chèn nút mới làm nút con bên trái của nó.
// Kiểm tra xem có nút nào trong cây nhị phân bị thiếu con phải không. Nếu một nút như vậy tồn tại thì hãy chèn nút mới làm nút con bên phải của nó.
// Nếu chúng ta không tìm thấy bất kỳ nút nào bị thiếu con trái hoặc con phải, thì hãy tìm nút thiếu cả hai nút con và chèn nút đó làm nút con trái hoặc phải của nó.

public class BinaryTree {
    public static Node insert(Node root, int data) {
        // check if the tree is empty, then newNode is the root
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // create a queue to traverse the tree and find the position to insert
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // add the root the queue
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            // check left child
            if (temp.left == null) {
                Node newNode = new Node(data);
                temp.left = newNode;
                break;
            } else {
                queue.offer(temp.left); // add left child to queue because it not empty
            }

            // check right child
            if (temp.right == null) {
                Node newNode = new Node(data);
                temp.right = newNode;
                break;
            } else {
                queue.offer(temp.right); // the same of left child
            }
        }
        return root;
    }

    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); // add the root to the queue
        while (!queue.isEmpty()) {
            // take the first one out;
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null)
                queue.offer(tempNode.left);
            if (tempNode.right != null)
                queue.offer(tempNode.right);
        }
        System.out.println();
    }

    // =)) nhuc dau ve lo
    public static void preorderTraversal(Node root) { // root -> left -> right
        if (root == null)
            return;
        System.out.print(root.data + " ");

        preorderTraversal(root.left);

        preorderTraversal(root.right);
    }

    //
    public static void postorderTraversal(Node root) { // left -> right -> root
        if (root == null)
            return;
        postorderTraversal(root.left);

        postorderTraversal(root.right);

        System.out.print(root.data + " ");
    }

    public static void inorderTraversal(Node root) { // left -> root -> right
        if (root == null)
            return;

        inorderTraversal(root.left);

        System.out.print(root.data + " ");

        inorderTraversal(root.right);
    }

    public static boolean breathFirstTraversal(Node root, int data) {
        if (root == null)
            return false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.data == data)
                return true;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return false;
    }


    // su dung vong lap
    public static TreeNode inverseTreeNode_Loop (TreeNode root){
        // kiem tra root 
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add root vao danh sach 
        while(!queue.isEmpty()){
            TreeNode currentTreeNode = queue.poll();
            
            // swap
            TreeNode temp = currentTreeNode.left;
            currentTreeNode.left = currentTreeNode.right;
            currentTreeNode.right = temp;

            // neu ko null thi them vao list de swap
            if(currentTreeNode.left != null) queue.offer(currentTreeNode.left);
            if(currentTreeNode.right != null) queue.offer(currentTreeNode.right);
        }
        return root;
    }

    public static TreeNode inverseTreeNode_Recursion (TreeNode root){
        if(root == null) return null;

        TreeNode node = new TreeNode(root.val);
        node.left = inverseTreeNode_Recursion(node.right);
        node.right = inverseTreeNode_Recursion(node.left);
        
        return node;
    }

    // public static int maxDepth(TreeNode root) {

    // }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 4);
        root = insert(root, 5);
        root = insert(root, 6);
        root = insert(root, 7);
        root = insert(root, 8);
        root = insert(root, 9);
        root = insert(root, 10);
        root = insert(root, 11);
        root = insert(root, 12);
        root = insert(root, 13);
        root = insert(root, 14);
        root = insert(root, 15);
        root = insert(root, 16);

        System.out.println(breathFirstTraversal(root, 1100));
        levelOrderTraversal(inverseTreeNode_Loop(root));
    }
}
