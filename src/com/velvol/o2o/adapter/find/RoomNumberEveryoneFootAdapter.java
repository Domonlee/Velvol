package com.velvol.o2o.adapter.find;

import java.util.List;

import com.velvol.o2o.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//房主页面大家一起点的食物ListView
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RoomNumberEveryoneFootAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	public RoomNumberEveryoneFootAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listview_room_everyone,
					null);
			holder = new ViewHolder();
			holder.masterName = (TextView) convertView
					.findViewById(R.id.room_master_name_textview);
			holder.masterTotal = (TextView) convertView
					.findViewById(R.id.room_master_total_textview);
			holder.friendName = (TextView) convertView
					.findViewById(R.id.room_friend_name_textview);
			holder.friendTotal = (TextView) convertView
					.findViewById(R.id.room_friend_total_textview);
			holder.masterFootListView = (ListView) convertView
					.findViewById(R.id.room_master_foot_listView);
			RoomNumberMasterFootAdapter adapter = new RoomNumberMasterFootAdapter(
					context);
			holder.masterFootListView.setAdapter(adapter);
			holder.frendFootListView = (ListView) convertView
					.findViewById(R.id.room_friend_foot_listView);
			RoomNumberFriendFootAdapter adapter1 = new RoomNumberFriendFootAdapter(
					context);
			holder.frendFootListView.setAdapter(adapter1);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	class ViewHolder {
		// 房间主人的名字
		TextView masterName;
		// 合计钱数
		TextView masterTotal;
		// 房间主人点菜的ListView
		ListView masterFootListView;
		// 朋友的名字
		TextView friendName;
		// 朋友合计的钱数
		TextView friendTotal;
		// 朋友点菜的ListView
		ListView frendFootListView;
	}
}
