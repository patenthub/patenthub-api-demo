package com.patenthub.api.model;

import com.patenthub.api.entity.EnterprisePortrait;

import java.util.Map;

public class EnterprisePortraitModel {

    private boolean success;//访问成功与否
    private int code;//响应代码

    private EnterprisePortrait enterprisePortrait;

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

    public EnterprisePortrait getEnterprisePortrait() {
        return enterprisePortrait;
    }

    public void setEnterprisePortrait(EnterprisePortrait enterprisePortrait) {
        this.enterprisePortrait = enterprisePortrait;
    }
}
