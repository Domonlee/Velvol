package com.velvol.o2o.constant;

import org.json.JSONException;
import org.json.JSONObject;

public class CouponShop {
	private Integer id;
	private Integer chStateid;// �Ż�ȯ״̬
	private String chTitle;
	private String chAddtime;
	private String chUrl;

	public CouponShop(JSONObject object) {
		try {
			id = object.getInt("id");
			chStateid = object.getInt("chStateid");
			chTitle = object.getString("chTitle");
			chUrl = object.getString("chUrl");
			chAddtime = object.getString("chAddtime");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getChStateid() {
		return chStateid;
	}

	public void setChStateid(Integer chStateid) {
		this.chStateid = chStateid;
	}

	public String getChTitle() {
		return chTitle;
	}

	public void setChTitle(String chTitle) {
		this.chTitle = chTitle;
	}

	public String getChAddtime() {
		return chAddtime;
	}

	public void setChAddtime(String chAddtime) {
		this.chAddtime = chAddtime;
	}

	public String getChUrl() {
		return chUrl;
	}

	public void setChUrl(String chUrl) {
		this.chUrl = chUrl;
	}

}
