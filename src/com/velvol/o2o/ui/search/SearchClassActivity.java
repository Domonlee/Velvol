package com.velvol.o2o.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.search.ClassSearchAdapter;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.constant.SellSearch;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.make.ParticularsActivity;

public class SearchClassActivity extends BaseActivity implements
		OnClickListener {
	private RadioButton all;
	private RadioButton sales;
	private RadioButton price;
	private RadioButton news;
	private PullToRefreshListView mPullToRefreshListView;
	private ListView list;
	private List<SellSearch> list_sell = new ArrayList<SellSearch>();
	private EditText search;
	private ImageView back;
	private TextView cancle;
	private ClassSearchAdapter adapter;
	private SearchHistory popwindow;
	private LinearLayout ll;
	private String key,classifyId;
	private int LOADER = 100,REFRESH=101,action=0,page = 1;
	private int sortfield=1;
	/**
	 * 0降序 1升序
	 */
	private int count_order=0,price_order=0,order=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_class);
		findViewById();
		initView();
		classifyId =  getIntent().getStringExtra("classifyId");
		key = getIntent().getStringExtra("key");
		showProgressDialog(SearchClassActivity.this);
		httpget(GetUrl.getSearchByNameUrl(data.User_id, key, classifyId, sortfield+"",order+"", (page=1)+""), 1);
	}

	@Override
	protected void findViewById() {
		all = (RadioButton) findViewById(R.id.rb_class_all);
		sales = (RadioButton) findViewById(R.id.rb_class_sales);
		price = (RadioButton) findViewById(R.id.rb_class_price);
		news = (RadioButton) findViewById(R.id.rb_class_new);
		mPullToRefreshListView = (PullToRefreshListView) findViewById(R.id.lv_class_listview);
		list = mPullToRefreshListView.getRefreshableView();
		search = (EditText) findViewById(R.id.search);
		back = (ImageView) findViewById(R.id.title_topbar_back_iv);
		cancle = (TextView) findViewById(R.id.tv_search_cancle);
		ll = (LinearLayout) findViewById(R.id.ll_ll);
	}

	@Override
	protected void initView() {
		popwindow = new SearchHistory(SearchClassActivity.this);
		adapter = new ClassSearchAdapter(SearchClassActivity.this,list_sell);
		
		if(count_order==0)
			sales.setText("销量↓");
		else
			sales.setText("销量↑");
		if(price_order==0)
			price.setText("价格↓");
		else
			price.setText("价格↑");
		
		Listener();
		list.setAdapter(adapter);
		back.setOnClickListener(this);
		all.setOnClickListener(this);
		sales.setOnClickListener(this);
		price.setOnClickListener(this);
		news.setOnClickListener(this);
		cancle.setOnClickListener(this);
		search.setOnClickListener(this);
		
	}
	
	private void Listener(){
		
		mPullToRefreshListView.setOnRefreshListener(mOnRefreshListener2);
		
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(SearchClassActivity.this,ParticularsActivity.class).putExtra("SellId", list_sell.get(arg2).getId()));
			}
		});
		
		search.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					if (popwindow.window == null
							|| !popwindow.window.isShowing())
						popwindow.showwindow(ll);
				} 
			}
		});

		search.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEND
						|| (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
					if(search.getText().toString().length()>0){
						key = search.getText().toString();
						setPullMode(Mode.PULL_FROM_START);
					}
				}
				return false;
			}
		});
	}
	
	PullToRefreshBase.OnRefreshListener2<ListView> mOnRefreshListener2 =new OnRefreshListener2<ListView>() {

		@Override
		public void onPullDownToRefresh(
				PullToRefreshBase<ListView> refreshView) {
			String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
					DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
			action = REFRESH;
			httpget(GetUrl.getSearchByNameUrl(data.User_id, key, classifyId, sortfield+"",order+"", (page=1)+""), 1);
			refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
			
		}

		@Override
		public void onPullUpToRefresh(
				PullToRefreshBase<ListView> refreshView) {
			action = LOADER;
			httpget(GetUrl.getSearchByNameUrl(data.User_id, key, classifyId,sortfield+"", order+"", (++page)+""), 1);
		}
	};
	
	@Override
	protected void result(String result) {
		if(action == 0)
			loadingDialog.dismiss();
		else
			mPullToRefreshListView.onRefreshComplete();
		try {
			JSONObject c = new JSONObject(result);
			if (c.getInt("mark") == 1) {
				JSONArray array = c.optJSONArray("result");
				if (array == null) {
				Log.v("Sen", "recentorder字段不存在");
				return;
			}
			if(action!=LOADER)
				list_sell.removeAll(list_sell);
			int len = array.length();
				if (len > 0) {
					for (int i = 0; i < len; i++) {
						SellSearch sell = new SellSearch(array.getJSONObject(i));
						list_sell.add(sell);
					}
					adapter.notifyDataSetChanged();
				}
			} else
				ShowToast("数据出错！");
		} catch (JSONException e) {
			e.printStackTrace();
			ShowToast("网络异常！");
		}
		finally{
			action = 1;
		}
	}

	


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		// 全部
		case R.id.rb_class_all:
			sortfield = 1;
			
			setPullMode(Mode.PULL_FROM_START);
			break;
		// 销量
		case R.id.rb_class_sales:
			if(count_order==0){
				sales.setText("销量↓");
				order = count_order;
				count_order = 1;
			}
			else{
				sales.setText("销量↑");
				order = count_order;
				count_order = 0;
			}
			sortfield = 2;
			setPullMode(Mode.PULL_FROM_START);
			break;
		// 价格
		case R.id.rb_class_price:
			if(price_order==0){
				price.setText("价格↓");
				order = price_order;
				price_order = 1;
			}
			else{
				price.setText("价格↑");
				order = price_order;
				price_order = 0;
			}
			sortfield = 3;
			
			setPullMode(Mode.PULL_FROM_START);
			break;
		// 新品
		case R.id.rb_class_new:
			sortfield = 4;
			setPullMode(Mode.PULL_FROM_START);
			break;
		// 返回
		case R.id.title_topbar_back_iv:
			finish();
			break;
		// 取消
		case R.id.tv_search_cancle:
			if(popwindow.window!=null)
				popwindow.window.dismiss();
			search.clearFocus();
			// 收键盘
			((InputMethodManager) getSystemService(
					Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
					search.getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
			break;

		default:
			break;
		}
	}
	
	private void setPullMode(Mode mode){
		mPullToRefreshListView.setCurrentMode(mode);
		mPullToRefreshListView.setRefreshing(true);
	}
}
