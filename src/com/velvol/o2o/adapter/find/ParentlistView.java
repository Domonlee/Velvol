package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
//自定义ListView(里面的listView也可滚动)
public class ParentlistView extends ListView{

	public ParentlistView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public ParentlistView(Context context,AttributeSet attrs){
		super(context,attrs);
	}
	public ParentlistView(Context context,AttributeSet attrs,int defStyle){
		super(context,attrs,defStyle);
	}
	//将 onInterceptTouchEvent的返回值设置为false，取消其对触摸事件的处理，将事件分发给子view
	//不拦截触碰事件
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}
}
