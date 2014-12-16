package com.velvol.o2o.ui.find;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

//创建拼单房间
public class FoundMargeRoomActivity extends BaseActivity {

	private EditText found_marge_number_editText;
	private Button button;
	private Button button1;
	// 创建的房间号
	private String textRoomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_found_marge_room);
		// Show the Up button in the action bar.
		findViewById();
		initView();

	}

	@Override
	protected void findViewById() {
		found_marge_number_editText = (EditText) findViewById(R.id.found_marge_number_editText);
		button = (Button) findViewById(R.id.found_buttom);
		button1 = (Button) findViewById(R.id.found_buttom1);
		textRoomNumber = found_marge_number_editText.getText().toString();
	}

	@Override
	protected void initView() {
		button.setOnClickListener(clickListener);
		button1.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.found_buttom:
				startActivity(new Intent(FoundMargeRoomActivity.this,
						RoomNumberActivity.class));
				break;
			case R.id.found_buttom1:
				startActivity(new Intent(FoundMargeRoomActivity.this,
						MargeActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {
	}

}
