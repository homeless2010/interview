package practice.test;

import java.util.ArrayList;
import java.util.List;

public class Tttttttt {
    List<String> getMediumNameList(String[][] employeeList) {
        List<String> ret = new ArrayList<>();
        int[] arr = new int[employeeList.length];
        for (int i = 0; i < employeeList.length; i++) {
            arr[i] = Integer.parseInt(employeeList[i][1]);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int tmp = arr[j];
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        int min = 0;
        if ((employeeList.length & 1) == 0) {
            min = Math.min(arr[employeeList.length / 2 - 1], arr[employeeList.length / 2]);
        } else {
            min = arr[employeeList.length / 2];
        }
        for (int i = employeeList.length - 1; i >= 0; i--) {
            if (Integer.parseInt(employeeList[i][1]) == min) {
                ret.add(employeeList[i][0]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[][] fff = {{"sss", "2"}, {"sss", "1"}, {"sss", "5"}, {"jjjjj", "3"}, {"sss", "4"}};
        new Tttttttt().getMediumNameList(fff);
    }
}
