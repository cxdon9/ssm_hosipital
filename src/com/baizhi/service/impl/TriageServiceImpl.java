package com.baizhi.service.impl;

import com.baizhi.dao.TriageDao;
import com.baizhi.entity.Triage;
import com.baizhi.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriageServiceImpl implements TriageService {
    @Autowired
    private TriageDao triageDao;

    @Override
    public List<Triage> select() {
        return triageDao.select();
    }

    @Override
    public void insert(Triage triage) {
        triageDao.insert(triage);
    }

    @Override
    public Triage selectOne(String id) {
        return triageDao.selectOne(id);
    }

    @Override
    public void update(Triage triage) {
        triageDao.update(triage);
    }

    @Override
    public void updateStatus(String id) {
        triageDao.updateStatus(id);
    }

    @Override
    public List<Triage> selectByDept(String did) {
        return triageDao.selectByDept(did);
    }
}
