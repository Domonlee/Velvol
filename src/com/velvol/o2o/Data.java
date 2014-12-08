package com.velvol.o2o;

import android.app.Application;
import android.content.Context;

public class Data extends Application {
	
	private static Data mInstance = null;
	
	public static Data getInstance() {
		return mInstance;
	}
	
	public Context getContext() {
		return getBaseContext();
	}
}
