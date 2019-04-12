package com.baizhi.service.impl;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public PageInfo<Department> select(Department department, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Department> pageInfo = new PageInfo<>(departmentDao.select(department));
        return pageInfo;
    }

    @Override
    public void insert(Department department) {
        departmentDao.insert(department);
    }

    @Override
    public void delete(String id) {
        departmentDao.delete(id);
    }

    @Override
    public void deleteMany(String[] ids) {
        departmentDao.deleteMany(ids);
    }

    @Override
    public Department selectOne(String id) {
        return departmentDao.selectOne(id);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }
}
