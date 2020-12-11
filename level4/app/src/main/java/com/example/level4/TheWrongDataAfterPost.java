package com.example.level4;

public class TheWrongDataAfterPost {
    /*
    {
        "data": null,
        "errorCode": -1,
        "errorMsg": "账号密码不匹配！"
     }
     */

    public TheWrongDataAfterPost(String data, int errorCode, String errorMsg) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    String data=null;
    int errorCode=-1;
    String errorMsg="账号密码不匹配！";
}
