package com.velvol.o2o;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.velvol.o2o.tool.BaseActivity;

public class RegisterActivity extends BaseActivity {
	public LinearLayout topLayout;
	public ImageView topBack_iv;
	public RadioGroup reg_tab_rg;
	public RadioButton reg_tab01_tv,reg_tab02_tv,reg_tab03_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(getWindow().FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		topBack_iv = (ImageView)findViewById(R.id.title_topbar_back_iv);
		reg_tab_rg = (RadioGroup)findViewById(R.id.reg_bar_rg);
		reg_tab01_tv = (RadioButton)findViewById(R.id.reg_tab01_tv);
		reg_tab02_tv = (RadioButton)findViewById(R.id.reg_tab02_tv);
		reg_tab03_tv = (RadioButton)findViewById(R.id.reg_tab03_tv);
	}

	@Override
	protected void initView() {
		
		topBack_iv.setOnClickListener(listener);
//		reg_tab01_tv.setOnClickListener(listener);
//		reg_tab02_tv.setOnClickListener(listener);
//		reg_tab03_tv.setOnClickListener(listener);
		
		reg_tab_rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				
			}
		});
	}
		View.OnClickListener listener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.title_topbar_back_iv:
					startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
					finish();	
					break;
				case R.id.reg_tab01_tv:
//					reg_tab01_tv.setPressed(true);
					break;
				case R.id.reg_tab02_tv:
					break;
				case R.id.reg_tab03_tv:
					break;
				}
				
			}
		};
		

	@Override
	protected void result(String result) {
		
	}

}
