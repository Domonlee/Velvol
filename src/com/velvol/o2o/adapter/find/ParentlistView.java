package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
//�Զ���ListView(�����listViewҲ�ɹ���)
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
	//�� onInterceptTouchEvent�ķ���ֵ����Ϊfalse��ȡ����Դ����¼��Ĵ������¼��ַ�����view
	//�����ش����¼�
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return false;
	}
}
