package com.velvol.o2o.adapter;

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

import com.velvol.o2o.R;

public class NewAdapter extends BaseAdapter {
	private int[] r = { R.drawable.test1, R.drawable.test2, R.drawable.test3,
			R.drawable.test4 };
	private Context context;
	private LayoutInflater mInflater;
	private int width;

	public NewAdapter(Context con, int width) {
		context = con;
		mInflater = LayoutInflater.from(context);
		this.width = width;
	}

	@Override
	public int getCount() {
		return 6;
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
			holder.price = (TextView) convertView.findViewById(R.id.price_new);
			holder.status = (TextView) convertView.findViewById(R.id.status);
			holder.buy = (Button) convertView.findViewById(R.id.buy);
			convertView.setTag(holder);
			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.layout.setLayoutParams(new AbsListView.LayoutParams(width,
				(int) (width * 1.4)));
		holder.img.setImageResource(r[position % 4]);
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
			Log.v("sen", "buy");
			switch (v.getId()) {
			case R.id.buy:
				// TODO 购物车操作
				Log.v("sen", "buy");
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
