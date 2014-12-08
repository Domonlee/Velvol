package com.velvol.o2o.tool;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.velvol.o2o.R;

public abstract class PullBase {
	private LayoutInflater inflater;
	public ScrollView sc;
	/**
	 * 
	 */
	public LinearLayout globleLayout;
	private LinearLayout header;
	private Animation anim;
	private ImageView iv_anim_first;
	private ImageView iv_header_fresh_anim;
	private TextView tv_text;
	private AnimationDrawable ad;
	private Context context;
	private int headerHeight; // 头高度
	private int lastHeaderPadding; // 最后一次调用Move Header的Padding
	private int headerState = DONE; // 头部状态
	static final private int RELEASE_To_REFRESH = 0; // 释放刷新:一直下拉屏幕时显示
	static final private int PULL_To_REFRESH = 1; // 正在刷新：放开屏幕后显示
	static final private int REFRESHING = 2; // 正在刷新
	static final private int DONE = 3;
	private boolean isBack; // 从Release 转到 pull

	public PullBase(Context context, LinearLayout globle, ScrollView sc) {
		this.context = context;
		this.sc = sc;
		globleLayout = globle;
	}

	// 计算头部高度
	public void initview() {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// 头部布局
		header = (LinearLayout) inflater.inflate(R.layout.first_header, null);
		tv_text = (TextView) header.findViewById(R.id.tv_first_refresh_text);
		iv_header_fresh_anim = (ImageView) header
				.findViewById(R.id.iv_header_anim);
		iv_header_fresh_anim.setBackgroundResource(R.anim.frame);
		ad = (AnimationDrawable) iv_header_fresh_anim.getBackground();
		// 头部动画
		anim = AnimationUtils.loadAnimation(context, R.anim.rotate);
		// 动画应用到的控件
		iv_anim_first = (ImageView) header.findViewById(R.id.iv_first_refresh);
		measureView(header);
		headerHeight = header.getMeasuredHeight();
		lastHeaderPadding = (-1 * headerHeight);
		header.setPadding(10, lastHeaderPadding, 0, 0);
		header.invalidate();
		// 添加头部布局
		globleLayout.addView(header, 0);
		anim.setFillAfter(true);// 动画结束后保持动画
		// 为ScrollView绑定监听
		sc.setOnTouchListener(new OnTouchListener() {
			private int beginY;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					/**
					 * sc.getScrollY == 0 scrollview 滑动到头了 lastHeaderPadding >
					 * (-1*headerHeight) 表示header还没完全隐藏起来时 headerState !=
					 * REFRESHING正在刷新时
					 */
					if ((sc.getScrollY() == 0 || lastHeaderPadding > (-1 * headerHeight))
							&& headerState != REFRESHING) {
						// 拿到滑动的Y轴距离
						int interval = (int) (event.getY() - beginY);
						Log.v("PullBase", event.getY() + "--");
						// 是向下滑动而不是向上滑动
						if (interval > 0) {
							interval = interval / 4;// 下滑阻力
							lastHeaderPadding = interval + (-1 * headerHeight);
							header.setPadding(10, lastHeaderPadding, 0, 0);
							if (lastHeaderPadding > 0) {
								// txView.setText("我要刷新咯");
								headerState = RELEASE_To_REFRESH;
								// 是否已经更新了UI
								if (!isBack) {
									isBack = true; // 到了Release状态，如果往回滑动到了pull则启动动画
									changeHeaderViewByState();
								}
							} else {
								headerState = PULL_To_REFRESH;
								changeHeaderViewByState();
								// txView.setText("看到我了哦");
								// sc.scrollTo(0, headerPadding);
							}
						}
					}
					break;
				case MotionEvent.ACTION_DOWN:
					// 加上下滑阻力与实际滑动距离的差（大概值）
					beginY = (int) ((int) event.getY() + sc.getScrollY() * 1.5);
					break;
				case MotionEvent.ACTION_UP:
					if (headerState != REFRESHING) {
						switch (headerState) {
						case DONE:
							// 什么也不干
							break;
						case PULL_To_REFRESH:
							headerState = DONE;
							lastHeaderPadding = -1 * headerHeight;
							header.setPadding(10, lastHeaderPadding, 0, 0);
							changeHeaderViewByState();
							break;
						case RELEASE_To_REFRESH:
							isBack = false; // 准备开始刷新，此时将不会往回滑动
							headerState = REFRESHING;
							changeHeaderViewByState();
							onRefresh();
							break;
						default:
							break;
						}
					}
					break;
				}
				// 如果Header是完全被隐藏的则让ScrollView正常滑动，让事件继续否则的话就阻断事件
				if (lastHeaderPadding > (-1 * headerHeight)
						&& headerState != REFRESHING) {
					return true;
				} else {
					return false;
				}

			}

		});
	}

	abstract public void onRefreshLoader();

	private void onRefresh() {
		new AsyncTask<Void, Void, Void>() {
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(2000);
					onRefreshLoader();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				onRefreshComplete();
			}

		}.execute(null, null);
	}

	public void onRefreshComplete() {
		headerState = DONE;
		changeHeaderViewByState();
	}

	private void measureView(View childView) {
		LayoutParams p = childView.getLayoutParams();
		if (p == null) {
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
		int height = p.height;
		int childHeightSpec;
		if (height > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(height,
					MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0,
					MeasureSpec.UNSPECIFIED);
		}
		childView.measure(childWidthSpec, childHeightSpec);
	}

	private void changeHeaderViewByState() {
		switch (headerState) {
		case PULL_To_REFRESH:
			// 是由RELEASE_To_REFRESH状态转变来的
			if (isBack) { // 向上送
				isBack = false;
				// 开启动画
				iv_anim_first.startAnimation(anim);
				ad.start();
				tv_text.setText("下拉刷新");
			}
			tv_text.setText("下拉刷新");
			break;
		case RELEASE_To_REFRESH: // 向下拖：这里只有右边的进度动画
			iv_anim_first.setVisibility(View.VISIBLE);
			iv_header_fresh_anim.setVisibility(View.VISIBLE);
			tv_text.setVisibility(View.VISIBLE);
			iv_anim_first.startAnimation(anim); // 右边的进度动画
			tv_text.setText("松手刷新");
			break;
		case REFRESHING:
			lastHeaderPadding = 0;
			header.setPadding(10, lastHeaderPadding, 0, 0);
			header.invalidate();
			iv_header_fresh_anim.setVisibility(View.VISIBLE);
			iv_anim_first.setVisibility(View.VISIBLE);
			tv_text.setText("载入中...");
			ad.start();
			break;
		case DONE: // 向上送
			lastHeaderPadding = -1 * headerHeight;
			header.setPadding(10, lastHeaderPadding, 0, 0);
			header.invalidate();
			iv_header_fresh_anim.setVisibility(View.GONE);
			tv_text.setText("下拉刷新");
			break;
		default:
			break;
		}
	}
}
