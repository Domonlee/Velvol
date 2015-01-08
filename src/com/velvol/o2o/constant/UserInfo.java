package com.velvol.o2o.constant;

import org.json.JSONException;
import org.json.JSONObject;

import com.velvol.o2o.Utils.Util;

public class UserInfo {

	private String UserId;
	private String balance;
	private String score;
	private String nickname;
	private String phone;
	private String name;
	private String email;
	private String address;
	private String heading;

	public UserInfo(String userId, String balance, String score, String nickname,
			String phone, String name, String email, String address,
			String heading) {
		super();
		this.UserId = userId;
		this.balance = balance;
		this.score = score;
		this.nickname = nickname;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.address = address;
//		this.heading = heading;
	}
	
	public UserInfo(JSONObject json){
		try {
			balance = json.getString("balance");
			score = json.getString("score");
			UserId = json.getString("id");
			nickname = json.getString("nickname");
			phone = json.getString("phone");
			name = json.getString("name");
			email = json.getString("email");
			address = json.getString("address");
//			heading = json.getString("heading");
		} catch (JSONException e) {
			Util.ShowErrorLog("用户信息UserApi_loadMyInfo接口错误");
			e.printStackTrace();
		}
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

}
