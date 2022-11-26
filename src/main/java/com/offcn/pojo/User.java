package com.offcn.pojo;

import java.io.Serializable;

/**
 * @author ldq
 * @version 1.0
 * @date 2022/11/10 13:44
 * @Description:
 */
public class User implements Serializable {
    private Integer uid;
    private String uname;
    private String upwd;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
