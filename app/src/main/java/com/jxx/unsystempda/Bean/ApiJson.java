package com.jxx.unsystempda.Bean;

public class ApiJson<T> {

    private CommonParameters head = null;
    private T body = null;
    private  String sign = "";

    public CommonParameters getHead() {
        return head;
    }

    public void setHead(CommonParameters head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
