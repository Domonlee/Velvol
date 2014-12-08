package com.velvol.o2o.tool;

import android.content.Context;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.velvol.o2o.R;

public class MoveListener implements OnGestureListener{
	public boolean move_flag = false;
	private ViewFlipper flipper; 
	private Context context;
	public MoveListener(ViewFlipper fli,Context con) {
		flipper = fli;
		context = con;
	}
	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		move_flag = false;
		return false;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,  
			float velocityY) {  
			if (e1.getX() - e2.getX() > 150) {
				flipper.setInAnimation(AnimationUtils.loadAnimation(context,  R.anim.push_left_in)); 
                flipper.setOutAnimation(AnimationUtils.loadAnimation(context,  R.anim.push_left_out));
			flipper.showNext();  
			move_flag = true;  
			} else if (e1.getX() - e2.getX() < -150) { 
				flipper.setInAnimation(AnimationUtils.loadAnimation(context, R.anim.push_right_in)); 
                flipper.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.push_right_out)); 
			flipper.showPrevious(); 
			move_flag = true;  
			}  
			if(move_flag)
				flipper.stopFlipping();
			return move_flag;  
			}
}
