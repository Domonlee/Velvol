package com.velvol.o2o.ui.find;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;
//�ĸ��̵���ĸ���Ʒ���Ż�ȯ
public class PrivilegeTicketAssignToActivity extends BaseActivity{
	//�Ż�ʳ��ͼƬ
	private ImageView privilege_ticket_assignfood_picture_imageview;
	//�Ż�ʳ���������
	private TextView merchant_foor_name_textview;
	//�Ż�ʳ������
	private TextView privilege_ticket_assignfood_name_textview;
	//�Żݺ�ļ۸�
	private TextView privilege_ticket_assignfood_cost_textview;
	//�Ż�����1
	private TextView privilege_ticket_assignfood_content1_textview;
	//�Ż�����2���費��ҪԤԼ��
	private TextView privilege_ticket_assignfood_appointment_textview;
	//��Чʱ��
	private TextView privilege_ticket_assignfood_validitytime_textview;
	//���ذ�ť
	private ImageView merchant_return_imageview;
	//�ұߵı���
	private TextView title_topbar_right_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_privilege_ticket_assignfood);
		findViewById();
		initView();
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		merchant_return_imageview=(ImageView) findViewById(R.id.title_topbar_back_iv);
		privilege_ticket_assignfood_picture_imageview=(ImageView) findViewById(R.id.privilege_ticket_assignfood_picture_imageview);
		privilege_ticket_assignfood_name_textview=(TextView) findViewById(R.id.privilege_ticket_assignfood_name_textview);
		privilege_ticket_assignfood_cost_textview=(TextView) findViewById(R.id.privilege_ticket_assignfood_cost_textview);
		privilege_ticket_assignfood_content1_textview=(TextView) findViewById(R.id.privilege_ticket_assignfood_content1_textview);
		privilege_ticket_assignfood_appointment_textview=(TextView) findViewById(R.id.privilege_ticket_assignfood_appointment_textview);
		privilege_ticket_assignfood_validitytime_textview=(TextView) findViewById(R.id.privilege_ticket_assignfood_validitytime_textview);
		merchant_foor_name_textview=(TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		
		merchant_foor_name_textview.setText("â���ɿ������ʵ����Ż�ȯ");
		merchant_return_imageview.setOnClickListener(listener);
	}
	View.OnClickListener listener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
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
