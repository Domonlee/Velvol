package com.velvol.o2o.fragment;

import com.velvol.o2o.R;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.adapter.CartAdapter;
import com.velvol.o2o.adapter.NewAdapter;
import com.velvol.o2o.tool.BaseFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class CartFragmentActivity extends BaseFragment {
	
	private ListView listView;
	private View view;
	private Context mContext;
	private CartAdapter mAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_cart, container, false);
		findViewById();
		initView();
		return view;
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		listView = (ListView)view.findViewById(R.id.listview);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		mContext = view.getContext();
		mAdapter = new CartAdapter(mContext);
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
		// TODO Auto-generated method stub

	}

}
