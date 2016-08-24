package com.patenthub.api.model;

import com.patenthub.api.entity.Transaction;

import java.util.List;

public class TransactionModel {
    private boolean success;//访问成功与否
    private int code;//响应代码

    private List<Transaction> transactions;

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
