package com.velvol.o2o.ui.find;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.find.RemarkAdapter;
import com.velvol.o2o.tool.BaseActivity;

//神点评
public class ReviewActivity extends BaseActivity {

	// 回退按钮
	private ImageView reviewReturnImageView;
	// 正中的标题
	private TextView title_topbar_tv;
	// 右边的标题
	private TextView title_topbar_right_tv;
	// 展示点菜的ListView
	private ListView remark_listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_remark);
		findViewById();
		initView();
		RemarkAdapter adapter = new RemarkAdapter(this);
		remark_listview.setAdapter(adapter);
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.review_people_name_textview);
		reviewReturnImageView = (ImageView) findViewById(R.id.title_topbar_back_iv);
		remark_listview = (ListView) findViewById(R.id.remark_listview);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("神点评");
		// 回退按钮
		reviewReturnImageView.setOnClickListener(clicklistener);
	}

	// 点击监听
	View.OnClickListener clicklistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			// 返回
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
