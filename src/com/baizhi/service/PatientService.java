package com.baizhi.service;

import com.baizhi.entity.Patient;
import com.github.pagehelper.PageInfo;

public interface PatientService {


    public PageInfo<Patient> select(Patient patient, int pageIndex, int pageSize);

    public void insert(Patient Patient);

    public void delete(String id);

    public void deleteMany(String[] ids);

    public Patient selectOne(String id);

    public void update(Patient patient);
}
