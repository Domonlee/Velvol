package com.velvol.o2o.ui.manager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class UserFaceActivity extends BaseActivity {

	private ImageView title_topbar_back_iv;
	public TextView title_topbar_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_userface);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("ÉÏ´«Í·Ïñ");
		title_topbar_back_iv.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (R.id.title_topbar_back_iv) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
