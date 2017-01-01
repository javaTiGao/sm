package org.sm.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Gell on 2016/12/27.
 * 班级
 */
@Entity
public class Classes {
    @Id
    private int cId;
    private String cName;
    private int cNum;
    private String Headmaster;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public String getHeadmaster() {
        return Headmaster;
    }

    public void setHeadmaster(String headmaster) {
        Headmaster = headmaster;
    }
}
