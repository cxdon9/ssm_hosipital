package com.baizhi.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Files {
    private String id;
    private String file_name;
    private String file_path;
    private String save_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date up_time;
    private String file_size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getSave_name() {
        return save_name;
    }

    public void setSave_name(String save_name) {
        this.save_name = save_name;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id='" + id + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", save_name='" + save_name + '\'' +
                ", up_time=" + up_time +
                ", file_size='" + file_size + '\'' +
                '}';
    }
}
