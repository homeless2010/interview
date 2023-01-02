package com.cjcui.practice.od;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 系统设计围棋
 */
/*
有一项围棋活动，一共有 num 张围棋桌，分为两种桌：小孩桌和家长桌，其中有 cnt 张小孩桌，其余为家长桌，初始所有围棋桌均空闲。
陆续有人员到围棋区下棋，按到达时刻先后顺序以 [到达时刻，是否为小孩] 格式记录于二维数组 people 中 。是否为小孩 仅为 0 或 1，1 表示小孩， 0 表示家长。

围棋对弈规则如下：

·         1）小孩可使用两种桌，家长仅可使用家长桌；

·         2）优先对弈

o    小孩与最早等待的人员对弈（含两种桌等待的人员）；

o    家长只能与在家长桌等待的人员对弈（等待人员有可能是家长或小孩）；

·         3）若无法对弈，则试图占用一个桌子并等待；若无桌可用，则直接离开

o    小孩优先占用小孩桌，若无小孩桌则可占用家长桌；

o    家长只能占用家长桌；

假设每桌对弈持续 time 单位时间，完成对弈后两人均离开并空出桌子。请计算并返回每位到达人员对弈的开始时刻；对于不能对弈（即离开棋馆或一直等待）的人员，则标识为 -1。

注意： 相同时刻到达的人员，按下标先后顺序依次处理。

示例 1：

输入：
num = 2
cnt = 1
time = 3
people = [[1,0],[1,1],[2,1],[2,0]]

输出：[1,1,-1,-1]

解释：
有 2 张围棋桌，其中 1 张仅面向小孩开放；
[1,0]，时刻 1 ：一位家长到达，占用 1 个家长桌并处于等待中；
[1,1]，时刻 1 ：一位小孩到达，与在时刻 1 等待的家长开始对弈；
[2,1]，时刻 2 ：一位小孩到达，占用 1 个小孩桌并处于等待中，后续没有人加入，不能正常开始；
[2,0]，时刻 2 ：一位家长到达，到达时无空闲桌（家长不能与在小孩桌等待的人员对弈），离开并空出桌子。
因此返回 [1,1,-1,-1]

示例 2：

输入：
num = 3
cnt = 1
time = 4
people=[[1,1],[1,0],[2,0],[2,1],[3,1],[4,1],[4,1],[6,1],[6,0],[7,0]]

输出：[2,2,2,2,4,4,-1,-1,7,7]
 */
public class Go {
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


    private void release(int time, int[][] people, int[] result, Deque<int[]> olderQ, Deque<int[]> cntQ,

                         int index) {

        if (!olderQ.isEmpty() && olderQ.peekLast()[1] != -1

                && people[index][0] - result[olderQ.peekLast()[1]] >= time) {

            olderQ.pollLast();

        }

        if (!cntQ.isEmpty() && cntQ.peekLast()[1] != -1 && people[index][0] - result[cntQ.peekLast()[1]] >= time) {

            cntQ.pollLast();

        }

    }


    private boolean game(int[][] people, int[] result, Deque<int[]> inQ, int index) {

        if (!inQ.isEmpty() && inQ.peekFirst()[1] == -1) {

            inQ.peekFirst()[1] = index;

            result[index] = people[index][0];

            result[inQ.peekFirst()[0]] = people[index][0];

            return true;

        }

        return false;

    }


    private boolean wait(int inNum, Deque<int[]> inQ, int index) {

        if (inQ.size() < inNum) {

            inQ.offerFirst(new int[]{index, -1});

            return true;

        }

        return false;

    }
    /*
    该解法用两个双端队列cntQ和olderQ分别存储小孩桌和家长桌的占用信息；队列每个节点是一个整型数组。

函数wait的作用是处理占桌：占桌时往队列最前面添加一个节点（一维数组），设置数组内容为{index, -1}，index为占桌人的索引，-1标识有个人在等待；通过传递不同的参数（cntQ和olderQ）把小孩占桌和家长占桌的处理代码合一。

函数game寻找等待的人，如果找到则开始对弈；注意并不需要遍历整个队列，只需要查看队列最前端的节点就可以判断出是否有等待的人了。

这里同样是依据来的人是小孩还是家长、分别找对应的队列（cntQ和olderQ）传递给game函数，这也是双队列的好处（各处理各的，不会混淆）。

主函数第10行~第17行的代码逻辑是：

if (game(people, result, cntQ, i) || game(people, result, olderQ, i) || wait(cnt, cntQ, i)) {

l  如果来的人员是小孩，先去小孩桌找等待的人，找不到再去家长桌找等待的人；发现没有等待对弈的人，就尝试去占空闲的小孩桌；

没有空闲的小孩桌，就尝试去占空闲的家长桌。

l  如果来的人员是家长，先去家长桌找等待的人；发现没有等待对弈的人，就尝试去占空闲的家长桌。

函数release的作用是查看队列最末端的节点是否超时，如果超时则调用pollLast方法移除队列最后一个元素。

对弈开始时刻直接从返回数组result中获取。

函数拆分合理、功能明确，思路清晰，代码简洁易懂，时间复杂度同样是O(N)。
     */
}
