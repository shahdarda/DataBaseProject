package com.example.demo1;

public class Purchase {
    private int purchase_id;
    private int order_id;
    private String paymentMethod;
    private String transactionStatus;
    private String paymentConfirmation;



    public Purchase(int purchase_id, int order_id, String paymentConfirmation, String paymentMethod, String transactionStatus) {
        this.purchase_id = purchase_id;
        this.order_id = order_id;
        this.paymentMethod = paymentMethod;
        this.transactionStatus = transactionStatus;
        this.paymentConfirmation = paymentConfirmation;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(String paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchase_id=" + purchase_id +
                ", order_id=" + order_id +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", transactionStatus='" + transactionStatus + '\'' +
                ", paymentConfirmation=" + paymentConfirmation +
                '}';
    }
}




