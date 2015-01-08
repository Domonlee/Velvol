package com.velvol.o2o.ui.find;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.find.IndentAccountChangeadresstoAdapter;
import com.velvol.o2o.tool.BaseActivity;
//�ڶ��������Ͳ͵�ַ
public class IndentAccountChangeaddresstoActivity extends BaseActivity{

	//���ذ�ť
	ImageView title_topbar_back_iv;
	//����
	TextView title_topbar_tv;
	//�ұ�
	TextView title_topbar_right_tv;
	//���������
	EditText indent_account_changeaddressto_seek_et;
	//�������ϸ��ַ
	EditText indent_account_changeaddressto_particular_site_et;
	//��ʷ��ַlv
	ListView indent_account_changeaddressto_history_site_lv;
	//�����ʷ��ַ
	Button indent_account_changeaddressto_history_empty_bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_indent_account_changeaddressto);
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
		//���������
		indent_account_changeaddressto_seek_et=(EditText) findViewById(R.id.indent_account_changeaddressto_seek_et);
		//�������ϸ��ַ
		indent_account_changeaddressto_particular_site_et=(EditText) findViewById(R.id.indent_account_changeaddressto_particular_site_et);
		//��ʷ��ַlv
		indent_account_changeaddressto_history_site_lv=(ListView) findViewById(R.id.indent_account_changeaddressto_history_site_lv);
		//�����ʷ��ַ
		indent_account_changeaddressto_history_empty_bt=(Button) findViewById(R.id.indent_account_changeaddressto_history_empty_bt);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		IndentAccountChangeadresstoAdapter adapter = new IndentAccountChangeadresstoAdapter(this);
		indent_account_changeaddressto_history_site_lv.setAdapter(adapter);
		title_topbar_tv.setText("�����Ͳ͵�ַ");
		title_topbar_right_tv.setText("ȷ��");
		title_topbar_back_iv.setOnClickListener(clicklistener);
		title_topbar_right_tv.setOnClickListener(clicklistener);
		indent_account_changeaddressto_history_empty_bt.setOnClickListener(clicklistener);
	}
	OnClickListener clicklistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
				//ȷ����ť����
			case R.id.title_topbar_right_tv:
				break;
				//�����ʷ��ť����
			case R.id.indent_account_changeaddressto_history_empty_bt:
				break;
			}
		}
	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
