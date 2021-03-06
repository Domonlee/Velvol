package com.velvol.o2o.ui.login;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class ForgetPswActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public TextView forget_next_btn,reg_info_mcode_btn;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	public EditText forget_phone_tv,reg_info_mcode_tv;

	public String pswFlag;

	private TimeCount time;
	private String strphone,smscode = "aaaaaa";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_forget_psw);
		pswFlag = getIntent().getStringExtra("pswFlag");

		findViewById();
		initView();
		time = new TimeCount(100000, 1000);
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		forget_next_btn = (TextView) findViewById(R.id.forget_next_btn);
		reg_info_mcode_btn = (TextView)findViewById(R.id.reg_info_mcode_btn);
		forget_phone_tv = (EditText)findViewById(R.id.forget_phone_tv);
		reg_info_mcode_tv = (EditText)findViewById(R.id.reg_info_mcode_tv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("找回密码");
		title_topbar_back_iv.setOnClickListener(clickListener);
		forget_next_btn.setOnClickListener(clickListener);
		reg_info_mcode_btn.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				if (pswFlag.equals("myInfo")) {
					finish();
				} else {
					startActivity(new Intent(ForgetPswActivity.this,
							LoginActivity.class));
					finish();
				}
				break;
			case R.id.forget_next_btn:
				String str_code = reg_info_mcode_tv.getText().toString();
				if (str_code.equals(smscode)){
					startActivity(new Intent(ForgetPswActivity.this,
							ResetPswActivity.class).putExtra("phone", strphone));
					finish();
				}
				else
					Toast.makeText(getApplicationContext(), "验证码不匹配", 0).show();
			case R.id.reg_info_mcode_btn:
				strphone = forget_phone_tv.getText().toString();
				if(emailFormat(strphone,2)){
				httpget(GetUrl.getCodeUrl("0",strphone),1);
				showProgressDialog(ForgetPswActivity.this);	
				time.start();
				}
				else 
					Toast.makeText(getApplicationContext(),"手机号码填写错误！",0).show();
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
				smscode = dataJson.getString("result");
			}
			else
				Toast.makeText(getApplicationContext(), "账号不存在", Toast.LENGTH_SHORT).show();
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "网络不给力！", Toast.LENGTH_SHORT).show();
		}
	}
	
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
		}

		@Override
		public void onFinish() {// 计时完毕时触发
			reg_info_mcode_btn.setText("重新验证");
			reg_info_mcode_btn.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// 计时过程显示
			reg_info_mcode_btn.setClickable(false);
			reg_info_mcode_btn.setText(millisUntilFinished / 1000 + "秒");
		}
	}
}
