package com.velvol.o2o.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.NewAdapter;
import com.velvol.o2o.tool.BaseFragment;

public class MakeFragmentActivity extends BaseFragment {

	private View view;
	private NewAdapter mAdapter;
	private PullToRefreshGridView mPullRefreshGridView;
	private GridView mGridView;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_make, container, false);
		findViewById();
		initView();
		return view;
	}

	@Override
	protected void findViewById() {
		mPullRefreshGridView = (PullToRefreshGridView) view.findViewById(R.id.pull_refresh_grid);
		mGridView = mPullRefreshGridView.getRefreshableView();
	}

	@Override
	protected void initView() {
		DisplayMetrics metric = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        Log.v("MakeFragmentActivity", width+"");
		mAdapter = new NewAdapter(getActivity(),width/2);
		mGridView.setAdapter(mAdapter);
		mGridView.setOnItemClickListener(listener);
		mPullRefreshGridView.setOnRefreshListener(new OnRefreshListener2<GridView>() {
			
			public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
				//Ë¢ÐÂ
				mAdapter.notifyDataSetChanged();
				mPullRefreshGridView.onRefreshComplete();
			}
			
			public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
				//¼ÓÔØ
				mAdapter.notifyDataSetChanged();
				mPullRefreshGridView.onRefreshComplete();
			}
		});
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
