package com.velvol.o2o.constant;

public class GetUrl {

	// private static String HOST = "http://192.168.1.124:8888/diancan/check_";
	private static String HOST = "http://www.xiao2.me:8080/";
	// 图片头部
	public static String IMAGE_STORE_URL = HOST + "/admins/images/shopImgs/";
	public static String IMAGE_DISCOUNT_URL = HOST
			+ "/admins/images/discountImgs/";
	public static String IMAGE_MSG_URL = HOST + "/admins/images/userImgs/";
	public static String IMAGE_SELL_URL = HOST + "/admins/images/dishesImgs/";
	public static String IMAGE_ICON_URL = HOST + "/userimg/";

	private static String CODE = HOST + "UserApi_loadValidateCode";
	private static String REGISTER = HOST + "UserApi_register";
	private static String UPDATE = HOST + "UserApi_updatePwd";
	private static String LOGIN = HOST + "UserApi_login";
	private static String ADDRESS = HOST + "loadStaticAddress";
	private static String ADDRESS_OLD = HOST + "UserApi_listHistoryAddress";
	private static String ADDRESS_ADD = HOST + "UserApi_addUserAddress";
	private static String MYINFO = HOST + "UserApi_loadMyInfo";
	private static String MYINFO_UPDATE = HOST + "UserApi_updateUserInfo";
	private static String MAIN_INFO = HOST + "ShopDishesApi_loadIndexInfo";
	private static String MAIN_INFO_BYID = HOST
			+ "ShopDishesApi_findInfoByFlag";
	private static String SELL_DISHES = HOST + "ShopDishesApi_loadDishesInfo";
	private static String SEARCH_CLASSIFY = HOST
			+ "ShopDishesApi_loadDishesType";
	private static String SEARCH_BY_NAME = HOST
			+ "ShopDishesApi_loadDishesForSearch";
	private static String LIKE = HOST + "ShopDishesApi_addOrRemoveCollection";

	public static String FIND_AD = HOST + "ShopDishesApi_gotoFoundPage";

	// 发表评论
	private static String REPORT_COMMENT = HOST
			+ "RepliesAndMessageApi_submitReply";
	// 加载菜品所有评论
	private static String ALL_COMMENT = HOST
			+ "RepliesAndMessageApi_listReplies";
	// 加载评论详情
	private static String COMMENT_DETIAL = HOST
			+ "RepliesAndMessageApi_loadRepliesInfo";

	// 获取有优惠券的店铺
	private static String GET_COUPON = HOST
			+ "ShopDishesApi_listCouponShopByCoupon";

	// 获取店铺的优惠券
	private static String GET_SHOP_COUPON = HOST
			+ "ShopDishesApi_findAllCouponByCshopid";
	// 神点评
	public static String GOD_COMMENT = HOST + "ShopDishesApi_bestreplies";

	/**
	 * 发表评论接口
	 */
	public static String reportComment(String userid, String repliesid,
			String replies) {
		return REPORT_COMMENT + "?userid=" + userid + "&repliesid=" + repliesid
				+ "&replies=" + replies;
	}

	/**
	 * 得到所有评论接口
	 */
	public static String allComment(String dishesid, String repliestype,
			String pagenum) {
		return ALL_COMMENT + "?dishesid=" + dishesid + "&repliestype="
				+ repliestype + "&pagenum=" + pagenum;
	}

	/**
	 * 得到详细评论接口
	 */

	public static String commentDetial(String repliesid, String pagenum) {
		return COMMENT_DETIAL + "?repliesid=" + repliesid + "&pagenum="
				+ pagenum;
	}

	/**
	 * 得到有优惠券的店铺
	 */
	public static String getCoupon(String pagenum) {
		return GET_COUPON + "?pagenum=" + pagenum;
	}

	/**
	 * 获取店铺的优惠券
	 */
	public static String getShopCoupon(String cshopid) {
		return GET_SHOP_COUPON + "?cshopid=" + cshopid;
	}

	/**
	 * 我喜欢，添加或移除
	 * 
	 * @param userid
	 * @param dishesid
	 * @return
	 */
	public static String getLikeUrl(String userid, String dishesid) {
		return LIKE + "?userid=" + userid + "&dishesid=" + dishesid;
	}

	/**
	 * 菜品模糊搜索
	 * 
	 * @param userid
	 * @param keywords
	 * @param typeid
	 * @param sortfield
	 * @param sortrule
	 * @param pagenum
	 */
	public static String getSearchByNameUrl(String userid, String keywords,
			String typeid, String sortfield, String sortrule, String pagenum) {
		return SEARCH_BY_NAME + "?userid=" + userid + "&keywords=" + keywords
				+ "&typeid=" + typeid + "&sortfield=" + sortfield
				+ "&sortrule=" + sortrule + "&pagenum=" + pagenum;
	}

	/**
	 * 搜索分类
	 * 
	 * @param typeid
	 * @return
	 */
	public static String getSearchClassifyUrl(String typeid) {
		return SEARCH_CLASSIFY + "?typeid=" + typeid;
	}

	/**
	 * 菜品详情
	 * 
	 * @param userid
	 * @param dishesid
	 * @return
	 */
	public static String getSellDishesUrl(String userid, int dishesid) {
		return SELL_DISHES + "?userid=" + userid + "&dishesid=" + dishesid;
	}

	/**
	 * 首页刷新接口
	 * 
	 * @param userid
	 * @param pagenum
	 * @param flag
	 *            1 我喜欢 2最近点餐 3推荐菜品 4优惠
	 * @return
	 */
	public static String getMainInfoByIdUrl(String userid, int pagenum, int flag) {
		return MAIN_INFO_BYID + "?userid=" + userid + "&pagenum=" + pagenum
				+ "&flag=" + flag;
	}

	/**
	 * 首页数据接口
	 * 
	 * @param userid
	 */
	public static String getMainInfoUrl(String userid) {
		return MAIN_INFO + "?userid=" + userid;
	}

	/**
	 * Title: getUpdateMyInfoUrl Description: 修改我的资料接口
	 * 
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
