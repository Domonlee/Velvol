package com.velvol.o2o.fragment;

import com.velvol.o2o.R;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.adapter.SearchAdapter;
import com.velvol.o2o.tool.BaseFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

public class SearchFragmentActivity extends BaseFragment {
	
	private ListView listView;
	private GridView gridView;
	private View view;
	private Context mContext;
	private SearchAdapter mAdapter;
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
		listView = (ListView)view.findViewById(R.id.listview);
		gridView = (GridView)view.findViewById(R.id.search_gridView1);
	}

	@Override
	protected void initView() {
		mContext = view.getContext();
		mAdapter = new SearchAdapter(mContext);
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(listener);
	}
	
	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		}
	};
	@Override
	protected void result(String result) {

	}

}
