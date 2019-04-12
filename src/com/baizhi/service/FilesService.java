package com.baizhi.service;

import com.baizhi.entity.Files;
import com.github.pagehelper.PageInfo;

public interface FilesService {
    public PageInfo<Files> select(Files files, int pageIndex, int pageSize);

    public void insert(Files files);

    public Files selectOne(int id);
}
