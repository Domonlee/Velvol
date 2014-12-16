package com.velvol.o2o.ui.find;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.ListView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.PrivilegeTicketAssignAdapter;
import com.velvol.o2o.tool.BaseActivity;
//指定界面优惠券
public class PrivilegeTicketAssignActivity extends BaseActivity{
	//指定店面的优惠券listview
	private ListView privilegeTicketAssigeListview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
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
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		privilegeTicketAssigeListview.setOnClickListener(listener);
	}
	View.OnClickListener listener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.privilege_ticket_assign_listview:
				
				break;
			}
		}
	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub
		
	}

}
