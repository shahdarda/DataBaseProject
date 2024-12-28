package com.example.demo1;

import java.util.Date;

public class Order {
    private int or_id;
    private int c_id;
    private String date;

    private String totalAmount;

    public Order(int or_id, int c_id, String date, String totalAmount) {
        this.or_id = or_id;
        this.c_id = c_id;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public int getOr_id() {
        return or_id;
    }

    public void setOr_id(int or_id) {
        this.or_id = or_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalAmount() {

        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}