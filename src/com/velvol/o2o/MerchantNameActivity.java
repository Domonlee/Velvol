package com.velvol.o2o;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnDismissListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MerchantNameActivity extends Activity {

	//商家店面
	private TextView xiangqing;
	private RadioGroup radio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_merchant_name);
		xiangqing = (TextView) findViewById(R.id.xiangqing);
		radio = (RadioGroup) findViewById(R.id.merchant_radioGroup);
		xiangqing.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MerchantNameActivity.this,
						XiangqingActivity.class);
				startActivity(i);
			}
		});
		//分类点击
		
		LayoutInflater inflater = LayoutInflater.from(MerchantNameActivity.this);
		View view = inflater.inflate(R.layout.merchant_popupowindow, null);
		final PopupWindow pop = new PopupWindow(view,130, 220);
		ImageView classify = (ImageView) findViewById(R.id.merchant_classify);
		pop.setOutsideTouchable(true);
		pop.setBackgroundDrawable(new PaintDrawable());
		pop.setFocusable(true);
		classify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if(pop.isShowing()){
					pop.dismiss();
				}else {
					pop.showAsDropDown(v);				}
			}
		});
		view.findViewById(R.id.merchant_popup_mianshi).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(
						MerchantNameActivity.this,
						ClassifyActivity.class);
				i.putExtra("classify", "面食");
				startActivity(i);
				pop.dismiss();
			}
		});
view.findViewById(R.id.merchant_popup_caipin).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(
						MerchantNameActivity.this,
						ClassifyActivity.class);
				i.putExtra("classify", "菜品");
				startActivity(i);
				pop.dismiss();
			}
		});
view.findViewById(R.id.merchant_popup_yinliao).setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(
				MerchantNameActivity.this,
				ClassifyActivity.class);
		i.putExtra("classify", "饮料");
		startActivity(i);
		pop.dismiss();
	}
});
view.findViewById(R.id.merchant_popup_xiaochi).setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(
				MerchantNameActivity.this,
				ClassifyActivity.class);
		i.putExtra("classify", "小吃");
		startActivity(i);
		pop.dismiss();
	}
});
		

		radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				switch (checkedId) {
				case R.id.merchant_radio1:

					break;
				case R.id.merchant_radio2:

					break;
				case R.id.merchant_radio3:

					break;
				case R.id.merchant_radio4:

					break;

				}
			}
		});
		// 返回按钮
		findViewById(R.id.merchant_return).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.merchant_name, menu);
		return true;
	}

}
