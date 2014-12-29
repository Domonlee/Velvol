package com.velvol.o2o.ui.make;

import android.os.Bundle;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.make.ShopDetailsAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MyListView;

public class ShopDetailsActivity extends BaseActivity {
	
	private MyListView listView;
	private ShopDetailsAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_shopdetails);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		listView = (MyListView)findViewById(R.id.listview);
	}

	@Override
	protected void initView() {
		adapter = new ShopDetailsAdapter(ShopDetailsActivity.this);
		listView.setAdapter(adapter);
	}

	@Override
	protected void result(String result) {

	}

}
