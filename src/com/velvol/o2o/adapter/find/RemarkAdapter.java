package com.velvol.o2o.adapter.find;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.EvaluateActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.view.CircularImage;
//神点评adapter
public class RemarkAdapter extends BaseAdapter{
	
	private Context context;
	private LayoutInflater inflater;
	
	public RemarkAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.listview_remark, null);
			holder.review_people_name_Head_CircularImage=(CircularImage) convertView.findViewById(R.id.review_people_name_Head_CircularImage);
			holder.review_food_name_textview=(TextView)convertView.findViewById(R.id.review_food_name_textview);
			holder.reviewTimeTextView=(TextView)convertView.findViewById(R.id.review_time_textview);
			holder.reviewContentTextView=(TextView)convertView.findViewById(R.id.review_content_textview);
			holder.reviewFootPictureImageView1=(ImageView)convertView.findViewById(R.id.review_foot_picture_imageView1);
			holder.reviewFootPictureImageView2=(ImageView)convertView.findViewById(R.id.review_foot_picture_imageView2);
			holder.reviewFootPictureImageView3=(ImageView)convertView.findViewById(R.id.review_foot_picture_imageView3);
			holder.reviewCountTextview=(TextView)convertView.findViewById(R.id.review_count_textview);
			holder.reviewGoodCountTextview=(TextView)convertView.findViewById(R.id.review_good_count_textview);
			holder.reviewClick=(LinearLayout)convertView.findViewById(R.id.review_click_linerlayout);
			holder.reviewGoodClick=(LinearLayout)convertView.findViewById(R.id.review_good_click_linerlayout);
			holder.goodImageview=(ImageView)convertView.findViewById(R.id.imageView4);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		holder.review_people_name_Head_CircularImage.setImageResource(R.drawable.userface);
		holder.reviewTimeTextView.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		MyClick listener = new MyClick(position, holder.reviewGoodCountTextview, holder.goodImageview);
		holder.reviewClick.setOnClickListener(listener);
		holder.reviewGoodClick.setOnClickListener(listener);
		
		//设置监听
		return convertView;
	}
	class ViewHolder{
		//点评人头像
		CircularImage review_people_name_Head_CircularImage;
		//点评人名字
		TextView review_people_name_textview;
		//点评的菜品名字
		TextView review_food_name_textview;
		//点评时间
		TextView reviewTimeTextView;
		//点评内容
		TextView reviewContentTextView;
		//点评的食物图片
		ImageView reviewFootPictureImageView1;
		ImageView reviewFootPictureImageView2;
		ImageView reviewFootPictureImageView3;
		//点评数量
		TextView reviewCountTextview;
		//点赞数量
		TextView reviewGoodCountTextview;
		//支持单击点评布局
		LinearLayout reviewClick;
		//支持单击点赞布局
		LinearLayout reviewGoodClick;
		//赞的小手图标
		 ImageView goodImageview;
	}
	
	class MyClick implements OnClickListener{
		private int index;
		private TextView reviewGoodCountTextview;
		private ImageView goodImageview;
		public MyClick(int index,TextView reviewGoodCountTextview,ImageView goodImageview){
			this.index = index;
			this.reviewGoodCountTextview = reviewGoodCountTextview;
			this.goodImageview = goodImageview;
		}
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.review_good_click_linerlayout:
				int count=Integer.parseInt(reviewGoodCountTextview.getText().toString());
				count++;
				reviewGoodCountTextview.setText(count+"");
				goodImageview.setImageResource(R.drawable.mymsg_good_red_icon);
				break;
			case R.id.review_click_linerlayout:
				context.startActivity(new Intent(context,EvaluateActivity.class).putExtra("index", index));
				break;
			default:
				break;
			}
			
		}
		
	}
	
}
