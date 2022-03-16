public class Test2 {
    public static void main(String[] args) {
        new Test2().sort();
    }

    public void sort() {
        int[] array = {4, 6, 7, 1, 2, 5, 9};
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = k + 1; j < length; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        System.out.println(array);
    }
}
