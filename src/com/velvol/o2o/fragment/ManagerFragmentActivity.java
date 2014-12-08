package com.velvol.o2o.fragment;

import com.velvol.o2o.R;
import com.velvol.o2o.R.drawable;
import com.velvol.o2o.R.id;
import com.velvol.o2o.R.layout;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.view.CircularImage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ManagerFragmentActivity extends BaseFragment {
	
	private View view;
	private Context mContext;
	private CircularImage cImageView;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_manager, container, false);
		findViewById();
		initView();
		return view;
	}

	@Override
	protected void findViewById() {
		cImageView = (CircularImage)view.findViewById(R.id.icon);
	}

	@Override
	protected void initView() {
		cImageView.setImageResource(R.drawable.ic_launcher);
		mContext = view.getContext();
	}
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
