package com.velvol.o2o.ui.manager;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class OrderInfoActivity extends BaseActivity {
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
	public TextView title_topbar_tv;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_orderinfo);
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
		title_topbar_tv.setText("∂©µ•œÍ«È");
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);
	
		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 5; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", "∫Ï…’«—◊”");
			map.put("price", "£§38");
			arrayList.add(map);
		}

	}

	View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.title_topbar_right_tv:
				startActivity(new Intent(OrderInfoActivity.this,
						SendMsgActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}
}