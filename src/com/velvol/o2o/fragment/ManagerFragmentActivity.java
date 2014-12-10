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
import com.velvol.o2o.view.CircularImage;

public class ManagerFragmentActivity extends BaseFragment {
	
	private View view;
	private Context mContext;
	private CircularImage cImageView;
	
	private LinearLayout manager_about_layout;
	private LinearLayout manager_feedback_layout;
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
		manager_about_layout = (LinearLayout)view.findViewById(R.id.manager_about_layout);
		manager_feedback_layout = (LinearLayout)view.findViewById(R.id.manager_feedback_layout);
	}

	@Override
	protected void initView() {
		cImageView.setImageResource(R.drawable.ic_launcher);
		mContext = view.getContext();
		manager_about_layout.setOnClickListener(clickListener);
		manager_feedback_layout.setOnClickListener(clickListener);
	}
	View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.manager_about_layout:
				intent.setClass(mContext, AboutActivity.class);
				startActivity(intent);
				getActivity().finish();
				break;
			case R.id.manager_feedback_layout:
				intent.setClass(mContext, FeedbackActivity.class);
				startActivity(intent);
				getActivity().finish();
				break;
			}
			
		}
	};
	
	@Override
	protected void result(String result) {

	}

}
