package com.cjcui.algorithm.lfu;


import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    //key 到 val的映射
    HashMap<Integer, Integer> keyToval;
    //key 到 freq的映射
    HashMap<Integer, Integer> keyToFreq;
    //freq 到 key列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    //最小频次
    int minFreq;

    //缓存最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToval = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToval.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToval.get(key);
    }

    public void put(int key, int val) {
        if (this.cap <= 0) {
            return;
        }
        if (keyToval.containsKey(key)) {
            keyToval.put(key, val);
            increaseFreq(key);
            return;
        }
        if (this.cap <= keyToval.size()) {
            removeMinFreqKey();
        }
        keyToval.put(key, val);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    void removeMinFreqKey() {
        LinkedHashSet<Integer> set = freqToKeys.get(this.minFreq);
        Integer next = set.iterator().next();
        set.remove(next);
        if (set.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToval.remove(next);
        keyToFreq.remove(next);
    }

    void increaseFreq(int key) {
        Integer integer = keyToFreq.get(key);
        keyToFreq.put(key, integer + 1);
        freqToKeys.get(integer).remove(key);
        freqToKeys.putIfAbsent(integer + 1, new LinkedHashSet<>());
        freqToKeys.get(integer + 1).add(key);
        if (freqToKeys.get(integer).isEmpty()) {
            freqToKeys.remove(integer);
            if (integer == this.minFreq) {
                this.minFreq++;
            }
        }
    }
}
