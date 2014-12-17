package com.velvol.o2o.fragment;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.CartAdapter;
import com.velvol.o2o.tool.BaseFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CartFragmentActivity extends BaseFragment {
	
	private PullToRefreshListView mPullToRefreshListView;
	private ListView listView;
	private View view;
	private Context mContext;
	private CartAdapter mAdapter;
	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
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
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		title_topbar_tv = (TextView) view.findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) view.findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) view.findViewById(R.id.title_topbar_back_iv);
	}

	@Override
	protected void initView() {
		title_topbar_back_iv.setVisibility(View.GONE);
		title_topbar_tv.setText("购物车");
		title_topbar_right_tv.setText("编辑");
		mContext = view.getContext();
		mAdapter = new CartAdapter(mContext);
		listView = mPullToRefreshListView.getRefreshableView();
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(listener);
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener2<ListView>() {

			@Override
			public void onPullDownToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				String label = DateUtils.formatDateTime(getActivity().getApplicationContext(), System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
				// TODO 这只个测试
				httpget("http://m.baidu.com/", 1);
				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
				
			}

			@Override
			public void onPullUpToRefresh(
					PullToRefreshBase<ListView> refreshView) {
				//TODO 这只个测试
				httpget("http://m.baidu.com/", 1);
			}
		});
		
	}
	
	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		}
	};
	@Override
	protected void result(String result) {
		mAdapter.notifyDataSetChanged();
		mPullToRefreshListView.onRefreshComplete();
	}

}
