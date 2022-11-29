package com.offcn.pojo;

import java.util.Date;

public class Evaluate {
    private Integer eid;

    private String econtent;

    private Integer bFk;

    private Integer uFk;

    private Date etime;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent;
    }

    public Integer getbFk() {
        return bFk;
    }

    public void setbFk(Integer bFk) {
        this.bFk = bFk;
    }

    public Integer getuFk() {
        return uFk;
    }

    public void setuFk(Integer uFk) {
        this.uFk = uFk;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }
}