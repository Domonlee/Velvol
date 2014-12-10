package com.velvol.o2o.ui.manager;

import com.velvol.o2o.R;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.tool.BaseActivity;

import android.R.string;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends BaseActivity {

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
	}

	@Override
	protected void initView() {
		about_company_inof_tv.setText(aboutString);
	}

	@Override
	protected void result(String result) {

	}

}
