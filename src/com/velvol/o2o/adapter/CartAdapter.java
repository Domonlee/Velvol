package com.velvol.o2o.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.velvol.o2o.Data;
import com.velvol.o2o.R;
import com.velvol.o2o.constant.Sell;
import com.velvol.o2o.fragment.CartFragmentActivity;

public class CartAdapter extends BaseAdapter {
	
	private CartFragmentActivity activity;
	private Context context;
	private LayoutInflater mInflater;
	private List<Sell> sell_list;
	public boolean Edit_flag = false;
	public HashMap<Integer,Boolean> isSelect = new HashMap<Integer, Boolean>();
	private int oldsize = 0,oldindex = -1;

	public CartAdapter(Context con,CartFragmentActivity activity) {
		this.activity = activity;
		context = con;
		mInflater = LayoutInflater.from(context);
		sell_list = Data.getInstance().cat_sell_list;
	}
	/**
	 * @param index -1 : 全选  -2：全取消
	 */
	public void setSelect(int index){
		if(index == -1){
			for(int i = 0;i<oldsize;i++)
				isSelect.put(i, true);
		}
		else if(index == -2){
			for(int i = 0;i<oldsize;i++)
				isSelect.put(i, false);
		}
		else{
			isSelect.put(oldindex, false);
			isSelect.put(index, true);
			oldindex = index;
		}
		notifyDataSetChanged();	
	}
	@Override
	public int getCount() {
		if(oldindex > sell_list.size()){
			oldindex = 0;
		}
		for(int i = oldsize;i<sell_list.size();i++)
			isSelect.put(i, false);
		oldsize = sell_list.size();
		return sell_list.size();
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
			convertView = mInflater.inflate(
					R.layout.listview_cart_item, null);
			holder = new ViewHolder();
			holder.checkBox = (CheckBox) convertView
					.findViewById(R.id.cart_check);
			holder.img = (ImageView) convertView
					.findViewById(R.id.catergory_image);
			holder.name = (TextView) convertView
					.findViewById(R.id.catergoryitem_title);
			holder.price = (TextView) convertView.findViewById(R.id.money);
			holder.store = (TextView) convertView
					.findViewById(R.id.catergoryitem_cat);
			holder.number = (TextView) convertView.findViewById(R.id.number);
			holder.layout = (LinearLayout) convertView
					.findViewById(R.id.number_layout);
			holder.newnumber = (TextView) convertView
					.findViewById(R.id.newnumber);
			holder.add = (TextView) convertView.findViewById(R.id.add);
			holder.sub = (TextView) convertView.findViewById(R.id.sub);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		ImageLoader.getInstance().displayImage(
				sell_list.get(position).getImgname(), holder.img,
				Data.getInstance().displayImageOptions);
		
		if(isSelect.get(position))
			holder.checkBox.setChecked(true);
		else 
			holder.checkBox.setChecked(false);
		
		holder.name.setText(sell_list.get(position).getDishname());
		holder.price.setText("￥" + sell_list.get(position).getPrice());
		holder.store.setText(sell_list.get(position).getStorename());
		holder.number.setText("数量:  "+sell_list.get(position).count);
		holder.newnumber.setText(sell_list.get(position).count + "");

		if (Edit_flag){
			holder.layout.setVisibility(View.VISIBLE);
			holder.checkBox.setVisibility(View.VISIBLE);
		}
		else{
			holder.layout.setVisibility(View.GONE);
			holder.checkBox.setVisibility(View.GONE);
		}
		mOnclick mClick = new mOnclick(position, holder.number,
				holder.newnumber,holder.checkBox);
		holder.add.setOnClickListener(mClick);
		holder.sub.setOnClickListener(mClick);
		holder.checkBox.setOnClickListener(mClick);
		
		return convertView;
	}

	public class mOnclick implements View.OnClickListener {
		int position;
		private TextView number;
		private TextView newnumber;
		private CheckBox checkBox;

		public mOnclick(int index, TextView number, TextView newnumber,CheckBox checkBox) {
			position = index;
			this.number = number;
			this.newnumber = newnumber;
			this.checkBox = checkBox;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.add:
				sell_list.get(position).count++;
				number.setText("数量:  "+sell_list.get(position).count);
				newnumber.setText(sell_list.get(position).count + "");
				activity.getMoneyAll();
				break;
			case R.id.sub:
				if (sell_list.get(position).count > 1) {
					sell_list.get(position).count--;
					number.setText("数量:  "+sell_list.get(position).count);
					newnumber.setText(sell_list.get(position).count + "");
					activity.getMoneyAll();
				}
				break;
			case R.id.cart_check:
				if(checkBox.isChecked())
					isSelect.put(position, true);
				else
					isSelect.put(position, false);
				break;
			default:
				break;
			}
			
		}

	};

	class ViewHolder {
		CheckBox checkBox;
		ImageView img;
		TextView name;
		TextView price;
		TextView store;
		TextView number;
		LinearLayout layout;
		TextView add;
		TextView sub;
		TextView newnumber;
	}
}
