public class Test {
    public static void main(String[] args) {
        int[] arry = {4, 6, 1, 6, 7, 8, 1, 4, 5, 3};
        int[] returnArry = new Test().findTopN(arry, 3);
//        Arrays.sort();
        for (int i = 0; i < returnArry.length; i++) {
            System.out.print(returnArry[i] + " ");
        }
    }

    public int[] findTopN(int[] arry, int n) {
        int length = arry.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                }
            }
        }
        int[] returnArray = new int[n];
        for (int i = 0; i < n; i++) {
            returnArray[i] = arry[length - i - 1];
        }
        return returnArray;
    }
}
