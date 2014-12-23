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
import com.velvol.o2o.adapter.find.RoomNumberEveryoneFootAdapter;
import com.velvol.o2o.adapter.find.RoomNumberRequestAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;
//����ƴ������
public class RoomNumberActivity extends BaseActivity{

	//���ذ�ť
	private ImageView roomReturnImageview;
	//�����
	private TextView roomNumberTextview;
	//����������
	private String roomMasterName; 
	private TextView roomMasterNameTextview;
	//�ϲ�������
	private String roomMergeMany; 
	private TextView roomMergeManyTextview;
	//���ƶ���Ǯ
	private String roomMergeMoney; 
	private TextView roomMergeMoneyTextview;
	//����ͷ��
	private Bitmap roomMasterImage; 
	private CircularImage roomMasterImageCI;
	//����1��ͷ��
	private CircularImage roomFriendImageCI1;
	//����2��ͷ��
	private CircularImage roomFriendImageCI2;
	//����1������
	private String roomFriendName1; 
	private TextView roomFriendNameTextview1;
	//����2������
	private String roomFriendName2; 
	private TextView roomFriendNameTextview2;
	//�������Listview
	private ListView roomRequestitemListview;
	//��ͬ��Ĳ�listview���������listview�������ѵ��listview��
	private ListView roomCommonFoolListview;
	//�������
	private ImageView roomContinueOrderImageview;
	//ȷ�ϵ��
	private ImageView roomConfirmOrderImageview;
	//���еı���
	private TextView title_topbar_tv;
	//�ұߵı���
	private TextView title_topbar_right_tv;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_room_number);
		// Show the Up button in the action bar.
		findViewById();
		initView();
		//�������Adapter
		RoomNumberRequestAdapter requestadapter = new RoomNumberRequestAdapter(this);
		roomRequestitemListview.setAdapter(requestadapter);
		//��ͬ��͵�ListView
		RoomNumberEveryoneFootAdapter everyoneadapter=new RoomNumberEveryoneFootAdapter(this);
		roomCommonFoolListview.setAdapter(everyoneadapter);
		//��ȡ��һ��Activity���ݹ����Ĳ���
		toGetIntent();
	}
	private void toGetIntent() {
		// TODO Auto-generated method stub
		Intent toFoundMargeRoomActivity=getIntent();
		String roomNumber=toFoundMargeRoomActivity.getStringExtra("roomNumber");
		roomNumberTextview.setText("����"+roomNumber);
	}
	@Override
	protected void findViewById() {
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
		roomReturnImageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
		roomNumberTextview=(TextView)findViewById(R.id.title_topbar_tv);
		roomMasterNameTextview=(TextView)findViewById(R.id.room_master_name);
		roomMergeManyTextview=(TextView)findViewById(R.id.room_merge_many);
		roomMergeMoneyTextview=(TextView)findViewById(R.id.room_merge_money);
		roomMasterImageCI=(CircularImage)findViewById(R.id.room_master_image);
		roomFriendImageCI1=(CircularImage)findViewById(R.id.room_friend_image1);
		roomFriendImageCI2=(CircularImage)findViewById(R.id.room_friend_image2);
		roomFriendNameTextview1=(TextView)findViewById(R.id.room_friend_name1);
		roomFriendNameTextview2=(TextView)findViewById(R.id.room_friend_name2);
		roomRequestitemListview=(ListView)findViewById(R.id.room_requestitem_listView1);
		roomCommonFoolListview=(ListView)findViewById(R.id.room_commonfood_listview);
		roomContinueOrderImageview=(ImageView)findViewById(R.id.room_continueorder_imageview);
		roomConfirmOrderImageview=(ImageView)findViewById(R.id.room_confirmorder_imageview);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		roomMasterImageCI.setImageResource(R.drawable.userface);
		roomFriendImageCI1.setImageResource(R.drawable.userface);
		roomFriendImageCI2.setImageResource(R.drawable.userface);
		roomMasterName=roomMasterNameTextview.getText().toString();
		roomMergeMany=roomMergeManyTextview.getText().toString();
		roomMergeMoney=roomMergeMoneyTextview.getText().toString();
		roomFriendName1=roomFriendNameTextview1.getText().toString();
		roomFriendName2=roomFriendNameTextview2.getText().toString();
		roomContinueOrderImageview.setOnClickListener(listener);
		roomConfirmOrderImageview.setOnClickListener(listener);
		roomReturnImageview.setOnClickListener(listener);
	}
	View.OnClickListener listener=new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.room_continueorder_imageview:
				//������ͼ���
				//startActivity(new Intent(RoomNumberActivity.this, PrivilegeTicketActivity.class));
				break;
			case R.id.room_confirmorder_imageview:
				//ȷ����ͼ���
				//startActivity(new Intent(RoomNumberActivity.this, DataFootActivity.class));
				break;
			case R.id.title_topbar_back_iv:
				//���ذ�ť
				finish();
				break;
			}
		}
	};
	@Override
	protected void result(String result) {
	}

}
