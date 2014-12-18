package com.velvol.o2o.ui.find;

import android.os.Bundle;
import android.widget.ListView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.DataFootAdapter;
import com.velvol.o2o.tool.BaseActivity;
//数据餐饮
public class DataFootActivity extends BaseActivity{
	//显示餐饮数据的listview
	private ListView dataFootListview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_datafoot);
		findViewById();
		initView();
		DataFootAdapter adapter=new DataFootAdapter(this);
		dataFootListview.setAdapter(adapter);
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		dataFootListview=(ListView)findViewById(R.id.data_food_listView);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub
		
	}

}
