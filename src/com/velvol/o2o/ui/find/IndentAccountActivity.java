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
//��������
public class IndentAccountActivity extends BaseActivity{

	//���ذ�ť
	ImageView title_topbar_back_iv;
	//����
	TextView title_topbar_tv;
	//�ұ�
	TextView title_topbar_right_tv;
	//�ǳ�
	TextView indent_account_name_tv;
	//��ϵ��
	TextView indent_account_linkman_tv;
	//��ϵ�����Ҽ�ͷ
	ImageView indent_account_linkman_iv;
	//��ϵ�绰
	TextView indent_account_linkman_phone_tv;
	//��ϵ�˵绰���Ҽ�ͷ
	ImageView indent_account_linkman_phone_iv;
	//�Ͳ�ʱ��
	TextView indent_account_give_time_tv;
	//�Ͳ�ʱ�����Ҽ�ͷ
	ImageView indent_account_give_time_iv;
	//���͵�ַ
	TextView indent_account_give_site_tv;
	//���͵�ַ���Ҽ�ͷ
	ImageView indent_account_give_site_iv;
	//��Ʒ���ƶ���Ԫ
	TextView indent_account_dishes_total_tv;
	//�˷�
	TextView indent_account_freight_tv;
	//�Բ�Ʒ�ı�ע
	EditText indent_account_foot_explain_ev;
	//ʵ��
	TextView indent_account_practical_payment_tv;
	//�ύ��
	Button indent_account_submit_bt;
	//��̬��Ӳ���
	LinearLayout indent_account_foot_layout_ll;
	//��̬�����ʳ��ҳ��
	View footview1;
	View footview2;
	//��̬ʳ������
	TextView view_indent_account_foot_name_tv1;
	TextView view_indent_account_foot_name_tv2;
	//ʳ������
	TextView view_indent_account_foot_quantity_tv1;
	TextView view_indent_account_foot_quantity_tv2;
	//ʳ�ﵥ�� 
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
		//���ذ�ť
		 title_topbar_back_iv=(ImageView) findViewById(R.id.title_topbar_back_iv);
		//����
		 title_topbar_tv=(TextView) findViewById(R.id.title_topbar_tv);
		//�ұ�
		 title_topbar_right_tv=(TextView) findViewById(R.id.title_topbar_right_tv);
		//�ǳ�
		 indent_account_name_tv=(TextView) findViewById(R.id.indent_account_name_tv);
		//��ϵ��
		 indent_account_linkman_tv=(TextView) findViewById(R.id.indent_account_linkman_tv);
		//��ϵ�����Ҽ�ͷ
		 indent_account_linkman_iv=(ImageView) findViewById(R.id.indent_account_linkman_iv);
		//��ϵ�绰
		 indent_account_linkman_phone_tv=(TextView) findViewById(R.id.indent_account_linkman_phone_tv);
		//��ϵ�˵绰���Ҽ�ͷ
		 indent_account_linkman_phone_iv=(ImageView) findViewById(R.id.indent_account_linkman_phone_iv);
		//�Ͳ�ʱ��
		 indent_account_give_time_tv=(TextView) findViewById(R.id.indent_account_give_time_tv);
		//�Ͳ�ʱ�����Ҽ�ͷ
		 indent_account_give_time_iv=(ImageView) findViewById(R.id.indent_account_give_time_iv);
		//���͵�ַ
		 indent_account_give_site_tv=(TextView) findViewById(R.id.indent_account_give_site_tv);
		//���͵�ַ���Ҽ�ͷ
		 indent_account_give_site_iv=(ImageView) findViewById(R.id.indent_account_give_site_iv);
		//��Ʒ���ƶ���Ԫ
		 indent_account_dishes_total_tv=(TextView) findViewById(R.id.indent_account_dishes_total_tv);
		//�˷�
		 indent_account_freight_tv=(TextView) findViewById(R.id.indent_account_freight_tv);
		//�Բ�Ʒ�ı�ע
		 indent_account_foot_explain_ev=(EditText) findViewById(R.id.indent_account_foot_explain_ev);
		//ʵ��
		 indent_account_practical_payment_tv=(TextView) findViewById(R.id.indent_account_practical_payment_tv);
		//�ύ��
		 indent_account_submit_bt=(Button) findViewById(R.id.indent_account_submit_bt);
		//��̬��Ӳ���
		 indent_account_foot_layout_ll=(LinearLayout) findViewById(R.id.indent_account_foot_layout_ll);
		//��̬�����ʳ��ҳ�� 
		 footview1=LayoutInflater.from(this).inflate(R.layout.view_indent_account, null);
		 footview2=LayoutInflater.from(this).inflate(R.layout.view_indent_account, null);
		 //ʳ������
		 view_indent_account_foot_name_tv1=(TextView)footview1.findViewById(R.id.view_indent_account_foot_name_tv);
		 view_indent_account_foot_name_tv2=(TextView)footview2.findViewById(R.id.view_indent_account_foot_name_tv);
		 //ʳ������
		 view_indent_account_foot_quantity_tv1=(TextView)footview1.findViewById(R.id.view_indent_account_foot_quantity_tv);
		 view_indent_account_foot_quantity_tv2=(TextView)footview2.findViewById(R.id.view_indent_account_foot_quantity_tv);
		 //ʳ�ﵥ��
		 view_indent_account_foot_price_tv1=(TextView)footview1.findViewById(R.id.view_indent_account_foot_price_tv);
		 view_indent_account_foot_price_tv2=(TextView)footview2.findViewById(R.id.view_indent_account_foot_price_tv);
		 
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		//��̬��Ӳ�Ʒ
		indent_account_foot_layout_ll.addView(footview1);
		indent_account_foot_layout_ll.addView(footview2);
		title_topbar_tv.setText("��������");
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
