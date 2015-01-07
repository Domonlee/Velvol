package com.velvol.o2o.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class ForgetPswActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public TextView forget_next_btn,reg_info_mcode_btn;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	public EditText forget_phone_tv,reg_info_mcode_tv;

	public String pswFlag;

	private TimeCount time;
	private String strphone, sendcode = "aaaaaa";
	private boolean reg_flag = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_forget_psw);
		pswFlag = getIntent().getStringExtra("pswFlag");

		findViewById();
		initView();
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
		title_topbar_tv.setText("�һ�����");
		title_topbar_back_iv.setOnClickListener(clickListener);
		forget_next_btn.setOnClickListener(clickListener);
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
				startActivity(new Intent(ForgetPswActivity.this,
						ResetPswActivity.class));
				finish();
				break;
			}

		}
	};

	@Override
	protected void result(String result) {

	}
	
	class TimeCount extends CountDownTimer {
		public TimeCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);// ��������Ϊ��ʱ��,�ͼ�ʱ��ʱ����
		}

		@Override
		public void onFinish() {// ��ʱ���ʱ����
			reg_info_mcode_btn.setText("������֤");
			reg_info_mcode_btn.setClickable(true);
		}

		@Override
		public void onTick(long millisUntilFinished) {// ��ʱ������ʾ
			reg_info_mcode_btn.setClickable(false);
			reg_info_mcode_btn.setText(millisUntilFinished / 1000 + "��");
		}
	}
}
