package com.velvol.o2o.ui.manager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.velvol.o2o.HomeActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

public class ChangeAddressActivity extends BaseActivity {

	public TextView title_topbar_tv;
	public TextView title_topbar_right_tv;
	public RadioButton change_addr_history1_rb;
	public ImageView title_topbar_back_iv;
	public LinearLayout title_topbar_layout;
	public EditText myaddr_info_more_ed;

	public static String USERADDRESS = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_manager_changeaddr);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		myaddr_info_more_ed = (EditText) findViewById(R.id.myaddr_info_more_ed);
		change_addr_history1_rb = (RadioButton) findViewById(R.id.change_addr_history1_rb);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("修改地址");
//		title_topbar_right_tv.setText("完成");
		title_topbar_back_iv.setOnClickListener(clickListener);
		title_topbar_right_tv.setOnClickListener(clickListener);
		change_addr_history1_rb.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			// the right btn for edit
			case R.id.title_topbar_right_tv:
				// USERADDRESS = change_addr_history1_tv.getText().toString();
				finish();
				break;
			case R.id.change_addr_history1_rb:
//				USERADDRESS = change_addr_history1_rb.getText().toString();
				Intent intent = new Intent();
				intent.putExtra("useraddr", change_addr_history1_rb.getText().toString());
				setResult(0, intent);
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}
}
