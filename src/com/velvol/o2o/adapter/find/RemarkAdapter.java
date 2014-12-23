package com.velvol.o2o.adapter.find;

import com.velvol.o2o.R;
import com.velvol.o2o.view.CircularImage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RemarkAdapter extends BaseAdapter{
	
	private Context context;
	private LayoutInflater inflater;
	private ViewHolder holder;
	private String reviewGoodCount;
	
	public RemarkAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return 5;
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
		 holder=null;
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
		//���ü���
		setTouchListener();
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
	private void setTouchListener() {
		// TODO Auto-generated method stub
		holder.reviewGoodClick.setOnTouchListener(touchlistener);
	}
	//��������
		View.OnTouchListener touchlistener=new OnTouchListener() {
			


			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.review_click_linerlayout:
					//���������ת
					//startActivity(new Intent(ReviewActivity.this, FoundMargeRoomActivity.class));
					break;
				case R.id.review_good_click_linerlayout:
					int count=Integer.parseInt(reviewGoodCount);
					count++;
					holder.reviewGoodCountTextview.setText(count+"");
					holder.goodImageview.setImageResource(R.drawable.mymsg_good_red_icon);
					break;
				}
				return true;
			}};
}