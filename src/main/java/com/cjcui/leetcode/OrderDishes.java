package com.cjcui.leetcode;

import java.util.*;

/**
 * @author cjcui
 * leetcode 1418.点菜展示表
 */
public class OrderDishes {

}

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> nameSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            Integer id = Integer.valueOf(order.get(1));
            Map<String, Integer> map = foodsCnt.getOrDefault(id, new HashMap<>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id, map);
        }
        List<String> names = new ArrayList<>();
        for (String s : nameSet) {
            names.add(s);
        }
        Collections.sort(names);

        List<Integer> ids = new ArrayList<>();
        Set<Integer> keySet = foodsCnt.keySet();
        for (Integer integer : keySet) {
            ids.add(integer);
        }
        Collections.sort(ids);

        List<List<String>> list = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
//        header.addAll(names);
        for (String name : names) {
            header.add(name);
        }
        list.add(header);
        for (int i = 0; i < ids.size(); i++) {
            int id = ids.get(i);
            Map<String, Integer> map = foodsCnt.get(id);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(id));
            for (int j = 0; j < names.size(); j++) {
                row.add(Integer.toString(map.getOrDefault(names.get(j), 0)));
            }
            list.add(row);
        }
        return list;
    }
}
