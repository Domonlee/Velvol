package com.velvol.o2o;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
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
		setContentView(R.layout.activity_particulars);
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
				Intent i = new Intent(ParticularsActivity.this,
						SsssActivity.class);
				startActivity(i);
			}
		});
		// �̼���
		merchantName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(ParticularsActivity.this,
						MerchantNameActivity.class);
				startActivity(i);
			}
		});
		// ɹ����������
		comment.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(ParticularsActivity.this,
						CommentActivity.class);
				startActivity(i);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.particulars, menu);
		return true;
	}

	

}
