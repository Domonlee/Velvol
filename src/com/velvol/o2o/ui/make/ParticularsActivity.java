package com.velvol.o2o.ui.make;

<<<<<<< HEAD
import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
=======
import com.velvol.o2o.EvaluateActivity;
import com.velvol.o2o.R;
import com.velvol.o2o.adapter.make.EvaluateAdapter;
import com.velvol.o2o.tool.BaseActivity;
import com.velvol.o2o.tool.MyListView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
>>>>>>> origin/qiu
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ParticularsActivity extends BaseActivity {

	// ฯ๊ว้าณ
	private TextView merchantName;
<<<<<<< HEAD
	private LinearLayout comment;
	private ImageView back;
	private PopupWindow pop;
=======
	private LinearLayout comment,popLayout;
	private ImageView back,classify;
	private MyListView listView;
	private EvaluateAdapter adapter;
	private boolean pop_layout_flag = false;
	
>>>>>>> origin/qiu

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_particulars);
<<<<<<< HEAD

		findViewById();
		initView();
		initPopWindow();
=======
		findViewById();
		initView();
>>>>>>> origin/qiu
	}

	@Override
	protected void findViewById() {
		merchantName = (TextView) findViewById(R.id.particulars_tv_merchantName);
		comment = (LinearLayout) findViewById(R.id.comment);
		back = (ImageView) findViewById(R.id.particulars_return);
<<<<<<< HEAD

	}

=======
		classify = (ImageView) findViewById(R.id.classify);
		listView = (MyListView)findViewById(R.id.listview);
		popLayout = (LinearLayout)findViewById(R.id.pop_layout);
	}

>>>>>>> origin/qiu
	@Override
	protected void initView() {
		merchantName.setOnClickListener(listener);
		comment.setOnClickListener(listener);
		back.setOnClickListener(listener);
<<<<<<< HEAD

	}

	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.classify:
				if (pop.isShowing())
					pop.dismiss();
				else
					pop.showAsDropDown(v);
				break;

			case R.id.particulars_return:
				finish();
				break;

=======
		classify.setOnClickListener(listener);
		adapter = new EvaluateAdapter(ParticularsActivity.this);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				startActivity(new Intent(ParticularsActivity.this,EvaluateActivity.class));
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

>>>>>>> origin/qiu
			default:
				break;
			}

		}
	};

	@Override
	protected void result(String result) {

<<<<<<< HEAD
	}

	private void initPopWindow() {
		// popWindow
		LayoutInflater inflater = LayoutInflater.from(ParticularsActivity.this);
		View view = inflater.inflate(R.layout.particular_popupwindow, null);
		pop = new PopupWindow(view, LayoutParams.MATCH_PARENT,
				120);
		pop.setBackgroundDrawable(new PaintDrawable(Color.argb(0, 0, 0, 0)));
		ImageView classify = (ImageView) findViewById(R.id.classify);
		pop.setOutsideTouchable(true);
		pop.setBackgroundDrawable(new PaintDrawable());
		pop.setFocusable(true);
		classify.setOnClickListener(listener);
	}

=======
	}


>>>>>>> origin/qiu
}
