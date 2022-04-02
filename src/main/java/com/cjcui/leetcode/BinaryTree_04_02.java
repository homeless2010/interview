package com.cjcui.leetcode;

/**
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/
 */
public class BinaryTree_04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return tree(0, nums.length - 1, nums);
    }

    TreeNode tree(int begin, int end, int[] nums) {
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = tree(begin, mid - 1, nums);
        root.right = tree(mid + 1, end, nums);
        return root;
    }
}
