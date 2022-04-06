package practice.test;

/**
 * https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class PrefixSum_1413 {
    public int minStartValue(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int sum = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            if (prefixSum[i] + sum <= 0) {
                sum += Math.abs(prefixSum[i] + sum) + 1;
            }
        }
        return sum == 0 ? 1 : sum;
    }

    public static void main(String[] args) {
        new PrefixSum_1413().minStartValue(new int[]{-3, 2, -3, 4, 2});
    }
}
