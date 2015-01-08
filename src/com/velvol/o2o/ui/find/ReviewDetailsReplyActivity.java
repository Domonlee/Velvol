package com.velvol.o2o.ui.find;

import com.velvol.o2o.EvaluateActivity;
import com.velvol.o2o.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.tool.BaseActivity;
//回复页面
public class ReviewDetailsReplyActivity extends BaseActivity{

	//返回按钮
	private ImageView data_food_return_imageview;
	//正中标题
	private TextView title_topbar_tv;
	//标题右边
	private TextView title_topbar_right_tv;
	//回复的内容
	private TextView details_reply;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_review_details_reply);
		findViewById();
		initView();
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		data_food_return_imageview=(ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv=(TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView) findViewById(R.id.title_topbar_right_tv);
		details_reply=(TextView)findViewById(R.id.details_reply);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("回复");
		title_topbar_right_tv.setText("发表");
		data_food_return_imageview.setOnClickListener(listener);
		title_topbar_right_tv.setOnClickListener(listener);
	}
	OnClickListener listener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				startActivity(new Intent(ReviewDetailsReplyActivity.this, EvaluateActivity.class));
				break;
			case R.id.title_topbar_right_tv:
				String reply=details_reply.getText().toString();
				Intent intent=new Intent(ReviewDetailsReplyActivity.this,EvaluateActivity.class);
				intent.putExtra("reply", reply);
				startActivity(intent);
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
