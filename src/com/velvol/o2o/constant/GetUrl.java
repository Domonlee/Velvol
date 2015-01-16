package com.velvol.o2o.constant;

public class GetUrl {

	// private static String HOST = "http://192.168.1.124:8888/diancan/check_";
	private static String HOST = "http://www.xiao2.me:8080/";
	// ͼƬͷ��
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

	// ��������
	private static String REPORT_COMMENT = HOST
			+ "RepliesAndMessageApi_submitReply";
	// ���ز�Ʒ��������
	private static String ALL_COMMENT = HOST
			+ "RepliesAndMessageApi_listReplies";
	// ������������
	private static String COMMENT_DETIAL = HOST
			+ "RepliesAndMessageApi_loadRepliesInfo";

	// ��ȡ���Ż�ȯ�ĵ���
	private static String GET_COUPON = HOST
			+ "ShopDishesApi_listCouponShopByCoupon";

	// ��ȡ���̵��Ż�ȯ
	private static String GET_SHOP_COUPON = HOST
			+ "ShopDishesApi_findAllCouponByCshopid";
	// �����
	public static String GOD_COMMENT = HOST + "ShopDishesApi_bestreplies";

	/**
	 * �������۽ӿ�
	 */
	public static String reportComment(String userid, String repliesid,
			String replies) {
		return REPORT_COMMENT + "?userid=" + userid + "&repliesid=" + repliesid
				+ "&replies=" + replies;
	}

	/**
	 * �õ��������۽ӿ�
	 */
	public static String allComment(String dishesid, String repliestype,
			String pagenum) {
		return ALL_COMMENT + "?dishesid=" + dishesid + "&repliestype="
				+ repliestype + "&pagenum=" + pagenum;
	}

	/**
	 * �õ���ϸ���۽ӿ�
	 */

	public static String commentDetial(String repliesid, String pagenum) {
		return COMMENT_DETIAL + "?repliesid=" + repliesid + "&pagenum="
				+ pagenum;
	}

	/**
	 * �õ����Ż�ȯ�ĵ���
	 */
	public static String getCoupon(String pagenum) {
		return GET_COUPON + "?pagenum=" + pagenum;
	}

	/**
	 * ��ȡ���̵��Ż�ȯ
	 */
	public static String getShopCoupon(String cshopid) {
		return GET_SHOP_COUPON + "?cshopid=" + cshopid;
	}

	/**
	 * ��ϲ������ӻ��Ƴ�
	 * 
	 * @param userid
	 * @param dishesid
	 * @return
	 */
	public static String getLikeUrl(String userid, String dishesid) {
		return LIKE + "?userid=" + userid + "&dishesid=" + dishesid;
	}

	/**
	 * ��Ʒģ������
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
	 * ��������
	 * 
	 * @param typeid
	 * @return
	 */
	public static String getSearchClassifyUrl(String typeid) {
		return SEARCH_CLASSIFY + "?typeid=" + typeid;
	}

	/**
	 * ��Ʒ����
	 * 
	 * @param userid
	 * @param dishesid
	 * @return
	 */
	public static String getSellDishesUrl(String userid, int dishesid) {
		return SELL_DISHES + "?userid=" + userid + "&dishesid=" + dishesid;
	}

	/**
	 * ��ҳˢ�½ӿ�
	 * 
	 * @param userid
	 * @param pagenum
	 * @param flag
	 *            1 ��ϲ�� 2������ 3�Ƽ���Ʒ 4�Ż�
	 * @return
	 */
	public static String getMainInfoByIdUrl(String userid, int pagenum, int flag) {
		return MAIN_INFO_BYID + "?userid=" + userid + "&pagenum=" + pagenum
				+ "&flag=" + flag;
	}

	/**
	 * ��ҳ���ݽӿ�
	 * 
	 * @param userid
	 */
	public static String getMainInfoUrl(String userid) {
		return MAIN_INFO + "?userid=" + userid;
	}

	/**
	 * Title: getUpdateMyInfoUrl Description: �޸��ҵ����Ͻӿ�
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
	 * �ҵ����Ͻӿ�
	 */
	public static String getMyInfoUrl(String userid) {
		return MYINFO + "?userid=" + userid;
	}

	/**
	 * ������ַ�ӿ�
	 */
	public static String getAddAddressUrl(String userid, String uadressid,
			String floor) {
		return ADDRESS_ADD + "?userid=" + userid + "&uadressid=" + uadressid
				+ "&floor=" + floor;
	}

	/**
	 * ��ʷ��ַ�ӿ�
	 */
	public static String getOldAddressUrl(String userid) {
		return ADDRESS_OLD + "?userid=" + userid;
	}

	/**
	 * ������ַ�ӿ�
	 */
	public static String getAddressUrl(String keywords) {
		return ADDRESS + "?keywords=" + keywords;
	}

	/**
	 * �޸�����ӿ�
	 */
	public static String getUpdateUrl(String newpassword, String phone) {
		return UPDATE + "?phone=" + phone + "&newpassword=" + newpassword;
	}

	/**
	 * ע��ӿ�
	 */
	public static String getRegisterUrl(String password, String phone,
			String nickname) {
		return REGISTER + "?phone=" + phone + "&password=" + password
				+ "&nickname=" + nickname;
	}

	/**
	 * ��ȡ��֤��ӿ�
	 */
	public static String getCodeUrl(String operatype, String phone) {
		return CODE + "?phone=" + phone + "&operatype=" + operatype;
	}

	/**
	 * ��¼�ӿ�
	 */
	public static String getLoginUrl(String password, String phone) {
		return LOGIN + "?phone=" + phone + "&password=" + password;
	}
}
