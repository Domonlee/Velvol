package com.velvol.o2o.ui.find;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.find.IndentAccountChangeadressAdapter;
import com.velvol.o2o.adapter.find.IndentAccountChangeadresstoAdapter;
import com.velvol.o2o.tool.BaseActivity;
//更改配送地址
public class IndentAccountChangeaddressActivity extends BaseActivity{

	//返回按钮
	ImageView title_topbar_back_iv;
	//标题
	TextView title_topbar_tv;
	//右标
	TextView title_topbar_right_tv;
	//搜索
	EditText indent_account_changeaddress_seek_et;
	//取消搜索
	Button indent_account_changeaddress_seek_cancel_bt;
	//搜索结果lv
	ListView indent_account_changeaddress_lv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_indent_account_changeaddress);
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
		//搜索
		indent_account_changeaddress_seek_et=(EditText) findViewById(R.id.indent_account_changeaddress_seek_et);
		//取消搜索
		indent_account_changeaddress_seek_cancel_bt=(Button) findViewById(R.id.indent_account_changeaddress_seek_cancel_bt);
		//搜索结果lv
		indent_account_changeaddress_lv=(ListView) findViewById(R.id.indent_account_changeaddress_lv);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("更改配送地址");
		IndentAccountChangeadressAdapter adapter=new IndentAccountChangeadressAdapter(this);
		indent_account_changeaddress_lv.setAdapter(adapter);
		title_topbar_back_iv.setOnClickListener(clicklistener);
		indent_account_changeaddress_lv.setOnItemClickListener(itemlistener);
	}
	OnItemClickListener itemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (position) {
			case 0:
				startActivity(new Intent(IndentAccountChangeaddressActivity.this, IndentAccountChangeaddresstoActivity.class));
				break;
			}
		}
	};
	OnClickListener clicklistener=new OnClickListener() {
		
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
