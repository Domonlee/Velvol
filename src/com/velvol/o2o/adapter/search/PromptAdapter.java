package com.velvol.o2o.adapter.search;

import java.util.ArrayList;

import com.velvol.o2o.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PromptAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<String> list;

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public PromptAdapter(Context con) {
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
				R.layout.search_class_down_item, null);
		TextView name = (TextView) convertView
				.findViewById(R.id.tv_down_item_name);
		TextView count = (TextView) convertView
				.findViewById(R.id.tv_down_item_count);

		if (position == 0) {
			name.setText("ËÑË÷¡°" + list.get(position) + "¡±²ËÆ·");
		}
		name.setText(list.get(position));
		count.setText("35");

		return convertView;
	}

}
