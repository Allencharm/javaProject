package com.blog.pojo;

import java.io.Serializable;
import java.util.List;

public class Btype implements Serializable {
    private Integer typeid;

    private String typename;

    private Integer typePid;

    private String typedes;

    private List<Btype> smallTypeList;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public String getTypedes() {
        return typedes;
    }

    public void setTypedes(String typedes) {
        this.typedes = typedes;
    }

    public List<Btype> getSmallTypeList() {
        return smallTypeList;
    }

    public void setSmallTypeList(List<Btype> smallTypeList) {
        this.smallTypeList = smallTypeList;
    }
}