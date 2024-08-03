package DSA_Java.DataStructure.Tree;

public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    
}
