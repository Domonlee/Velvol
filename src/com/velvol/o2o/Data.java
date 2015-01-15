package com.velvol.o2o;


import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap.Config;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.velvol.o2o.constant.Sell;
import com.velvol.o2o.tool.ConfigUtil;

public class Data extends Application {
	
	private static Data mInstance = null;
	public boolean login_flag = false;
	public String User_id = "";
	public String searchHistory = "";
	public DisplayImageOptions displayImageOptions;
	public List<Sell> cat_sell_list = new ArrayList<Sell>();
	public static Data getInstance() {
		return mInstance;
	}
	
	public Context getContext() {
		return getBaseContext();
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		initData();
		initImageLoader();
	}
	public void initData(){
		login_flag = ConfigUtil.getBoolean("login_flag", false);
		User_id = ConfigUtil.getString("user_id", "");
		searchHistory = ConfigUtil.getString("searchHistory", "{\"searchHistory\":[{\"name\":\"牛肉面\"},{\"name\":\"炒米饭\"}]}");
	}
	
	public void initImageLoader() {
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				getBaseContext())
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove for release app
				.build();

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
		displayImageOptions = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.ic_launcher)
				// 设置图片下载期间显示的图片
				.showImageForEmptyUri(R.drawable.ic_launcher)
				// 设置图片Uri为空或是错误的时候显示的图片
				.showImageOnFail(R.drawable.ic_launcher)
				// 设置图片加载或解码过程中发生错误显示的图片
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
				.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
				.displayer(new SimpleBitmapDisplayer())
				.bitmapConfig(Config.RGB_565).build(); // 创建配置过得DisplayImageOption对象
	}
	
}
