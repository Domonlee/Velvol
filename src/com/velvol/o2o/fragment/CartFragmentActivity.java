package com.velvol.o2o.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.CartAdapter;
import com.velvol.o2o.tool.BaseFragment;

public class CartFragmentActivity extends BaseFragment {

	private PullToRefreshListView mPullToRefreshListView;
	private ListView listView;
	private View view;
	private Context mContext;
	private CartAdapter mAdapter;
	public TextView title_topbar_tv, title_topbar_right_tv, money_all;
	public Button sub;
	public ImageView title_topbar_back_iv;
	private CheckBox select_all;

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
		mPullToRefreshListView = (PullToRefreshListView) view
				.findViewById(R.id.pull_refresh_list);
		title_topbar_tv = (TextView) view.findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) view
				.findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) view
				.findViewById(R.id.title_topbar_back_iv);
		money_all = (TextView) view.findViewById(R.id.cart_totalprice_tv);
		sub = (Button) view.findViewById(R.id.cart_submit_tv);
		select_all = (CheckBox) view.findViewById(R.id.cart_selectall_cb);
	}

	@Override
	protected void initView() {
		title_topbar_back_iv.setVisibility(View.GONE);
		title_topbar_tv.setText("���ﳵ");
		title_topbar_right_tv.setText("�༭");
		mContext = view.getContext();
		getMoneyAll();
		mAdapter = new CartAdapter(mContext,this);
		listView = mPullToRefreshListView.getRefreshableView();
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(listener);
		title_topbar_right_tv.setOnClickListener(listener2);
		sub.setOnClickListener(listener2);
		select_all.setOnClickListener(listener2);

		mPullToRefreshListView
				.setOnRefreshListener(new OnRefreshListener2<ListView>() {

					@Override
					public void onPullDownToRefresh(
							PullToRefreshBase<ListView> refreshView) {
						String label = DateUtils.formatDateTime(getActivity()
								.getApplicationContext(), System
								.currentTimeMillis(),
								DateUtils.FORMAT_SHOW_TIME
										| DateUtils.FORMAT_SHOW_DATE
										| DateUtils.FORMAT_ABBREV_ALL);
						// TODO ��ֻ������
						httpget("http://m.baidu.com/", 1);
						refreshView.getLoadingLayoutProxy()
								.setLastUpdatedLabel(label);

					}

					@Override
					public void onPullUpToRefresh(
							PullToRefreshBase<ListView> refreshView) {
						// TODO ��ֻ������
						httpget("http://m.baidu.com/", 1);
					}
				});

	}

	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
		}
	};

	View.OnClickListener listener2 = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_right_tv:
				if(mAdapter.Edit_flag){
					mAdapter.Edit_flag = false;
					mAdapter.notifyDataSetChanged();
					title_topbar_right_tv.setText("�༭");
					sub.setBackgroundColor(Color.rgb(248, 182, 42));
					sub.setText("����");
				}
				else{
					mAdapter.Edit_flag = true;
					mAdapter.notifyDataSetChanged();
					title_topbar_right_tv.setText("���");
					sub.setBackgroundColor(Color.rgb(232, 52, 40));
					sub.setText("ɾ��");
				}
				
				break;
			case R.id.cart_submit_tv:
				if(mAdapter.Edit_flag){
					for (int i = 0; i < mAdapter.isSelect.size(); i++) {
						if(mAdapter.isSelect.get(i))
							data.cat_sell_list.remove(i);
					}
					mAdapter.notifyDataSetChanged();
				}
				break;
			case R.id.cart_selectall_cb:
				if(select_all.isChecked())
					mAdapter.setSelect(-1);
				else
					mAdapter.setSelect(-2);
				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void result(String result) {
		mAdapter.notifyDataSetChanged();
		mPullToRefreshListView.onRefreshComplete();
	}

	public void  getMoneyAll() {
		double moneyall = 0;
		for (int i = 0; i < data.cat_sell_list.size(); i++) {
			moneyall += data.cat_sell_list.get(i).getPrice()
					* data.cat_sell_list.get(i).count;
		}
		money_all.setText("��" + moneyall);
	}
}
