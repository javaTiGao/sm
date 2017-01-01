package org.sm.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Gell on 2016/12/27.
 * 宿舍
 */
@Entity
public class Dormitorys {
    @Id
    private int dId;
    private String dName;
    private String dClass;
    private int maxNum;
    private int num;
    private String dLord;

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdClass() {
        return dClass;
    }

    public void setdClass(String dClass) {
        this.dClass = dClass;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getdLord() {
        return dLord;
    }

    public void setdLord(String dLord) {
        this.dLord = dLord;
    }
}
