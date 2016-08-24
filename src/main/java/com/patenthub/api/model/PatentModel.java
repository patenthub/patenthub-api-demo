package com.patenthub.api.model;

import com.patenthub.api.entity.Patent;

public class PatentModel {
    private boolean success;//访问成功与否
    private int code;//响应代码

    private Patent patent;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Patent getPatent() {
        return patent;
    }

    public void setPatent(Patent patent) {
        this.patent = patent;
    }
}
