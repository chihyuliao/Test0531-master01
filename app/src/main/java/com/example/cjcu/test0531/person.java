package com.example.cjcu.test0531;

/**
 * Created by CJCU on 2018/6/14.
 */

public class person {

    public person() {
    }

    private  String cdate;
private  String info;
private  String  amount;

    public person(String cdate, String info, String amount) {
        this.cdate = cdate;
        this.info = info;
        this.amount = amount;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
