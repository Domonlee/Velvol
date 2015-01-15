package com.velvol.o2o.fragment;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.R;
import com.velvol.o2o.constant.GetUrl;
import com.velvol.o2o.tool.BaseFragment;
import com.velvol.o2o.ui.find.DataFootActivity;
import com.velvol.o2o.ui.find.MargeActivity;
import com.velvol.o2o.ui.find.PrivilegeTicketActivity;
import com.velvol.o2o.ui.find.ReviewActivity;

public class FindFragmentActivity extends BaseFragment {

	private View view;

	// 拼单
	private LinearLayout pindan;
	// 神评论
	private LinearLayout comment;
	// 数据餐饮
	private LinearLayout dataFoot;
	// 优惠券
	private LinearLayout privilegeTicket;

	public TextView title_topbar_tv;
	public ImageView title_topbar_back_iv;
	public TextView title_topbar_right_tv;
	private TextView username,context,reply,nice;
	private ImageView usericon;
	private String result;
	private boolean http_init = true;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_find, container, false);
		findViewById();
		initView();
		if(http_init)
			httpget(GetUrl.FIND_AD, 1);
		else
			result(result);
		http_init = false;
		return view;
	}

	@Override
	protected void findViewById() {
		title_topbar_tv = (TextView) view.findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) view.findViewById(R.id.title_topbar_right_tv);
		title_topbar_back_iv = (ImageView) view.findViewById(R.id.title_topbar_back_iv);
		pindan = (LinearLayout) view.findViewById(R.id.find_join_layout);
		comment = (LinearLayout) view.findViewById(R.id.find_comment_layout);
		dataFoot = (LinearLayout) view.findViewById(R.id.find_data_layout);
		privilegeTicket = (LinearLayout) view.findViewById(R.id.find_ticket_layout);
		username = (TextView)view.findViewById(R.id.tv_find_username);
		context = (TextView)view.findViewById(R.id.tv_find_count);
		reply = (TextView)view.findViewById(R.id.iv_find_up);
		nice = (TextView)view.findViewById(R.id.iv_find_down);
		usericon = (ImageView)view.findViewById(R.id.iv_top_user);

	}

	@Override
	protected void initView() {
		title_topbar_back_iv.setVisibility(View.GONE);
		title_topbar_right_tv.setVisibility(View.GONE);
		title_topbar_tv.setText("发现");

		
		pindan.setOnClickListener(listener);
		comment.setOnClickListener(listener);
		dataFoot.setOnClickListener(listener);
		privilegeTicket.setOnClickListener(listener);

	}

	View.OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.find_comment_layout:
				startActivity(new Intent(getActivity(),ReviewActivity.class));
				break;
			case R.id.find_data_layout:
				startActivity(new Intent(getActivity(),DataFootActivity.class));
				break;
			case R.id.find_join_layout:
				startActivity(new Intent(getActivity(),MargeActivity.class));
				break;
			case R.id.find_ticket_layout:
				startActivity(new Intent(getActivity(),PrivilegeTicketActivity.class));
				break;
			}
		}
	};

	@Override
	protected void result(String result) {
		this.result = result;
		try {
			JSONObject c = new JSONObject(result);
			if (c.getInt("mark") == 1) {
				JSONObject results = c.getJSONObject("result");
				username.setText(results.getString("username"));
				context.setText(results.getString("reviewcontext"));
				reply.setText("点评("+results.getInt("replycount")+")");
				nice.setText("赞("+results.getInt("zambiacount")+")");
			} else
				Toast.makeText(getActivity().getApplicationContext(), "数据出错！", 0).show();
		} catch (JSONException e) {
			e.printStackTrace();
			Toast.makeText(getActivity().getApplicationContext(), "网络异常！", 0).show();
		}
	}

}
