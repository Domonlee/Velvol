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

//����ƴ������
public class MargeActivity extends BaseActivity {

	private TextView marge_submit_btn;
	// ��õķ�������
	private String argeRoomPassword;
	private EditText marge_editText;
	// ���˰�ť
	private ImageView marge_submit_return_imageview, createRoom;
	// ���еı���
	private TextView title_topbar_tv;
	// �ұߵı���
	private TextView title_topbar_right_tv;
	// �����
	private String roomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_marge);
		// Show the Up button in the action bar.
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		marge_editText = (EditText) findViewById(R.id.marge_password_editText);
		marge_submit_btn = (TextView) findViewById(R.id.marge_submit_textview);
		marge_submit_return_imageview = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.review_people_name_textview);
		createRoom = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("����ƴ��");
		marge_submit_btn.setOnClickListener(clickListener);
		marge_submit_return_imageview.setOnClickListener(clickListener);
		createRoom.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.marge_submit_textview:
				roomNumber = marge_editText.getText().toString();
				if (roomNumber != "") {
					startActivity(new Intent(MargeActivity.this,
							FriendRoomNumberActivity.class).putExtra("roomNumber", roomNumber));
				} else {
					Toast.makeText(MargeActivity.this, "��������ȷ��4λ����ţ��磨1234��", 1)
							.show();
				}
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.imageView1:
				startActivity(new Intent(MargeActivity.this,
						FoundMargeRoomActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
