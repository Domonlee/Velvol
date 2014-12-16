package com.velvol.o2o.ui.find;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.RoomNumberFriendFootAdapter;
import com.velvol.o2o.adapter.RoomNumberFriendRoomEveryoneFootAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;
//����ƴ������
public class FriendRoomNumberActivity extends BaseActivity{

	//���ذ�ť
	private ImageView froomReturnImageview;
	//�����
	private String froomNumber;
	private TextView froomNumberTextview;
	//����������
	private String froomMasterName; 
	private TextView froomMasterNameTextview;
	//�ϲ�������
	private String froomMergeMany; 
	private TextView froomMergeManyTextview;
	//���ƶ���Ǯ
	private String froomMergeMoney; 
	private TextView froomMergeMoneyTextview;
	//����ͷ��
	private Bitmap froomMasterImage; 
	private CircularImage froomMasterImageCI;
	//����1��ͷ��
	private CircularImage froomFriendImageCI1;
	//����2��ͷ��
	private CircularImage froomFriendImageCI2;
	//����1������
	private String froomFriendName1; 
	private TextView froomFriendNameTextview1;
	//����2������
	private String froomFriendName2; 
	private TextView froomFriendNameTextview2;
	//��ͬ��Ĳ�listview���������listview�������ѵ��listview��
	private ListView froomCommonFoolListview;
	//�������
	private ImageView froomContinueOrderImageview;
	//ȷ�ϵ��
	private ImageView froomConfirmOrderImageview;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room_number_friend);
		// Show the Up button in the action bar.
		findViewById();
		initView();
		RoomNumberFriendRoomEveryoneFootAdapter adapter = new RoomNumberFriendRoomEveryoneFootAdapter(this);
		froomCommonFoolListview.setAdapter(adapter);
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		froomReturnImageview=(ImageView)findViewById(R.id.room_returnf_imageView);
		froomNumberTextview=(TextView)findViewById(R.id.room_numberf);
		froomMasterNameTextview=(TextView)findViewById(R.id.room_masterf_name);
		froomMergeManyTextview=(TextView)findViewById(R.id.room_mergef_many);
		froomMergeMoneyTextview=(TextView)findViewById(R.id.room_mergef_money);
		froomMasterImageCI=(CircularImage)findViewById(R.id.room_masterf_image);
		froomFriendImageCI1=(CircularImage)findViewById(R.id.room_friendf_image1);
		froomFriendImageCI2=(CircularImage)findViewById(R.id.room_friendf_image2);
		froomFriendNameTextview1=(TextView)findViewById(R.id.room_friendf_name1);
		froomFriendNameTextview2=(TextView)findViewById(R.id.room_friendf_name2);
		froomCommonFoolListview=(ListView)findViewById(R.id.room_commonfoodf_listview);
		froomContinueOrderImageview=(ImageView)findViewById(R.id.room_continueorderf_imageview);
		
		froomNumber=froomNumberTextview.getText().toString();
		froomMasterName=froomMasterNameTextview.getText().toString();
		froomMergeMany=froomMergeManyTextview.getText().toString();
		froomMergeMoney=froomMergeMoneyTextview.getText().toString();
		froomFriendName1=froomFriendNameTextview1.getText().toString();
		froomFriendName2=froomFriendNameTextview2.getText().toString();
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		froomContinueOrderImageview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(FriendRoomNumberActivity.this, ReviewActivity.class));
			}
		});
	}

	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub
		
	}

}
