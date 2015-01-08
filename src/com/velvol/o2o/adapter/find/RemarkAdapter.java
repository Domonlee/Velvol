package com.velvol.o2o.adapter.find;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.EvaluateActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.ui.find.DataFootActivity;
import com.velvol.o2o.view.CircularImage;
//�����adapter
public class RemarkAdapter extends BaseAdapter{
	
	private Context context;
	private LayoutInflater inflater;
	private String reviewGoodCount;
	
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
			reviewGoodCount=holder.reviewGoodCountTextview.getText().toString();
			holder.reviewClick=(LinearLayout)convertView.findViewById(R.id.review_click_linerlayout);
			holder.reviewGoodClick=(LinearLayout)convertView.findViewById(R.id.review_good_click_linerlayout);
			holder.goodImageview=(ImageView)convertView.findViewById(R.id.imageView4);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		holder.review_people_name_Head_CircularImage.setImageResource(R.drawable.userface);
		holder.reviewTimeTextView.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		//���ü���
		setTouchListener(holder.goodImageview,reviewGoodCount,holder.reviewGoodCountTextview,holder.reviewGoodClick,holder.reviewClick);
		return convertView;
	}
	class ViewHolder{
		//������ͷ��
		CircularImage review_people_name_Head_CircularImage;
		//����������
		TextView review_people_name_textview;
		//�����Ĳ�Ʒ����
		TextView review_food_name_textview;
		//����ʱ��
		TextView reviewTimeTextView;
		//��������
		TextView reviewContentTextView;
		//������ʳ��ͼƬ
		ImageView reviewFootPictureImageView1;
		ImageView reviewFootPictureImageView2;
		ImageView reviewFootPictureImageView3;
		//��������
		TextView reviewCountTextview;
		//��������
		TextView reviewGoodCountTextview;
		//֧�ֵ�����������
		LinearLayout reviewClick;
		//֧�ֵ������޲���
		LinearLayout reviewGoodClick;
		//�޵�С��ͼ��
		 ImageView goodImageview;
	}
	private void setTouchListener(final ImageView goodImageview,final String reviewGoodCount,final TextView reviewGoodCountTextview,final LinearLayout reviewGoodClick,final LinearLayout reviewClick) {
		// TODO Auto-generated method stub0
		reviewClick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				context.startActivity(new Intent(context,EvaluateActivity.class));
			}
		});
		reviewGoodClick.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
					int count=Integer.parseInt(reviewGoodCount);
					count++;
					reviewGoodCountTextview.setText(count+"");
					goodImageview.setImageResource(R.drawable.mymsg_good_red_icon);
				return true;
			}
		});
	}
}
