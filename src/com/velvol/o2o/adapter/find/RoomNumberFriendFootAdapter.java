package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.velvol.o2o.R;
//���ѵ��ʳ���Listview
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
		//���ѵ��ʳ������
		TextView friendFoodName;
		//ʳ������
		TextView friengFoodMany;
		//ʳ��ļ۸�
		TextView friengFoodPrice;
	}
	//����ʳ��۸�ķ���(��Ҫһ����Ʒ����)
	public static int getFriendfoodpricetotal(){
		//ѭ������ÿ��Item(ÿ����)
		for(int i=0;i<10;i++){
			//1ȡ��ÿ���˵ļ۸�
			//2�ۼ����
		}
		//�������ֵ
		return 50;
	}
}
