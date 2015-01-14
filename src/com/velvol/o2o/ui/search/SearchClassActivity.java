package com.velvol.o2o.ui.search;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.velvol.o2o.R;
import com.velvol.o2o.SearchItemInfoActivity;
import com.velvol.o2o.adapter.search.ClassSearchAdapter;
import com.velvol.o2o.adapter.search.PromptAdapter;
import com.velvol.o2o.adapter.search.RecentAdapter;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.make.ParticularsActivity;

public class SearchClassActivity extends BaseActivity implements
		OnClickListener {
	private RadioButton all;
	private RadioButton sales;
	private RadioButton price;
	private RadioButton news;
	private ListView list;
	private EditText search;
	private ImageView back;
	private TextView cancle;
	private ClassSearchAdapter adapter;
	private String name;
	private SearchHistory popwindow;
	private LinearLayout ll;
	private String key,classifyId;
	/**
	 * 0: name = 关键字
	 * 1: name = 二级分类ID 
	 */
	private int action;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_class);
		findViewById();
		initView();
		action =  getIntent().getIntExtra("action", 0);
		if(action == 0)
			key = getIntent().getStringExtra("name");
		else
			classifyId= getIntent().getStringExtra("name");
		showProgressDialog(SearchClassActivity.this);
		httpget(GetUrl.getSearchByNameUrl(data.User_id, key, "-1", "1", "1", "1"), 1);
	}

	@Override
	protected void findViewById() {
		all = (RadioButton) findViewById(R.id.rb_class_all);
		sales = (RadioButton) findViewById(R.id.rb_class_sales);
		price = (RadioButton) findViewById(R.id.rb_class_price);
		news = (RadioButton) findViewById(R.id.rb_class_new);
		list = (ListView) findViewById(R.id.lv_class_listview);
		search = (EditText) findViewById(R.id.search);
		back = (ImageView) findViewById(R.id.title_topbar_back_iv);
		cancle = (TextView) findViewById(R.id.tv_search_cancle);
		cancle.setVisibility(View.GONE);
		ll = (LinearLayout) findViewById(R.id.ll_ll);
	}

	@Override
	protected void initView() {
		popwindow = new SearchHistory(SearchClassActivity.this);
		name = getIntent().getStringExtra("name");
		search.setText(name);
		adapter = new ClassSearchAdapter(SearchClassActivity.this);
		list.setAdapter(adapter);
		Listener();
		back.setOnClickListener(this);
		all.setOnClickListener(this);
		sales.setOnClickListener(this);
		price.setOnClickListener(this);
		news.setOnClickListener(this);
		cancle.setOnClickListener(this);
		search.setOnClickListener(this);
	}
	
	private void Listener(){

		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(SearchClassActivity.this,ParticularsActivity.class));
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
					Intent intent = new Intent(SearchClassActivity.this,
							SearchItemInfoActivity.class);
					startActivity(intent);
				}
				return false;
			}
		});
	}
	
	@Override
	protected void result(String result) {

	}

	


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			
		// 搜索
		case R.id.search:
			
			break;
		
		// 全部
		case R.id.rb_class_all:
			break;
		// 销量
		case R.id.rb_class_sales:
			break;
		// 价格
		case R.id.rb_class_price:
			break;
		// 新品
		case R.id.rb_class_new:
			break;
		// 返回
		case R.id.title_topbar_back_iv:
			finish();
			break;
		// 取消
		case R.id.tv_search_cancle:
			ll.setFocusable(true);
			ll.setFocusableInTouchMode(true);
			cancle.setVisibility(View.GONE);
			back.setVisibility(View.VISIBLE);
			break;

		default:
			break;
		}
	}

}
