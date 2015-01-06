package com.velvol.o2o.ui.find;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
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
	private PullToRefreshListView remark_listview;
	//	private RemarkAdapter adapter;
	//	private Handler mhandler;
	private RemarkAdapter adapter;
	private ListView mListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_remark);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.review_people_name_textview);
		reviewReturnImageView = (ImageView) findViewById(R.id.title_topbar_back_iv);
		remark_listview = (PullToRefreshListView) findViewById(R.id.remark_listview);
		mListView = remark_listview.getRefreshableView();
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("神点评");
		
		adapter = new RemarkAdapter(this);
		mListView.setAdapter(adapter);
		remark_listview.setOnRefreshListener(new OnRefreshListener2<ListView>() {

			//刷新
			public void onPullDownToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				//重新获取数据，更新自己
				adapter.notifyDataSetChanged();
				//当前刷新标记为完成。将重置UI和隐藏刷新视图
				remark_listview.onRefreshComplete();
			}
			//加载
			public void onPullUpToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				//重新获取数据，更新自己
				adapter.notifyDataSetChanged();
				//当前刷新标记为完成。将重置UI和隐藏刷新视图
				remark_listview.onRefreshComplete();
			}
		});
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
