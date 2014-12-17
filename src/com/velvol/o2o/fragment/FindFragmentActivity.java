package com.velvol.o2o.fragment;

import android.content.Context;
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

import com.velvol.o2o.CombineActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.find.FoundMargeRoomActivity;

public class FindFragmentActivity extends BaseFragment {

	private View view;
	private Context mContext;
	private LinearLayout pindan;
	
	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_find, container, false);
		findViewById();
		initView();
		pindan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getActivity(),
						FoundMargeRoomActivity.class);
				startActivity(i);
			}
		});
		return view;
	}

	@Override
	protected void findViewById() {
		pindan = (LinearLayout) view.findViewById(R.id.layout3);
		title_topbar_tv = (TextView) view.findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) view.findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) view.findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		title_topbar_back_iv.setVisibility(View.GONE);
		title_topbar_tv.setText("·¢ÏÖ");
	}

	@Override
	protected void result(String result) {

	}

}
