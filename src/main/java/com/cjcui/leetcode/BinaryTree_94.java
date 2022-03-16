package com.cjcui.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        xxxxx(root, list);
        return  list;
    }

    void xxxxx(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            xxxxx(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            xxxxx(root.right, list);
        }
    }
}
