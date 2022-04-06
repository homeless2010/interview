package com.cjcui.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class BinaryTree_993 {
    //层序遍历
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode poll = deque.poll();
                List<Integer> levelList = new ArrayList<>();
                if (poll.left != null) {
                    deque.add(poll.left);
                    levelList.add(poll.left.val);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                    levelList.add(poll.right.val);
                }
                list.add(levelList);
                size--;
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(x) || list.get(i).contains(y)) {
                    set.add(i);
                }
            }
            if (set.size() == 2) {
                return true;
            }
            set.clear();
            list.clear();
        }
        return false;
    }
}
