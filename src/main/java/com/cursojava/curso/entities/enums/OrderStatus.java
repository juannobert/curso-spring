package com.cursojava.curso.entities.enums;

public enum OrderStatus {
	WAITTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERY(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public  static  OrderStatus valueOf(int code) {
		for(OrderStatus orderStatus : OrderStatus.values()) {
			if(code == orderStatus.getCode()) {
				return orderStatus;
			}
		}
		throw new IllegalArgumentException("Código invalido");
	}
	
	
	

}
