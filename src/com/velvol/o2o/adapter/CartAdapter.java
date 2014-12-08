package com.velvol.o2o.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.velvol.o2o.R;

public class CartAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	public CartAdapter(Context con){
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
			convertView = mInflater.inflate(R.layout.listview_cart_item, null);
			holder = new ViewHolder();
//			holder.img = (TextView)convertView.findViewById(R.id.icon);
//			holder.name = (TextView)convertView.findViewById(R.id.name);
//			holder.price= (TextView)convertView.findViewById(R.id.price);
//			holder.condition = (TextView)convertView.findViewById(R.id.condition);
//			holder.buy= (TextView)convertView.findViewById(R.id.buy);
			convertView.setTag(holder);
		}
		else {
			holder = (ViewHolder) convertView.getTag();
		}
//			mOnclick mClick = new mOnclick(position);
//			holder.buy.setOnClickListener(mClick);
			return convertView;
		}
//	public class mOnclick implements View.OnClickListener{
//		int position;
//		public mOnclick(int index){
//			position = index;
//		} 
//		@Override
//		public void onClick(View v) {
//			switch (v.getId()) {
//			case R.id.buy:
//				Toast.makeText(context, "加入购物车成功", 0).show();
//				
//				break;
//			default:
//				break;
//			}
//		}
//		
//	};
		class ViewHolder {
			TextView img;
			TextView name;
			TextView price;
			TextView condition;
			TextView buy;
		}
}
