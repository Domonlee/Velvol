package com.velvol.o2o.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.SearchAdapter;
import com.velvol.o2o.adapter.search.SearchFoodAdapter;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.search.SearchClassActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;

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
		listView = (ListView) view.findViewById(R.id.listview);
		gridView = (GridView) view.findViewById(R.id.search_gridView1);
	}

	@SuppressLint("UseSparseArrays")
	@Override
	protected void initView() {
		// ������
		leftlist = new ArrayList<String>();
		leftlist.add("��ʳ");
		leftlist.add("��Ʒ");
		leftlist.add("��ʽ���");
		leftlist.add("��ʳ");
		leftlist.add("����");
		rightlist = new ArrayList<String>();
		rightlist.add("����");
		rightlist.add("����");
		rightlist.add("������");
		rightlist.add("��ʳ");
		rightlist.add("����");
		rightlist.add("����");
		rightlist.add("�ձ�");
		rightlist.add("����");

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

}
