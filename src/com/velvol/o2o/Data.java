package com.velvol.o2o;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.velvol.o2o.tool.ConfigUtil;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap.Config;

public class Data extends Application {
	
	private static Data mInstance = null;
	public boolean login_flag = false;
	public DisplayImageOptions displayImageOptions;
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
				// ����ͼƬ�����ڼ���ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.ic_launcher)
				// ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.ic_launcher)
				// ����ͼƬ���ػ��������з���������ʾ��ͼƬ
				.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
				.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
				.displayer(new FadeInBitmapDisplayer(500)) // ���ó�Բ��ͼƬ
				.bitmapConfig(Config.RGB_565).build(); // �������ù���DisplayImageOption����
	}
}
