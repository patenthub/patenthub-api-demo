package com.patenthub.api.model;

import com.patenthub.api.entity.PatentPart;

import java.util.List;

public class Pagination {

    private boolean success;//访问成功与否
    private int code;//响应代码

    private float took;//使用时间
    private int total;//搜索结果条数
    private int page;//当前页
    private int totalPages;//总页数
    private int nextPage;//下一页

    private List<PatentPart> patents;//当前页专利数据

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

    public float getTook() {
        return took;
    }

    public void setTook(float took) {
        this.took = took;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<PatentPart> getPatents() {
        return patents;
    }

    public void setPatents(List<PatentPart> patents) {
        this.patents = patents;
    }
}
