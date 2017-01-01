package org.sm.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Gell on 2016/12/27.
 * 学生
 */
@Entity
public class Students {
    @Id
    private int sId;
    private int sNo;
    private String sName;
    private String sSex;
    private String sClass;
    private String Headmaster;
    private String sPwd;

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getHeadmaster() {
        return Headmaster;
    }

    public void setHeadmaster(String headmaster) {
        Headmaster = headmaster;
    }
}
