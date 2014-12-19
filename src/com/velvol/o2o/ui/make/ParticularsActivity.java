package com.velvol.o2o.ui.make;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ParticularsActivity extends BaseActivity {

	// ฯ๊ว้าณ
	private TextView merchantName;
	private LinearLayout comment;
	private ImageView back;
	private PopupWindow pop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_particulars);

		findViewById();
		initView();
		initPopWindow();
	}

	@Override
	protected void findViewById() {
		merchantName = (TextView) findViewById(R.id.particulars_tv_merchantName);
		comment = (LinearLayout) findViewById(R.id.comment);
		back = (ImageView) findViewById(R.id.particulars_return);

	}

	@Override
	protected void initView() {
		merchantName.setOnClickListener(listener);
		comment.setOnClickListener(listener);
		back.setOnClickListener(listener);

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

			default:
				break;
			}

		}
	};

	@Override
	protected void result(String result) {

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

}
