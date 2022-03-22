package practice.test;

public class Array_16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] ret;
        if (k == 0) {
            ret = new int[0];
        } else if (shorter == longer) {
            ret = new int[]{k * shorter};
        } else {
            ret = new int[k + 1];
            for (int i = k; i >= 0; i--) {
                ret[k - i] = i * shorter + (k - i) * longer;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
