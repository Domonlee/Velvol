package com.velvol.o2o.adapter;


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
//朋友房间大家一起点的食物ListView
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RoomNumberFriendRoomEveryoneFootAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater inflater;
	
	public RoomNumberFriendRoomEveryoneFootAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 ViewHolder holder = null;
		if(convertView==null){
		   convertView=inflater.inflate(R.layout.listview_room_everyone, null);
		   holder=new ViewHolder();
		   holder.masterName=(TextView) convertView.findViewById(R.id.room_master_name_textview);
		   holder.masterTotal=(TextView) convertView.findViewById(R.id.room_master_total_textview);
		   holder.friendName=(TextView) convertView.findViewById(R.id.room_friend_name_textview);
		   holder.friendTotal=(TextView) convertView.findViewById(R.id.room_friend_total_textview);
		   holder.masterFootListView=(ListView) convertView.findViewById(R.id.room_master_foot_listView);
		   RoomNumberMasterFootAdapter adapter = new RoomNumberMasterFootAdapter(context);
		   RoomNumberFriendFootAdapter adapter1 = new RoomNumberFriendFootAdapter(context);
		   holder.frendFootListView=(ListView) convertView.findViewById(R.id.room_friend_foot_listView);
		   holder.masterFootListView.setAdapter(adapter1);
		   holder.frendFootListView.setAdapter(adapter);
		   
		   convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	class ViewHolder{
		//房间主人的名字
		TextView masterName;
		//合计钱数
		TextView masterTotal;
		//房间主人点菜的ListView
		ListView masterFootListView;
		//朋友的名字
		TextView friendName;
		//朋友合计的钱数
		TextView friendTotal;
		//朋友点菜的ListView
		ListView frendFootListView;
	}
}
