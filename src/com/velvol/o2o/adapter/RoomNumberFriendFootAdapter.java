package com.velvol.o2o.adapter;

import com.velvol.o2o.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
//朋友点的食物的Listview
public class RoomNumberFriendFootAdapter extends BaseAdapter{

		
		private Context Context;
		private LayoutInflater inflater;

		public RoomNumberFriendFootAdapter(Context context){
			this.Context=context;
			inflater=LayoutInflater.from(context);
		}
	@Override
	public int getCount() {
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
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.listview_room_everyonefriendfood, null);
			holder=new ViewHolder();
			holder.friendFoodName=(TextView) convertView.findViewById(R.id.room_friend_food_textview);
			holder.friengFoodMany=(TextView)convertView.findViewById(R.id.room_friend_food_many_textview);
			holder.friengFoodPrice=(TextView)convertView.findViewById(R.id.room_friend_food_price_textview);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	class ViewHolder{
		//朋友点的食物名字
		TextView friendFoodName;
		//食物数量
		TextView friengFoodMany;
		//食物的价格
		TextView friengFoodPrice;
	}
}
