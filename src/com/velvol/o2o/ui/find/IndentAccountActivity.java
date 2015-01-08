package com.velvol.o2o.ui.find;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;
//订单结算
public class IndentAccountActivity extends BaseActivity{

	//返回按钮
	ImageView title_topbar_back_iv;
	//标题
	TextView title_topbar_tv;
	//右标
	TextView title_topbar_right_tv;
	//昵称
	TextView indent_account_name_tv;
	//联系人
	TextView indent_account_linkman_tv;
	//联系人向右箭头
	ImageView indent_account_linkman_iv;
	//联系电话
	TextView indent_account_linkman_phone_tv;
	//联系人电话向右箭头
	ImageView indent_account_linkman_phone_iv;
	//送餐时间
	TextView indent_account_give_time_tv;
	//送餐时间向右箭头
	ImageView indent_account_give_time_iv;
	//配送地址
	TextView indent_account_give_site_tv;
	//配送地址向右箭头
	ImageView indent_account_give_site_iv;
	//菜品共计多少元
	TextView indent_account_dishes_total_tv;
	//运费
	TextView indent_account_freight_tv;
	//对菜品的备注
	EditText indent_account_foot_explain_ev;
	//实付
	TextView indent_account_practical_payment_tv;
	//提交表单
	Button indent_account_submit_bt;
	//动态添加布局
	LinearLayout indent_account_foot_layout_ll;
	//动态放入的食物页面
	View footview1;
	View footview2;
	//动态食物名字
	TextView view_indent_account_foot_name_tv1;
	TextView view_indent_account_foot_name_tv2;
	//食物数量
	TextView view_indent_account_foot_quantity_tv1;
	TextView view_indent_account_foot_quantity_tv2;
	//食物单价 
	TextView view_indent_account_foot_price_tv1;
	TextView view_indent_account_foot_price_tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_indent_account);
		findViewById();
		initView();
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		//返回按钮
		 title_topbar_back_iv=(ImageView) findViewById(R.id.title_topbar_back_iv);
		//标题
		 title_topbar_tv=(TextView) findViewById(R.id.title_topbar_tv);
		//右标
		 title_topbar_right_tv=(TextView) findViewById(R.id.title_topbar_right_tv);
		//昵称
		 indent_account_name_tv=(TextView) findViewById(R.id.indent_account_name_tv);
		//联系人
		 indent_account_linkman_tv=(TextView) findViewById(R.id.indent_account_linkman_tv);
		//联系人向右箭头
		 indent_account_linkman_iv=(ImageView) findViewById(R.id.indent_account_linkman_iv);
		//联系电话
		 indent_account_linkman_phone_tv=(TextView) findViewById(R.id.indent_account_linkman_phone_tv);
		//联系人电话向右箭头
		 indent_account_linkman_phone_iv=(ImageView) findViewById(R.id.indent_account_linkman_phone_iv);
		//送餐时间
		 indent_account_give_time_tv=(TextView) findViewById(R.id.indent_account_give_time_tv);
		//送餐时间向右箭头
		 indent_account_give_time_iv=(ImageView) findViewById(R.id.indent_account_give_time_iv);
		//配送地址
		 indent_account_give_site_tv=(TextView) findViewById(R.id.indent_account_give_site_tv);
		//配送地址向右箭头
		 indent_account_give_site_iv=(ImageView) findViewById(R.id.indent_account_give_site_iv);
		//菜品共计多少元
		 indent_account_dishes_total_tv=(TextView) findViewById(R.id.indent_account_dishes_total_tv);
		//运费
		 indent_account_freight_tv=(TextView) findViewById(R.id.indent_account_freight_tv);
		//对菜品的备注
		 indent_account_foot_explain_ev=(EditText) findViewById(R.id.indent_account_foot_explain_ev);
		//实付
		 indent_account_practical_payment_tv=(TextView) findViewById(R.id.indent_account_practical_payment_tv);
		//提交表单
		 indent_account_submit_bt=(Button) findViewById(R.id.indent_account_submit_bt);
		//动态添加布局
		 indent_account_foot_layout_ll=(LinearLayout) findViewById(R.id.indent_account_foot_layout_ll);
		//动态放入的食物页面 
		 footview1=LayoutInflater.from(this).inflate(R.layout.view_indent_account, null);
		 footview2=LayoutInflater.from(this).inflate(R.layout.view_indent_account, null);
		 //食物名字
		 view_indent_account_foot_name_tv1=(TextView)footview1.findViewById(R.id.view_indent_account_foot_name_tv);
		 view_indent_account_foot_name_tv2=(TextView)footview2.findViewById(R.id.view_indent_account_foot_name_tv);
		 //食物数量
		 view_indent_account_foot_quantity_tv1=(TextView)footview1.findViewById(R.id.view_indent_account_foot_quantity_tv);
		 view_indent_account_foot_quantity_tv2=(TextView)footview2.findViewById(R.id.view_indent_account_foot_quantity_tv);
		 //食物单价
		 view_indent_account_foot_price_tv1=(TextView)footview1.findViewById(R.id.view_indent_account_foot_price_tv);
		 view_indent_account_foot_price_tv2=(TextView)footview2.findViewById(R.id.view_indent_account_foot_price_tv);
		 
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		//动态添加菜品
		indent_account_foot_layout_ll.addView(footview1);
		indent_account_foot_layout_ll.addView(footview2);
		title_topbar_tv.setText("订单结算");
		title_topbar_back_iv.setOnClickListener(clicklistener);
		indent_account_give_site_iv.setOnClickListener(clicklistener);
	}
	OnClickListener clicklistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.indent_account_give_site_iv:
				startActivity(new Intent(IndentAccountActivity.this, IndentAccountChangeaddressActivity.class));
				break;
			}
		}
	};
	OnTouchListener touchlistener=new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.indent_account_give_site_tv:
				startActivity(new Intent(IndentAccountActivity.this, IndentAccountChangeaddressActivity.class));
				break;
			}
			return true;
		}
	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
