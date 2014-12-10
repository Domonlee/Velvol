package com.velvol.o2o;

import com.velvol.o2o.ui.login.LoginActivity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class GuideActivity extends Activity {

	public ImageView imageView;
	public Data data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		data = (Data) getApplication();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		findView();
		initView();

	}

	private void findView() {
		imageView = (ImageView) findViewById(R.id.bg);
	}

	public void initView() {
		Animation translate = AnimationUtils.loadAnimation(this, R.anim.myset);
		translate.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				startActivity(new Intent().setClass(getApplicationContext(),
						LoginActivity.class));

				overridePendingTransition(R.anim.push_left_in,
						R.anim.push_left_out);
				GuideActivity.this.finish();
			}
		});
		imageView.setAnimation(translate);
	}

}
