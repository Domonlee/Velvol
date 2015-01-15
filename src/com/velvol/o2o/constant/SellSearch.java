package com.velvol.o2o.constant;

import org.json.JSONException;
import org.json.JSONObject;

import com.velvol.o2o.Utils.Util;

public class SellSearch {

	private int id;
	private String img;
	private int count;
	private int isilike;
	private double price;
	private double oldprice;
	private String dishname;
	private int soldout;

	public SellSearch() {
	}
	
	public SellSearch(JSONObject json){
		try {
			id = json.getInt("id");
			oldprice = json.getDouble("oldprice");
			price = json.getDouble("price");
			isilike = json.getInt("isilike");
			soldout = json.getInt("soldout");
			count = json.getInt("soldout");
			img =GetUrl.IMAGE_SELL_URL + json.getString("img");
			dishname = json.getString("dishname");
		} catch (JSONException e) {
			Util.ShowErrorLog("搜索商品信息数据解析出错");
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getOldprice() {
		return oldprice;
	}

	public void setOldprice(double oldprice) {
		this.oldprice = oldprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIsilike() {
		return isilike;
	}

	public void setIsilike(int isilike) {
		this.isilike = isilike;
	}

	public int getSoldout() {
		return soldout;
	}

	public void setSoldout(int soldout) {
		this.soldout = soldout;
	}

	public String getDishname() {
		return dishname;
	}

	public void setDishname(String dishname) {
		this.dishname = dishname;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
