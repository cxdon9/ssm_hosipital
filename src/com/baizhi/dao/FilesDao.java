package com.baizhi.dao;

import com.baizhi.entity.Files;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilesDao {
    public List<Files> select(@Param("files") Files files);

    public void insert(Files files);

    public Files selectOne(int id);
}
