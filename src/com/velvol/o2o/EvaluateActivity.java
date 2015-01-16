package com.velvol.o2o;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.adapter.RepayAdapter;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.constant.Replies;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.ui.find.ReviewDetailsReplyActivity;
import com.velvol.o2o.view.CircularImage;

public class EvaluateActivity extends BaseActivity {
	private ImageView back;
	private TextView top_title,top_menu;
	private CircularImage user_img;
	private LinearLayout img_layout;
	private RatingBar lv;
	private ListView listView;
	private RepayAdapter adapter;
	private int width = 0;
	private TextView praise;
	private int s1;
	private TextView reply;
	private TextView replyContent;
	private TextView name;
	private TextView time;
	private TextView context;
	private Intent intent = null;
	private String repliesid = null;
	private int pagenum = 1;
	
	private ArrayList<Replies> list = new ArrayList<Replies>();
	private Replies replies = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evaluate);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		width = dm.widthPixels;
		findViewById();
		initView();
		httpget(GetUrl.commentDetial(repliesid, String.valueOf(pagenum)), 1);
	}

	@Override
	protected void findViewById() {
		back = (ImageView)findViewById(R.id.title_topbar_back_iv);
		top_title = (TextView) findViewById(R.id.title_topbar_tv);
		top_menu = (TextView) findViewById(R.id.title_topbar_right_tv);
		user_img = (CircularImage) findViewById(R.id.user_img);
		img_layout = (LinearLayout)findViewById(R.id.img_layout);
		lv = (RatingBar)findViewById(R.id.lv);
		listView = (ListView)findViewById(R.id.listview);
		praise=(TextView)findViewById(R.id.praise);
		reply=(TextView)findViewById(R.id.reply_tv);
		replyContent=(TextView)findViewById(R.id.reply);
		name = (TextView) findViewById(R.id.username);
		time = (TextView) findViewById(R.id.time);
		context = (TextView) findViewById(R.id.context);
	}

	@Override
	protected void initView() {
		back.setOnClickListener(listener);
		String s=praise.getText().toString();
		int i=s.indexOf("(");
		int ei=s.indexOf(")");
		s1=Integer.parseInt(s.substring(i+1, ei));
		praise.setOnClickListener(listener);
		reply.setOnClickListener(listener);
		lv.setProgress(4);
		top_menu.setVisibility(View.GONE);
		top_title.setText("评价详情");
		user_img.setImageResource(R.drawable.userface);
		adapter = new RepayAdapter(EvaluateActivity.this);
//		listView.setAdapter(adapter);
		img_layout.addView(Img(""));
		img_layout.addView(Img(""));
		img_layout.addView(Img(""));
		img_layout.addView(Img(""));
		//取出评价内容
		Intent intent = getIntent();
		String reply1=intent.getStringExtra("reply");
		//XXX
		repliesid = intent.getIntExtra("repliesid", 0)+"";
		replyContent.setText(reply1);
	}
	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				finish();
				break;
			case R.id.praise:
				s1++;
				praise.setText("赞("+s1+")");
				praise.setTextColor(Color.parseColor("#D9210D"));
				break;
			case R.id.reply_tv:
				startActivity(new Intent(EvaluateActivity.this, ReviewDetailsReplyActivity.class).putExtra("repliesid", repliesid));
				finish();
				break;
			}
		}
	};
	public ImageView Img(String filepath){
		LinearLayout.LayoutParams params = new LayoutParams(width/4,width/4);
		ImageView imageView = new ImageView(EvaluateActivity.this);
		params.setMargins(10, 0, 10, 0);
		imageView.setLayoutParams(params);
		imageView.setImageResource(R.drawable.test1);
		imageView.setScaleType(ScaleType.CENTER_CROP);
//		imageLoader.displayImage(filepath, imageView,
//				data.displayImageOptions);
		return imageView;
	}
	@Override
	protected void result(String result) {
		try {
			JSONObject object = new JSONObject(result);
			if (object.getInt("mark") == 1) {
				JSONObject ro = object.getJSONObject("result");
				JSONArray array = ro.getJSONArray("replys");
				if (array != null) {
					for (int i = 0; i < array.length(); i++) {
						replies = new Replies(array.getJSONObject(i));
						list.add(replies);
					}
				}

				JSONObject o = ro.getJSONObject("repliesbean");
				if (o != null) {
					name.setText(o.getString("username"));
					time.setText(o.getString("createdate"));
					lv.setProgress(o.getInt("starcount"));
					praise.setText(o.getString("(" + "zambiacount" + ")"));
					replyContent.setText(o.getString("(" + "replycount" + ")"));
					context.setText(o.getString("context"));
					imageLoader.displayImage(o.getString("userheadimg"),
							user_img, data.displayImageOptions);
					if (o.getJSONArray("imgs") != null) {
						for (int j = 0; j < o.getJSONArray("imgs").length(); j++) {
							Img(o.getJSONArray("imgs").getString(j));
						}
					}
				}
				adapter.notifyDataSetChanged();

			} else {
				Toast.makeText(EvaluateActivity.this, "数据出错！", 0).show();
			}

		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(EvaluateActivity.this, "网络异常！", 0).show();
		}

	}

}
