package com.velvol.o2o.ui.make;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.EvaluateActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.make.EvaluateAdapter;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.constant.SellDishes;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MyListView;

public class ParticularsActivity extends BaseActivity {

	// 详情页
	private TextView merchantName;
	private LinearLayout popLayout;
	private ImageView back, classify;
	private MyListView listView;
	private EvaluateAdapter adapter;
	private boolean pop_layout_flag = false;
	private int id; 
	private SellDishes sellDishes = new SellDishes();
	private TextView title,sell_name,shop_name,old_price,price,sub,number,add,salecount,sell_context,like,buy,replycount,leadreputably;
	private ImageView status;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_particulars);
		id = getIntent().getIntExtra("SellId", -1);
		findViewById();
		initView();
		
		if(id == -1){
			ShowToast("无效商品！");
			finish();
		}
			
		if(isNetworkConnected(getApplicationContext())){
			showProgressDialog(ParticularsActivity.this);
			httpget(GetUrl.getSellDishesUrl(data.User_id, id), 1);
		}
		else
			ShowToast("请检查网络连接！");
	}

	@Override
	protected void findViewById() {
		merchantName = (TextView) findViewById(R.id.particulars_tv_merchantName);
		back = (ImageView) findViewById(R.id.particulars_return);
		classify = (ImageView) findViewById(R.id.classify);
		listView = (MyListView) findViewById(R.id.listview);
		popLayout = (LinearLayout) findViewById(R.id.pop_layout);
		title = (TextView)findViewById(R.id.title);
		sell_name = (TextView)findViewById(R.id.particulars_tv_top);
		shop_name = (TextView)findViewById(R.id.particulars_tv_merchantName);
		old_price = (TextView)findViewById(R.id.old_price);
		price = (TextView)findViewById(R.id.price);
		sub = (TextView)findViewById(R.id.sub);
		number = (TextView)findViewById(R.id.number);
		add = (TextView)findViewById(R.id.add);
		salecount = (TextView)findViewById(R.id.salecount);
		sell_context = (TextView)findViewById(R.id.sell_context);
		like = (TextView)findViewById(R.id.like);
		buy = (TextView)findViewById(R.id.buy);
		replycount = (TextView)findViewById(R.id.replycount);
		leadreputably = (TextView)findViewById(R.id.leadreputably);
		status = (ImageView)findViewById(R.id.status);
	}

	@Override
	protected void initView() {
		merchantName.setOnClickListener(listener);
		back.setOnClickListener(listener);
		classify.setOnClickListener(listener);
		adapter = new EvaluateAdapter(ParticularsActivity.this,sellDishes.getReplieslist());
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(ParticularsActivity.this,
						EvaluateActivity.class));
			}
		});
	}

	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.classify:
				if (!pop_layout_flag)
					popLayout.setVisibility(View.VISIBLE);
				else
					popLayout.setVisibility(View.GONE);
				pop_layout_flag = !pop_layout_flag;
				break;
			case R.id.particulars_return:
				finish();
				break;
			case R.id.particulars_tv_merchantName:
				startActivity(new Intent(ParticularsActivity.this,
						ShopDetailsActivity.class));
				break;
			default:
				break;
			}

		}
	};

	@Override
	protected void result(String result) {
		loadingDialog.dismiss();

		try {
			JSONObject c = new JSONObject(result);
			if (c.getInt("mark") == 1){ 
				sellDishes.setJson(c.getJSONObject("result"));
				setData();
				adapter.notifyDataSetChanged();
			}
			else
				ShowToast("数据异常！");
		} catch (JSONException e) {
			e.printStackTrace();
			ShowToast("网络不给力");
		}
	}
	
	public void setData(){
		title.setText(sellDishes.getName());
		sell_name.setText(sellDishes.getName());
		shop_name.setText(sellDishes.getShopname());
		old_price.setText("￥"+sellDishes.getOldprice());
		price.setText("￥"+sellDishes.getPrice());
		salecount.setText(sellDishes.getSalecount()+"份");
		sell_context.setText(sellDishes.getDishesdesc());
		replycount.setText("("+sellDishes.getRepliescount()+")");
		leadreputably.setText(sellDishes.getLeadreputably());
	}

}
