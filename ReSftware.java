package com.gl.longrange.entity;

import java.io.Serializable;

public class ReSftware implements Serializable {
    private  Integer Sf_id;
    private  String Sf_name;
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
}
