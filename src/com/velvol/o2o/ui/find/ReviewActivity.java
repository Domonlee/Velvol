package com.velvol.o2o.ui.find;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;

import android.R.integer;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
//�����
public class ReviewActivity extends BaseActivity{

	//������ͷ��
	private CircularImage reviewHeadCircularImage;
	//����������
	private String reviewName;
	private TextView reviewNameTextView;
	//������Ʒ����
	private String reviewFootName;
	private TextView reviewFootNameTextView;
	//����ʱ��
	private String reviewTime;
	private TextView reviewTimeTextView;
	//��������
	private String reviewContent;
	private TextView reviewContentTextView;
	//������ʳ��ͼƬ1
	private ImageView reviewFootPictureImageView1;
	//������ʳ��ͼƬ2
	private ImageView reviewFootPictureImageView2;
	//������ʳ��ͼƬ3
	private ImageView reviewFootPictureImageView3;
	//��������
	private String reviewCount;
	private TextView reviewCountTextview;
	//��������
	private String reviewGoodCount;
	private TextView reviewGoodCountTextview;
	//֧�ֵ�����������
	private LinearLayout reviewClick;
	//֧�ֵ������޲���
	private LinearLayout reviewGoodClick;

	//������ͷ��2
	private CircularImage reviewHeadCircular2Image;
	//����������2
	private String reviewName2;
	private TextView reviewName2TextView;
	//������Ʒ����2
	private String reviewFootName2;
	private TextView reviewFootName2TextView;
	//����ʱ��2
	private String reviewTime2;
	private TextView reviewTime2TextView;
	//��������2
	private String reviewContent2;
	private TextView reviewContent2TextView;
	//������ʳ��2ͼƬ1
	private ImageView reviewFootPicture2ImageView1;
	//������ʳ��2ͼƬ2
	private ImageView reviewFootPicture2ImageView2;
	//������ʳ��2ͼƬ3
	private ImageView reviewFootPicture2ImageView3;
	//��������2
	private String reviewCount2;
	private TextView reviewCount2Textview;
	//��������2
	private String reviewGoodCount2;
	private TextView reviewGoodCount2Textview;
	//֧�ֵ�����������2
	private LinearLayout reviewClick2;
	//����1������������д�����ݿ⣩
	private int count;
	//֧�ֵ������޲���2
	private LinearLayout reviewGoodClick2;
	//����2������������д�����ݿ⣩
	private int count2;
	//���˰�ť
	private ImageView reviewReturnImageView;
	//���еı���
	private TextView title_topbar_tv;
	//�ұߵı���
	private TextView title_topbar_right_tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_review);
		findViewById();
		initView();
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		title_topbar_tv=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
		reviewReturnImageView=(ImageView)findViewById(R.id.title_topbar_back_iv);
		
		reviewHeadCircularImage=(CircularImage)findViewById(R.id.review_people_name_Head_CircularImage);
		reviewNameTextView=(TextView)findViewById(R.id.review_people_name_textview);
		reviewFootNameTextView=(TextView)findViewById(R.id.review_food_name_textview);
		reviewTimeTextView=(TextView)findViewById(R.id.review_time_textview);
		reviewContentTextView=(TextView)findViewById(R.id.review_content_textview);
		reviewFootPictureImageView1=(ImageView)findViewById(R.id.review_foot_picture_imageView1);
		reviewFootPictureImageView2=(ImageView)findViewById(R.id.review_foot_picture_imageView2);
		reviewFootPictureImageView3=(ImageView)findViewById(R.id.review_foot_picture_imageView3);
		reviewCountTextview=(TextView)findViewById(R.id.review_count_textview);
		reviewGoodCountTextview=(TextView)findViewById(R.id.review_good_count_textview);
		reviewClick=(LinearLayout)findViewById(R.id.review_click_linerlayout);
		reviewGoodClick=(LinearLayout)findViewById(R.id.review_good_click_linerlayout);

		reviewHeadCircular2Image=(CircularImage)findViewById(R.id.review_people_name_Head2_CircularImage);
		reviewName2TextView=(TextView)findViewById(R.id.review_people_name2_textview);
		reviewFootName2TextView=(TextView)findViewById(R.id.review_food_name2_textview);
		reviewTime2TextView=(TextView)findViewById(R.id.review_time2_textview);
		reviewContent2TextView=(TextView)findViewById(R.id.review_content2_textview);
		reviewFootPicture2ImageView1=(ImageView)findViewById(R.id.review_foot_picture1_imageView1);
		reviewFootPicture2ImageView2=(ImageView)findViewById(R.id.review_foot_picture2_imageView2);
		reviewFootPicture2ImageView3=(ImageView)findViewById(R.id.review_foot_picture3_imageView3);
		reviewCount2Textview=(TextView)findViewById(R.id.review_count2_textview);
		reviewGoodCount2Textview=(TextView)findViewById(R.id.review_good_count2_textview);
		reviewClick2=(LinearLayout)findViewById(R.id.review_click2_linerlayout);
		reviewGoodClick2=(LinearLayout)findViewById(R.id.review_good_click2_linerlayout);

		reviewName=reviewNameTextView.getText().toString();
		reviewFootName=reviewFootNameTextView.getText().toString();
		reviewTime=reviewTimeTextView.getText().toString();
		reviewCount=reviewCountTextview.getText().toString();
		reviewContent=reviewContentTextView.getText().toString();
		reviewGoodCount=reviewGoodCountTextview.getText().toString();
		reviewName2=reviewName2TextView.getText().toString();
		reviewFootName2=reviewFootName2TextView.getText().toString();
		reviewTime2=reviewTime2TextView.getText().toString();
		reviewContent2=reviewContent2TextView.getText().toString();
		reviewCount2=reviewCount2Textview.getText().toString();
		reviewGoodCount2=reviewGoodCount2Textview.getText().toString();
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("�����");
		reviewClick2.setOnTouchListener(touchlistener);
		reviewGoodClick2.setOnTouchListener(touchlistener);
		//���˰�ť
		reviewReturnImageView.setOnClickListener(clicklistener);
	}
	//�������
	View.OnClickListener clicklistener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			//����
			case R.id.title_topbar_back_iv:
				finish();
				break;

			default:
				break;
			}
		}
	};
	//��������
	View.OnTouchListener touchlistener=new OnTouchListener() {
		

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.review_click2_linerlayout:
				//���������ת
				//startActivity(new Intent(ReviewActivity.this, FoundMargeRoomActivity.class));
				break;
			case R.id.review_good_click_linerlayout:
				 count=Integer.parseInt(reviewGoodCount);
				count++;
				reviewGoodCountTextview.setText(count+"");
				break;
			case R.id.review_good_click2_linerlayout:
				int count2=Integer.parseInt(reviewGoodCount2);
				count2++;
				reviewGoodCount2Textview.setText(count2+"");
				
				break;
			}
			return true;
		}};
		@Override
		protected void result(String result) {
			// TODO Auto-generated method stub

		}

	}
