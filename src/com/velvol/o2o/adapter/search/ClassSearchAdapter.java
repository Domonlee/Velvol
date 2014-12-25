package com.velvol.o2o.adapter.search;

import com.velvol.o2o.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassSearchAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater mInflater;

	public ClassSearchAdapter(Context con) {
		this.context = con;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 10;
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
			convertView = mInflater.inflate(R.layout.classsearch_item, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView
					.findViewById(R.id.tv_class_item_name);
			holder.price = (TextView) convertView
					.findViewById(R.id.tv_class_item_price);
			holder.vipprice = (TextView) convertView
					.findViewById(R.id.tv_class_item_vipprice);
			holder.count = (TextView) convertView
					.findViewById(R.id.tv_class_item_month_count);
			holder.buy = (TextView) convertView
					.findViewById(R.id.tv_class_item_buy);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	class ViewHolder {
		TextView name;
		ImageView img;
		TextView price;
		TextView vipprice;
		TextView count;
		TextView buy;

	}
}
