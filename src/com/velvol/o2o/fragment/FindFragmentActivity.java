package com.velvol.o2o.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.find.DataFootActivity;
import com.velvol.o2o.ui.find.FoundMargeRoomActivity;
import com.velvol.o2o.ui.find.MargeActivity;
import com.velvol.o2o.ui.find.PrivilegeTicketActivity;
import com.velvol.o2o.ui.find.ReviewActivity;

public class FindFragmentActivity extends BaseFragment {

	private View view;

	// 拼单
	private LinearLayout pindan;
	// 神评论
	private LinearLayout comment;
	// 数据餐饮
	private LinearLayout dataFoot;
	// 优惠券
	private LinearLayout privilegeTicket;

	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_find, container, false);
		findViewById();
		initView();
		return view;
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) view.findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) view.findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) view.findViewById(R.id.title_topbar_back_iv);
		pindan = (LinearLayout) view.findViewById(R.id.find_join_layout);
		comment = (LinearLayout) view.findViewById(R.id.find_comment_layout);
		dataFoot = (LinearLayout) view.findViewById(R.id.find_data_layout);
		privilegeTicket = (LinearLayout) view.findViewById(R.id.find_ticket_layout);

	}

	@Override
	protected void initView() {
		title_topbar_back_iv.setVisibility(View.GONE);
		title_topbar_right_tv.setVisibility(View.GONE);
		title_topbar_tv.setText("发现");

		
		pindan.setOnClickListener(listener);
		comment.setOnClickListener(listener);
		dataFoot.setOnClickListener(listener);
		privilegeTicket.setOnClickListener(listener);

	}

	View.OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.find_comment_layout:
				startActivity(new Intent(getActivity(),ReviewActivity.class));
				break;
			case R.id.find_data_layout:
				startActivity(new Intent(getActivity(),DataFootActivity.class));
				break;
			case R.id.find_join_layout:
				startActivity(new Intent(getActivity(),MargeActivity.class));
				break;
			case R.id.find_ticket_layout:
				startActivity(new Intent(getActivity(),PrivilegeTicketActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
