package model;

import java.sql.Date;

public class Goods {
	private String goodsName;
	private double price;
	private int count;
	private Date date;
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Goods(String goodsName, double price, int count, Date date) {
		this.goodsName = goodsName;
		this.price = price;
		this.count = count;
		this.date = date;
	}
}
