package com.velvol.o2o.adapter.make;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.velvol.o2o.R;

public class ShopDetailsAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	public ShopDetailsAdapter(Context con){
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
			convertView = mInflater.inflate(R.layout.listview_shopdetails_item, null);
			holder = new ViewHolder();
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);
			holder.name = (TextView)convertView.findViewById(R.id.name);
			holder.totl_number= (TextView)convertView.findViewById(R.id.totl_number);
			holder.good= (TextView)convertView.findViewById(R.id.good);
			holder.money = (TextView)convertView.findViewById(R.id.money);
			holder.member_money= (TextView)convertView.findViewById(R.id.member_money);
			holder.buy = (Button)convertView.findViewById(R.id.buy);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
			return convertView;
		}
		class ViewHolder {
			ImageView icon;
			TextView name;
			TextView totl_number;
			TextView good;
			TextView money;
			TextView member_money;
			Button buy;
		}
}
