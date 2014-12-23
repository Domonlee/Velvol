package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;

//数据餐饮listview
public class DataFootAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	public DataFootAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 3;
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
			convertView = inflater.inflate(R.layout.listview_datafoot_item,
					null);
			holder = new ViewHolder();
			holder.day = (TextView) convertView
					.findViewById(R.id.data_food_day_textview);
			holder.explain = (TextView) convertView
					.findViewById(R.id.data_food_explain_textview);
			holder.left = (ImageView) convertView
					.findViewById(R.id.data_foot_left_imageview);
			holder.right = (ImageView) convertView
					.findViewById(R.id.data_foot_right_imageview1);
			holder.selectedPicture1 = (ImageView) convertView
					.findViewById(R.id.data_foot_selected_picture1_imageview);
			holder.footPicture1 = (ImageView) convertView
					.findViewById(R.id.data_foot_picture1_imageview);
			holder.footName1 = (TextView) convertView
					.findViewById(R.id.data_foot_name1_textview);
			holder.selectedPicture2 = (ImageView) convertView
					.findViewById(R.id.data_foot_selected_picture2_imageview);
			holder.footPicture2 = (ImageView) convertView
					.findViewById(R.id.data_foot_picture2_imageview);
			holder.footName2 = (TextView) convertView
					.findViewById(R.id.data_foot_name2_textview);
			holder.selectedPicture3 = (ImageView) convertView
					.findViewById(R.id.data_foot_selected_picture3_imageview);
			holder.footPicture3 = (ImageView) convertView
					.findViewById(R.id.data_foot_picture3_imageview);
			holder.footName3 = (TextView) convertView
					.findViewById(R.id.data_foot_name3_textview);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

	class ViewHolder {
		// day上下午
		TextView day;
		// 评价内容
		TextView explain;
		// 左边滑
		ImageView left;
		// 右边滑
		ImageView right;
		// 选中的菜品圆圈
		ImageView selectedPicture1;
		// 选中菜品的图片
		ImageView footPicture1;
		// 选中菜品的名字
		TextView footName1;

		// 选中的菜品2
		ImageView selectedPicture2;
		// 选中菜品的图片2
		ImageView footPicture2;
		// 选中菜品的名字2
		TextView footName2;

		// 选中的菜品3
		ImageView selectedPicture3;
		// 选中菜品的图片3
		ImageView footPicture3;
		// 选中菜品的名字3
		TextView footName3;
	}
}
