package com.velvol.o2o.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.NewAdapter;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.constant.Sell;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.tool.ConfigUtil;
import com.velvol.o2o.ui.make.ParticularsActivity;
import com.velvol.o2o.ui.manager.ChangeAddressActivity;

public class MakeFragmentActivity extends BaseFragment {

	
	private View view;
	private NewAdapter mAdapter;
	private PullToRefreshGridView mPullRefreshGridView;
	private GridView mGridView;
	private TextView address;
	private List<Sell> advicedishes = new ArrayList<Sell>();
	private List<Sell> recentorder = new ArrayList<Sell>();
	private List<Sell> discount = new ArrayList<Sell>();
	private List<Sell> ilike = new ArrayList<Sell>();
	private RadioGroup radioGroup;
	private int check_id;
	private int LOADER = 100,REFRESH=101,action=0;
	private int[] page = {1,1,1,1};
	private String main_result;
	private boolean result_flag = false;
	

	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_make, container, false);
		findViewById();
		initView();
		if(action == 0){
			main_result = ConfigUtil.getString("main_result", "");
			if(main_result.equals("")||isNetworkConnected(getActivity())){
				result_flag = true;
				httpget(GetUrl.getMainInfoUrl(data.User_id), 1);
			}
			else
				result(main_result);
		}
		return view;
	}
	
	protected void findViewById() {
		mPullRefreshGridView = (PullToRefreshGridView) view
				.findViewById(R.id.pull_refresh_grid);
		address = (TextView) view.findViewById(R.id.address);
		radioGroup = (RadioGroup) view
				.findViewById(R.id.home_radio_button_group);
		mGridView = mPullRefreshGridView.getRefreshableView();
	}

	protected void initView() {
		DisplayMetrics metric = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels;
		Log.v("MakeFragmentActivity", width + "");
		mAdapter = new NewAdapter(getActivity(), width / 2);
		mAdapter.setList(ilike);
		check_id = R.id.like;
		mGridView.setAdapter(mAdapter);
		mGridView.setOnItemClickListener(listener);

		mPullRefreshGridView
				.setOnRefreshListener(new OnRefreshListener2<GridView>() {

					public void onPullDownToRefresh(
							PullToRefreshBase<GridView> refreshView) {
						// 刷新
						action = REFRESH;
						int i = check_id - (R.id.like)+1;
						if(isNetworkConnected(getActivity()))
							httpget(GetUrl.getMainInfoByIdUrl(data.User_id, page[i]=1, i), 1);
						else 
							Toast.makeText(getActivity().getApplicationContext(), "请检查网络连接！", 0).show();
					}

					public void onPullUpToRefresh(
							PullToRefreshBase<GridView> refreshView) {
						// 加载
						action = LOADER;
						int i = check_id - (R.id.like)+1;
						if(isNetworkConnected(getActivity()))
							httpget(GetUrl.getMainInfoByIdUrl(data.User_id, ++page[i], i), 1);
						else 
							Toast.makeText(getActivity().getApplicationContext(), "请检查网络连接！", 0).show();
					}
				});

		address.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivityForResult((new Intent(getActivity(),
						ChangeAddressActivity.class)), 0);
			}
		});

		radioGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						check_LoaderList(checkedId);
					}
				});
	}

	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			startActivity(new Intent(getActivity(), ParticularsActivity.class).putExtra("SellId", mAdapter.getList().get(position).getId()));
		}
	};

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null)
			address.setText(data.getStringExtra("useraddr"));
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * httpGet 回调函数
	 */
	protected void result(String result) {
		try {
			JSONObject c = new JSONObject(result);
			if (c.getInt("mark") == 1) {
				Json(c.optJSONArray("recentorder"), "recentorder", recentorder);
				Json(c.optJSONArray("discount"), "discount", discount);
				Json(c.optJSONArray("ilike"), "ilike", ilike);
				Json(c.optJSONArray("advicedishes"), "advicedishes",
						advicedishes);
				if(result_flag)
					ConfigUtil.putString("main_result", result);
				check_LoaderList(check_id);
					
			} else
				Toast.makeText(getActivity().getApplicationContext(), "数据出错！", 0).show();
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getActivity().getApplicationContext(), "网络异常！", 0).show();
			page[check_id - (R.id.like)]--;
		}
		finally{
			result_flag = false;
			action = 1;
			mPullRefreshGridView.onRefreshComplete();
		}
	}

	/**
	 * Json数组解析
	 * @param array
	 * @throws JSONException
	 */
	private void Json(JSONArray array, String action, List<Sell> list)
			throws JSONException {
		if (array == null) {
			Log.v("Sen", action + "字段不存在");
			return;
		}
		if(this.action!=LOADER)
			list.removeAll(list);
		int len = array.length();
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				Sell sell = new Sell(array.getJSONObject(i));
				list.add(sell);
			}
		}
	}
	
	/**
	 * Adapter加载List数据
	 * @param checkedId
	 */
	private void check_LoaderList(int checkedId) {
		switch (checkedId) {
		case R.id.like:
			mAdapter.setList(ilike);
			break;
		case R.id.late:
			mAdapter.setList(recentorder);
			break;
		case R.id.recommend:
			mAdapter.setList(advicedishes);
			break;
		case R.id.privilege:
			mAdapter.setList(discount);
			break;
		}
		check_id = checkedId;
		mAdapter.notifyDataSetChanged();
	}
}
