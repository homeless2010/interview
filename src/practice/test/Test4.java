package practice.test;

public class Test4 {
    public static void main(String[] args) {
        int[] ayy = {4, 1, 3, 7, 2};
        int length = ayy.length;
        /*for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                int temp = ayy[j + 1];
                if (ayy[j] < ayy[j + 1]) {
                    ayy[j + 1] = ayy[j];
                    ayy[j] = temp;
                }
            }
        }*/
        for (int i = 0; i < length - 1; i++) {
            int temp = ayy[i];
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (temp > ayy[j]) {
                    temp = ayy[j];
                    index = j;
                }
            }
            ayy[index] = ayy[i];
            ayy[i] = temp;
        }
        for (int i = 0; i < ayy.length; i++) {
            System.out.println(ayy[i]);
        }
    }
}
