package com.velvol.o2o;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MD5;
import com.velvol.o2o.ui.login.LoginActivity;

public class RegisterActivity extends BaseActivity {
	public LinearLayout topLayout, reg_info_mcode_layout,
			reg_info_protocol_layout;
	public ImageView topBack_iv;
	public RadioGroup reg_tab_rg;
	public RadioButton reg_tab01_tv, reg_tab02_tv, reg_tab03_tv;
	public TextView reg_info_protocol_info_tv, reg_info_submit_btn,
			reg_info_mcode_btn;
	public EditText reg_info_line1_tv, reg_info_line2_tv, reg_info_line3_tv,
			reg_info_mcode_tv;
	private TimeCount time;
	private String strphone, sendcode = "aaaaaa";
	private boolean reg_flag = false;
	private int sub_action = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_register);
		findViewById();
		initView();
		time = new TimeCount(100000, 1000);
	}

	@Override
	protected void findViewById() {
		topBack_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		reg_tab_rg = (RadioGroup) findViewById(R.id.reg_bar_rg);
		reg_tab01_tv = (RadioButton) findViewById(R.id.reg_tab01_tv);
		reg_tab02_tv = (RadioButton) findViewById(R.id.reg_tab02_tv);
		reg_tab03_tv = (RadioButton) findViewById(R.id.reg_tab03_tv);
		reg_info_line1_tv = (EditText) findViewById(R.id.reg_info_line1_tv);
		reg_info_line2_tv = (EditText) findViewById(R.id.reg_info_line2_tv);
		reg_info_line3_tv = (EditText) findViewById(R.id.reg_info_line3_tv);
		reg_info_mcode_tv = (EditText) findViewById(R.id.reg_info_mcode_tv);
		reg_info_protocol_info_tv = (TextView) findViewById(R.id.reg_info_protocol_info_tv);
		reg_info_submit_btn = (TextView) findViewById(R.id.reg_info_submit_btn);
		reg_info_mcode_btn = (TextView) findViewById(R.id.reg_info_mcode_btn);
		reg_info_mcode_layout = (LinearLayout) findViewById(R.id.reg_info_mcode_layout);
		reg_info_protocol_layout = (LinearLayout) findViewById(R.id.reg_info_protocol_layout);
	}

	@Override
	protected void initView() {

		// reg_info_protocol_info_tv.setText(Html.fromHtml("<a href=\"http://www.w3school.com.cn/\">Visit W3School</a>"));

		topBack_iv.setOnClickListener(listener);
		reg_info_mcode_btn.setOnClickListener(listener);
		reg_info_submit_btn.setOnClickListener(listener);

		// 页签选择
		reg_tab_rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.reg_tab01_tv:
					reg_info_mcode_layout.setVisibility(View.GONE);
					reg_info_line1_tv.setVisibility(View.VISIBLE);
					reg_info_protocol_layout.setVisibility(View.VISIBLE);
					reg_info_line1_tv.setHint("请输入手机号码");
					reg_info_line2_tv.setVisibility(View.GONE);
					reg_info_line3_tv.setVisibility(View.GONE);
					reg_info_submit_btn.setText("获取验证码");
					break;
				case R.id.reg_tab02_tv:
					reg_info_mcode_layout.setVisibility(View.VISIBLE);
					reg_info_protocol_layout.setVisibility(View.GONE);
					reg_info_line1_tv.setVisibility(View.GONE);
					reg_info_line2_tv.setVisibility(View.GONE);
					reg_info_line3_tv.setVisibility(View.GONE);
					reg_info_submit_btn.setText("确定");
					break;
				case R.id.reg_tab03_tv:
					reg_info_mcode_layout.setVisibility(View.GONE);
					reg_info_protocol_layout.setVisibility(View.GONE);
					reg_info_line1_tv.setVisibility(View.VISIBLE);
					reg_info_line2_tv.setVisibility(View.VISIBLE);
					reg_info_line3_tv.setVisibility(View.VISIBLE);
					reg_info_line1_tv.setHint("设置昵称");
					reg_info_line2_tv.setHint("设置密码");
					reg_info_line3_tv.setHint("确认密码");
					reg_info_submit_btn.setText("确定");
					break;
				}

			}
		});
		reg_tab01_tv.setChecked(true);
	}

	View.OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				startActivity(new Intent(RegisterActivity.this,
						LoginActivity.class));
				finish();

				break;
			case R.id.reg_info_mcode_btn:
				httpget(GetUrl.getCodeUrl("1", strphone), 1);
				showProgressDialog(RegisterActivity.this);
				time.start();
				break;
			case R.id.reg_info_submit_btn:
				switch (sub_action) {
				case 0:
					strphone = reg_info_line1_tv.getText().toString();
					if (emailFormat(strphone, 2)) {
						httpget(GetUrl.getCodeUrl("1", strphone), 1);
						showProgressDialog(RegisterActivity.this);
						time.start();
					} else
						Toast.makeText(getApplicationContext(), "手机号码填写错误！", 0).show();
					break;
				case 1:
					String str_code = reg_info_mcode_tv.getText().toString();
					if (str_code.equals(sendcode)){
						sub_action++;
						reg_tab03_tv.setChecked(true);
						reg_info_line1_tv.setText("");
					}
					else
						Toast.makeText(getApplicationContext(), "验证码不匹配", 0).show();
					break;
				case 2:
					String pass1 = reg_info_line2_tv.getText().toString();
					String pass2 = reg_info_line3_tv.getText().toString();
					String nickname = reg_info_line1_tv.getText().toString();
					if (pass1.equals(pass2))
						if (pass1.length() > 6)
							if (isNetworkConnected(getApplicationContext())) {
								httpget(GetUrl.getRegisterUrl(new MD5(pass1).getMd5_32(), strphone,nickname), 1);
								reg_flag = true;
								showProgressDialog(RegisterActivity.this);
							} else
								Toast.makeText(getApplicationContext(),"无网络连接", 0).show();
						else
							Toast.makeText(getApplicationContext(),"密码长度要大于6位", 0).show();
					else
						Toast.makeText(getApplicationContext(), "两次密码不一致", 0).show();

					break;

				}

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
				if(reg_flag)
					finish();
				else {
					sendcode = dataJson.getString("result");
					sub_action++;
					reg_tab02_tv.setChecked(true);
				}
				
				
				
			}
			else
				//Toast.makeText(getApplicationContext(), dataJson.getString("markmassage"), Toast.LENGTH_SHORT).show();
				Toast.makeText(getApplicationContext(), " 短信接口异常", Toast.LENGTH_SHORT).show();
				
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getApplicationContext(), "网络异常！", Toast.LENGTH_SHORT).show();
		}
		 finally{
			 reg_flag = false;
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
