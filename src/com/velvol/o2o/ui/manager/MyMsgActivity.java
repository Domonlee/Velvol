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
import android.widget.ImageView;
import android.widget.TextView;

public class MyMsgActivity extends BaseActivity {
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
	public TextView title_topbar_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_mymsg);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_right_tv = (TextView) findViewById(R.id.title_topbar_right_tv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("¡Ù—‘∞Â");
		title_topbar_right_tv.setText("∑¢±Ì");
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.title_topbar_right_tv:
			startActivity(new Intent(getApplicationContext(), SendMsgActivity.class));	
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
