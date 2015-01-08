package com.velvol.o2o.ui.manager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.R.fraction;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
import com.velvol.o2o.Utils.PhotoUtil;
import com.velvol.o2o.Utils.VelvolConstants;
import com.velvol.o2o.tool.BaseActivity;

public class UserFaceActivity extends BaseActivity {

	private ImageView title_topbar_back_iv;
	public TextView title_topbar_tv;
	private ImageView manage_userface_big_iv;
	private LinearLayout manage_userface_big_layout;
	private int w_screen, h_screen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(1);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manager_userface);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		title_topbar_back_iv = (ImageView) findViewById(R.id.title_topbar_back_iv);
		manage_userface_big_iv = (ImageView) findViewById(R.id.manage_userface_big_iv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		manage_userface_big_layout = (LinearLayout) findViewById(R.id.manage_userface_big_layout);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("上传头像");
		title_topbar_back_iv.setOnClickListener(clickListener);
		manage_userface_big_iv.setOnClickListener(clickListener);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		w_screen = dm.widthPixels;
//		h_screen = dm.heightPixels;
		int ivw_screen = (int) (w_screen * 0.8);
		
		LayoutParams params = manage_userface_big_iv.getLayoutParams();  
	    params.height=ivw_screen;  
	    params.width =ivw_screen;  
	    manage_userface_big_iv.setLayoutParams(params);  
//		manage_userface_big_iv
//				.setLayoutParams(new ImageView.LayoutParams(ivw_screen,
//						ivw_screen));
		Log.w("屏幕长度", w_screen + ";" + h_screen);
	}

	View.OnClickListener clickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.title_topbar_back_iv:
				Log.w("finish", "finish");
				finish();
				break;
			case R.id.manage_userface_big_iv:
				showAvatarPop();
				break;
			}
		}
	};

	@Override
	protected void result(String result) {

	}

	/**
	 * 更新头像 refreshAvatar
	 * 
	 * @return void
	 * @throws
	 */
	// private void refreshAvatar(String avatar) {
	// if (avatar != null && !avatar.equals("")) {
	// ImageLoader.getInstance().displayImage(avatar, iv_set_avator,
	// ImageLoadOptions.getOptions());
	// } else {
	// iv_set_avator.setImageResource(R.drawable.default_head);
	// }
	// }

	RelativeLayout layout_choose;
	RelativeLayout layout_photo;
	PopupWindow avatorPop;

	public String filePath = "";

	/**
	 * 显示头像处理弹出框
	 */
	@SuppressWarnings("deprecation")
	private void showAvatarPop() {
		View view = LayoutInflater.from(this).inflate(R.layout.pop_showavator,
				null);
		layout_choose = (RelativeLayout) view.findViewById(R.id.layout_choose);
		layout_photo = (RelativeLayout) view.findViewById(R.id.layout_photo);
		layout_photo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ShowLog("点击拍照");
				layout_choose.setBackgroundColor(getResources().getColor(
						R.color.base_color_text_white));
				layout_photo.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.pop_bg_press));
				File dir = new File(VelvolConstants.MyAvatarDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				// 原图
				File file = new File(dir, new SimpleDateFormat("yyMMddHHmmss")
						.format(new Date()));
				filePath = file.getAbsolutePath();// 获取相片的保存路径
				Uri imageUri = Uri.fromFile(file);

				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent,
						VelvolConstants.REQUESTCODE_UPLOADAVATAR_CAMERA);
			}
		});
		layout_choose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				ShowLog("点击相册");
				layout_photo.setBackgroundColor(getResources().getColor(
						R.color.base_color_text_white));
				layout_choose.setBackgroundDrawable(getResources().getDrawable(
						R.drawable.pop_bg_press));
				Intent intent = new Intent(Intent.ACTION_PICK, null);
				intent.setDataAndType(
						MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
				startActivityForResult(intent,
						VelvolConstants.REQUESTCODE_UPLOADAVATAR_LOCATION);
			}
		});
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int mScreenWidth = metric.widthPixels;

		avatorPop = new PopupWindow(view, mScreenWidth, 600);
		avatorPop.setTouchInterceptor(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
					avatorPop.dismiss();
					return true;
				}
				return false;
			}
		});
		avatorPop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
		avatorPop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		avatorPop.setTouchable(true);
		avatorPop.setFocusable(true);
		avatorPop.setOutsideTouchable(true);
		avatorPop.setBackgroundDrawable(new BitmapDrawable());
		// 动画效果 从底部弹起
		avatorPop.setAnimationStyle(R.style.Animations_GrowFromBottom);
		avatorPop.showAtLocation(manage_userface_big_layout, Gravity.BOTTOM, 0, 0);
	}

	/**
	 * @Title: startImageAction
	 * @return void
	 * @throws 
	 * 剪切图片
	 */
	private void startImageAction(Uri uri, int outputX, int outputY,
			int requestCode, boolean isCrop) {
		Intent intent = null;
		if (isCrop) {
			intent = new Intent("com.android.camera.action.CROP");
		} else {
			intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		}
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", outputX);
		intent.putExtra("outputY", outputY);
		intent.putExtra("scale", true);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		intent.putExtra("return-data", true);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
		startActivityForResult(intent, requestCode);
	}

	Bitmap newBitmap;
	boolean isFromCamera = false;// 区分拍照旋转
	int degree = 0;

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case VelvolConstants.REQUESTCODE_UPLOADAVATAR_CAMERA:// 拍照修改头像
			if (resultCode == RESULT_OK) {
				if (!Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					ShowToast("SD不可用");
					return;
				}
				isFromCamera = true;
				File file = new File(filePath);
				degree = PhotoUtil.readPictureDegree(file.getAbsolutePath());
				Log.i("life", "拍照后的角度：" + degree);
				startImageAction(Uri.fromFile(file), 200, 200,
						VelvolConstants.REQUESTCODE_UPLOADAVATAR_CROP, true);
			}
			break;
		case VelvolConstants.REQUESTCODE_UPLOADAVATAR_LOCATION:// 本地修改头像
			if (avatorPop != null) {
				avatorPop.dismiss();
			}
			Uri uri = null;
			if (data == null) {
				return;
			}
			if (resultCode == RESULT_OK) {
				if (!Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					ShowToast("SD不可用");
					return;
				}
				isFromCamera = false;
				uri = data.getData();
				startImageAction(uri, 200, 200,
						VelvolConstants.REQUESTCODE_UPLOADAVATAR_CROP, true);
			} else {
				ShowToast("照片获取失败");
			}
			break;
		case VelvolConstants.REQUESTCODE_UPLOADAVATAR_CROP:// 裁剪头像返回
			// TODO sent to crop
			if (avatorPop != null) {
				avatorPop.dismiss();
			}
			if (data == null) {
				// Toast.makeText(this, "取消选择", Toast.LENGTH_SHORT).show();
				ShowToast("取消选择");
				return;
			} else {
				saveCropAvator(data);
			}
			// 初始化文件路径
			filePath = "";
			// 上传头像
			// uploadAvatar();
			break;
		default:
			break;

		}
	}

	String path;

	/**
	 * 保存裁剪的头像
	 * 
	 * @param data
	 */
	private void saveCropAvator(Intent data) {
		Bundle extras = data.getExtras();
		if (extras != null) {
			Bitmap bitmap = extras.getParcelable("data");
			Log.i("life", "avatar - bitmap = " + bitmap);
			if (bitmap != null) {
				bitmap = PhotoUtil.toRoundCorner(bitmap, 10);
				if (isFromCamera && degree != 0) {
					bitmap = PhotoUtil.rotaingImageView(degree, bitmap);
				}
				manage_userface_big_iv.setImageBitmap(bitmap);
				// 保存图片
				String filename = new SimpleDateFormat("yyMMddHHmmss")
						.format(new Date());
				path = VelvolConstants.MyAvatarDir + filename;
				PhotoUtil.saveBitmap(VelvolConstants.MyAvatarDir, filename,
						bitmap, true);
				// 上传头像
				if (bitmap != null && bitmap.isRecycled()) {
					bitmap.recycle();
				}
			}
		}
	}

}
