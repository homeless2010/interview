package com.cjcui.leetcode;

public class DP_17_16 {
    public int massage(int[] nums) {
        //每个预约i 1：接 2：不接
        //接：dpi接 = dpi-1不接 + i用时
        //不接： dpi不接 = Max（dpi-1接,dpi-1不接）
        //通项公式Max(dpi接,dpi不接)
        //
        if (nums.length == 0) {
            return 0;
        }
        int dpBujie = 0;
        int dpJie = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = dpBujie;
            dpBujie = Math.max(dpJie, dpBujie);
            dpJie = temp + nums[i];
        }
        return Math.max(dpBujie, dpJie);
    }
}
