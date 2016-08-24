package com.patenthub.api.model;

import com.patenthub.api.entity.PatentPart;

import java.util.List;

public class LikePatentModel {
    private boolean success;//访问成功与否
    private int code;//响应代码

    private List<PatentPart> patentLikeList;

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

    public List<PatentPart> getPatentLikeList() {
        return patentLikeList;
    }

    public void setPatentLikeList(List<PatentPart> patentLikeList) {
        this.patentLikeList = patentLikeList;
    }
}
