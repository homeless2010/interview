package com.cjcui.interview;

import java.util.ArrayList;
import java.util.List;

public class City {
    String id;
    String pid;
    String name;
    int level;

    public City() {
    }

    public City(String id, String pid, String name, int level) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.level = level;
    }

    public List<City> getChildren() {
        return children;
    }

    public void setChildren(List<City> children) {
        this.children = children;
    }

    List<City> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
