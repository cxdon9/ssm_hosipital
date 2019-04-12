package com.baizhi.dao;

import com.baizhi.entity.Triage;

import java.util.List;

public interface TriageDao {

    public List<Triage> select();

    public void insert(Triage triage);

    public Triage selectOne(String id);

    public void update(Triage triage);

    public void updateStatus(String id);

    public List<Triage> selectByDept(String did);
}
