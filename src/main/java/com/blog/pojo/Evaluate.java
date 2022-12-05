package com.blog.pojo;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    private Integer eid;

    private String econtent;

    private Integer bFk;

    private Integer uFk;

    private Date etime;

    private User user;

    private Blog blog;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}