package com.baizhi.service;

import com.baizhi.entity.Department;
import com.github.pagehelper.PageInfo;

public interface DepartmentService {


    public PageInfo<Department> select(Department department, int pageIndex, int pageSize);

    public void insert(Department department);

    public void delete(String id);

    public void deleteMany(String[] ids);

    public Department selectOne(String id);

    public void update(Department department);
}
