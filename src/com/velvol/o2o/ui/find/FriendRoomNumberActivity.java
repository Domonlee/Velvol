package com.velvol.o2o.ui.find;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.adapter.find.RoomNumberFriendRoomEveryoneFootAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;
//����ƴ������
public class FriendRoomNumberActivity extends BaseActivity{

	//���ذ�ť
	private ImageView froomReturnImageview;
	//�����
	private TextView froomNumberTextview;
	//����������
	private String froomMasterName; 
	private TextView froomMasterNameTextview;
	//�ϲ�������
	private String froomMergeMany; 
	private TextView froomMergeManyTextview;
	//���ƶ���Ǯ
	private int froomMergeMoney; 
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
	//�ұߵı���
	private TextView title_topbar_right_tv;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_room_number_friend);
		RoomNumberFriendRoomEveryoneFootAdapter adapter = new RoomNumberFriendRoomEveryoneFootAdapter(this);
		froomMergeMoney=adapter.getFoodpricetotal();
		// Show the Up button in the action bar.
		findViewById();
		initView();
		//�����ͼ���͹����Ĳ���
		toGetIntener();
		froomCommonFoolListview.setAdapter(adapter);
		Log.i("����ҳ�湲��Ǯ��", froomMergeMoney+"");
	}
	private void toGetIntener() {
		// TODO Auto-generated method stub
		Intent toMargeActivity=getIntent();
		//���÷����
		froomNumberTextview.setText("����"+toMargeActivity.getStringExtra("roomNumber"));
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		froomReturnImageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
		froomNumberTextview=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
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

		
		froomMasterName=froomMasterNameTextview.getText().toString();
		froomMergeMany=froomMergeManyTextview.getText().toString();
		froomFriendName1=froomFriendNameTextview1.getText().toString();
		froomFriendName2=froomFriendNameTextview2.getText().toString();
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		froomMasterImageCI.setImageResource(R.drawable.userface);
		froomFriendImageCI1.setImageResource(R.drawable.userface);
		froomFriendImageCI2.setImageResource(R.drawable.userface);
		froomNumberTextview.setText("����6666");
		froomMergeMoneyTextview.setText(""+froomMergeMoney); 
		
		froomContinueOrderImageview.setOnClickListener(listener);
		froomReturnImageview.setOnClickListener(listener);
		
		
	}
	View.OnClickListener listener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			//���ѷ��������ͼ���
			case R.id.room_continueorderf_imageview:
				break;
			//���˼���
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub
	}

}
