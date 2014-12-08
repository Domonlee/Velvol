package com.velvol.o2o.tool;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class HandlerUp{
	
	/**apk下载地址**/
	public String apkPath;
	/**apk大小**/
	public int Sezi;
	public Context myactivity;
	public ProgressDialog pBar;
	public Handler handler;
	public int count = 0;  
	public HandlerUp(String str,Context activity,int ApkSezi){
		myactivity = activity;
		apkPath = str;
		Sezi = ApkSezi;
		handler = new Handler() {  
			public void handleMessage(Message msg) {  
			super.handleMessage(msg);    
			if(msg.what==11)
				pBar.setProgress(count);
			else{
			Dialog dialog = new AlertDialog.Builder(myactivity).setTitle("系统更新").setMessage("发现新版本，请更新！")   
			.setPositiveButton("确定",new DialogInterface.OnClickListener() {   
						public void onClick(DialogInterface dialog, int which) {  
								pBar = new ProgressDialog(myactivity);  
								pBar.setTitle("正在下载");
								pBar.setMessage("请稍候...");
								//进度条是否不明确, false可以显示数值  true来回移动
								pBar.setIndeterminate(false);
								pBar.setCancelable(true);
								pBar.setCanceledOnTouchOutside(false);
								pBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
								pBar.setMax(Sezi);
								downFile(apkPath);}})
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {  
						public void onClick(DialogInterface dialog, int whichButton) {  
			
				}}).create();
			dialog.show();  
			}
			
			}
		};
	}
	public void downFile(final String url) {  
		pBar.show();  
		Log.v("url",url);
		new Thread() {  
		public void run() {  
		HttpClient client = new DefaultHttpClient();  
		HttpGet get = new HttpGet(url);  
		HttpResponse response;  
		try {  
		response = client.execute(get);  
		HttpEntity entity = response.getEntity();  
		long length = entity.getContentLength();  
		InputStream is = entity.getContent();  
		FileOutputStream fileOutputStream = null;  
		if (is != null) {  
			File file = new File(Environment.getExternalStorageDirectory(),"demo.apk");
		if (!file.exists()) {
			file.createNewFile(); 
			}
		fileOutputStream = new FileOutputStream(file);  
		byte[] buf = new byte[10240];  
		int ch = -1;  
		count = 0;  
		while ((ch = is.read(buf)) != -1) {  
		fileOutputStream.write(buf, 0, ch);  
		count += ch;
		sendMsg(11);
		}  
		}
		
		fileOutputStream.flush();  
		if (fileOutputStream != null) {  
		fileOutputStream.close();  
		}  
		down();  
		} catch (ClientProtocolException e) {  
		e.printStackTrace();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}  
		}  
		}.start();  
		}  
		public void down() {  
		handler.post(new Runnable()   
		{  
		public void run() {  
		pBar.dismiss();  
		update();  
		}});  
		}
		public void update() {  
			Intent intent = new Intent(Intent.ACTION_VIEW);  
			intent.setDataAndType(Uri.fromFile(new File("/sdcard/demo.apk")),"application/vnd.android.package-archive");  
			myactivity.startActivity(intent);  
			} 
		private void sendMsg(int flag) {  
	        Message msg = new Message();  
	        msg.what = flag;  
	        handler.sendMessage(msg);  
	    }  
}
