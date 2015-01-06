package com.velvol.o2o.ui.find;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;
//哪个商店的哪个菜品的优惠券
public class PrivilegeTicketAssignToActivity extends BaseActivity{
	//优惠食物图片
	private ImageView privilege_ticket_assignfood_picture_imageview;
	//优惠食物标题名字
	private TextView merchant_foor_name_textview;
	//优惠食物名字
	private TextView privilege_ticket_assignfood_name_textview;
	//优惠后的价格
	private TextView privilege_ticket_assignfood_cost_textview;
	//优惠描述1
	private TextView privilege_ticket_assignfood_content1_textview;
	//优惠描述2（需不需要预约）
	private TextView privilege_ticket_assignfood_appointment_textview;
	//有效时间
	private TextView privilege_ticket_assignfood_validitytime_textview;
	//返回按钮
	private ImageView merchant_return_imageview;
	//右边的标题
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
		
		merchant_foor_name_textview.setText("芒果巧克力三彩蛋糕优惠券");
		merchant_foor_name_textview.setTextSize(18);
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
