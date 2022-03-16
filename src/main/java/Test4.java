import java.util.*;

public class Test4 {
    //    给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
//
//
//    示例：
//
//    输入：[1,12,-5,-6,50,3], k = 4
//    输出：12.75
//    解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//    提示：
//
//            1 <= k <= n <= 30,000。
//    所给数据范围 [-10,000，10,000]
    public static void main(String[] args) {
        int[] arr = {1, 12, -5, -6, 50, 3};
        double avgMax = new Test4().getAvgMax(arr, 4);
        System.out.println(avgMax);
    }


    public double getAvgMax(int[] arr, int k) {
        int length = arr.length;
        Set set = new TreeSet();
        for (int i = 0; i < length - k; i++) {
            int[] tempArr = new int[k];
            for (int j = 0; j < k; j++) {
                tempArr[j] = arr[i + j];
            }
            OptionalDouble average = Arrays.stream(tempArr).average();
            set.add(average.getAsDouble());
        }
        double d = 0d;//0l 注意
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            d = (double) iterator.next();
        }
        return d;
    }

}
