package com.velvol.o2o.ui.find;


import com.velvol.o2o.R;
import com.velvol.o2o.adapter.RoomNumberFriendFootAdapter;
import com.velvol.o2o.tool.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
//进入拼单房间
public class MargeActivity extends BaseActivity {

	private EditText marge_editText;
	private TextView marge_submit_btn;
	//获得的房间号
	private String argeRoomNumber;
	//回退按钮
	private ImageView marge_submit_return_imageview;
	//正中的标题
	private TextView title_topbar_tv;
	//右边的标题
	private TextView title_topbar_right_tv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_marge);
		// Show the Up button in the action bar.
		findViewById();
		initView();

	}

	@Override
	protected void findViewById() {
		marge_editText=(EditText)findViewById(R.id.marge_editText);
		marge_submit_btn=(TextView)findViewById(R.id.marge_submit_textview);
		marge_submit_return_imageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("多人拼单");
		marge_submit_btn.setOnClickListener(clickListener);
		marge_submit_return_imageview.setOnClickListener(clickListener);
	}
	View.OnClickListener clickListener = new OnClickListener() {


		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.marge_submit_textview:
				argeRoomNumber=marge_editText.getText().toString();
				startActivity(new Intent(MargeActivity.this,FriendRoomNumberActivity.class ));
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
