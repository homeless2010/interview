package com.cjcui.practice;

public class Solution {
    public int getMaxDepth(String inputStr) {
        int deep = 0;
        int lastIndexOf = inputStr.lastIndexOf("(");
        char[] chars = inputStr.toCharArray();
        for (int i = 0; i < lastIndexOf + 1; i++) {
            if (chars[i] == ')') {
                deep--;
            } else if (chars[i] == '(') {
                deep++;
            }
        }
        return deep;
    }

    public int getMaxDepth2(String inputStr) {
        int deep = 0;
        int lastIndexOf = inputStr.lastIndexOf("(");
        char[] chars = inputStr.toCharArray();
        for (int i = 0; i < lastIndexOf + 1; i++) {
            if (chars[i] == ')') {
                deep--;
            } else if (chars[i] == '(') {
                deep++;
            }
        }
        return deep;
    }

    public static void main(String[] args) {
        //(  () (( )) )    (( ))
        int maxDepth = new Solution().getMaxDepth("((())(()))(())");
        System.out.println(maxDepth);
    }
}
