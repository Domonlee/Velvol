package com.velvol.o2o.ui.find;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

//����ƴ������
public class FoundMargeRoomActivity extends BaseActivity {
	// ��������
	private Button button;
	// ���뷿��
	private Button button1;
	// ��ô����ķ����
	private String textRoomNumber;
	private EditText found_marge_number_editText;
	// ���ذ�ť
	private ImageView found_marge_number_return_imageview;
	// ���еı���
	private TextView title_topbar_tv;
	// �ұߵı���
	private TextView title_topbar_right_tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_found_marge_room);
		findViewById();
		initView();

	}

	@Override
	protected void findViewById() {
		found_marge_number_editText = (EditText) findViewById(R.id.found_marge_number_editText);
		button = (Button) findViewById(R.id.found_buttom);
		button1 = (Button) findViewById(R.id.found_buttom1);
		found_marge_number_return_imageview = (ImageView) findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv = (TextView) findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv = (TextView) findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("����ƴ������");
		button.setOnClickListener(clickListener);
		button1.setOnClickListener(clickListener);
		found_marge_number_return_imageview.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			// ���������÷����
			case R.id.found_buttom:
				textRoomNumber = found_marge_number_editText.getText()
						.toString();
				if (textRoomNumber != "" && isMobileNO(textRoomNumber)) {
					Intent intent = new Intent(FoundMargeRoomActivity.this,
							RoomNumberActivity.class);
					intent.putExtra("roomNumber", textRoomNumber);
					startActivity(intent);
				} else {
					Toast.makeText(FoundMargeRoomActivity.this,
							"��������ȷ��4λ����ţ��磨1234��", 1).show();
				}
				break;
			// ���뷿���÷����
			case R.id.found_buttom1:
				textRoomNumber = found_marge_number_editText.getText()
						.toString();
				if (textRoomNumber != "" && isMobileNO(textRoomNumber)) {
					Intent intent = new Intent(FoundMargeRoomActivity.this,
							MargeActivity.class);
					intent.putExtra("roomNumber", textRoomNumber);
					startActivity(intent);
				} else {
					Toast.makeText(FoundMargeRoomActivity.this,
							"��������ȷ��4λ����ţ��磨1234��", 1).show();
				}
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};

	// ������ʽ��֤����(0-9)����λ����
	public static boolean isMobileNO(String mobiles) {
//		^[0-9]{4}$
		Pattern p = Pattern.compile("[0123456789]{4}");
		Matcher m = p.matcher(mobiles);
		Log.i("�������Ƿ�����", m.matches() + "");
		return m.matches();
	}

	@Override
	protected void result(String result) {
	}

}
