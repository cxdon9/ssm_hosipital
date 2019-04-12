package com.baizhi.dao;

import com.baizhi.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentDao {

    public List<Department> select(@Param("department") Department department);

    public void insert(Department department);

    public Department selectOne(String id);

    public void delete(String id);

    public void deleteMany(String[] ids);

    public void update(Department department);

}
