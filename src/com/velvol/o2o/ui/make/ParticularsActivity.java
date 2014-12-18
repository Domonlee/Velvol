package com.velvol.o2o.ui.make;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.velvol.o2o.R;
import android.app.Activity;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ParticularsActivity extends Activity {

	// ����ҳ
	private LinearLayout caipinxiangqing;
	private TextView merchantName;
	private LinearLayout comment;
	private ImageView choose;
	private SlidingMenu menu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_particulars);
		caipinxiangqing = (LinearLayout) findViewById(R.id.tv_particulars3);
		merchantName = (TextView) findViewById(R.id.particulars_tv_merchantName);
		choose = (ImageView) findViewById(R.id.tv_particulars2);
		comment = (LinearLayout) findViewById(R.id.comment);

		menu = new SlidingMenu(this);
		menu.setMenu(R.layout.choose_number);
		menu.setMode(SlidingMenu.RIGHT);
		menu.setSecondaryShadowDrawable(R.drawable.particulars_shodow);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setTouchModeBehind(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidth(100);

		menu.setBehindScrollScale(0.35f);
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		menu.setBehindWidth(metrics.widthPixels / 5 * 4);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

		// ��Ʒ����
		caipinxiangqing.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});
		// �̼���
		merchantName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});
		// ɹ����������
		comment.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});
		// ... ��ť
		LayoutInflater inflater = LayoutInflater.from(ParticularsActivity.this);
		View view = inflater.inflate(R.layout.particular_popupwindow, null);
		final PopupWindow pop = new PopupWindow(view,130, 220);
		ImageView classify = (ImageView) findViewById(R.id.classify);
		pop.setOutsideTouchable(true);
		pop.setBackgroundDrawable(new PaintDrawable());
		pop.setFocusable(true);
		classify.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				if(pop.isShowing()){
					pop.dismiss();
				}else {
					pop.showAsDropDown(v);				}
			}
		});
		// ���ذ�ť
		findViewById(R.id.particulars_return).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						finish();
					}
				});
		//������ﳵ��>�����˵�
		findViewById(R.id.particulars_gouwuche).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						menu.toggle();
					}
				});
		findViewById(R.id.tv_particulars2).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						menu.toggle();
					}
				});
	}

	

}
