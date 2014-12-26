package com.velvol.o2o.adapter.search;

import java.util.ArrayList;

import com.velvol.o2o.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SearchHotAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<String> list;

	public SearchHotAdapter(Context con) {
		this.context = con;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(
				R.layout.search_hot_item, null);
		TextView name1 = (TextView) convertView
				.findViewById(R.id.tv_search_hot_name1);
		TextView name2 = (TextView) convertView
				.findViewById(R.id.tv_search_hot_name2);
		TextView count1 = (TextView) convertView
				.findViewById(R.id.tv_search_hot_count1);
		TextView count2 = (TextView) convertView
				.findViewById(R.id.tv_search_hot_count2);
		name1.setText(list.get(position * 2));
		name2.setText(list.get(position * 2 + 1));

		return convertView;
	}

}
