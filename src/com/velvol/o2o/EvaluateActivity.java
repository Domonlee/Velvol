package com.velvol.o2o;


import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.velvol.o2o.adapter.RepayAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;

public class EvaluateActivity extends BaseActivity {
	private ImageView back;
	private TextView top_title,top_menu;
	private CircularImage user_img;
	private LinearLayout img_layout;
	private RatingBar lv;
	private ListView listView;
	private RepayAdapter adapter;
	private int width = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluate);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		width = dm.widthPixels;
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		back = (ImageView)findViewById(R.id.title_topbar_back_iv);
		top_title = (TextView) findViewById(R.id.title_topbar_tv);
		top_menu = (TextView) findViewById(R.id.title_topbar_right_tv);
		user_img = (CircularImage) findViewById(R.id.user_img);
		img_layout = (LinearLayout)findViewById(R.id.img_layout);
		lv = (RatingBar)findViewById(R.id.lv);
		listView = (ListView)findViewById(R.id.listview);
	}

	@Override
	protected void initView() {
		back.setOnClickListener(listener);
		lv.setProgress(4);
		top_menu.setVisibility(View.GONE);
		top_title.setText("∆¿º€œÍ«È");
		user_img.setImageResource(R.drawable.userface);
		adapter = new RepayAdapter(EvaluateActivity.this);
		listView.setAdapter(adapter);
		img_layout.addView(Img(""));
		img_layout.addView(Img(""));
		img_layout.addView(Img(""));
		img_layout.addView(Img(""));
		
	}
	View.OnClickListener listener = new View.OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;

			default:
				break;
			}
		}
	};
	public ImageView Img(String filepath){
		LinearLayout.LayoutParams params = new LayoutParams(width/4,width/4);
		ImageView imageView = new ImageView(EvaluateActivity.this);
		params.setMargins(10, 0, 10, 0);
		imageView.setLayoutParams(params);
		imageView.setImageResource(R.drawable.test1);
		imageView.setScaleType(ScaleType.CENTER_CROP);
//		imageLoader.displayImage(filepath, imageView,
//				data.displayImageOptions);
		return imageView;
	}
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
