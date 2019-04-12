package com.baizhi.service.impl;

import com.baizhi.dao.PatientDao;
import com.baizhi.entity.Patient;
import com.baizhi.service.PatientService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Override
    public PageInfo<Patient> select(Patient patient, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Patient> pageInfo = new PageInfo<>(patientDao.select(patient));
        return pageInfo;
    }

    @Override
    public void insert(Patient patient) {
        patientDao.insert(patient);
    }

    @Override
    public void delete(String id) {
        patientDao.delete(id);
    }

    @Override
    public void deleteMany(String[] ids) {
        patientDao.deleteMany(ids);
    }

    @Override
    public Patient selectOne(String id) {
        return patientDao.selectOne(id);
    }

    @Override
    public void update(Patient patient) {
        patientDao.update(patient);
    }
}
