package com.rizkykojek.ejb.entity;

import java.io.Serializable;

public class ShippingObject implements Serializable {

	private String item;
	private String address;
	private Integer amount;
	
	public ShippingObject(){
		
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
