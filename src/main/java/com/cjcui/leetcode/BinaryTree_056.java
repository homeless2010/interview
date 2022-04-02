package com.cjcui.leetcode;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/opLdQz/
 */
public class BinaryTree_056 {
    public static void main(String[] args) {
        System.out.println(11 << 1);
    }

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        Deque<TreeNode> stk = new LinkedList<>();
        stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode poll = stk.poll();
            map.put(poll.val, k - poll.val);
            if (poll.left != null) {
                stk.add(poll.left);
            }
            if (poll.right != null) {
                stk.add(poll.right);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.containsKey(k - integer) && (integer << 2 != k)) {
                return true;
            }
        }
        return false;
    }

    List<Integer> tree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        stk.add(root);
        while (!stk.isEmpty()) {
            TreeNode poll = stk.poll();
            list.add(poll.val);
            if (poll.left != null) {
                stk.add(poll.left);
            }
            if (poll.right != null) {
                stk.add(poll.right);
            }
        }
        return list;
    }
}
