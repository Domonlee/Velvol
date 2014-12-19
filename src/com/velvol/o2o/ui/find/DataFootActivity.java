package com.velvol.o2o.ui.find;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.DataFootAdapter;
import com.velvol.o2o.tool.BaseActivity;
//数据餐饮
public class DataFootActivity extends BaseActivity{
	//显示餐饮数据的listview
	private ListView dataFootListview;
	//返回按钮
	private ImageView data_food_return_imageview;
	//正中标题
	private TextView title_topbar_tv;
	//标题右边
	private TextView title_topbar_right_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_datafoot);
		findViewById();
		initView();
		DataFootAdapter adapter=new DataFootAdapter(this);
		dataFootListview.setAdapter(adapter);
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		dataFootListview=(ListView)findViewById(R.id.data_food_listView);
		title_topbar_tv=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
		data_food_return_imageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("数据餐饮");
		// TODO Auto-generated method stub
		data_food_return_imageview.setOnClickListener(clicklistener);
		
	}
	View.OnClickListener clicklistener=new OnClickListener() {
		
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
