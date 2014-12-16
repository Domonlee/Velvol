package com.velvol.o2o.ui.find;


import com.velvol.o2o.R;
import com.velvol.o2o.adapter.RoomNumberFriendFootAdapter;
import com.velvol.o2o.tool.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
//进入拼单房间
public class MargeActivity extends BaseActivity {

	private EditText marge_editText;
	private TextView marge_submit_btn;
	//获得的房间号
	private String argeRoomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marge);
		// Show the Up button in the action bar.
		findViewById();
		initView();
		
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		marge_editText=(EditText)findViewById(R.id.marge_editText);
		marge_submit_btn=(TextView)findViewById(R.id.marge_submit_btn);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		marge_submit_btn.setOnClickListener(clickListener);
	}
		View.OnClickListener clickListener = new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.marge_submit_btn:
					argeRoomNumber=marge_editText.getText().toString();
					startActivity(new Intent(MargeActivity.this,FriendRoomNumberActivity.class ));
					break;
				}
			}
		};

	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub
		
	}

}
