package com.cjcui.practice.od;


import java.util.*;

/**
 *
 */
public class SysDesign_MergeFile {
    Deque<Integer> queue = new LinkedList<>();
    Map<Integer, Set<Integer>> fileMap = new HashMap<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int timeout;
    int success;

    public SysDesign_MergeFile(int timeout) {
        this.timeout = timeout;
    }

    /**
     * 在时刻 time 收到 fileId 文件的下载请求，分块数量为 number
     *
     * @param time
     * @param fileId
     * @param number
     * @return
     */
    public boolean request(int time, int fileId, int number) {
        check(time);
        if (map.containsKey(fileId)) {
            return false;//收到重复请求，直接返回false;
        }
        queue.offer(fileId);
        List<Integer> list = new ArrayList<>();
        list.add(time);
        list.add(number);
        map.put(fileId, list);

        fileMap.put(fileId, new HashSet<>());

        return true;


    }
//  注意：文件收包的有效时间不超过 此文件Request时的time + timeout ，若在有效时间内收完所有包，
//  则文件为 Ready状态，否则视为超时（不再接收分块）。Ready状态文件的合并保存遵循
//  「队首优先保存规则」处理。收包后按照此规则做后处理。

    /**
     * 在时刻 time，收到 fileId 文件的 partId 分块（编号从 0 ~ number-1）
     *
     * @param time
     * @param fileId
     * @param partId
     * @return
     */
    public int receive(int time, int fileId, int partId) {
        if (!map.containsKey(fileId) || (map.get(fileId).get(0) + timeout < time) || fileMap.get(fileId).contains(partId)) {
            return -1;
        }
        fileMap.get(fileId).add(partId);
        return map.get(fileId).get(1) - fileMap.get(fileId).size();
    }
//「队首优先保存规则」如下：
//任意时刻，对于请求队列队首的文件下载请求，若超时则直接移除该请求；若已收完所有分块，则合并保存文件再移除该请求；持续处理队首的请求，直到队首是未超时且未收完所有分块的请求。
//注意：
//输入保证 Request、Receive、Query 函数的日期 time 参数按输入顺序严格递增

    /**
     * 查询时刻 time 已完成合并保存的文件个数。注意先按照「队首优先保存规则」处理后再查询
     *
     * @param time
     * @return
     */
    public int query(int time) {
        check(time);
        return success;
    }


    public void check(int time) {
        while (queue.size() > 0 && ((map.get(queue.peek()).get(0) + timeout) <= time || (fileMap.get(queue.peek()).size() == map.get(queue.peek()).get(1)))) {
            int id = queue.remove();//取出队头
            if (fileMap.get(id).size() == map.get(id).get(1)) {
                success++;
            }
            map.remove(id);
            fileMap.remove(id);
        }
    }
}
