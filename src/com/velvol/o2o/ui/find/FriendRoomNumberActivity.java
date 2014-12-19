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

//朋友拼单房间
public class FriendRoomNumberActivity extends BaseActivity {

	// 返回按钮
	private ImageView froomReturnImageview;
	// 房间号
	private String froomNumber;
	private TextView froomNumberTextview;
	// 房主的名字
	private String froomMasterName;
	private TextView froomMasterNameTextview;
	// 合并的人数
	private String froomMergeMany;
	private TextView froomMergeManyTextview;
	// 共计多少钱
	private String froomMergeMoney;
	private TextView froomMergeMoneyTextview;
	// 房主头像
	private Bitmap froomMasterImage;
	private CircularImage room_masterf_image_ci;
	// 朋友1的头像
	private CircularImage froomFriendImageCI1;
	// 朋友2的头像
	private CircularImage froomFriendImageCI2;
	// 朋友1的名字
	private String froomFriendName1;
	private TextView froomFriendNameTextview1;
	// 朋友2的名字
	private String froomFriendName2;
	private TextView froomFriendNameTextview2;
	// 共同点的菜listview（房主点菜listview）（朋友点菜listview）
	private ListView froomCommonFoolListview;
	// 继续点餐
	private ImageView froomContinueOrderImageview;
	// 右边的标题
	private TextView title_topbar_right_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_room_number_friend);
		findViewById();
		initView();
		RoomNumberFriendRoomEveryoneFootAdapter adapter = new RoomNumberFriendRoomEveryoneFootAdapter(
				this);
		froomCommonFoolListview.setAdapter(adapter);
	}

	@Override
	protected void findViewById() {
		froomReturnImageview = (ImageView) findViewById(R.id.title_topbar_back_iv);
		froomNumberTextview = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.review_people_name_textview);
		froomMasterNameTextview = (TextView) findViewById(R.id.room_masterf_name);
		froomMergeManyTextview = (TextView) findViewById(R.id.room_mergef_many);
		froomMergeMoneyTextview = (TextView) findViewById(R.id.room_mergef_money);
		room_masterf_image_ci = (CircularImage) findViewById(R.id.room_masterf_image_ci);
		froomFriendImageCI1 = (CircularImage) findViewById(R.id.room_friendf_image1);
		froomFriendImageCI2 = (CircularImage) findViewById(R.id.room_friendf_image2);
		froomFriendNameTextview1 = (TextView) findViewById(R.id.room_friendf_name1);
		froomFriendNameTextview2 = (TextView) findViewById(R.id.room_friendf_name2);
		froomCommonFoolListview = (ListView) findViewById(R.id.room_commonfoodf_listview);
		froomContinueOrderImageview = (ImageView) findViewById(R.id.room_continueorderf_imageview);

		froomNumber = froomNumberTextview.getText().toString();
		froomMasterName = froomMasterNameTextview.getText().toString();
		froomMergeMany = froomMergeManyTextview.getText().toString();
		froomMergeMoney = froomMergeMoneyTextview.getText().toString();
		froomFriendName1 = froomFriendNameTextview1.getText().toString();
		froomFriendName2 = froomFriendNameTextview2.getText().toString();
	}

	@Override
	protected void initView() {
		room_masterf_image_ci.setImageResource(R.drawable.userface);
		froomNumberTextview.setText("房间6666");
		froomContinueOrderImageview.setOnClickListener(listener);
		froomReturnImageview.setOnClickListener(listener);
	}

	View.OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			// 朋友房间继续点餐监听
			case R.id.room_continueorderf_imageview:
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

}
