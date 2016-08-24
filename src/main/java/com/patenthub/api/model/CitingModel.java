package com.patenthub.api.model;

import com.patenthub.api.entity.PatentPart;

import java.util.List;

public class CitingModel {
    private boolean success;//访问成功与否
    private int code;//响应代码

    private List<PatentPart> citedList;//被引用
    private List<String> patentXref;//专利引用
    private List<String> noPatentXref;//非专利引用

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

    public List<PatentPart> getCitedList() {
        return citedList;
    }

    public void setCitedList(List<PatentPart> citedList) {
        this.citedList = citedList;
    }

    public List<String> getPatentXref() {
        return patentXref;
    }

    public void setPatentXref(List<String> patentXref) {
        this.patentXref = patentXref;
    }

    public List<String> getNoPatentXref() {
        return noPatentXref;
    }

    public void setNoPatentXref(List<String> noPatentXref) {
        this.noPatentXref = noPatentXref;
    }
}
