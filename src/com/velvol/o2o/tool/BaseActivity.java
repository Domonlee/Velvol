package com.velvol.o2o.tool;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.velvol.o2o.Data;
import com.velvol.o2o.R;

public abstract class BaseActivity extends Activity {

	public static final String TAG = BaseActivity.class.getSimpleName();
	public Dialog loadingDialog = null;
	protected MyHandler handler = null;
	protected Thread mtThread = null;
	public int UserID, Code = 1;
	public String get, result = null, ID, aPath;
	public HttpGet httpGet;
	public HttpResponse httpResponse;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	public Data data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		data = (Data) getApplication();
		super.onCreate(savedInstanceState);
		AppManager.getInstance().addActivity(this);
	}

	protected void openActivity(Activity mClass, Class<?> pClass, Bundle pBundle) {
		Intent intent = new Intent(mClass, pClass);
		if (pBundle != null) {
			intent.putExtras(pBundle);
		}
		startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	/**
	 */
	protected abstract void findViewById();

	/**
	 */
	protected abstract void initView();

	public void showProgressDialog(Context context) {
		if (loadingDialog != null) {
			loadingDialog.cancel();
		}
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
		// main.xml中的ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
		// 加载动画
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_animation);
		// 使用ImageView显示动画
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText("正在加载中请稍后！");// 设置加载信息

		loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog

		loadingDialog.setCancelable(true);// 不可以用“返回键”取消
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));// 设置布局
		loadingDialog.show();
	}

	public boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	public void httpget(String http_get, int code) {
		Log.v("http--Url", http_get);
		if (code == 1) {
			httpGet = new HttpGet(http_get);
			Code = code;
		} else {
			aPath = http_get;
			Code = code;
		}
		if (handler == null)
			handler = new MyHandler();
		MyThread thread = new MyThread(handler);
		mtThread = new Thread(thread);
		mtThread.start();
	}

	public class MyThread implements Runnable {
		MyHandler Myhandler;

		public MyThread(MyHandler handler) {
			this.Myhandler = handler;
		}

		@Override
		public void run() {
			Message msg = new Message();
			Bundle bundle = new Bundle();
			if (Code == 1)
				get();
			else
				result = uploadFile();
			Log.v("http--result", result);
			bundle.putString("result", String.valueOf(result));
			msg.setData(bundle);
			handler.sendMessage(msg);
		}
	}

	protected abstract void result(String result);

	public class MyHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle bundle = msg.getData();
			result(bundle.getString("result"));
		}
	}

	public void get() {
		try {
			httpResponse = new DefaultHttpClient().execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200)
				result = EntityUtils.toString(httpResponse.getEntity(),
						"GB2312");
			else
				result = "";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String uploadFile() {
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		try {
			URL url = new URL("http://www.qipeio.com/Sell/setimage.ashx");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
			con.setRequestMethod("POST");
			/* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);
			DataOutputStream ds = new DataOutputStream(con.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date(System.currentTimeMillis());
			String filesString = formatter.format(date).substring(0, 8);
			ds.writeBytes("Content-Disposition: form-data; "
					+ "name=\"file\";filename=\"" + formatter.format(date)
					+ "\"" + end);
			ds.writeBytes(end);
			FileInputStream fStream = new FileInputStream(aPath);
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = -1;
			/* 浠庢枃浠惰鍙栨暟鎹嚦缂撳啿鍖? */
			while ((length = fStream.read(buffer)) != -1) {
				/* 灏嗚祫鏂欏啓鍏ataOutputStream涓? */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
			/* close streams */
			fStream.close();
			ds.flush();
			/* 鍙栧緱Response鍐呭 */
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer b = new StringBuffer();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			/* 鍏抽棴DataOutputStream */
			ds.close();
			/* 灏哛esponse鏄剧ず浜嶥ialog */
			if (b.toString().equals("0"))
				return "{\"sell\":[{\"msg\":\"1\"}]}";
			else
				return "{\"sell\":[{\"msg\":\"" + "/UploadFiles/Product/"
						+ filesString + "/" + formatter.format(date)
						+ ".png\"}]}";
		} catch (Exception e) {
			return "{\"sell\":[{\"msg\":\"error\"}]}";
		}
	}

	/**
	 * @说明 String 待检验字符串 Int 检验动作 1:邮箱 2:手机
	 * @return boolean
	 */
	public boolean emailFormat(String str, int action) {
		boolean tag = true;
		final String pattern1 = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$";
		final String pattern2 = "^[1][3,4,5,8][0-9]{9}$";
		Pattern pattern;
		if (action == 1)
			pattern = Pattern.compile(pattern1);
		else
			pattern = Pattern.compile(pattern2);
		Matcher mat = pattern.matcher(str);
		if (!mat.matches()) {
			tag = false;
		}
		return tag;
	}

	public String getkey(String key) {

		key = key.replace("_", "");
		key = key.replace("%", "");
		key = key.replace("'", "");
		key = key.replace("\"", "");
		key = key.replace("&", "");
		key = key.replace("||", "");
		key = key.replace("@", "");
		key = key.replace("*", "");
		key = key.replace("(", "");
		key = key.replace(")", "");
		key = key.replace("--", "");

		try {
			key = java.net.URLEncoder.encode(key, "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return key;
	}
}
