package com.internousdev.ecsite.dto;

public class BuyItemDTO {
	private int id;
	private String itemName;
	private String itemPrice;
	private String count;
	private String gokeiPrice;

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName= itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getGokeiPrice(){
		return gokeiPrice;
	}
	public void setGokeiPrice(String gokeiPrice){
		this.gokeiPrice = gokeiPrice;
	}


}
