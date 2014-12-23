package com.velvol.o2o.ui.manager;

import com.velvol.o2o.R;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.login.ForgetPswActivity;

import android.R.string;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SendCommentActivity extends BaseActivity {
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_tv;
	public EditText sendmsg_info_et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_sendcom);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		sendmsg_info_et = (EditText) findViewById(R.id.sendmsg_info_et);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("∑¢±Ì∆¿¬€");
		title_topbar_back_iv.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
				//right btn
			case R.id.title_topbar_right_tv:
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
