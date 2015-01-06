package com.velvol.o2o.ui.manager;


import com.velvol.o2o.R;
import com.velvol.o2o.adapter.MsgAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyMsgActivity extends BaseActivity {
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
	public TextView title_topbar_tv;
	public ListView mymsg_info_lv;
	public CircularImage circularImage;
	public MsgAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_mymsg);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_right_tv = (TextView) findViewById(R.id.title_topbar_right_tv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		mymsg_info_lv = (ListView) findViewById(R.id.mymsg_info_lv);
//		circularImage = (CircularImage)findViewById(R.layout.listview_mymsg_item).findViewById(R.id.mymsg_item_face_ci);
	}

	@Override
	protected void initView() {
//		circularImage.setImageResource(R.drawable.userface);
		title_topbar_tv.setText("¡Ù—‘∞Â");
		title_topbar_right_tv.setText("∑¢±Ì");
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		adapter = new MsgAdapter(MyMsgActivity.this,dm.widthPixels);
		mymsg_info_lv.setAdapter(adapter);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.title_topbar_right_tv:
				startActivity(new Intent(MyMsgActivity.this,
						SendCommentActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
