package com.velvol.o2o.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class ForgetPswActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public TextView forget_next_btn;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_forget_psw);
		findViewById();
		initView();
	}


	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_back_iv = (ImageView)findViewById(R.id.title_topbar_back_iv);
		forget_next_btn = (TextView)findViewById(R.id.forget_next_btn);
		
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("’“ªÿ√‹¬Î");
		title_topbar_back_iv.setOnClickListener(clickListener);
		forget_next_btn.setOnClickListener(clickListener);
	}
	View.OnClickListener clickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				startActivity(new Intent(ForgetPswActivity.this,LoginActivity.class));
				finish();	
				break;
			case R.id.forget_next_btn:
				startActivity(new Intent(ForgetPswActivity.this,ResetPswActivity.class));
				finish();	
				break;
			}
			
		}
	};

	@Override
	protected void result(String result) {
		
	}
}
