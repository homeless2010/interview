package practice.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 *
 * @author c30023520
 */
public class Stack_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] resultArr = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                resultArr[pop] = i - pop;
            }
            stack.push(i);
        }
        return resultArr;
    }

    public static void main(String[] args) {
        int[] tempArr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] dailyTemperatures = new Stack_739().dailyTemperatures(tempArr);
        for (int i = 0; i < dailyTemperatures.length; i++) {
            System.out.print(dailyTemperatures[i]);
        }
    }

}
