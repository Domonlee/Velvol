package com.velvol.o2o;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import com.velvol.o2o.adapter.NewAdapter;
import com.velvol.o2o.tool.BaseActivity;
public class SearchItemInfoActivity extends BaseActivity {
	private EditText search;
	private GridView gridView;
	private ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_iten_info);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		search = (EditText) findViewById(R.id.search);
		back = (ImageView) findViewById(R.id.title_topbar_back_iv);
		gridView = (GridView) findViewById(R.id.gv_search_info_gridview);

	}

	@Override
	protected void initView() {
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels;
		NewAdapter adapter = new NewAdapter(SearchItemInfoActivity.this,
				width / 2);
		gridView.setAdapter(adapter);

	}

	@Override
	protected void result(String result) {

	}

}
