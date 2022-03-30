package com.cjcui.leetcode;

/**
 * https://leetcode-cn.com/problems/matrix-diagonal-sum/
 */
public class MatrixDiagonalSum_1572 {
    public int diagonalSum(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int sum = 0;
        for (int i = 0, j = 0; (i < row) && (j < col); i++, j++) {
            sum += mat[i][j];
            if (j == (col - j - 1)) {

            } else {
                sum += mat[i][col - j - 1];
            }
        }
        return sum;
    }
}
