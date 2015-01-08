package com.velvol.o2o.constant;

import android.util.Log;

public class GetUrl {

	// private static String HOST = "http://192.168.1.124:8888/diancan/check_";
	private static String HOST = "http://123.56.94.10:8080/";
	// 图片头部
	// public static String IMAGE_URL = "http://192.168.1.124:8888/diancan/";

	private static String CODE = HOST + "UserApi_loadValidateCode";
	private static String REGISTER = HOST + "UserApi_register";
	private static String UPDATE = HOST + "UserApi_updatePwd";
	private static String LOGIN = HOST + "UserApi_login";
	private static String ADDRESS = HOST + "loadStaticAddress";
	private static String ADDRESS_OLD = HOST + "UserApi_listHistoryAddress";
	private static String ADDRESS_ADD = HOST + "UserApi_addUserAddress";
	private static String MYINFO = HOST + "UserApi_loadMyInfo";
	private static String MYINFO_UPDATE = HOST + "UserApi_updateUserInfo";

	/**
	 * 
	 * Title: getUpdateMyInfoUrl 
	 * Description: 修改我的资料接口
	 * @param userid
	 * @param updatefield
	 * @param context
	 * @return
	 */
	public static String getUpdateMyInfoUrl(String userid, String updatefield,
			String context) {
		return MYINFO_UPDATE + "?userid=" + userid + "&updatefield="
				+ updatefield + "&context=" + context;
	}

	/**
	 * 我的资料接口
	 */
	public static String getMyInfoUrl(String userid) {
		return MYINFO + "?userid=" + userid;
	}

	/**
	 * 新增地址接口
	 */
	public static String getAddAddressUrl(String userid, String uadressid,
			String floor) {
		return ADDRESS_ADD + "?userid=" + userid + "&uadressid=" + uadressid
				+ "&floor=" + floor;
	}

	/**
	 * 历史地址接口
	 */
	public static String getOldAddressUrl(String userid) {
		return ADDRESS_OLD + "?userid=" + userid;
	}

	/**
	 * 搜索地址接口
	 */
	public static String getAddressUrl(String keywords) {
		return ADDRESS + "?keywords=" + keywords;
	}

	/**
	 * 修改密码接口
	 */
	public static String getUpdateUrl(String newpassword, String phone) {
		return UPDATE + "?phone=" + phone + "&newpassword=" + newpassword;
	}

	/**
	 * 注册接口
	 */
	public static String getRegisterUrl(String password, String phone,
			String nickname) {
		return REGISTER + "?phone=" + phone + "&password=" + password
				+ "&nickname=" + nickname;
	}

	/**
	 * 获取验证码接口
	 */
	public static String getCodeUrl(String operatype, String phone) {
		return CODE + "?phone=" + phone + "&operatype=" + operatype;
	}

	/**
	 * 登录接口
	 */
	public static String getLoginUrl(String password, String phone) {
		return LOGIN + "?phone=" + phone + "&password=" + password;
	}
}
