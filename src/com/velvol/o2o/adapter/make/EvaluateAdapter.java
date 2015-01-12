package com.velvol.o2o.adapter.make;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.constant.Replies;

public class EvaluateAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	private List<Replies>replies;
	public EvaluateAdapter(Context con,List<Replies>replies){
		context = con;
		mInflater = LayoutInflater.from(context);
		this.replies = replies;
	}
	@Override
	public int getCount() {
		if(replies != null)
			return replies.size();
		return 0;
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
			holder.context = (TextView)convertView.findViewById(R.id.context);
			holder.name = (TextView)convertView.findViewById(R.id.name);
			holder.praise= (TextView)convertView.findViewById(R.id.praise);
			holder.replay = (TextView)convertView.findViewById(R.id.reply);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
			holder.lv.setProgress(replies.get(position).getStarcount());
			holder.context.setText(replies.get(position).getContext());
			holder.name.setText(replies.get(position).getUsername()+"  "+replies.get(position).getCreatedate()+replies.get(position).getCreatetime());
			holder.praise.setText("("+replies.get(position).getZambiacount()+")");
			holder.replay.setText("»Ø¸´("+replies.get(position).getReplycount()+")");
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
