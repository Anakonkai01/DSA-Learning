package DSA_Java.DataStructure.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.QueryEval;

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

    public static TreeNode insert(TreeNode root, int data) {
        // check if the tree is empty, then newNode is the root
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        // create a queue to traverse the tree and find the position to insert
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add the root the queue
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            // check left child
            if (temp.left == null) {
                TreeNode newNode = new TreeNode(data);
                temp.left = newNode;
                break;
            } else {
                queue.offer(temp.left); // add left child to queue because it not empty
            }

            // check right child
            if (temp.right == null) {
                TreeNode newNode = new TreeNode(data);
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

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add the root to the queue
        while (!queue.isEmpty()) {
            // take the first one out;
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");

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
    public static void postorderTraversal(TreeNode root) { // left -> right -> root
        if (root == null)
            return;
        postorderTraversal(root.left);

        postorderTraversal(root.right);

        System.out.print(root.val + " ");
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
    public static TreeNode inverseTreeNode_Loop(TreeNode root) {
        // kiem tra root
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add root vao danh sach
        while (!queue.isEmpty()) {
            TreeNode currentTreeNode = queue.poll();

            // swap
            TreeNode temp = currentTreeNode.left;
            currentTreeNode.left = currentTreeNode.right;
            currentTreeNode.right = temp;

            // neu ko null thi them vao list de swap
            if (currentTreeNode.left != null)
                queue.offer(currentTreeNode.left);
            if (currentTreeNode.right != null)
                queue.offer(currentTreeNode.right);
        }
        return root;
    }

    public static TreeNode inverseTreeNode_Recursion(TreeNode root) {
        if (root == null)
            return null;

        TreeNode node = new TreeNode(root.val);
        node.left = inverseTreeNode_Recursion(node.right);
        node.right = inverseTreeNode_Recursion(node.left);

        return node;
    }

    public static int maxDepth_DFS(TreeNode root){
        if(root == null) return 0;
        int left = 1 + maxDepth_DFS(root.left);
        int right = 1 + maxDepth_DFS(root.right);
        return Math.max(left,right);
    }

    public static int maxDepth_BFS(Node root) { // cần cải thiện vì mỗi độ rộng của mỗi tầng = chính size của queue
        if (root == null)
            return 0;

        int maxLength = 0;

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> nextQueue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                // System.out.print(temp.data+" ");
                if (temp.left != null)
                    nextQueue.offer(temp.left);
                if (temp.right != null)
                    nextQueue.offer(temp.right);
            }
            // System.out.println();
            maxLength++;
            queue.addAll(nextQueue);
            nextQueue.clear();
        }

        return maxLength;
    }

    public static boolean BinarySearchTree(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (val == node.val) {
                return true;
            } else if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;

    }

    public static TreeNode insert_BinaryTree_ForBSF_Loop(TreeNode root, int val) {
        /*
         * quy luật là left < root < right
         */

        if (root == null) {
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }

        TreeNode temp = root;
        TreeNode rootOfTempNode = null; // tracking thằng trước đó 1 bước
        while (temp != null) {
            rootOfTempNode = temp;
            if (temp.val > val) {
                temp = temp.left;
            } else if (temp.val < val) {
                temp = temp.right;
            } else {
                return root; // đã có sẵn trong cây nên ko cần thêm nữa
            }
        }
        TreeNode newNode = new TreeNode(val);
        if (rootOfTempNode.val > val) {
            rootOfTempNode.left = newNode;
        } else {
            rootOfTempNode.right = newNode;
        }
        return root;
    }

    public static TreeNode insert_BinaryTree_ForBSF_Recursion(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val > val)
            root.left = insert_BinaryTree_ForBSF_Recursion(root.left, val);
        else if (root.val < val)
            root.right = insert_BinaryTree_ForBSF_Recursion(root.right, val);
        return root;
    }

    // public static int diameterOfBinaryTree(TreeNode root){
    // int longestPath_between_twoNode = 0;
    // // i will use BFS
    // if(root == null) return 0;

    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);
    // while(!queue.isEmpty()){

    // }

    // return longestPath_between_twoNode;
    // }

    public static int diameterOfBinaryTree_DFS(TreeNode root) {
        int[] result = new int[1];
        Find_Using_DFS(root, result);
        return result[0];
    }

    // cần làm lại cái này vì ko phải tự bản thân làm ra
    public static int Find_Using_DFS(TreeNode node, int[] result) {
        if (node == null)
            return 0;
        int left = Find_Using_DFS(node.left, result);
        int right = Find_Using_DFS(node.right, result);
        result[0] = Math.max(result[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static boolean isBalanced(TreeNode root) {
        // chiều cao trái và phải của mỗi subtrees là ko quá 1
        boolean[] check = new boolean[1];
        check[0] = true;
        check_balance_DFS(root, check);
        return check[0];
    }

    public static int check_balance_DFS(TreeNode root,boolean[] check){
        if( root == null) return 0;
        int left = 1 + check_balance_DFS(root.left, check);
        int right = 1 + check_balance_DFS(root.right, check);
        if(Math.abs(left - right) > 1) check[0] = false;
        return Math.max(left,right);
    }


    public static boolean isSameTree_DFS(TreeNode p, TreeNode q){
        // dung DFS
        if(p == null && q == null){
            return true;
        }
        else if(p != null && q != null && q.val == p.val){
            return isSameTree_DFS(p.left, q.left) && isSameTree_DFS(p.right, q.right);
        }
        return false;
    }

    public static boolean isSameTree_BFS(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode temp1 = queue1.poll();
            TreeNode temp2 = queue2.poll();
            if(temp1 == null && temp2 != null) return false;
            if(temp2 == null && temp1 != null) return false;
            if(temp1 != null && temp2 != null){
                if(temp1.val != temp2.val) return false;
                queue1.offer(temp1.left);
                queue1.offer(temp1.right);
                queue2.offer(temp2.left);
                queue2.offer(temp2.right);
            }
        }
        return true;
        
    }
    public static void main(String[] args) {
        TreeNode root1 = null;
        TreeNode root2 = null;

        
    }
}
