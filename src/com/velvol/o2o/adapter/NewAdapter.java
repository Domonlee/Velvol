package com.velvol.o2o.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.velvol.o2o.Data;
import com.velvol.o2o.R;
import com.velvol.o2o.Utils.Util;
import com.velvol.o2o.constant.Sell;

public class NewAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater mInflater;
	private List<Sell>sell_list;
	private int width;

	public NewAdapter(Context con, int width) {
		context = con;
		mInflater = LayoutInflater.from(context);
		this.width = width;
	}
	public void setList(List<Sell>sell_list) {
		this.sell_list = sell_list;
	}
	public List<Sell> getList(){
		return sell_list;
	}
	@Override
	public int getCount() {
		if(sell_list!=null)
			return sell_list.size();
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
			convertView = mInflater.inflate(R.layout.listview_make_item, null);
			holder = new ViewHolder();
			holder.layout = (LinearLayout) convertView
					.findViewById(R.id.layout);
			holder.img = (ImageView) convertView.findViewById(R.id.icon);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.price = (TextView) convertView.findViewById(R.id.price);
			holder.price_new = (TextView) convertView.findViewById(R.id.price_new);
			holder.status = (TextView) convertView.findViewById(R.id.status);
			holder.buy = (Button) convertView.findViewById(R.id.buy);
			convertView.setTag(holder);
			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.layout.setLayoutParams(new AbsListView.LayoutParams(width,
				(int) (width * 1.4)));
		ImageLoader.getInstance().displayImage(sell_list.get(position).getImgname(), holder.img,Data.getInstance().displayImageOptions);
		holder.name.setText(sell_list.get(position).getDishname());
		holder.price.setText("￥"+sell_list.get(position).getOldprice());
		holder.price_new.setText("会员价￥"+sell_list.get(position).getPrice());
		if(sell_list.get(position).getSoldout()!=0)
			holder.status.setBackgroundResource(R.drawable.status_on);
		mOnclick mClick = new mOnclick(position);
		holder.buy.setOnClickListener(mClick);
		return convertView;
	}

	public class mOnclick implements View.OnClickListener {
		int position;

		public mOnclick(int index) {
			position = index;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.buy:
				new Util().addCat(sell_list.get(position));
				Toast.makeText(context, "加入购物车成功" + position, 0).show();

				break;
			default:
				break;
			}
		}

	};

	class ViewHolder {
		LinearLayout layout;
		ImageView img;
		TextView name;
		TextView price;
		TextView price_new;
		TextView status;
		Button buy;
	}
}
