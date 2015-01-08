package com.velvol.o2o.ui.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;
//�Ż�ȯ
public class PrivilegeTicketActivity extends BaseActivity{
	//�Ż�ȯ��ʾGridView
	private GridView privilegeTicketGridView;
	private ImageView imageview;
	int [] imageIds=new int[]{
			R.drawable.restaurant_gali,
			R.drawable.restaurant_mingjian,
			R.drawable.restaurant_pingding,
			R.drawable.restaurant_xiangdao,
			R.drawable.restaurant_gali,
			R.drawable.restaurant_mingjian,
			R.drawable.restaurant_pingding,
			R.drawable.restaurant_xiangdao,
			R.drawable.restaurant_gali,
			R.drawable.restaurant_mingjian,
			R.drawable.restaurant_pingding,
			R.drawable.restaurant_xiangdao,
	};
	//ͼƬ����
	private ArrayList<Map<String, Object>> listItems;
	//item����
	private LinearLayout privilegeTicketImage;
	//����
	private ImageView privilege_return_imageview;
	//���еı���
	private TextView title_topbar_tv;
	//�ұߵı���
	private TextView title_topbar_right_tv;
	private ImageView restaurant_dashu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
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
		privilege_return_imageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		title_topbar_tv.setText("�Ż�ȯ");
		privilegeTicketGridView.setOnItemClickListener(itemlistener);
		privilege_return_imageview.setOnClickListener(clicklistenre);
	}
	//����¼�����
	View.OnClickListener clicklistenre=new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};
	//GridView����
	OnItemClickListener itemlistener=new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			switch (imageIds[position]) {
			case R.drawable.restaurant_gali:
				startActivity(new Intent(PrivilegeTicketActivity.this, PrivilegeTicketAssignActivity.class));
				break;
			case R.drawable.restaurant_mingjian:
				startActivity(new Intent(PrivilegeTicketActivity.this, IndentAccountActivity.class));
				break;
			}
		}
	};
	@Override
	protected void result(String result) {
		// TODO Auto-generated method stub

	}

}
