package com.velvol.o2o.ui.manager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class MyAddressActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public TextView title_topbar_right_tv;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	public EditText myaddr_info_pro_ed, myaddr_info_city_ed,
			myaddr_info_area_ed, myaddr_info_road_ed, myaddr_info_street_ed,
			myaddr_info_more_ed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_manager_myaddr);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		myaddr_info_pro_ed = (EditText) findViewById(R.id.myaddr_info_pro_ed);
		myaddr_info_city_ed = (EditText) findViewById(R.id.myaddr_info_city_ed);
		myaddr_info_area_ed = (EditText) findViewById(R.id.myaddr_info_area_ed);
		myaddr_info_road_ed = (EditText) findViewById(R.id.myaddr_info_road_ed);
		myaddr_info_street_ed = (EditText) findViewById(R.id.myaddr_info_street_ed);
		myaddr_info_more_ed = (EditText) findViewById(R.id.myaddr_info_more_ed);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("�ҵĵ�ַ");
		title_topbar_right_tv.setText("�༭");
		title_topbar_right_tv.setGravity(Gravity.CENTER);
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
			// the right btn for edit
			case R.id.title_topbar_right_tv:
				startActivity(new Intent(getApplicationContext(), ChangeAddressActivity.class));
				break;
			}
		}
	};

	// ����EditText����״̬
	public void changeEdEnable(boolean b) {
		if (b==true) {
		myaddr_info_pro_ed.setEnabled(true);
		myaddr_info_city_ed.setEnabled(true);
		myaddr_info_area_ed.setEnabled(true);
		myaddr_info_road_ed.setEnabled(true);
		myaddr_info_street_ed.setEnabled(true);
		myaddr_info_more_ed.setEnabled(true);
		title_topbar_right_tv.setText("���");
		}
		else {
		myaddr_info_pro_ed.setEnabled(false);
		myaddr_info_city_ed.setEnabled(false);
		myaddr_info_area_ed.setEnabled(false);
		myaddr_info_road_ed.setEnabled(false);
		myaddr_info_street_ed.setEnabled(false);
		myaddr_info_more_ed.setEnabled(false);
		title_topbar_right_tv.setText("�༭");
		}
	}

	@Override
	protected void result(String result) {

	}
}
