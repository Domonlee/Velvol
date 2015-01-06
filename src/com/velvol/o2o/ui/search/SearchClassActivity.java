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
	private PopupWindow window;
	private LinearLayout ll;
	private TextView clear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_class);
		findViewById();
		initView();
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
					back.setVisibility(View.GONE);
					cancle.setVisibility(View.VISIBLE);
					showwindow();
				} else {
					back.setVisibility(View.VISIBLE);
					cancle.setVisibility(View.GONE);
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

	/**
	 * չʾ
	 */
	private void showwindow() {
		search.setEnabled(true);
		window = new PopupWindow(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		View view = LayoutInflater.from(SearchClassActivity.this).inflate(
				R.layout.search_class_down, null);
		window.setContentView(view);
		window.setOutsideTouchable(true);
		window.setBackgroundDrawable(new ColorDrawable());
		window.setFocusable(false);
		// ȫ��PopupWindow ��ס�����
		window.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		window.showAsDropDown(ll);
		// ��ʾlistview
		ListView prompt = (ListView) view
				.findViewById(R.id.lv_search_class_down_prompt);
		// �������listview
		ListView recent = (ListView) view
				.findViewById(R.id.lv_search_class_down_search);

		// ������
		ArrayList<String> list = new ArrayList<String>();
		list.add("������" + "����" + "����Ʒ");
		list.add("ţ����");
		list.add("�����");
		list.add("�ɽ������");
		list.add("��������");
		PromptAdapter promptAdapter = new PromptAdapter(
				SearchClassActivity.this);
		promptAdapter.setList(list);
		prompt.setAdapter(promptAdapter);

		ArrayList<String> flist = new ArrayList<String>();
		flist.add("����");
		flist.add("��������˿");
		flist.add("��������˿");
		flist.add("��������˿");
		flist.add("��������˿");
		RecentAdapter recentAdapter = new RecentAdapter(
				SearchClassActivity.this);
		recentAdapter.setList(flist);

		recent.setAdapter(recentAdapter);
		clear = (TextView) view.findViewById(R.id.tv_search_class_down_clear);
		clear.setOnClickListener(SearchClassActivity.this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//�����ʷ����
		case R.id.tv_search_class_down_clear:
			break;
			
		// ����
		case R.id.search:
			showwindow();
			break;
		
		// ȫ��
		case R.id.rb_class_all:
			break;
		// ����
		case R.id.rb_class_sales:
			break;
		// �۸�
		case R.id.rb_class_price:
			break;
		// ��Ʒ
		case R.id.rb_class_new:
			break;
		// ����
		case R.id.title_topbar_back_iv:
			finish();
			break;
		// ȡ��
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
