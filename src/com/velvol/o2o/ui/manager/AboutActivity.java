package com.velvol.o2o.ui.manager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class AboutActivity extends BaseActivity {

	private ImageView title_topbar_back_iv;
	private TextView about_company_inof_tv;
	private String aboutString = "        这里应该有公司简介/n" + "这里应该有公司简介/n"
			+ "这里应该有公司简介/n";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		about_company_inof_tv = (TextView) findViewById(R.id.about_company_inof_tv);
		title_topbar_back_iv = (ImageView)findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		about_company_inof_tv.setText(aboutString);
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
