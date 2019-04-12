package com.baizhi.entity;

import java.util.List;

public class DepartmentSTO {
    private List<Department> list;

    @Override
    public String toString() {
        return "DepartmentSTO{" +
                "list=" + list +
                '}';
    }

    public List<Department> getList() {
        return list;
    }

    public void setList(List<Department> list) {
        this.list = list;
    }
}
