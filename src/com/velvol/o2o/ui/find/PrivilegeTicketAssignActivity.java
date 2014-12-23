package com.velvol.o2o.ui.find;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.find.PrivilegeTicketAssignAdapter;
import com.velvol.o2o.tool.BaseActivity;
//ָ���̵���Ż�ȯ
public class PrivilegeTicketAssignActivity extends BaseActivity{
	//ָ��������Ż�ȯlistview
	private ListView privilegeTicketAssigeListview;
	//���ذ�ť
	private ImageView privilege_ticket_return_imageview;
	//���еı���
	private TextView privilege_ticket_foor_name_textview;
	//�ұߵı���
	private TextView title_topbar_right_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_privilege_ticket_assign);
		findViewById();
		initView();
		PrivilegeTicketAssignAdapter adapter = new PrivilegeTicketAssignAdapter(this);
		privilegeTicketAssigeListview.setAdapter(adapter);
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		privilegeTicketAssigeListview=(ListView) findViewById(R.id.privilege_ticket_assign_listview);
		privilege_ticket_return_imageview=(ImageView) findViewById(R.id.title_topbar_back_iv);
		privilege_ticket_foor_name_textview=(TextView)findViewById(R.id.title_topbar_tv);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		privilege_ticket_foor_name_textview.setText("��଴����Ż�ȯ");
		privilegeTicketAssigeListview.setOnItemClickListener(itemlistener);
		privilege_ticket_return_imageview.setOnClickListener(clicklistener);
	}
	//�������
	View.OnClickListener clicklistener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			//���ذ�ť
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};
	//listview����
	OnItemClickListener itemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				startActivity(new Intent(PrivilegeTicketAssignActivity.this, PrivilegeTicketAssignToActivity.class));
				break;
			}
		}
	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
