package com.report.ytb.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String USERNAME;
    private String PASSWORD;
    private String LOGIN_INFO;
    private String HSID;
    private String SSID;
    private String SID;

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getLOGIN_INFO() {
        return LOGIN_INFO;
    }

    public void setLOGIN_INFO(String LOGIN_INFO) {
        this.LOGIN_INFO = LOGIN_INFO;
    }

    public String getHSID() {
        return HSID;
    }

    public void setHSID(String HSID) {
        this.HSID = HSID;
    }

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }
}

