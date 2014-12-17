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
import android.widget.TextView;

public class CartFragmentActivity extends BaseFragment {
	
	private ListView cart_detail_lv;
	private View view;
	private Context mContext;
	private CartAdapter mAdapter;
	private TextView title_logo,title_text,title_address;
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
		cart_detail_lv = (ListView)view.findViewById(R.id.cart_detail_lv);
		title_logo = (TextView)view.findViewById(R.id.logo);
	}

	@Override
	protected void initView() {
		mContext = view.getContext();
		mAdapter = new CartAdapter(mContext);
		cart_detail_lv.setAdapter(mAdapter);
		cart_detail_lv.setOnItemClickListener(listener);
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
