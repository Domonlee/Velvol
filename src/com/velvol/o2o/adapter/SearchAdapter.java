package com.velvol.o2o.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.R;

public class SearchAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	public SearchAdapter(Context con){
		context = con;
		mInflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listview_search_item, null);
			holder = new ViewHolder();
			holder.img = (TextView)convertView.findViewById(R.id.icon);
			holder.name = (TextView)convertView.findViewById(R.id.name);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
			return convertView;
		}
		class ViewHolder {
			TextView img;
			TextView name;
		}
}
