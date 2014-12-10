package com.velvol.o2o.ui.login;

import com.velvol.o2o.HomeActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.RegisterActivity;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.manager.AboutActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {
		
	private TextView login,login2;
	private TextView reg,forget_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		login = (TextView)findViewById(R.id.login);
		login2 = (TextView)findViewById(R.id.login2);
		reg = (TextView)findViewById(R.id.reg);
		forget_tv = (TextView)findViewById(R.id.forget_tv);
	}
	
	@Override
	protected void initView() {
		login.setOnClickListener(listener);
		login2.setOnClickListener(listener);
		reg.setOnClickListener(listener);
		forget_tv.setOnClickListener(listener);
	}
	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login:
				startActivity(new Intent(LoginActivity.this,HomeActivity.class));
				finish();
				break;
			case R.id.reg:
				startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
				finish();
				break;
			case R.id.login2:
				ShowToast("´ý¿ª·¢");
//				startActivity(new Intent(LoginActivity.this,AboutActivity.class));
//				finish();
				break;
			case R.id.forget_tv:
				startActivity(new Intent(LoginActivity.this,ForgetPswActivity.class));
				finish();
				break;
			}
		}
	};
	@Override
	protected void result(String result) {

	}

}
