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
import com.velvol.o2o.adapter.RoomNumberEveryoneFootAdapter;
import com.velvol.o2o.adapter.RoomNumberRequestAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.view.CircularImage;
//房主拼单房间
public class RoomNumberActivity extends BaseActivity{

	//返回按钮
	private ImageView roomReturnImageview;
	//房间号
	private String roomNumber;
	private TextView roomNumberTextview;
	//房主的名字
	private String roomMasterName; 
	private TextView roomMasterNameTextview;
	//合并的人数
	private String roomMergeMany; 
	private TextView roomMergeManyTextview;
	//共计多少钱
	private String roomMergeMoney; 
	private TextView roomMergeMoneyTextview;
	//房主头像
	private Bitmap roomMasterImage; 
	private CircularImage roomMasterImageCI;
	//朋友1的头像
	private CircularImage roomFriendImageCI1;
	//朋友2的头像
	private CircularImage roomFriendImageCI2;
	//朋友1的名字
	private String roomFriendName1; 
	private TextView roomFriendNameTextview1;
	//朋友2的名字
	private String roomFriendName2; 
	private TextView roomFriendNameTextview2;
	//请求加入Listview
	private ListView roomRequestitemListview;
	//共同点的菜listview（房主点菜listview）（朋友点菜listview）
	private ListView roomCommonFoolListview;
	//继续点餐
	private ImageView roomContinueOrderImageview;
	//确认点餐
	private ImageView roomConfirmOrderImageview;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room_number);
		// Show the Up button in the action bar.
		findViewById();
		initView();
		//请求加入Adapter
		RoomNumberRequestAdapter requestadapter = new RoomNumberRequestAdapter(this);
		roomRequestitemListview.setAdapter(requestadapter);
		//共同点餐的ListView
		RoomNumberEveryoneFootAdapter everyoneadapter=new RoomNumberEveryoneFootAdapter(this);
		roomCommonFoolListview.setAdapter(everyoneadapter);
	}
	@Override
	protected void findViewById() {
		roomReturnImageview=(ImageView)findViewById(R.id.room_return_imageView);
		roomNumberTextview=(TextView)findViewById(R.id.room_number);
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
		roomNumber=roomNumberTextview.getText().toString();
		roomMasterName=roomMasterNameTextview.getText().toString();
		roomMergeMany=roomMergeManyTextview.getText().toString();
		roomMergeMoney=roomMergeMoneyTextview.getText().toString();
		roomFriendName1=roomFriendNameTextview1.getText().toString();
		roomFriendName2=roomFriendNameTextview2.getText().toString();
		roomContinueOrderImageview.setOnClickListener(listener);
		roomConfirmOrderImageview.setOnClickListener(listener);
	}
	View.OnClickListener listener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.room_continueorder_imageview:
				startActivity(new Intent(RoomNumberActivity.this, PrivilegeTicketActivity.class));
				break;
			case R.id.room_confirmorder_imageview:
				startActivity(new Intent(RoomNumberActivity.this, DataFootActivity.class));
			}
		}
	};
	@Override
	protected void result(String result) {
	}

}
