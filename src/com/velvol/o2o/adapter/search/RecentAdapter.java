package com.velvol.o2o.adapter.search;

import java.util.ArrayList;

import com.velvol.o2o.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RecentAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<String> list;

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public RecentAdapter(Context con) {
		this.context = con;
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
				R.layout.search_class_down_recent_item_first, null);
		TextView name = (TextView) convertView
				.findViewById(R.id.tv_recent_name);
		ImageView img = (ImageView) convertView
				.findViewById(R.id.iv_recent_img);

		name.setText(list.get(position));

		return convertView;
	}

}
