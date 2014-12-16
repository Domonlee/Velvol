package com.velvol.o2o.ui.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;
//优惠券
public class PrivilegeTicketActivity extends BaseActivity{
	//优惠券显示GridView
	private GridView privilegeTicketGridView;
	private ImageView imageview;
	int [] imageIds=new int[]{
			R.drawable.test1,
			R.drawable.test2,
			R.drawable.test3,
			R.drawable.test4,
			R.drawable.test1,
			R.drawable.test2,
			R.drawable.test3,
			R.drawable.test4,
	};
	//图片数据
	private ArrayList<Map<String, Object>> listItems;
	private ImageView privilegeTicketImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_privilege_ticket);
		 listItems=new ArrayList<Map<String,Object>>();
		for(int i=0;i<imageIds.length;i++){
			Map<String, Object> listItem=new HashMap<String, Object>();
			listItem.put("image", imageIds[i]);
			listItems.add(listItem);
		}
		findViewById();
		initView();
		SimpleAdapter simleAdapter = new SimpleAdapter(this, listItems, R.layout.gridview_privilege_ticket, new String[]{"image"},  new int[] {R.id.privilege_ticket_picture_imageView1});
		privilegeTicketGridView.setAdapter(simleAdapter);
	}
	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		privilegeTicketGridView=(GridView)findViewById(R.id.privilege_ticket_gridView1);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
//		LayoutInflater inflater = LayoutInflater.from(this);
//		View view = inflater.inflate(R.layout.gridview_privilege_ticket, null);
//		privilegeTicketImage=(ImageView) view.findViewById(R.id.privilege_ticket_picture_imageView1);
//		//给gridView中item图片设置监听，报空指针异常。
//		privilegeTicketImage.setOnTouchListener(listener);
	}
//	View.OnTouchListener listener=new OnTouchListener() {
//		
//		@Override
//		public boolean onTouch(View v, MotionEvent event) {
//			// TODO Auto-generated method stub
//			switch (v.getId()) {
//			case R.id.privilege_ticket_picture_imageView1:
//				startActivity(new Intent(PrivilegeTicketActivity.this, DataFootActivity.class));
//				break;
//			}
//			return true;
//		}
//	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub
		
	}

}
