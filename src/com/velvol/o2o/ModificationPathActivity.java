package com.velvol.o2o;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Spinner;

public class ModificationPathActivity extends Activity {

	//更改地址界面
	private Spinner sheng;
	private Spinner shi;
	private Spinner qu;
	private Spinner jie;
	private Spinner xiaoqu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modification_path);
		sheng = (Spinner) findViewById(R.id.spinner1);
		shi = (Spinner) findViewById(R.id.spinner2);
		qu = (Spinner) findViewById(R.id.spinner3);
		jie = (Spinner) findViewById(R.id.spinner4);
		xiaoqu = (Spinner) findViewById(R.id.spinner5);
		sheng.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}
		});
		shi.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}
		});
		jie.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}
		});
		xiaoqu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
			}
		});
		findViewById(R.id.modification_return).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				finish();
			}
		});
	}

}
