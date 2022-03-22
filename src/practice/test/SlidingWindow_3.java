package practice.test;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口 最长字串
 */
public class SlidingWindow_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while ((right + 1 < s.length()) && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
