package practice.test;

import java.util.Set;
import java.util.TreeSet;

public class BinaryTree {
    int max = 0;

    public int maxDepth(TreeNode root) {
        int dfs = dfs(root);
        return dfs;
    }


    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left),dfs(node.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(7);
//      root.left = treeNode2;
//      treeNode2.left = treeNode6;
        root.right = treeNode3;
//        treeNode3.left = treeNode4;
//        treeNode3.right = treeNode5;
        int i = new BinaryTree().maxDepth(root);
        System.out.println(i);
    }
}
