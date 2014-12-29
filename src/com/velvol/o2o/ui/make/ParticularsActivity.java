package com.velvol.o2o.ui.make;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.EvaluateActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.make.EvaluateAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MyListView;

public class ParticularsActivity extends BaseActivity {

	// ฯ๊ว้าณ
	private TextView merchantName;
	private LinearLayout popLayout;
	private ImageView back, classify;
	private MyListView listView;
	private EvaluateAdapter adapter;
	private boolean pop_layout_flag = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_particulars);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		merchantName = (TextView) findViewById(R.id.particulars_tv_merchantName);
		back = (ImageView) findViewById(R.id.particulars_return);
		classify = (ImageView) findViewById(R.id.classify);
		listView = (MyListView) findViewById(R.id.listview);
		popLayout = (LinearLayout) findViewById(R.id.pop_layout);
	}

	@Override
	protected void initView() {
		merchantName.setOnClickListener(listener);
		back.setOnClickListener(listener);
		classify.setOnClickListener(listener);
		adapter = new EvaluateAdapter(ParticularsActivity.this);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(ParticularsActivity.this,
						EvaluateActivity.class));
			}
		});
	}

	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.classify:
				if (!pop_layout_flag)
					popLayout.setVisibility(View.VISIBLE);
				else
					popLayout.setVisibility(View.GONE);
				pop_layout_flag = !pop_layout_flag;
				break;
			case R.id.particulars_return:
				finish();
				break;
			case R.id.particulars_tv_merchantName:
<<<<<<< HEAD
<<<<<<< HEAD
				startActivity(new Intent(ParticularsActivity.this,
						ShopDetailsActivity.class));
=======
				startActivity(new Intent(ParticularsActivity.this,ShopDetailsActivity.class));
>>>>>>> e44722412540ad2f259fc94309a4a80802551648
=======
				
>>>>>>> d56c82afe2c99353a5f35878e0dac4c884091a94
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
