package com.example.pc252.mydemo.bean;

/**
 * Created by pc252 on 2019/1/4.
 */

public class TestModel {
    private int errorCode;
    private String  reason;
    private TestModel2 result;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public TestModel2 getResult() {
        return result;
    }

    public void setResult(TestModel2 result) {
        this.result = result;
    }
}
