package com.cjcui.interview;

import java.util.ArrayList;
import java.util.List;

public class TreeConvert {
    public static void main(String[] args) {
        List<City> data = init();
        List<City> list = new TreeConvert().data2Tree(data);
    }

    static List<City> init() {
        City city1 = new City("1", "0", "中国", 1);
        City city2 = new City("2", "1", "中国1", 2);
        City city3 = new City("3", "2", "中国2", 3);
        City city4 = new City("4", "3", "中国3", 4);
        City city5 = new City("5", "4", "中国4", 5);
        City city6 = new City("6", "5", "中国5", 6);
        City city7 = new City("7", "2", "中国6", 3);
        City city8 = new City("8", "4", "中国7", 5);
        City city9 = new City("9", "0", "美国", 1);
        City city10 = new City("10", "9", "美国1", 2);
        List<City> list = new ArrayList<>();
        list.add(city1);
        list.add(city2);
        list.add(city3);
        list.add(city4);
        list.add(city5);
        list.add(city6);
        list.add(city7);
        list.add(city8);
        list.add(city9);
        list.add(city10);
        return list;
    }

    public void print(List<City> data) {

    }

    public List<City> data2Tree(List<City> data) {
        for (int i = 0; i < data.size(); i++) {
            if ("0".equals(data.get(i).getPid())) {
            recursion(data.get(i), data);
//                data.get(i).setChildren(getChildren(data.get(i), data));
            }
        }
        return data;
    }

    //递归
    public void recursion(City city, List<City> data) {
        List<City> other = data;
        for (City datum : data) {
            if (city.getId().equals(datum.getPid())) {
                city.getChildren().add(datum);
                other.remove(datum);
            }else {

            }
            recursion(datum, other);
        }
    }

    public List<City> getChildren(City city, List<City> data) {
        List<City> children = new ArrayList<>();
        List<City> other = new ArrayList<>();
        for (City datum : data) {
            if (city.getId().equals(datum.getPid())) {
//                city.getChildren().add(datum);
                children.add(datum);
            } else {
                other.add(datum);
            }
        }
        if (children.isEmpty()) {
            return children;
        }
        for (City child : children) {
            child.setChildren(getChildren(child, other));
        }
        return children;
    }
}
