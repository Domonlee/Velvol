package com.velvol.o2o.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.manager.AboutActivity;
import com.velvol.o2o.ui.manager.FeedbackActivity;
import com.velvol.o2o.ui.manager.MyAddressActivity;
import com.velvol.o2o.ui.manager.MyInfoActivity;
import com.velvol.o2o.ui.manager.MyMsgActivity;
import com.velvol.o2o.ui.manager.MyOrderActivity;
import com.velvol.o2o.view.CircularImage;

public class ManagerFragmentActivity extends BaseFragment {

	private View view;
	private Context mContext;
	private CircularImage cImageView;

	private LinearLayout manager_about_layout;
	private LinearLayout manager_feedback_layout;
	private LinearLayout manager_myaddr_layout;
	private LinearLayout manager_mydata_layout;
	private LinearLayout manager_msgboard_layout;
	private LinearLayout manager_myorder_layout;

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
		cImageView = (CircularImage) view.findViewById(R.id.icon);
		manager_about_layout = (LinearLayout) view
				.findViewById(R.id.manager_about_layout);
		manager_feedback_layout = (LinearLayout) view
				.findViewById(R.id.manager_feedback_layout);
		manager_myaddr_layout = (LinearLayout) view
				.findViewById(R.id.manager_myaddr_layout);
		manager_mydata_layout = (LinearLayout) view
				.findViewById(R.id.manager_mydata_layout);
		manager_msgboard_layout = (LinearLayout) view
				.findViewById(R.id.manager_msgboard_layout);
		manager_myorder_layout = (LinearLayout) view
				.findViewById(R.id.manager_myorder_layout);
	}

	@Override
	protected void initView() {
		cImageView.setImageResource(R.drawable.userface);
		mContext = view.getContext();
		manager_about_layout.setOnClickListener(clickListener);
		manager_feedback_layout.setOnClickListener(clickListener);
		manager_myaddr_layout.setOnClickListener(clickListener);
		manager_mydata_layout.setOnClickListener(clickListener);
		manager_msgboard_layout.setOnClickListener(clickListener);
		manager_myorder_layout.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.manager_about_layout:
				intent.setClass(mContext, AboutActivity.class);
				break;
			case R.id.manager_feedback_layout:
				intent.setClass(mContext, FeedbackActivity.class);
				break;
			case R.id.manager_myaddr_layout:
				intent.setClass(mContext, MyAddressActivity.class);
				break;
			case R.id.manager_mydata_layout:
				intent.setClass(mContext, MyInfoActivity.class);
				break;
			case R.id.manager_msgboard_layout:
				intent.setClass(mContext, MyMsgActivity.class);
				break;
			case R.id.manager_myorder_layout:
				intent.setClass(mContext, MyOrderActivity.class);
				break;
			}
				startActivity(intent);
		}
	};

	@Override
	protected void result(String result) {

	}

}
