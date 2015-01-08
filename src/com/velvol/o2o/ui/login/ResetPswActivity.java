package com.velvol.o2o.ui.login;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.R;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MD5;

public class ResetPswActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public TextView forget_next_btn;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	private EditText reset_psw_new_tv, reset_psw_confirm_tv;
	private String phone = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_reset_psw);
		findViewById();
		initView();
		phone = getIntent().getStringExtra("phone");
		if (phone.equals("")) {
			ShowToast("操作异常");
			finish();
		}
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		forget_next_btn = (TextView) findViewById(R.id.forget_next_btn);
		reset_psw_new_tv = (EditText) findViewById(R.id.reset_psw_new_tv);
		reset_psw_confirm_tv = (EditText) findViewById(R.id.reset_psw_confirm_tv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("重置密码");
		title_topbar_back_iv.setOnClickListener(clickListener);
		forget_next_btn.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				startActivity(new Intent(ResetPswActivity.this,
						ForgetPswActivity.class));
				finish();
				break;
			case R.id.forget_next_btn:
				String pass1 = reset_psw_new_tv.getText().toString();
				String pass2 = reset_psw_confirm_tv.getText().toString();
				if (pass1.equals(pass2))
					if (pass1.length() > 6)
						if (isNetworkConnected(getApplicationContext())) {
							httpget(GetUrl.getUpdateUrl(phone,
									new MD5(pass1).getMd5_32()), 1);
							showProgressDialog(ResetPswActivity.this);
						} else
							Toast.makeText(getApplicationContext(), "无网络连接", 0).show();
					else
						Toast.makeText(getApplicationContext(), "密码长度要大于6位", 0).show();
				else
					Toast.makeText(getApplicationContext(), "两次密码不一致", 0).show();

				break;
			}
		}
	};

	@Override
	protected void result(String result) {
		loadingDialog.dismiss();
		JSONObject dataJson;
		 try {
			dataJson = new JSONObject(result);
			if(dataJson.getInt("mark")==1){
				startActivity(new Intent(ResetPswActivity.this, LoginActivity.class));
				finish();
			}
			Toast.makeText(getApplicationContext(), "修改失败！", Toast.LENGTH_SHORT).show();
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "网络不给力！", Toast.LENGTH_SHORT).show();
		}
	}
}
