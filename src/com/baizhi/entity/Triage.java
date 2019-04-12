package com.baizhi.entity;

public class Triage {
    private String id;
    private int status;
    private String illness_info;
    private String advice;
    private String pid; //患者的外键
    private String did; //科室的外键
    private String userid; //医生的外键
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIllness_info() {
        return illness_info;
    }

    public void setIllness_info(String illness_info) {
        this.illness_info = illness_info;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Triage{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", illness_info='" + illness_info + '\'' +
                ", advice='" + advice + '\'' +
                ", pid='" + pid + '\'' +
                ", did='" + did + '\'' +
                ", userid='" + userid + '\'' +
                '}';
    }
}
