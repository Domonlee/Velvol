package com.velvol.o2o.adapter.make;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.velvol.o2o.R;

public class EvaluateAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	public EvaluateAdapter(Context con){
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
			convertView = mInflater.inflate(R.layout.listview_evaluate_item, null);
			holder = new ViewHolder();
			holder.lv = (RatingBar) convertView.findViewById(R.id.lv);
			holder.name = (TextView)convertView.findViewById(R.id.name);
			holder.context = (TextView)convertView.findViewById(R.id.context);
			holder.praise= (TextView)convertView.findViewById(R.id.praise);
			holder.replay = (TextView)convertView.findViewById(R.id.reply);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
			return convertView;
		}
		class ViewHolder {
			RatingBar lv;
			TextView name;
			TextView context;
			TextView praise;
			TextView replay;
		}
}
