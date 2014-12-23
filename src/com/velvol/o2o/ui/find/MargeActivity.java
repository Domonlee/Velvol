package com.velvol.o2o.ui.find;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

//进入拼单房间
public class MargeActivity extends BaseActivity {

	private TextView marge_submit_btn;
	// 获得的房间密码
	private String argeRoomPassword;
	private EditText marge_editText;
	// 回退按钮
	private ImageView marge_submit_return_imageview;
	// 正中的标题
	private TextView title_topbar_tv;
	// 右边的标题
	private TextView title_topbar_right_tv;
	// 房间号
	private String roomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_marge);
		findViewById();
		initView();
		// 获取意图参数
		toGetIntent();
	}

	private void toGetIntent() {
		Intent toFoundMargeRoomActivity = getIntent();
		roomNumber = toFoundMargeRoomActivity.getStringExtra("roomNumber");
	}

	@Override
	protected void findViewById() {
		marge_editText = (EditText) findViewById(R.id.marge_password_editText);
		marge_submit_btn = (TextView) findViewById(R.id.marge_submit_textview);
		marge_submit_return_imageview = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("多人拼单");
		marge_submit_btn.setOnClickListener(clickListener);
		marge_submit_return_imageview.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.marge_submit_textview:
				argeRoomPassword = marge_editText.getText().toString();
				// 于房主设置的密码对比，相同进入不同提示密码错误
				String a = "1234";
				if (argeRoomPassword.equals(a) && argeRoomPassword != "") {
					Intent intent = new Intent(MargeActivity.this,
							FriendRoomNumberActivity.class);
					intent.putExtra("roomNumber", roomNumber);
					Toast.makeText(MargeActivity.this, "拼单成功", 1).show();
					startActivity(intent);
				} else {
					Toast.makeText(MargeActivity.this, "密码不正确，不要冒充哦~~~", 1)
							.show();
				}
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {
	}

}
