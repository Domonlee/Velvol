package com.velvol.o2o.ui.search;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.velvol.o2o.Data;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.search.RecentAdapter;
import com.velvol.o2o.tool.ConfigUtil;

public class SearchHistory {
	
	public PopupWindow window;
	private Activity activity;
	private RecentAdapter recentAdapter;
	private ArrayList<String> flist;
	public SearchHistory(Activity activity) {
		this.activity = activity;
		flist = new ArrayList<String>();
		recentAdapter = new RecentAdapter(activity);
		recentAdapter.setList(flist);
	}
	
	public void showwindow(View ll1) {

		window = new PopupWindow(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		View view = LayoutInflater.from(activity).inflate(
				R.layout.search_fragment_down, null);
		window.setContentView(view);
		window.setOutsideTouchable(false);
		window.setBackgroundDrawable(new ColorDrawable());
		window.setFocusable(false);
		// 全屏PopupWindow 挡住软键盘
		window.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		window.showAsDropDown(ll1);
		// 热门搜索
		ListView gridView = (ListView) view
				.findViewById(R.id.gv_search_fragment_down_listview);
		// 最近搜索
		ListView listView = (ListView) view
				.findViewById(R.id.lv_search_fragment_down_listview);
		TextView clear = (TextView) view.findViewById(R.id.tv_search_class_down_clear);
		// 假数据  热门搜索不要了
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("牛肉面");
//		list.add("酸菜面");
//		list.add("岐山臊子面");
//		list.add("金马刀削面");
//		SearchHotAdapter hotAdapter = new SearchHotAdapter(activity);
//		hotAdapter.setList(list);
//		gridView.setAdapter(hotAdapter);

		
		try {
			flist.clear();
			JSONObject json = new JSONObject(Data.getInstance().searchHistory);
			JSONArray array = json.getJSONArray("searchHistory");
			if(array!=null){
				for(int i=0;i<array.length();i++)
					flist.add(array.getJSONObject(i).getString("name"));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		listView.setAdapter(recentAdapter);
		clear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				flist.clear();
				recentAdapter.notifyDataSetChanged();
				ConfigUtil.putString("searchHistory", Data.getInstance().searchHistory = "{\"searchHistory\":[]}");
			}
		});

	}
}
