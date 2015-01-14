package com.velvol.o2o.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.velvol.o2o.R;

public class SearchAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	private List<HashMap<String, String>> list;
	private HashMap<Integer, Boolean> isselect;

	public void setIsselect(HashMap<Integer, Boolean> isselect) {
		this.isselect = isselect;
	}

	public SearchAdapter(Context con) {
		context = con;
		mInflater = LayoutInflater.from(context);
	}

	public void setList(List<HashMap<String, String>> list) {

		this.list = list;
	}

	@Override
	public int getCount() {
		if(list!=null)
			return list.size();
		return 0;
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
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater
					.inflate(R.layout.listview_search_item, null);
			holder = new ViewHolder();
			// holder.img = (TextView) convertView.findViewById(R.id.icon);
			holder.name = (TextView) convertView.findViewById(R.id.tv_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText(list.get(position).get("name"));
		if (isselect.get(position)) {
			holder.name.setBackgroundColor(Color.rgb(255, 255, 255));
		} else {
			holder.name.setBackgroundColor(Color.rgb(232, 232, 232));
		}
		return convertView;
	}

	class ViewHolder {
		// TextView img;
		TextView name;
	}
}
