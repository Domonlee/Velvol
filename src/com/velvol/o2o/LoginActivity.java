package com.velvol.o2o;

import com.velvol.o2o.tool.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {
		
	private TextView login;
	private TextView reg;
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
		reg = (TextView)findViewById(R.id.reg);
	}
	
	@Override
	protected void initView() {
		login.setOnClickListener(listener);
		reg.setOnClickListener(listener);
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
			default:
				break;
			}
		}
	};
	@Override
	protected void result(String result) {

	}

}
