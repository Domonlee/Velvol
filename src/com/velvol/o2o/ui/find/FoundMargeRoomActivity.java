package com.velvol.o2o.ui.find;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.velvol.o2o.R;
import com.velvol.o2o.tool.BaseActivity;

//创建拼单房间
public class FoundMargeRoomActivity extends BaseActivity {
	//创建房间
	private Button button;
	//进入房间
	private Button button1;
	// 获得创建的房间号
	private String textRoomNumber;
	private EditText found_marge_number_editText;
	//返回按钮
	private ImageView found_marge_number_return_imageview;
	//正中的标题
	private TextView title_topbar_tv;
	//右边的标题
	private TextView title_topbar_right_tv;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		setContentView(R.layout.activity_found_marge_room);
		// Show the Up button in the action bar.
		findViewById();
		initView();

	}

	@Override
	protected void findViewById() {
		found_marge_number_editText = (EditText) findViewById(R.id.found_marge_number_editText);
		button = (Button) findViewById(R.id.found_buttom);
		button1 = (Button) findViewById(R.id.found_buttom1);
		found_marge_number_return_imageview=(ImageView)findViewById(R.id.title_topbar_back_iv);
		title_topbar_tv=(TextView)findViewById(R.id.title_topbar_tv);
		title_topbar_right_tv=(TextView)findViewById(R.id.review_people_name_textview);
	}

	@Override
	protected void initView() {
		title_topbar_tv.setText("创建拼单房间");
		button.setOnClickListener(clickListener);
		button1.setOnClickListener(clickListener);
		found_marge_number_return_imageview.setOnClickListener(clickListener);
	}

	View.OnClickListener clickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			//创建房间获得房间号
			case R.id.found_buttom:
				textRoomNumber = found_marge_number_editText.getText().toString();
				if(textRoomNumber!="" && isMobileNO(textRoomNumber)){
					Intent intent = new Intent(FoundMargeRoomActivity.this,
							RoomNumberActivity.class);
					intent.putExtra("roomNumber", textRoomNumber);
					startActivity(intent);
				}else{
					Toast.makeText(FoundMargeRoomActivity.this, "请输入真确的4位房间号，如（1234）", 1).show();
				}
				break;
				//加入房间获得房间号
			case R.id.found_buttom1:
				textRoomNumber = found_marge_number_editText.getText().toString();
				if(textRoomNumber!=""&&isMobileNO(textRoomNumber)){
					Intent intent=new Intent(FoundMargeRoomActivity.this, MargeActivity.class);
					intent.putExtra("roomNumber", textRoomNumber);
					startActivity(intent);
				}else{
					Toast.makeText(FoundMargeRoomActivity.this, "请输入真确的4位房间号，如（1234）", 1).show();
				}
				break;
			case R.id.title_topbar_back_iv:
				finish();
				break;
			}
		}
	};
	//正则表达式验证数字(0-9)的四位数字
	public static boolean isMobileNO(String mobiles){       
		Pattern p = Pattern.compile("[0123456789]{4}");       
		Matcher m = p.matcher(mobiles);   
		Log.i("正则表达是否满足", m.matches()+"");
		return m.matches();       
	}   

	@Override
	protected void result(String result) {
	}

}
