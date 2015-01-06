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
	//��õķ�������
	private String argeRoomPassword;
	private EditText marge_editText;
	//���˰�ť
	private ImageView marge_submit_return_imageview;
	//���еı���
	private TextView title_topbar_tv;
	//�ұߵı���
	private TextView title_topbar_right_tv;
	//�����
	private String roomNumber;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_marge);
		// Show the Up button in the action bar.
		findViewById();
		initView();
		//��ȡ��ͼ����
		toGetIntent();
	}

	private void toGetIntent() {
		// TODO Auto-generated method stub
		Intent toFoundMargeRoomActivity=getIntent();
		roomNumber=toFoundMargeRoomActivity.getStringExtra("roomNumber");
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		marge_editText=(EditText)findViewById(R.id.marge_password_editText);
		marge_submit_btn=(TextView)findViewById(R.id.marge_submit_textview);
		marge_submit_return_imageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("����ƴ��");
		marge_submit_btn.setOnClickListener(clickListener);
		marge_submit_return_imageview.setOnClickListener(clickListener);
	}
	View.OnClickListener clickListener = new OnClickListener() {


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.marge_submit_textview:
				argeRoomPassword=marge_editText.getText().toString();
				//�ڷ������õ�����Աȣ���ͬ���벻ͬ��ʾ�������
				String a="1234";
				if (argeRoomPassword.equals(a)&&argeRoomPassword!="") {
					Intent  intent=new Intent(MargeActivity.this,FriendRoomNumberActivity.class);
					intent.putExtra("roomNumber", roomNumber);
					Toast.makeText(MargeActivity.this, "ƴ���ɹ�", 1).show();
					startActivity(intent);
				}else {
					Toast.makeText(MargeActivity.this, "���벻��ȷ����Ҫð��Ŷ~~~", 1).show();
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
		// TODO Auto-generated method stub

	}

}
