package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "goods")
public class Goods {
	@Id
	@Column(name = "goods_name")
	private String goodsName;
	private Double price;
	@Column(name = "count")
	private Integer count;
	@Column(name = "order_time")
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
	
	public Goods() {
	}
}
