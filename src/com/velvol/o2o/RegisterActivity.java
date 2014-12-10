package com.velvol.o2o;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.login.LoginActivity;

public class RegisterActivity extends BaseActivity {
	public LinearLayout topLayout, reg_info_mcode_layout,
			reg_info_protocol_layout;
	public ImageView topBack_iv;
	public RadioGroup reg_tab_rg;
	public RadioButton reg_tab01_tv, reg_tab02_tv, reg_tab03_tv;
	public TextView reg_info_protocol_info_tv, reg_info_submit_btn,
			reg_info_mcode_btn;
	public EditText reg_info_line1_tv, reg_info_line2_tv, reg_info_line3_tv,
			reg_info_mcode_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(getWindow().FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		topBack_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		reg_tab_rg = (RadioGroup) findViewById(R.id.reg_bar_rg);
		reg_tab01_tv = (RadioButton) findViewById(R.id.reg_tab01_tv);
		reg_tab02_tv = (RadioButton) findViewById(R.id.reg_tab02_tv);
		reg_tab03_tv = (RadioButton) findViewById(R.id.reg_tab03_tv);
		reg_info_line1_tv = (EditText) findViewById(R.id.reg_info_line1_tv);
		reg_info_line2_tv = (EditText) findViewById(R.id.reg_info_line2_tv);
		reg_info_line3_tv = (EditText) findViewById(R.id.reg_info_line3_tv);
		reg_info_mcode_tv = (EditText) findViewById(R.id.reg_info_mcode_tv);
		reg_info_protocol_info_tv = (TextView) findViewById(R.id.reg_info_protocol_info_tv);
		reg_info_submit_btn = (TextView) findViewById(R.id.reg_info_submit_btn);
		reg_info_mcode_btn = (TextView) findViewById(R.id.reg_info_mcode_btn);
		reg_info_mcode_layout = (LinearLayout) findViewById(R.id.reg_info_mcode_layout);
		reg_info_protocol_layout = (LinearLayout) findViewById(R.id.reg_info_protocol_layout);
	}

	@Override
	protected void initView() {

		// reg_info_protocol_info_tv.setText(Html.fromHtml("<a href=\"http://www.w3school.com.cn/\">Visit W3School</a>"));

		topBack_iv.setOnClickListener(listener);
		reg_tab01_tv.setChecked(true);

		// 页签选择
		reg_tab_rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.reg_tab01_tv:
					reg_info_mcode_layout.setVisibility(View.GONE);
					reg_info_line1_tv.setVisibility(View.VISIBLE);
					reg_info_protocol_layout.setVisibility(View.VISIBLE);
					reg_info_line1_tv.setHint("请输入手机号码");
					reg_info_line2_tv.setVisibility(View.GONE);
					reg_info_line3_tv.setVisibility(View.GONE);
					reg_info_submit_btn.setText("获取验证码");
					break;
				case R.id.reg_tab02_tv:
					reg_info_mcode_layout.setVisibility(View.VISIBLE);
					reg_info_protocol_layout.setVisibility(View.GONE);
					reg_info_line1_tv.setVisibility(View.GONE);
					reg_info_line2_tv.setVisibility(View.GONE);
					reg_info_line3_tv.setVisibility(View.GONE);
					reg_info_submit_btn.setText("确定");
					break;
				case R.id.reg_tab03_tv:
					reg_info_mcode_layout.setVisibility(View.GONE);
					reg_info_protocol_layout.setVisibility(View.GONE);
					reg_info_line1_tv.setVisibility(View.VISIBLE);
					reg_info_line2_tv.setVisibility(View.VISIBLE);
					reg_info_line3_tv.setVisibility(View.VISIBLE);
					reg_info_line1_tv.setHint("设置昵称");
					reg_info_line2_tv.setHint("设置密码");
					reg_info_line3_tv.setHint("确认密码");
					reg_info_submit_btn.setText("确定");
					break;
				}

			}
		});
	}

	View.OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				startActivity(new Intent(RegisterActivity.this,
						LoginActivity.class));
				finish();
				break;
			case R.id.reg_tab01_tv:
				// reg_tab01_tv.setPressed(true);
				break;
			case R.id.reg_tab02_tv:
				break;
			case R.id.reg_tab03_tv:
				break;
			}

		}
	};

	@Override
	protected void result(String result) {

	}

}
