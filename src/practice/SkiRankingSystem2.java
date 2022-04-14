package practice.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Li
 */
//---------------------------------------------//
//遇括号用栈
//TreeMap TreeSet多用
//细心 多思考
//换角度
//---------------------------------------------//
public class SkiRankingSystem2 {
    public static void main(String[] args) {
        String str = "((()))(())()";
//        str = str.replaceAll("\\(\\)", "");
        int count = 0;
        while (str.length() != 0) {
            str = str.replaceAll("\\(\\)", "");
            count++;
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx" + count);
        SkiRankingSystem sss = new SkiRankingSystem();

//        sss.addRecord(20, 8);
//        sss.addRecord(22, 6);
//        sss.addRecord(20, 6);
//
//        int[] it1 = sss.getTopAthletes(4);
//        for (int i = 0; i < it1.length; i++) {
//            System.out.println("***" + it1[i]);
//        }
//        int[] it2 = sss.queryTop3Record(20);
//        for (int i = 0; i < it2.length; i++) {
//            System.out.println(it2[i]);
//        }
    }

    TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
    HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

    public SkiRankingSystem2() {

    }

    public void addRecord(int userId, int duration) {
        if (tm.get(duration) == null) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(userId);
            tm.put(duration, al);
        } else {
            tm.get(duration).add(userId);
        }
        if (hm.get(userId) == null) {
            ArrayList<Integer> ts = new ArrayList<>();
            ts.add(duration);
            hm.put(userId, ts);
        } else {
            hm.get(userId).add(duration);
        }
    }

    public int[] getTopAthletes(int num) {
        ArrayList<Integer> al2 = new ArrayList<>();
        int count = 0;
        boolean flag = false;
        for (Integer it : tm.keySet()) {
            if (flag) {
                break;
            }
            ArrayList<Integer> al = tm.get(it);
            for (int i = 0; i < al.size(); i++) {
                if (!al2.contains(al.get(i))) {
                    al2.add(al.get(i));
                    count++;
                }
                if (count == num) {
                    flag = true;
                    break;
                }
            }
        }
        int cou = al2.size() < num ? al2.size() : num;
        int[] end = new int[cou];
        for (int i = 0; i < cou; i++) {
            end[i] = al2.get(i);
        }
        return end;
    }

    public int[] queryTop3Record(int userId) {

        ArrayList<Integer> aal = hm.get(userId);

        aal.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int get = aal.size() < 3 ? aal.size() : 3;
        int[] result = new int[get];
        for (int i = 0; i < get; i++) {
            result[i] = aal.get(i);
        }
        return result;
    }

}
