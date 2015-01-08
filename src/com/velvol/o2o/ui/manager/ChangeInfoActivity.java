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
import com.velvol.o2o.ui.login.ForgetPswActivity;

public class ChangeInfoActivity extends BaseActivity {

	public TextView title_topbar_tv, title_topbar_right_tv;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout, changeinfo_line1_layout,
			changeinfo_line2_layout, changeinfo_line3_layout,
			changeinfo_history_layout;

	public TextView changeinfo_line1_tv, changeinfo_line2_tv,
			changeinfo_line3_tv, changeinfo_notice_tv, changeinfo_forgetpsw_tv;
	public int editCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_changeinfo);
		Intent intent = getIntent();
		editCode = intent.getIntExtra(MyInfoActivity.EDITCODE,0);

//		editCode = intent.getStringExtra(MyInfoActivity.EDITCODE);

		ShowToast(editCode+"");

		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		changeinfo_line1_layout = (LinearLayout) findViewById(R.id.changeinfo_line1_layout);
		changeinfo_line2_layout = (LinearLayout) findViewById(R.id.changeinfo_line2_layout);
		changeinfo_line3_layout = (LinearLayout) findViewById(R.id.changeinfo_line3_layout);
		changeinfo_history_layout = (LinearLayout) findViewById(R.id.changeinfo_history_layout);
		changeinfo_line1_tv = (TextView) findViewById(R.id.changeinfo_line1_tv);
		changeinfo_line2_tv = (TextView) findViewById(R.id.changeinfo_line2_tv);
		changeinfo_line3_tv = (TextView) findViewById(R.id.changeinfo_line3_tv);
		changeinfo_notice_tv = (TextView) findViewById(R.id.changeinfo_notice_tv);
		changeinfo_forgetpsw_tv = (TextView) findViewById(R.id.changeinfo_forgetpsw_tv);

	}

	@Override
	protected void initView() {
		title_topbar_right_tv.setText("完成");
		switch (editCode) {
		case 1:
			title_topbar_tv.setText("修改昵称");
			changeinfo_line1_tv.setText("昵称:");
			changeinfo_line2_layout.setVisibility(View.GONE);
			changeinfo_line3_layout.setVisibility(View.GONE);
			changeinfo_history_layout.setVisibility(View.GONE);
			changeinfo_notice_tv.setVisibility(View.VISIBLE);
			changeinfo_forgetpsw_tv.setVisibility(View.GONE);
			break;
		case 2:
			title_topbar_tv.setText("修改真实姓名");
			changeinfo_line1_tv.setText("真实姓名:");
			changeinfo_line2_layout.setVisibility(View.GONE);
			changeinfo_line3_layout.setVisibility(View.GONE);
			changeinfo_history_layout.setVisibility(View.GONE);
			changeinfo_notice_tv.setVisibility(View.GONE);
			changeinfo_forgetpsw_tv.setVisibility(View.GONE);
			break;

		case 4:
			title_topbar_tv.setText("修改邮箱");
			changeinfo_line1_tv.setText("邮箱:");
			changeinfo_line2_layout.setVisibility(View.GONE);
			changeinfo_line3_layout.setVisibility(View.GONE);
			changeinfo_history_layout.setVisibility(View.GONE);
			changeinfo_notice_tv.setVisibility(View.GONE);
			changeinfo_forgetpsw_tv.setVisibility(View.GONE);
			break;

		case 9:
			title_topbar_tv.setText("修改密码");
			changeinfo_line1_tv.setText("原始密码:");
			changeinfo_line2_tv.setText("新密码:");
			changeinfo_line3_tv.setText("确认密码:");
			changeinfo_line2_layout.setVisibility(View.VISIBLE);
			changeinfo_history_layout.setVisibility(View.GONE);
			changeinfo_line3_layout.setVisibility(View.VISIBLE);
			changeinfo_notice_tv.setVisibility(View.GONE);
			changeinfo_forgetpsw_tv.setVisibility(View.VISIBLE);
			break;

		case 3:
			title_topbar_tv.setText("修改联系电话");
			changeinfo_line1_tv.setText("手机号:");
			changeinfo_line2_layout.setVisibility(View.GONE);
			changeinfo_line3_layout.setVisibility(View.GONE);
			changeinfo_history_layout.setVisibility(View.VISIBLE);
			changeinfo_notice_tv.setVisibility(View.GONE);
			changeinfo_forgetpsw_tv.setVisibility(View.GONE);
			break;
			
			default:
				break;
		}
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);
		changeinfo_forgetpsw_tv.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.title_topbar_right_tv:
				finish();
				break;
			case R.id.changeinfo_forgetpsw_tv:
				Intent gotoPswIntent = new Intent();
				gotoPswIntent.setClass(ChangeInfoActivity.this,
						ForgetPswActivity.class);
				gotoPswIntent.putExtra("pswFlag", "myInfo");
				startActivity(gotoPswIntent);
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}
}
