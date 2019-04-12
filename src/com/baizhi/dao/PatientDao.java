package com.baizhi.dao;

import com.baizhi.entity.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientDao {

    public List<Patient> select(@Param("patient") Patient patient);

    public void insert(Patient Patient);

    public Patient selectOne(String id);

    public void delete(String id);

    public void deleteMany(String[] ids);

    public void update(Patient patient);

}
