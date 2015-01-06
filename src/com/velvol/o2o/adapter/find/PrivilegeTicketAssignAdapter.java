package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;

//指定店面优惠食物Adapter
public class PrivilegeTicketAssignAdapter extends BaseAdapter{
		
	private Context context;
	private LayoutInflater inflater;
	public PrivilegeTicketAssignAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 6;
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
			ViewHolder holder=null;
			if(convertView==null){
				convertView=inflater.inflate(R.layout.listview_privilege_ticket_assign_item,null);
				holder=new ViewHolder();
				holder.ticketFootPicture=(ImageView) convertView.findViewById(R.id.ticket_foot_picture_imageView);
				holder.ticketFootName=(TextView)convertView.findViewById(R.id.ticket_foot_name_textview);
				holder.ticketFootContent=(TextView)convertView.findViewById(R.id.ticket_foot_content_textview);
				holder.ticketFootTime=(TextView)convertView.findViewById(R.id.ticket_foot_validity_time_textview);
				holder.ticketFootPrice=(TextView)convertView.findViewById(R.id.ticket_foot_price_textview);
				convertView.setTag(holder);
			}else {
				holder=(ViewHolder) convertView.getTag();
			}
		return convertView;
	}
	class ViewHolder{
		//食物优惠券图片
		ImageView ticketFootPicture;
		//食物优惠券名字
		TextView ticketFootName;
		//食物优惠券内容
		TextView ticketFootContent;
		//食物优惠券有效期
		TextView ticketFootTime;
		//食物优惠券有价格
		TextView ticketFootPrice;
	}
}
