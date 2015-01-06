package com.velvol.o2o.adapter.find;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
//����ҳ����һ����ʳ��ListView
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RoomNumberEveryoneFootAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater inflater;
	private int masterFootPriceTotal;
	private int friendFootPriceTotal;
	
	public RoomNumberEveryoneFootAdapter(Context context){
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
		   holder.masterFootListView.setAdapter(adapter);
		   holder.frendFootListView=(ListView) convertView.findViewById(R.id.room_friend_foot_listView);
		   RoomNumberFriendFootAdapter adapter1 = new RoomNumberFriendFootAdapter(context);
		   holder.frendFootListView.setAdapter(adapter1);
		   
		   convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		holder.masterTotal.setText("��"+masterFootPriceTotal);
		holder.friendTotal.setText("��"+friendFootPriceTotal);
		return convertView;
	}
	class ViewHolder{
		//�������˵�����
		TextView masterName;
		//�ϼ�Ǯ��
		TextView masterTotal;
		//�������˵�˵�ListView
		ListView masterFootListView;
		//���ѵ�����
		TextView friendName;
		//���ѺϼƵ�Ǯ��
		TextView friendTotal;
		//���ѵ�˵�ListView
		ListView frendFootListView;
	}
	//����ÿ����ʳ��۸��ܺ͵ķ���
			public int getFoodpricetotal(){
				//ѭ������ÿ����
//				for(int i=0;i<10;i++){
//					//ÿ����
//					for(){}
//					//1ȡ��ÿ���˵ļ۸�
//					//2�ۼ����
//				}
//				//�������ֵ
			 masterFootPriceTotal = RoomNumberMasterFootAdapter.getMasterFoodpricetotal();
			 friendFootPriceTotal = RoomNumberFriendFootAdapter.getFriendfoodpricetotal();
			int footpriceTotal = friendFootPriceTotal+masterFootPriceTotal;
			Log.i("���ѵ�˵ļ۸�", friendFootPriceTotal+"");
			Log.i("������˵ļ۸�", masterFootPriceTotal+"");
			Log.i("����",footpriceTotal+"");
			return footpriceTotal;
			}
}
