package com.velvol.o2o.adapter;

import com.velvol.o2o.R;
import com.velvol.o2o.view.CircularImage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class MsgAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater mInflater;
	private int width;

	public MsgAdapter(Context con,int width) {
		context = con;
		mInflater = LayoutInflater.from(context);
		this.width = width;
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
			convertView = mInflater.inflate(R.layout.listview_mymsg_item, null);
			holder = new ViewHolder();
			 holder.img = (CircularImage)convertView.findViewById(R.id.user_img);
			 holder.name = (TextView)convertView.findViewById(R.id.username);
			 holder.time= (TextView)convertView.findViewById(R.id.time);
			 holder.lv = (RatingBar)convertView.findViewById(R.id.lv);
			 holder.context = (TextView)convertView.findViewById(R.id.context);
			 holder.img_layout= (LinearLayout)convertView.findViewById(R.id.img_layout);
			 
			 holder.praise = (TextView)convertView.findViewById(R.id.praise);
			 holder.reply = (TextView)convertView.findViewById(R.id.reply);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.img_layout.removeAllViews();
		holder.img_layout.addView(Img(""));
		holder.img_layout.addView(Img(""));
		holder.img_layout.addView(Img(""));
		holder.img_layout.addView(Img(""));
		 mOnclick mClick = new mOnclick(position);
		 holder.praise.setOnClickListener(mClick);
		 holder.reply.setOnClickListener(mClick);
		return convertView;
	}
	
	class ViewHolder {
		CircularImage img;
		TextView name;
		TextView time;
		RatingBar lv;
		TextView context;
		LinearLayout img_layout;
		TextView praise;
		TextView reply;
	}
	public class mOnclick implements View.OnClickListener {
		int position;

		public mOnclick(int index) {
			position = index;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.praise:
				
				break;
			case R.id.reply:
				
				break;
			default:
				break;
			}
		}

	};
	
	public ImageView Img(String filepath){
		LinearLayout.LayoutParams params = new LayoutParams(width/4,width/4);
		ImageView imageView = new ImageView(context);
		params.setMargins(10, 0, 10, 0);
		imageView.setLayoutParams(params);
		imageView.setImageResource(R.drawable.test1);
		imageView.setScaleType(ScaleType.CENTER_CROP);
//		imageLoader.displayImage(filepath, imageView,
//				data.displayImageOptions);
		return imageView;
	}
	
	
}

