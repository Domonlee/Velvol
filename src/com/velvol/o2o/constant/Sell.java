package com.velvol.o2o.constant;

import org.json.JSONException;
import org.json.JSONObject;

import com.velvol.o2o.Utils.Util;

public class Sell {

	private int id;
	private String pricetypename;
	private int oldprice;
	private int price;
	private int isilike;
	private int soldout;
	private String imgname;
	private String storename;
	private String dishname;
	private String starttime;
	private String stoptime;

	public Sell() {
	}
	
	public Sell(JSONObject json){
		try {
			id = json.getInt("id");
			pricetypename = json.getString("pricetypename");
			oldprice = json.getInt("oldprice");
			price = json.getInt("price");
			isilike = json.getInt("isilike");
			soldout = json.getInt("soldout");
			imgname =GetUrl.IMAGE_SELL_URL + json.getString("imgname");
			storename = json.getString("storename");
			dishname = json.getString("dishname");
			starttime = json.getString("starttime");
			stoptime = json.getString("stoptime");
		} catch (JSONException e) {
			Util.ShowErrorLog("商品信息数据解析出错");
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPricetypename() {
		return pricetypename;
	}

	public void setPricetypename(String pricetypename) {
		this.pricetypename = pricetypename;
	}

	public int getOldprice() {
		return oldprice;
	}

	public void setOldprice(int oldprice) {
		this.oldprice = oldprice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getDishname() {
		return dishname;
	}

	public void setDishname(String dishname) {
		this.dishname = dishname;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}
	
	

	

}
