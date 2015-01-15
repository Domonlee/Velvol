package com.velvol.o2o.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.SearchAdapter;
import com.velvol.o2o.adapter.search.SearchFoodAdapter;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.tool.ConfigUtil;
import com.velvol.o2o.ui.search.SearchClassActivity;
import com.velvol.o2o.ui.search.SearchHistory;

public class SearchFragmentActivity extends BaseFragment {

	private ListView listView;
	private GridView gridView;
	private View view;
	private Context mContext;
	private SearchAdapter mAdapter;
	private SearchFoodAdapter adapter;
	
	private SearchHistory popwindow;
	private LinearLayout ll1;
	private EditText search;
	private TextView cencel;
	private HashMap<Integer, Boolean> isselect = new HashMap<Integer, Boolean>();
	private List<HashMap<String, String>> firstlist = new ArrayList<HashMap<String, String>>();
	private List<HashMap<String, String>> secendlist = new ArrayList<HashMap<String, String>>();
	private int check_index = 0;
	private String search_result;
	private boolean result_flag = false,http_init = true;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_search, container, false);
		findViewById();
		initView();
		if(http_init){
			search_result = ConfigUtil.getString("search_result", "");
			if(search_result.equals("")||isNetworkConnected(getActivity())){
				result_flag = true;
				httpget(GetUrl.getSearchClassifyUrl(-1 + ""), 1);
			}
			else
				result(search_result);
		}
		http_init =false;
		return view;
	}

	@Override
	protected void findViewById() {
		search = (EditText) view.findViewById(R.id.search);
		ll1 = (LinearLayout) view.findViewById(R.id.ll_ll1);
		listView = (ListView) view.findViewById(R.id.listview);
		gridView = (GridView) view.findViewById(R.id.search_gridView1);
		cencel = (TextView) view.findViewById(R.id.cencel);
	}

	@Override
	protected void initView() {
		if(popwindow ==null)
			popwindow = new SearchHistory(getActivity());

		mContext = view.getContext();
		if(mAdapter ==null)
			mAdapter = new SearchAdapter(mContext);
		mAdapter.setList(firstlist);
		mAdapter.setIsselect(isselect);
		listView.setAdapter(mAdapter);
		
		if(adapter==null)
		adapter = new SearchFoodAdapter(mContext);
		adapter.setList(secendlist);
		gridView.setAdapter(adapter);

		listView.setOnItemClickListener(listener);
		cencel.setOnClickListener(listener2);
		search.setOnEditorActionListener(listener3);

		search.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus)
					if (popwindow.window == null
							|| !popwindow.window.isShowing())
						popwindow.showwindow(ll1);

			}
		});
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long arg3) {
				startActivity(new Intent(getActivity(),
						SearchClassActivity.class).putExtra("classifyId", secendlist
						.get(position).get("id")).putExtra("key", "-1"));
			}
		});

	}

	TextView.OnEditorActionListener listener3 = new TextView.OnEditorActionListener() {
		@Override
		public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			if (actionId == EditorInfo.IME_ACTION_SEARCH
					&& search.getText().toString().length() > 0) {
				startActivity(new Intent(getActivity(),
						SearchClassActivity.class).putExtra("key", search
						.getText().toString()).putExtra("classifyId", "-1"));

				// 保存历史记录到XML文件中
				StringBuffer sb = new StringBuffer(data.searchHistory);
				if (data.searchHistory.length() > 21)
					sb.insert(18, "{\"name\":\"" + search.getText().toString()
							+ "\"},");
				else
					sb.insert(18, "{\"name\":\"" + search.getText().toString()
							+ "\"}");
				ConfigUtil.putString("searchHistory",
						data.searchHistory = sb.toString());
			}
			return false;
		}
	};

	View.OnClickListener listener2 = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.cencel:
				if(popwindow.window!=null)
					popwindow.window.dismiss();
				search.clearFocus();
				// 收键盘
				((InputMethodManager) getActivity().getSystemService(
						Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
						search.getWindowToken(),
						InputMethodManager.HIDE_NOT_ALWAYS);
				break;
			default:
				break;
			}
		}
	};
	AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			check_index = position;
			httpget(GetUrl.getSearchClassifyUrl(firstlist.get(position).get(
					"id")), 1);
		}
	};

	@Override
	protected void result(String result) {
		try {
			JSONObject c = new JSONObject(result);
			if (c.getInt("mark") == 1) {
				Json(c.optJSONArray("firstlist"), "firstlist", firstlist);
				Json(c.optJSONArray("secendlist"), "secendlist", secendlist);
				for (int i = 0; i < firstlist.size(); i++) {
					isselect.put(i, false);
				}
				isselect.put(check_index, true);
				if(result_flag)
					ConfigUtil.putString("search_result", result);
				mAdapter.notifyDataSetChanged();
				adapter.notifyDataSetChanged();
			} else
				Toast.makeText(getActivity().getApplicationContext(), "数据出错！",
						0).show();
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getActivity().getApplicationContext(), "网络异常！", 0)
					.show();
		}
		finally{
			result_flag = false;
		}
	}

	/**
	 * Json数组解析
	 * 
	 * @param array
	 * @throws JSONException
	 */
	private void Json(JSONArray array, String action,
			List<HashMap<String, String>> list) throws JSONException {
		if (array == null) {
			Log.v("Sen", action + "字段不存在");
			return;
		}
		list.clear();
		int len = array.length();
		if (len > 0) {
			for (int i = 0; i < len; i++) {
				HashMap<String, String> hashMap = new HashMap<String, String>();
				hashMap.put("name", array.getJSONObject(i).getString("name"));
				hashMap.put("id", array.getJSONObject(i).getInt("id") + "");
				hashMap.put("img",
						GetUrl.IMAGE_SELL_URL
								+ array.getJSONObject(i).getString("img"));
				list.add(hashMap);
			}
		}
	}

}
