package com.example.demo1;
import java.time.LocalDateTime;

public class Delivery {
    private int Delivery_Id;
    private int Order_Id;
    private String Delivery_Date;
    private String Estimated_Delivery_Time;
    private String Delivery_Statuse;
    private String Shipping_Company;
    private String Delivery_Address;


    public Delivery(int delivery_Id, int order_Id, String delivery_Date, String estimated_Delivery_Time, String delivery_Address, String shipping_Company, String delivery_Statuse ) {
        this.Delivery_Id = delivery_Id;
        this.Order_Id = order_Id;
        this.Delivery_Date = delivery_Date;
        this.Estimated_Delivery_Time = estimated_Delivery_Time;
        this.Delivery_Statuse = delivery_Statuse;
        this.Shipping_Company = shipping_Company;
        this.Delivery_Address = delivery_Address;

    }

    public int getDelivery_Id() {
        return Delivery_Id;
    }

    public void setDelivery_Id(int delivery_Id) {
        Delivery_Id = delivery_Id;
    }

    public int getOrder_Id() {
        return Order_Id;
    }

    public void setOrder_Id(int order_Id) {
        Order_Id = order_Id;
    }

    public String getDelivery_Date() {
        return Delivery_Date;
    }

    public void setDelivery_Date(String delivery_Date) {
        Delivery_Date = delivery_Date;
    }

    public String getEstimated_Delivery_Time() {
        return Estimated_Delivery_Time;
    }

    public void setEstimated_Delivery_Time(String estimated_Delivery_Time) {
        Estimated_Delivery_Time = estimated_Delivery_Time;
    }

    public String getDelivery_Statuse() {
        return Delivery_Statuse;
    }

    public void setDelivery_Statuse(String delivery_Statuse) {
        Delivery_Statuse = delivery_Statuse;
    }

    public String getShipping_Company() {
        return Shipping_Company;
    }

    public void setShipping_Company(String shipping_Company) {
        Shipping_Company = shipping_Company;
    }

    public String getDelivery_Address() {
        return Delivery_Address;
    }

    public void setDelivery_Address(String delivery_Address) {
        Delivery_Address = delivery_Address;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "Delivery_Id=" + Delivery_Id +
                ", Order_Id=" + Order_Id +
                ", Delivery_Date='" + Delivery_Date + '\'' +
                ", Estimated_Delivery_Time='" + Estimated_Delivery_Time + '\'' +
                ", Delivery_Statuse='" + Delivery_Statuse + '\'' +
                ", Shipping_Company='" + Shipping_Company + '\'' +
                ", Delivery_Address='" + Delivery_Address + '\'' +
                '}';
    }
}
