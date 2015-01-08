package com.velvol.o2o.ui.manager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.constant.UserInfo;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MD5;

public class MyInfoActivity extends BaseActivity {

	public static final int NICK = 1;
	public static final int NAME = 2;
	public static final int PHONE = 3;
	public static final int EMAIL = 4;
	public static final int CHANGEPSW = 9;
	
	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	public TextView myinfo_base_nick_edit_tv, myinfo_base_name_edit_tv,
			myinfo_base_phone_edit_tv, myinfo_base_email_edit_tv,
			myinfo_base_addr_edit_tv, myinfo_base_changepsw_edit_tv,
			myinfo_base_myscore_go_tv;
	private TextView  myinfo_base_nick_tv, myinfo_base_name_tv,
	myinfo_base_phone_tv, myinfo_base_email_tv,myinfo_base_myscore_tv,
	myinfo_base_addr_tv,myinfo_base_countextra_tv ;
	public static final String EDITCODE = "editCode";
	
	private UserInfo userInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_manager_myinfo);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		myinfo_base_nick_edit_tv = (TextView) findViewById(R.id.myinfo_base_nick_edit_tv);
		myinfo_base_name_edit_tv = (TextView) findViewById(R.id.myinfo_base_name_edit_tv);
		myinfo_base_phone_edit_tv = (TextView) findViewById(R.id.myinfo_base_phone_edit_tv);
		myinfo_base_email_edit_tv = (TextView) findViewById(R.id.myinfo_base_email_edit_tv);
		myinfo_base_addr_edit_tv = (TextView) findViewById(R.id.myinfo_base_addr_edit_tv);
		myinfo_base_changepsw_edit_tv = (TextView) findViewById(R.id.myinfo_base_changepsw_edit_tv);
		myinfo_base_myscore_go_tv = (TextView) findViewById(R.id.myinfo_base_myscore_go_tv);
		myinfo_base_nick_tv = (TextView) findViewById(R.id.myinfo_base_nick_tv);
		myinfo_base_name_tv = (TextView) findViewById(R.id.myinfo_base_name_tv);
		myinfo_base_phone_tv = (TextView) findViewById(R.id.myinfo_base_phone_tv);
		myinfo_base_email_tv = (TextView) findViewById(R.id.myinfo_base_email_tv);
		myinfo_base_myscore_tv = (TextView) findViewById(R.id.myinfo_base_myscore_tv);
		myinfo_base_addr_tv = (TextView) findViewById(R.id.myinfo_base_addr_tv);
		myinfo_base_countextra_tv = (TextView) findViewById(R.id.myinfo_base_countextra_tv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("我的资料");
		title_topbar_back_iv.setOnClickListener(clickListener);
		myinfo_base_nick_edit_tv.setOnClickListener(clickListener);
		myinfo_base_name_edit_tv.setOnClickListener(clickListener);
		myinfo_base_phone_edit_tv.setOnClickListener(clickListener);
		myinfo_base_email_edit_tv.setOnClickListener(clickListener);
		myinfo_base_addr_edit_tv.setOnClickListener(clickListener);
		myinfo_base_changepsw_edit_tv.setOnClickListener(clickListener);
		myinfo_base_myscore_go_tv.setOnClickListener(clickListener);
		
		httpget(GetUrl.getMyInfoUrl(data.User_id),1);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.myinfo_base_nick_edit_tv:
				intent.putExtra(EDITCODE,NICK);
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_name_edit_tv:
				intent.putExtra(EDITCODE, NAME);
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_phone_edit_tv:
				intent.putExtra(EDITCODE, PHONE);
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_email_edit_tv:
				intent.putExtra(EDITCODE, EMAIL);
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_addr_edit_tv:
				intent.setClass(getApplicationContext(),
						MyAddressActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_changepsw_edit_tv:
				intent.putExtra(EDITCODE, CHANGEPSW);
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;

			// 积分兑换
			case R.id.myinfo_base_myscore_go_tv:
				intent.putExtra(EDITCODE, "myscore");
				intent.setClass(getApplicationContext(), TaskActivity.class);
				startActivity(intent);
				break;

			}
		}
	};

	@Override
	protected void result(String result) {
		try {
			JSONObject jsonObject = new JSONObject(result);
			ShowLog(jsonObject+"");
			if (jsonObject.getInt("mark")== 1) {
				JSONObject userJson = jsonObject.getJSONObject("result");
				userInfo = new UserInfo(userJson);
				
				myinfo_base_nick_tv.setText(userInfo.getNickname());
				myinfo_base_name_tv.setText(userInfo.getName());
				myinfo_base_phone_tv.setText(userInfo.getPhone());
				myinfo_base_email_tv.setText(userInfo.getEmail());
				myinfo_base_addr_tv.setText(userInfo.getAddress());
				myinfo_base_myscore_tv.setText(userInfo.getScore());
				myinfo_base_countextra_tv.setText("￥"+userInfo.getBalance());
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}


	}
}
