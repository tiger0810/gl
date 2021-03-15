package com.gl.longrange.entity;

import java.io.Serializable;
import java.util.List;

public class RemoteInfo implements Serializable {
//#id#店名#远程码#验证码#主机副机服务器 #连接 ReSftware表
    private Integer Re_id;
    private String Re_name;
    private String Re_code;
    private String Re_pwd;
    private Integer Com_name;
    private  Integer Sf_id;
    private  String Sf_name;

    public Integer getRe_id() {
        return Re_id;
    }

    public void setRe_id(Integer re_id) {
        Re_id = re_id;
    }

    public String getRe_name() {
        return Re_name;
    }

    public void setRe_name(String re_name) {
        Re_name = re_name;
    }

    public String getRe_code() {
        return Re_code;
    }

    public void setRe_code(String re_code) {
        Re_code = re_code;
    }

    public String getRe_pwd() {
        return Re_pwd;
    }

    public void setRe_pwd(String re_pwd) {
        Re_pwd = re_pwd;
    }

    public Integer getCom_name() {
        return Com_name;
    }

    public void setCom_name(Integer com_name) {
        Com_name = com_name;
    }

    public Integer getSf_id() {
        return Sf_id;
    }

    public void setSf_id(Integer sf_id) {
        Sf_id = sf_id;
    }

    public String getSf_name() {
        return Sf_name;
    }

    public void setSf_name(String sf_name) {
        Sf_name = sf_name;
    }

    @Override
    public String toString() {
        return "RemoteInfo{" +
                "Re_id=" + Re_id +
                ", Re_name='" + Re_name + '\'' +
                ", Re_code='" + Re_code + '\'' +
                ", Re_pwd='" + Re_pwd + '\'' +
                ", Com_name=" + Com_name +
                ", Sf_id=" + Sf_id +
                ", Sf_name='" + Sf_name + '\'' +
                '}';
    }
}
