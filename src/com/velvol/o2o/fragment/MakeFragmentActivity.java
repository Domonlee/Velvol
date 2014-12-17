package com.velvol.o2o.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.NewAdapter;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.manager.ChangeAddressActivity;

public class MakeFragmentActivity extends BaseFragment {

	private View view;
	private NewAdapter mAdapter;
	private PullToRefreshGridView mPullRefreshGridView;
	private GridView mGridView;
	private TextView address;
	
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
		address = (TextView)view.findViewById(R.id.address);
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
		
		
		address.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivityForResult((new Intent(getActivity(), ChangeAddressActivity.class)),0);
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
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		address.setText(data.getStringExtra("useraddr"));
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void result(String result) {

	}
}
