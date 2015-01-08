package com.velvol.o2o;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.velvol.o2o.fragment.CartFragmentActivity;
import com.velvol.o2o.fragment.FindFragmentActivity;
import com.velvol.o2o.fragment.MakeFragmentActivity;
import com.velvol.o2o.fragment.ManagerFragmentActivity;
import com.velvol.o2o.fragment.SearchFragmentActivity;

public class HomeActivity extends FragmentActivity {

	private ViewPager mPager;
	private RadioButton[] radioButtons = new RadioButton[5];
	private RadioGroup mGroup;
	private MakeFragmentActivity makeFragment;
	private SearchFragmentActivity searchFragment;
	private FindFragmentActivity findFragment;
	private CartFragmentActivity cartFragment;
	private ManagerFragmentActivity managerFragment;
	private ArrayList<Fragment> fragmentList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_home);
		findViewById();
		initView();
	}

	private void findViewById() {
		radioButtons[0] = (RadioButton) findViewById(R.id.make);
		radioButtons[1] = (RadioButton) findViewById(R.id.search);
		radioButtons[2] = (RadioButton) findViewById(R.id.find);
		radioButtons[3] = (RadioButton) findViewById(R.id.cart);
		radioButtons[4] = (RadioButton) findViewById(R.id.manage);
		mGroup = (RadioGroup) findViewById(R.id.home_radio_button_group);
		mPager = (ViewPager) findViewById(R.id.viewpager);
	}

	private void initView() {

		fragmentList = new ArrayList<Fragment>();
		makeFragment = new MakeFragmentActivity();
		searchFragment = new SearchFragmentActivity();
		findFragment = new FindFragmentActivity();
		cartFragment = new CartFragmentActivity();
		managerFragment = new ManagerFragmentActivity();

		fragmentList.add(makeFragment);
		fragmentList.add(searchFragment);
		fragmentList.add(findFragment);
		fragmentList.add(cartFragment);
		fragmentList.add(managerFragment);

		mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			public int getCount() {
				return fragmentList.size();
			}

			public Fragment getItem(int arg0) {
				return fragmentList.get(arg0);
			}
		});

		mPager.setCurrentItem(0);// 设置当前显示标签页为第一页
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mGroup.setOnCheckedChangeListener(listener);
	}

	RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			Log.v("onCheckedChanged", checkedId + "");
			switch (checkedId) {
			case R.id.make:
				mPager.setCurrentItem(0);
				break;
			case R.id.search:
				mPager.setCurrentItem(1);
				break;
			case R.id.find:
				mPager.setCurrentItem(2);
				break;
			case R.id.cart:
				mPager.setCurrentItem(3);
				break;
			case R.id.manage:
				mPager.setCurrentItem(4);
				break;
			default:
				break;
			}
		}
	};

	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			Log.v("onPageScrollStateChanged", arg0 + "");
		}

		@Override
		public void onPageSelected(int arg0) {
			Log.v("onPageSelected", arg0 + "");
			radioButtons[arg0].setChecked(true);
		}
	}
}
