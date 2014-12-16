package com.velvol.o2o.ui.manager;

import java.util.ArrayList;
import java.util.HashMap;

import com.velvol.o2o.R;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.login.ForgetPswActivity;
import com.velvol.o2o.view.CircularImage;

import android.R.string;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MyMsgActivity extends BaseActivity {
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
	public TextView title_topbar_tv;
	public ListView mymsg_info_lv;
	public CircularImage circularImage;

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
		title_topbar_tv.setText("留言板");
		title_topbar_right_tv.setText("发表");
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);

		ArrayList<HashMap<String, String>> msgArrayList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("userName", "Domon");
			map.put("userMsg", "这里就是一个评论，这里是个评论");
			msgArrayList.add(map);
		}

		SimpleAdapter simpleAdapter = new SimpleAdapter(MyMsgActivity.this,
				msgArrayList, R.layout.listview_mymsg_item, new String[] {
						"userName", "userMsg" }, new int[] {
						R.id.mymsg_item_username_tv, R.id.mymsg_item_msg_tv });
		mymsg_info_lv.setAdapter(simpleAdapter);
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
						SendMsgActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
