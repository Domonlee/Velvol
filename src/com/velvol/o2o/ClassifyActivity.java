package com.velvol.o2o;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ClassifyActivity extends Activity {

	
	//�̼ҷ���
	private TextView pinzhong;
	private ImageView return1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify);
		return1 = (ImageView) findViewById(R.id.classify_return);
		pinzhong = (TextView) findViewById(R.id.textView1);
		//����������
		Intent i = getIntent();
		String extra = i.getStringExtra("classify");
		pinzhong.setText(extra);
		//����
		return1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.classify, menu);
		return true;
	}

}
