package com.velvol.o2o.ui.make;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.make.ShopDetailsAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MyListView;

public class ShopDetailsActivity extends BaseActivity {
	
	private TextView show_map;
	private ImageView back;
	private MyListView listView;
	private ShopDetailsAdapter adapter;
	private DialogMap map; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_shopdetails);
		SDKInitializer.initialize(getApplicationContext());
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		listView = (MyListView)findViewById(R.id.listview);
		show_map = (TextView)findViewById(R.id.show_map);
		back = (ImageView)findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		adapter = new ShopDetailsAdapter(ShopDetailsActivity.this);
		listView.setAdapter(adapter);
		show_map.setOnClickListener(listener);
		back.setOnClickListener(listener);
		map = new DialogMap();
	}
	View.OnClickListener listener = new View.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.show_map:
				map.showDitu(ShopDetailsActivity.this, 34.260921*1E6, 108.895761*1E6);
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			default:
				break;
			}
		}
	};
	@Override
	protected void result(String result) {

	}

}
