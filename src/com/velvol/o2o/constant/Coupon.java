package com.velvol.o2o.constant;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Coupon {

	private Integer id;
	private Integer ctypeid;
	private Integer cmoney;
	private String ctitle;
	private String cendtime;
	private String crul;
	
	public Coupon(JSONObject object){
		try {
			id = object.getInt("id");
			ctypeid = object.getInt("ctypeid");
			cmoney =object.getInt("cmoney");
			ctitle = object.getString("ctitle");
			cendtime = object.getString("cendtime");
			crul = object.getString("crul");
			
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

	public Integer getCtypeid() {
		return ctypeid;
	}

	public void setCtypeid(Integer ctypeid) {
		this.ctypeid = ctypeid;
	}

	public Integer getCmoney() {
		return cmoney;
	}

	public void setCmoney(Integer cmoney) {
		this.cmoney = cmoney;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCendtime() {
		return cendtime;
	}

	public void setCendtime(String cendtime) {
		this.cendtime = cendtime;
	}

	public String getCrul() {
		return crul;
	}

	public void setCrul(String crul) {
		this.crul = crul;
	}

}
