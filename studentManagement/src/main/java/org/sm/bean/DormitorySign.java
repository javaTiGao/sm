package org.sm.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Gell on 2016/12/27.
 * 宿舍签到
 */
@Entity
public class DormitorySign {
    @Id
    private int dId;
    private String dName;
    private String sSign;
    private Date signDate;

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

    public String getsSign() {
        return sSign;
    }

    public void setsSign(String sSign) {
        this.sSign = sSign;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
}
