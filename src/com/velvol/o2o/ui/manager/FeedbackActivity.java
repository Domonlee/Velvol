package com.velvol.o2o.ui.manager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class FeedbackActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_manager_feedback);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("�������");
		title_topbar_back_iv.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.forget_next_btn:
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}
}
