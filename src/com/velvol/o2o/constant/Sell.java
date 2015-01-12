package com.velvol.o2o.constant;

import org.json.JSONException;
import org.json.JSONObject;

import com.velvol.o2o.Utils.Util;

public class Sell {

	private int id;
	private String pricetypename;
	private String oldprice;
	private String price;
	private String isilike;
	private String soldout;
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
			oldprice = json.getString("oldprice");
			price = json.getString("price");
			isilike = json.getString("isilike");
			soldout = json.getString("soldout");
			imgname = json.getString("imgname");
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

	public String getOldprice() {
		return oldprice;
	}

	public void setOldprice(String oldprice) {
		this.oldprice = oldprice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsilike() {
		return isilike;
	}

	public void setIsilike(String isilike) {
		this.isilike = isilike;
	}

	public String getSoldout() {
		return soldout;
	}

	public void setSoldout(String soldout) {
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
