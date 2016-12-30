package org.sm.bean;

/**
 * Created by Gell on 2016/12/29.
 */
public class Teachers {
    private int tId;
    private String tNo;
    private String tName;
    private String tClasses;
    private String tPasswd;
    private String tsf;

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettClasses() {
        return tClasses;
    }

    public void settClasses(String tClasses) {
        this.tClasses = tClasses;
    }

    public String gettPasswd() {
        return tPasswd;
    }

    public void settPasswd(String tPasswd) {
        this.tPasswd = tPasswd;
    }

    public String getTsf() {
        return tsf;
    }

    public void setTsf(String tsf) {
        this.tsf = tsf;
    }
}
