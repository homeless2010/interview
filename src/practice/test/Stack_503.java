package practice.test;

import java.util.Arrays;

/**
 * 单调栈
 *
 * @author c30023520
 */
public class Stack_503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
//		 int[] ret = new int[n];
        int[] ret = {1, 2, 3};
        Arrays.fill(ret, -1);
        System.out.print(ret.length);
        System.out.print(ret[0]);
        System.out.print(ret[1]);
        System.out.print(ret[2]);
        System.out.println();
        System.out.println(6 % 5);
        return null;

    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 4};
        new Stack_503().nextGreaterElements(nums);
    }
}
