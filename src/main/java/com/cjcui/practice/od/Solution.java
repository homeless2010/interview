package com.cjcui.practice.od;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public int subString(String str) {
        List<String> list = new ArrayList<>();
        int length = str.length();
        // ---找所有连续子串----//
        // 第一步先找连续子串,从左至右找,先从第一个字符开始向后找至字符串尾部，然后第二个...
        // 两层for循环第一层索引控制起始位置，第二层向后遍历（找第一层起始位置的连续字串）
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String substring = str.substring(i, j);
                list.add(substring);
            }
        }
        int count = 0;
        // ----字串去重 利用hashmap key重复覆盖筛选出无重复字串----//
        Map map = new HashMap();
        for (String s : list) {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                map.put(aChar, null);
            }
            if (map.size() == s.length()) {
                count++;
            }
            map.clear();
        }
        return count;
    }

    public static void main(String[] args) throws ParseException {
        //        new Solution().subString("xbmxbnh");
        //        new Solution().fmtDate("");
        //        System.out.println(new Solution().toHex0or1Number(11));
        int[] arr = {0, 1, 1, 0, 1, 1, 0, 1};
        int[] arr2 = {0, 0, 0, 0, 0, 0, 0, 0};
        int xxx = new Solution().xxx(1, arr2);
        System.out.println(xxx);
    }

    SimpleDateFormat sdf = new SimpleDateFormat("d'st' MMM yyyy", Locale.ENGLISH);

    public String fmtDate(String date) throws ParseException {
        Date parse = sdf.parse("1st Oct 1949");
        System.out.println(parse);
        return "";
    }

    public int toHex0or1Number(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        char[] chars = "011111111011110000000011010101111100010101000011".toCharArray();
        //        for (char aChar : chars) {
        //            if (aChar == '0') {
        //                i++;
        //            } else if (aChar == '1') {
        //                j++;
        //            }
        //        }
        Set seti = new TreeSet();
        for (int k = 0; k < chars.length; k++) {
            int i = 0;
            while (chars[k] == '0') {
                i++;
                if (k < chars.length - 1) {
                    k++;
                } else {
                    break;
                }
            }
            if (i > 1) {
                seti.add(i);
                k--;
            }
        }
        Set setj = new TreeSet();
        for (int k = 0; k < chars.length; k++) {
            int j = 0;
            while (chars[k] == '1') {
                j++;
                if (k < chars.length - 1) {
                    k++;
                } else {
                    break;
                }
            }
            if (j > 1) {
                setj.add(j);
                k--;
            }
        }
        // 分别找出seti setj中最大值 比较返回最大的
        return 0;
    }

    int sum;
    boolean res;

    public int dfs(TreeNode cur, TreeNode root) {
        if (cur == null) {
            return 0;
        }
        int left = dfs(cur.left, root);
        int right = dfs(cur.right, root);
        if ((left + right + cur.val) * 2 == sum && cur != root) {
            res = true;
        }
        return left + right + cur.val;
    }

    int xxx(int target, int[] arr) {
        int index = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (map.containsKey(index) && (i - index == 1)) {
                    map.put(index, i);
                } else {
                    index = i;
                    map.put(i, 0);
                }
            }
        }
        int[] a = new int[map.isEmpty() ? 1 : map.size()];
        int[] b = new int[map.isEmpty() ? 1 : map.size() - 1];
        int i = 0;
        Map.Entry<Integer, Integer> pre = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            a[i] = integerIntegerEntry.getValue() == 0 ? 1 : integerIntegerEntry.getValue() - integerIntegerEntry.getKey() + 1;
            if (i > 0) {
                b[i - 1] = integerIntegerEntry.getKey() - pre.getValue() - 1;
            }
            i++;
            pre = integerIntegerEntry;
        }
        int max = 1;
        for (int i1 = 0; i1 < b.length; i1++) {
            if (b[i1] == 1) {
                max = Math.max(max, a[i1] + a[i1 + 1] + 1);
            }
        }
        Arrays.sort(a);
        return Math.max(max, a[a.length - 1]);
    }
}
