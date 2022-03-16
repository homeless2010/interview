package com.cjcui.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class BinarySearch {
    public int maxDepth(TreeNode root) {
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Integer pop1 = level.pop();
            max = Math.max(pop1, max);
            if (pop.left != null) {
                stack.push(pop.left);
                level.push(pop1 + 1);
            }
            if (pop.right != null) {
                stack.push(pop.right);
                level.push(pop1 + 1);
            }
        }
        return max;
    }


    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> dequen = new LinkedList<>();
        dequen.offer(root);
        int count = 0;
        while (!dequen.isEmpty()) {
            int size = dequen.size();
            while (size-- > 0) {
                TreeNode poll = dequen.poll();
                if (poll.left != null) {
                    dequen.offer(poll.left);
                }
                if (poll.right != null) {
                    dequen.offer(poll.right);
                }
            }
            count++;
        }
        return count;
    }
}
