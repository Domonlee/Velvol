package com.velvol.o2o.constant;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.velvol.o2o.Utils.Util;

public class SellDishes {

	private String name;
	private int id;
	private int shopid;
	private String shopname;
	private int oldprice;
	private String leadreputably;
	private int isilike;
	private String img;
	private int price;
	private int salecount;
	private int issaleout;
	private String dishesdesc;
	private int repliescount;
	private List<Replies> replieslist = new ArrayList<Replies>();
	
	public SellDishes(){}
	public void setJson(JSONObject json) {
		try {
			name = json.getString("name");
			id = json.getInt("id");
			shopid = json.getInt("shopid");
			shopname = json.getString("shopname");
			oldprice = json.getInt("oldprice");
			leadreputably = json.getString("leadreputably");
			isilike = json.getInt("isilike");
			img =GetUrl.IMAGE_SELL_URL + json.getString("img");
			price = json.getInt("price");
			salecount = json.getInt("salecount");
			issaleout = json.getInt("issaleout");
			dishesdesc = json.getString("dishesdesc");
			repliescount = json.getInt("repliescount");
			
			JSONArray array = json.optJSONArray("replieslist");
			if (array == null) {
				Log.v("Sen", "replieslist×Ö¶Î²»´æÔÚ");
				return;
			}
			replieslist.removeAll(replieslist);
			int len = array.length();
			if (len > 0) {
				for (int i = 0; i < len; i++) {
					Replies replies = new Replies(array.getJSONObject(i));
					replieslist.add(replies);
				}

			}
		} catch (JSONException e) {
			Util.ShowErrorLog("SellDishes½âÎö´íÎó");
			e.printStackTrace();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public int getOldprice() {
		return oldprice;
	}

	public void setOldprice(int oldprice) {
		this.oldprice = oldprice;
	}

	public String getLeadreputably() {
		return leadreputably;
	}

	public void setLeadreputably(String leadreputably) {
		this.leadreputably = leadreputably;
	}

	public int getIsilike() {
		return isilike;
	}

	public void setIsilike(int isilike) {
		this.isilike = isilike;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSalecount() {
		return salecount;
	}

	public void setSalecount(int salecount) {
		this.salecount = salecount;
	}

	public int getIssaleout() {
		return issaleout;
	}

	public void setIssaleout(int issaleout) {
		this.issaleout = issaleout;
	}

	public String getDishesdesc() {
		return dishesdesc;
	}

	public void setDishesdesc(String dishesdesc) {
		this.dishesdesc = dishesdesc;
	}

	public int getRepliescount() {
		return repliescount;
	}

	public void setRepliescount(int repliescount) {
		this.repliescount = repliescount;
	}

	public List<Replies> getReplieslist() {
		return replieslist;
	}

	public void setReplieslist(List<Replies> replieslist) {
		this.replieslist = replieslist;
	}
	
	
}
