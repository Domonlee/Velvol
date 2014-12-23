package com.velvol.o2o.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.login.LoginActivity;
import com.velvol.o2o.ui.manager.AboutActivity;
import com.velvol.o2o.ui.manager.ChangeAddressActivity;
import com.velvol.o2o.ui.manager.FeedbackActivity;
import com.velvol.o2o.ui.manager.MyAddressActivity;
import com.velvol.o2o.ui.manager.MyInfoActivity;
import com.velvol.o2o.ui.manager.MyMsgActivity;
import com.velvol.o2o.ui.manager.MyOrderActivity;
import com.velvol.o2o.ui.manager.TaskActivity;
import com.velvol.o2o.ui.manager.UserFaceActivity;
import com.velvol.o2o.view.CircularImage;

public class ManagerFragmentActivity extends BaseFragment {

	private View view;
	private Context mContext;
	private CircularImage cImageView;
	private Button manager_login;
	public TextView title_topbar_tv,title_topbar_right_tv;
	public ImageView title_topbar_back_iv;

	private LinearLayout manager_about_layout, manager_feedback_layout,
			manager_myaddr_layout, manager_mydata_layout,
			manager_msgboard_layout, manager_myorder_layout,
			manager_score_layout;
	

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
		cImageView = (CircularImage) view.findViewById(R.id.manager_userface_ci);
		manager_login = (Button) view.findViewById(R.id.manager_login);
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
		manager_score_layout = (LinearLayout) view
				.findViewById(R.id.manager_score_layout);
		title_topbar_tv = (TextView) view.findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) view.findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) view.findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		cImageView.setImageResource(R.drawable.userface);
		title_topbar_back_iv.setVisibility(View.GONE);
		title_topbar_right_tv.setVisibility(View.GONE);
		title_topbar_tv.setText("ÎÒµÄ");
		mContext = view.getContext();
		cImageView.setOnClickListener(clickListener);
		manager_login.setOnClickListener(clickListener);
		manager_about_layout.setOnClickListener(clickListener);
		manager_feedback_layout.setOnClickListener(clickListener);
		manager_myaddr_layout.setOnClickListener(clickListener);
		manager_mydata_layout.setOnClickListener(clickListener);
		manager_msgboard_layout.setOnClickListener(clickListener);
		manager_myorder_layout.setOnClickListener(clickListener);
		manager_score_layout.setOnClickListener(clickListener);
		
	}

	View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			switch (v.getId()) {
			case R.id.manager_userface_ci:
				intent.setClass(mContext, UserFaceActivity.class);
				break;
			case R.id.manager_login:
				intent.setClass(mContext, LoginActivity.class);
				getActivity().finish();
				break;
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
			case R.id.manager_score_layout:
				intent.setClass(mContext, TaskActivity.class);
				break;
			}
			startActivity(intent);
		}
	};

	@Override
	protected void result(String result) {

	}

}
