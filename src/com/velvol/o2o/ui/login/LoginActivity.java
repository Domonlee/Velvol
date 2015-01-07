package com.velvol.o2o.ui.login;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.HomeActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.RegisterActivity;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.ConfigUtil;
import com.velvol.o2o.tool.MD5;

public class LoginActivity extends BaseActivity {

	private TextView login, login2;
	private TextView reg, forget_tv;
	private EditText edit_username, edit_password;

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
		login = (TextView) findViewById(R.id.login);
		login2 = (TextView) findViewById(R.id.login2);
		reg = (TextView) findViewById(R.id.reg);
		forget_tv = (TextView) findViewById(R.id.forget_tv);
		edit_password = (EditText) findViewById(R.id.password);
		edit_username = (EditText) findViewById(R.id.username);
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
				String name = edit_username.getText().toString();
				String pw = edit_password.getText().toString();
				if (emailFormat(name, 2))
					if (!name.equals("") && !pw.equals("")) {
						if (isNetworkConnected(LoginActivity.this)) {
							 showProgressDialog(LoginActivity.this);
							 // XXX 接口地址    测试链接
							 httpget(GetUrl.getLoginUrl(new MD5(pw).getMd5_32(), name), 1);  
						} else
							ShowToast("请检查网络连接");
					} else
						ShowToast("用户名或密码不能为空");
				else
					ShowToast("请检查手机号码");
				break;
			case R.id.reg:
				startActivity(new Intent(LoginActivity.this,
						RegisterActivity.class));
				break;
			case R.id.login2:
				ShowToast("待开发");
				
				break;
			case R.id.forget_tv:
				startActivity(new Intent(LoginActivity.this,
						ForgetPswActivity.class));
				break;
			}
		}
	};

	/**
	 * http_get() 回调函数
	 */
	protected void result(String result) {
		loadingDialog.dismiss();
		
		try {
			JSONObject c = new JSONObject(result);
			if (c.getInt("mark") == 1) {
				ConfigUtil.putBoolean("login_flag", data.login_flag = true);
				ConfigUtil.putString("user_id", data.User_id = c.getInt("result")+"");
				startActivity(new Intent(LoginActivity.this,
						HomeActivity.class));
				finish();
			}
			else
				Toast.makeText(getApplicationContext(), "密码错误。", 0).show();
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(),"网络不给力", 0).show();
		}
	}

}
