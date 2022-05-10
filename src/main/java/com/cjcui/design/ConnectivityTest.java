package practice.exam;

import java.util.HashSet;
import java.util.Set;

//[] [] [] [] [] []
//[] [] [] [] [] []
//
//num=5
//operations=[[0,2],[0,1],[1,2],[0,2],[0,1]]
//output:[1,1,0,0,1]
//
//下电 增加阻断点
//上电 减少阻断点
//阻断电个数>0
public class ConnectivityTest {
    public int[] checkConnectivity(int num, int[][] operations) {
        Set<Integer> broken = new HashSet<Integer>();
        int[] result = new int[operations.length];
        for (int i = 0; i < operations.length; i++) {
            update(broken, operations[i][0] * num + operations[i][1]);
            int res = operate(broken, num);
            result[i] = res;
        }
        return result;
    }

    private int operate(Set<Integer> broken, int num) {
        for (int idx : broken) {
            if (broken.contains(idx + num) || broken.contains(idx - num) || broken.contains(idx + num + 1) || broken.contains(idx - num + 1)) {
                return 0;
            }
        }
        return 1;
    }

    private void update(Set<Integer> broken, int idx) {
        if (broken.contains(idx)) {
            broken.remove(idx);
        } else {
            broken.add(idx);
        }
    }
}
