package com.velvol.o2o.constant;

import org.json.JSONException;
import org.json.JSONObject;

import com.velvol.o2o.Utils.Util;


public class Replies {

	private String username;
	private String context;
	private int id;
	private String createtime;
	private String userheadimg	;
	private String createdate;
	private int starcount;
	private int replycount;
	private int zambiacount;
	
	public Replies(JSONObject json){
		try {
			username = json.getString("username");
			context = json.getString("context");
			id = json.getInt("id");
			createtime = json.getString("createtime");
			userheadimg = json.getString("userheadimg");
			createdate = json.getString("createdate");
			starcount = json.getInt("starcount");
			replycount = json.getInt("replycount");
			zambiacount = json.getInt("zambiacount");
		} catch (JSONException e) {
			Util.ShowErrorLog("Replies½âÎö´íÎó");
			e.printStackTrace();
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getUserheadimg() {
		return userheadimg;
	}

	public void setUserheadimg(String userheadimg) {
		this.userheadimg = userheadimg;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public int getStarcount() {
		return starcount;
	}

	public void setStarcount(int starcount) {
		this.starcount = starcount;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	public int getZambiacount() {
		return zambiacount;
	}

	public void setZambiacount(int zambiacount) {
		this.zambiacount = zambiacount;
	}
	
	
}

