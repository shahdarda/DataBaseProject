package com.example.demo1;
public class OrderItem {
	private int order_id;
	private int product_id;
	private int quantity;
	private double subtotal;
	public OrderItem( int product_id,int order_id, int quantity, double subtotal) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public String toString() {
		return "OrderItem [order_id=" + order_id + ", product_id=" + product_id + ", quantity=" + quantity
		        + ", subtotal=" + subtotal + "]";
	}
	
}
