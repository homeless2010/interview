package com.cjcui.design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 下棋
 */
public class Chess {

    public int[] goGame(int num, int cnt, int time, int[][] people) {
        int peopleNum = people.length;
        int[] result = new int[peopleNum];
        Deque<int[]> olderQ = new LinkedList<>();
        Deque<int[]> cntQ = new LinkedList<>();
        int olderNum = num - cnt;
        for (int i = 0; i < peopleNum; i++) {
            release(time, people, result, olderQ, cntQ, i);
            if (people[i][1] == 1) {
                if (game(people, result, cntQ, i) || game(people, result, olderQ, i) || wait(cnt, cntQ, i)) {
                    continue;
                }
            } else if (game(people, result, olderQ, i)) {
                continue;
            }
            wait(olderNum, olderQ, i);
        }
        for (int i = 0; i < peopleNum; i++) {
            if (result[i] == 0) {
                result[i] = -1;
            }
        }
        return result;
    }

    //超时
    private void release(int time, int[][] people, int[] result, Deque<int[]> olderQ, Deque<int[]> cntQ, int index) {
        if (!olderQ.isEmpty() && olderQ.peekLast()[1] != -1 && people[index][0] - result[olderQ.peekLast()[1]] >= time) {
            olderQ.pollLast();
        }
        if (!cntQ.isEmpty() && cntQ.peekLast()[1] != -1 && people[index][0] - result[cntQ.peekLast()[1]] >= time) {
            cntQ.pollLast();
        }
    }

    //
    private boolean game(int[][] people, int[] result, Deque<int[]> inQ, int index) {
        if (!inQ.isEmpty() && inQ.peekFirst()[1] == -1) {
            inQ.peekFirst()[1] = index;
            result[index] = people[index][0];
            result[inQ.peekFirst()[0]] = people[index][0];
            return true;
        }
        return false;
    }

    //等待
    private boolean wait(int inNum, Deque<int[]> inQ, int index) {
        if (inQ.size() < inNum) {
            inQ.offerFirst(new int[]{index, -1});
            return true;
        }
        return false;
    }
}
