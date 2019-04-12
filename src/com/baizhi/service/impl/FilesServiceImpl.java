package com.baizhi.service.impl;

import com.baizhi.dao.FilesDao;
import com.baizhi.entity.Files;
import com.baizhi.service.FilesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesServiceImpl implements FilesService {
    @Autowired
    private FilesDao filesDao;

    @Override
    public PageInfo<Files> select(Files files, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Files> pageInfo = new PageInfo<>(filesDao.select(files));
        return pageInfo;
    }

    @Override
    public void insert(Files files) {
        filesDao.insert(files);
    }

    @Override
    public Files selectOne(int id) {
        return filesDao.selectOne(id);
    }
}
