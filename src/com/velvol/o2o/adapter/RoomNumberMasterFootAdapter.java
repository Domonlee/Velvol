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
import android.widget.ImageView;
import android.widget.TextView;
//房间主人点的食物的Listview
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RoomNumberMasterFootAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater inflater;
	
	public RoomNumberMasterFootAdapter(Context context){
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
		   convertView=inflater.inflate(R.layout.listview_room_everyonemasterfood, null);
		   holder=new ViewHolder();
		   holder.masterFoodName=(TextView) convertView.findViewById(R.id.room_master_food_textview);
		   holder.masterFoodReduce=(TextView) convertView.findViewById(R.id.room_master_food_reduce_textview);
		   holder.masterFoodMany=(TextView) convertView.findViewById(R.id.room_master_food_many_textview);
		   holder.masterFoodPrice=(TextView) convertView.findViewById(R.id.room_master_food_price_textview);
		   holder.masterFoodDelete=(ImageView) convertView.findViewById(R.id.room_master_food_delete_imageview);
		   convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	class ViewHolder{
		//房间主人点的食物
		TextView masterFoodName;
		//主人删除食物减号
		TextView masterFoodReduce;
		//主人点的每道菜的个数
		TextView masterFoodMany;
		//菜价
		TextView masterFoodPrice;
		//删除按钮
		ImageView masterFoodDelete;
	}
}
