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
//第二个更改送餐地址
public class IndentAccountChangeaddresstoActivity extends BaseActivity{

	//返回按钮
	ImageView title_topbar_back_iv;
	//标题
	TextView title_topbar_tv;
	//右标
	TextView title_topbar_right_tv;
	//搜索输入框
	EditText indent_account_changeaddressto_seek_et;
	//输入的详细地址
	EditText indent_account_changeaddressto_particular_site_et;
	//历史地址lv
	ListView indent_account_changeaddressto_history_site_lv;
	//清空历史地址
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
		//返回按钮
		title_topbar_back_iv=(ImageView) findViewById(R.id.title_topbar_back_iv);
		//标题
		title_topbar_tv=(TextView) findViewById(R.id.title_topbar_tv);
		//右标
		title_topbar_right_tv=(TextView) findViewById(R.id.title_topbar_right_tv);
		//搜索输入框
		indent_account_changeaddressto_seek_et=(EditText) findViewById(R.id.indent_account_changeaddressto_seek_et);
		//输入的详细地址
		indent_account_changeaddressto_particular_site_et=(EditText) findViewById(R.id.indent_account_changeaddressto_particular_site_et);
		//历史地址lv
		indent_account_changeaddressto_history_site_lv=(ListView) findViewById(R.id.indent_account_changeaddressto_history_site_lv);
		//清空历史地址
		indent_account_changeaddressto_history_empty_bt=(Button) findViewById(R.id.indent_account_changeaddressto_history_empty_bt);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		IndentAccountChangeadresstoAdapter adapter = new IndentAccountChangeadresstoAdapter(this);
		indent_account_changeaddressto_history_site_lv.setAdapter(adapter);
		title_topbar_tv.setText("更改送餐地址");
		title_topbar_right_tv.setText("确定");
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
				//确定按钮监听
			case R.id.title_topbar_right_tv:
				break;
				//清空历史按钮监听
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
