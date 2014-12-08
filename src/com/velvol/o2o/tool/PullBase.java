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
	private int headerHeight; // ͷ�߶�
	private int lastHeaderPadding; // ���һ�ε���Move Header��Padding
	private int headerState = DONE; // ͷ��״̬
	static final private int RELEASE_To_REFRESH = 0; // �ͷ�ˢ��:һֱ������Ļʱ��ʾ
	static final private int PULL_To_REFRESH = 1; // ����ˢ�£��ſ���Ļ����ʾ
	static final private int REFRESHING = 2; // ����ˢ��
	static final private int DONE = 3;
	private boolean isBack; // ��Release ת�� pull

	public PullBase(Context context, LinearLayout globle, ScrollView sc) {
		this.context = context;
		this.sc = sc;
		globleLayout = globle;
	}

	// ����ͷ���߶�
	public void initview() {
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// ͷ������
		header = (LinearLayout) inflater.inflate(R.layout.first_header, null);
		tv_text = (TextView) header.findViewById(R.id.tv_first_refresh_text);
		iv_header_fresh_anim = (ImageView) header
				.findViewById(R.id.iv_header_anim);
		iv_header_fresh_anim.setBackgroundResource(R.anim.frame);
		ad = (AnimationDrawable) iv_header_fresh_anim.getBackground();
		// ͷ������
		anim = AnimationUtils.loadAnimation(context, R.anim.rotate);
		// ����Ӧ�õ��Ŀؼ�
		iv_anim_first = (ImageView) header.findViewById(R.id.iv_first_refresh);
		measureView(header);
		headerHeight = header.getMeasuredHeight();
		lastHeaderPadding = (-1 * headerHeight);
		header.setPadding(10, lastHeaderPadding, 0, 0);
		header.invalidate();
		// ���ͷ������
		globleLayout.addView(header, 0);
		anim.setFillAfter(true);// ���������󱣳ֶ���
		// ΪScrollView�󶨼���
		sc.setOnTouchListener(new OnTouchListener() {
			private int beginY;

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					/**
					 * sc.getScrollY == 0 scrollview ������ͷ�� lastHeaderPadding >
					 * (-1*headerHeight) ��ʾheader��û��ȫ��������ʱ headerState !=
					 * REFRESHING����ˢ��ʱ
					 */
					if ((sc.getScrollY() == 0 || lastHeaderPadding > (-1 * headerHeight))
							&& headerState != REFRESHING) {
						// �õ�������Y�����
						int interval = (int) (event.getY() - beginY);
						Log.v("PullBase", event.getY() + "--");
						// �����»������������ϻ���
						if (interval > 0) {
							interval = interval / 4;// �»�����
							lastHeaderPadding = interval + (-1 * headerHeight);
							header.setPadding(10, lastHeaderPadding, 0, 0);
							if (lastHeaderPadding > 0) {
								// txView.setText("��Ҫˢ�¿�");
								headerState = RELEASE_To_REFRESH;
								// �Ƿ��Ѿ�������UI
								if (!isBack) {
									isBack = true; // ����Release״̬��������ػ�������pull����������
									changeHeaderViewByState();
								}
							} else {
								headerState = PULL_To_REFRESH;
								changeHeaderViewByState();
								// txView.setText("��������Ŷ");
								// sc.scrollTo(0, headerPadding);
							}
						}
					}
					break;
				case MotionEvent.ACTION_DOWN:
					// �����»�������ʵ�ʻ�������Ĳ���ֵ��
					beginY = (int) ((int) event.getY() + sc.getScrollY() * 1.5);
					break;
				case MotionEvent.ACTION_UP:
					if (headerState != REFRESHING) {
						switch (headerState) {
						case DONE:
							// ʲôҲ����
							break;
						case PULL_To_REFRESH:
							headerState = DONE;
							lastHeaderPadding = -1 * headerHeight;
							header.setPadding(10, lastHeaderPadding, 0, 0);
							changeHeaderViewByState();
							break;
						case RELEASE_To_REFRESH:
							isBack = false; // ׼����ʼˢ�£���ʱ���������ػ���
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
				// ���Header����ȫ�����ص�����ScrollView�������������¼���������Ļ�������¼�
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
			// ����RELEASE_To_REFRESH״̬ת������
			if (isBack) { // ������
				isBack = false;
				// ��������
				iv_anim_first.startAnimation(anim);
				ad.start();
				tv_text.setText("����ˢ��");
			}
			tv_text.setText("����ˢ��");
			break;
		case RELEASE_To_REFRESH: // �����ϣ�����ֻ���ұߵĽ��ȶ���
			iv_anim_first.setVisibility(View.VISIBLE);
			iv_header_fresh_anim.setVisibility(View.VISIBLE);
			tv_text.setVisibility(View.VISIBLE);
			iv_anim_first.startAnimation(anim); // �ұߵĽ��ȶ���
			tv_text.setText("����ˢ��");
			break;
		case REFRESHING:
			lastHeaderPadding = 0;
			header.setPadding(10, lastHeaderPadding, 0, 0);
			header.invalidate();
			iv_header_fresh_anim.setVisibility(View.VISIBLE);
			iv_anim_first.setVisibility(View.VISIBLE);
			tv_text.setText("������...");
			ad.start();
			break;
		case DONE: // ������
			lastHeaderPadding = -1 * headerHeight;
			header.setPadding(10, lastHeaderPadding, 0, 0);
			header.invalidate();
			iv_header_fresh_anim.setVisibility(View.GONE);
			tv_text.setText("����ˢ��");
			break;
		default:
			break;
		}
	}
}
