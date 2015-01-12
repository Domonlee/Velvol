package com.velvol.o2o.tool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
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

public abstract class BaseFragment extends Fragment {
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
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data = (Data)getActivity().getApplication();
	}

	protected abstract void findViewById();

	/**
	 */
	protected abstract void initView();

	public void showProgressDialog(Context context) {
		if (loadingDialog != null) {
			loadingDialog.cancel();
		}
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.loading_dialog, null);// �õ�����view
		LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// ���ز���
		// main.xml�е�ImageView
		ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
		TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// ��ʾ����
		// ���ض���
		Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
				context, R.anim.loading_animation);
		// ʹ��ImageView��ʾ����
		spaceshipImage.startAnimation(hyperspaceJumpAnimation);
		tipTextView.setText("���ڼ��������Ժ�");// ���ü�����Ϣ

		loadingDialog = new Dialog(context, R.style.loading_dialog);// �����Զ�����ʽdialog

		loadingDialog.setCancelable(true);// �������á����ؼ���ȡ��
		loadingDialog.setCanceledOnTouchOutside(false);
		loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));// ���ò���
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
				// result = uploadFile();
				;
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
			result = "";
		}
	}

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
