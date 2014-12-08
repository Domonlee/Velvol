package com.velvol.o2o.fragment;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.NewAdapter;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.tool.PullBase;
import com.velvol.o2o.view.MyGridView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MakeFragmentActivity extends BaseFragment {

	private MyGridView gridView;
	private View view;
	private NewAdapter mAdapter;
	private PullBase pullbase;
	private LinearLayout layout;
	private ScrollView sc;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_make, container, false);
		findViewById();
		initView();
		pullbase = new PullBase(getActivity(), layout, sc) {
			public void onRefreshLoader() {
				// TODO
			}
		};
		pullbase.initview();
		return view;
	}

	@Override
	protected void findViewById() {
		gridView = (MyGridView) view.findViewById(R.id.gridview);
		layout = (LinearLayout) view.findViewById(R.id.main_layout);
		sc = (ScrollView) view.findViewById(R.id.main_scroll);
	}

	@Override
	protected void initView() {
		DisplayMetrics metric = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels;
		Log.v("MakeFragmentActivity", width + "");
		mAdapter = new NewAdapter(getActivity(), width / 2);
		gridView.setAdapter(mAdapter);
		gridView.setOnItemClickListener(listener);
	}

	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

		}
	};

	@Override
	protected void result(String result) {

	}

}
