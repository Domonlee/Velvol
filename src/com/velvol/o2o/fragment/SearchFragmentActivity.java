package com.velvol.o2o.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.SearchAdapter;
import com.velvol.o2o.adapter.search.PromptAdapter;
import com.velvol.o2o.adapter.search.RecentAdapter;
import com.velvol.o2o.adapter.search.SearchFoodAdapter;
import com.velvol.o2o.adapter.search.SearchHotAdapter;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.search.SearchClassActivity;

public class SearchFragmentActivity extends BaseFragment {

	private ListView listView;
	private GridView gridView;
	private View view;
	private Context mContext;
	private SearchAdapter mAdapter;
	private SearchFoodAdapter adapter;
	private HashMap<Integer, Boolean> isselect;
	private ArrayList<String> leftlist;
	private ArrayList<String> rightlist;
	private TextView clear;
	private PopupWindow window;
	private LinearLayout ll1;
	private EditText search;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_search, container, false);
		findViewById();
		initView();
		return view;
	}

	@Override
	protected void findViewById() {
		search = (EditText) view.findViewById(R.id.search);
		ll1 = (LinearLayout) view.findViewById(R.id.ll_ll1);
		listView = (ListView) view.findViewById(R.id.listview);
		gridView = (GridView) view.findViewById(R.id.search_gridView1);
	}

	@SuppressLint("UseSparseArrays")
	@Override
	protected void initView() {
		// 假数据
		leftlist = new ArrayList<String>();
		leftlist.add("面食");
		leftlist.add("菜品");
		leftlist.add("西式快餐");
		leftlist.add("零食");
		leftlist.add("饮料");
		rightlist = new ArrayList<String>();
		rightlist.add("面条");
		rightlist.add("点心");
		rightlist.add("拉条子");
		rightlist.add("麻食");
		rightlist.add("包子");
		rightlist.add("饺子");
		rightlist.add("烧饼");
		rightlist.add("其他");

		isselect = new HashMap<Integer, Boolean>();

		for (int i = 0; i < leftlist.size(); i++) {
			isselect.put(i, false);
		}
		isselect.put(0, true);
		mContext = view.getContext();
		mAdapter = new SearchAdapter(mContext);
		mAdapter.setList(leftlist);
		mAdapter.setIsselect(isselect);
		listView.setAdapter(mAdapter);
		adapter = new SearchFoodAdapter(mContext);
		adapter.setList(rightlist);
		gridView.setAdapter(adapter);
		listView.setOnItemClickListener(listener);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				Intent intent = new Intent(getActivity(),
						SearchClassActivity.class);
				intent.putExtra("name", rightlist.get(position));
				startActivity(intent);
			}
		});

		search.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					showwindow();
				}
			}
		});

		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showwindow();
			}
		});
	}

	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			for (int i = 0; i < leftlist.size(); i++) {
				isselect.put(i, false);
			}
			isselect.put(position, true);
			mAdapter.setIsselect(isselect);
			mAdapter.notifyDataSetChanged();
			ArrayList<String> leftlists = new ArrayList<String>();
			leftlists.addAll(leftlist);
			leftlists.remove(position);
			adapter.setList(leftlists);
			adapter.notifyDataSetChanged();
		}

	};

	@Override
	protected void result(String result) {

	}

	/**
	 * 展示
	 */
	private void showwindow() {

		window = new PopupWindow(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.search_fragment_down, null);
		window.setContentView(view);
		window.setOutsideTouchable(true);
		window.setBackgroundDrawable(new ColorDrawable());
		window.setFocusable(false);
		// 全屏PopupWindow 挡住软键盘
		window.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		window.showAsDropDown(ll1);
		// 热门搜索
		ListView gridView = (ListView) view
				.findViewById(R.id.gv_search_fragment_down_listview);
		// 最近搜索
		ListView listView = (ListView) view
				.findViewById(R.id.lv_search_fragment_down_listview);

		// 假数据
		ArrayList<String> list = new ArrayList<String>();
		list.add("牛肉面");
		list.add("酸菜面");
		list.add("岐山臊子面");
		list.add("金马刀削面");
		SearchHotAdapter hotAdapter = new SearchHotAdapter(getActivity());
		hotAdapter.setList(list);
		gridView.setAdapter(hotAdapter);

		ArrayList<String> flist = new ArrayList<String>();
		flist.add("面条");
		flist.add("酸辣土豆丝");
		flist.add("酸辣土豆丝");
		flist.add("酸辣土豆丝");
		flist.add("酸辣土豆丝");
		RecentAdapter recentAdapter = new RecentAdapter(getActivity());
		recentAdapter.setList(flist);

		listView.setAdapter(recentAdapter);
		clear = (TextView) view.findViewById(R.id.tv_search_class_down_clear);
		clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

	}

}
