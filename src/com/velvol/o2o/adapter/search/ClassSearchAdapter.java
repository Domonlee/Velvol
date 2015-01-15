package com.velvol.o2o.adapter.search;

import java.util.List;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.velvol.o2o.Data;
import com.velvol.o2o.R;
import com.velvol.o2o.Utils.Util;
import com.velvol.o2o.adapter.NewAdapter.mOnclick;
import com.velvol.o2o.constant.Sell;
import com.velvol.o2o.constant.SellSearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassSearchAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater mInflater;
	private List<SellSearch> list_sell;
	public ClassSearchAdapter(Context con,List<SellSearch> list_sell) {
		this.context = con;
		mInflater = LayoutInflater.from(context);
		this.list_sell = list_sell;
	}

	@Override
	public int getCount() {
		if(list_sell!=null)
			return list_sell.size();
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.classsearch_item, null);
			holder = new ViewHolder();
			holder.img = (ImageView) convertView.findViewById(R.id.iv_class_item_img);
			holder.name = (TextView) convertView.findViewById(R.id.tv_class_item_name);
			holder.price = (TextView) convertView.findViewById(R.id.tv_class_item_price);
			holder.vipprice = (TextView) convertView.findViewById(R.id.tv_class_item_vipprice);
			holder.count = (TextView) convertView.findViewById(R.id.tv_class_item_month_count);
			holder.buy = (TextView) convertView.findViewById(R.id.tv_class_item_buy);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ImageLoader.getInstance().displayImage(list_sell.get(position).getImg(), holder.img,Data.getInstance().displayImageOptions);
		holder.name.setText(list_sell.get(position).getDishname());
		holder.price.setText("￥"+list_sell.get(position).getOldprice());
		holder.vipprice.setText("￥"+list_sell.get(position).getPrice());
		holder.count.setText(""+list_sell.get(position).getCount());
		mOnclick mClick = new mOnclick(position);
		holder.buy.setOnClickListener(mClick);
		return convertView;
	}

	class ViewHolder {
		TextView name;
		ImageView img;
		TextView price;
		TextView vipprice;
		TextView count;
		TextView buy;

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
				new Util().addCat(new Sell(list_sell.get(position).getId(), list_sell.get(position).getPrice(),
						list_sell.get(position).getImg(), list_sell.get(position).getDishname(), list_sell.get(position).getDishname()));
				Toast.makeText(context, "加入购物车成功" + position, 0).show();

				break;
			default:
				break;
			}
		}

	};
}
