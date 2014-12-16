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

public class MyOrderActivity extends BaseActivity {
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
	public TextView title_topbar_tv;
	public ListView myorder_info_lv;
	public RadioButton myorder_all_tv, myorder_unpay_tv, myorder_unsend_tv,
			myorder_uncommit_tv, myorder_uncomment_tv;
	public RadioGroup myorder_titlebar_rg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_myorder);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_right_tv = (TextView) findViewById(R.id.title_topbar_right_tv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		myorder_info_lv = (ListView) findViewById(R.id.myorder_info_lv);

		myorder_titlebar_rg = (RadioGroup) findViewById(R.id.myorder_titlebar_rg);
		myorder_all_tv = (RadioButton) findViewById(R.id.myorder_all_tv);
		myorder_unpay_tv = (RadioButton) findViewById(R.id.myorder_unpay_tv);
		myorder_unsend_tv = (RadioButton) findViewById(R.id.myorder_unsend_tv);
		myorder_uncommit_tv = (RadioButton) findViewById(R.id.myorder_uncommit_tv);
		myorder_uncomment_tv = (RadioButton) findViewById(R.id.myorder_uncomment_tv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("Œ“µƒ∂©µ•");
		title_topbar_right_tv.setText("±‡º≠");
		setDrawableDir();
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);
		myorder_all_tv.setOnClickListener(clickListener);

		ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 5; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", "∫Ï…’«—◊”");
			map.put("price", "£§38");
			arrayList.add(map);
		}

		SimpleAdapter simpleAdapter = new SimpleAdapter(MyOrderActivity.this,
				arrayList, R.layout.listview_myorder_item, new String[] {
						"name", "price" }, new int[] {
						R.id.myorder_item_name_tv, R.id.myorder_item_price_tv });
		myorder_info_lv.setAdapter(simpleAdapter);

	}

	// …Ë÷√Õº∆¨æ”◊Û
	private void setDrawableDir() {
		Drawable drawable = getResources().getDrawable(
				R.drawable.myorder_search_icon);
		drawable.setBounds(0, 0, drawable.getMinimumWidth(),
				drawable.getMinimumHeight());
		title_topbar_right_tv.setCompoundDrawables(drawable, null, null, null);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.title_topbar_right_tv:
				startActivity(new Intent(MyOrderActivity.this,
						SendMsgActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}
}