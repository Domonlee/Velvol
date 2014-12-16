package com.velvol.o2o.ui.manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class MyInfoActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;

	public TextView myinfo_base_nick_edit_tv, myinfo_base_name_edit_tv,
			myinfo_base_phone_edit_tv, myinfo_base_email_edit_tv,
			myinfo_base_addr_edit_tv, myinfo_base_changepsw_edit_tv,
			myinfo_base_myscore_go_tv;
	public String EDITCODE = "editCode";

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
				intent.putExtra(EDITCODE, "nick");
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_name_edit_tv:
				intent.putExtra(EDITCODE, "name");
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_phone_edit_tv:
				intent.putExtra(EDITCODE, "phone");
				intent.setClass(getApplicationContext(),
						ChangeInfoActivity.class);
				startActivity(intent);
				break;
			case R.id.myinfo_base_email_edit_tv:
				intent.putExtra(EDITCODE, "email");
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
				intent.putExtra(EDITCODE, "changepsw");
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

	}
}
