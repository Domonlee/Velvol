package com.velvol.o2o.ui.login;

import com.velvol.o2o.HomeActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.RegisterActivity;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.ConfigUtil;
import com.velvol.o2o.tool.MD5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
							 // XXX �ӿڵ�ַ    ��������
							 httpget(GetUrl.getLoginUrl(new MD5(pw).getMd5_32(), name), 1);  
						} else
							ShowToast("������������");
					} else
						ShowToast("�û��������벻��Ϊ��");
				else
					ShowToast("�����ֻ�����");
				break;
			case R.id.reg:
				startActivity(new Intent(LoginActivity.this,
						RegisterActivity.class));
				break;
			case R.id.login2:
				ShowToast("������");
				
				break;
			case R.id.forget_tv:
				startActivity(new Intent(LoginActivity.this,
						ForgetPswActivity.class));
				break;
			}
		}
	};

	/**
	 * http_get() �ص�����
	 */
	protected void result(String result) {
		loadingDialog.dismiss();
		ConfigUtil.putBoolean("login_flag", data.login_flag = true);
		startActivity(new Intent(LoginActivity.this,
				HomeActivity.class));
		finish();
		// XXX ��ʽ���̴���
//		try {
//			JSONObject c = new JSONObject(result);
//			if (c.getInt("mark") == 1) {
//				ConfigUtil.putBoolean("login_flag", data.login_flag = true);
//			}
//			else
//				Toast.makeText(getApplicationContext(), c.getString("meg"), 0).show();
//		} catch (JSONException e) {
//			e.printStackTrace();
//			Toast.makeText(getApplicationContext(),"����ӿ��쳣", 0).show();
//		}
	}

}
