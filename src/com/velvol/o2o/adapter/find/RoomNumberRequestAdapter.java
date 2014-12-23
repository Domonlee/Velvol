package com.velvol.o2o.adapter.find;

import java.util.List;

import com.velvol.o2o.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

//请求加入房间
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RoomNumberRequestAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private ViewHolder holder;

	public RoomNumberRequestAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(
					R.layout.listview_room_requestitem_item, null);
			holder = new ViewHolder();
			holder.requestName = (TextView) convertView
					.findViewById(R.id.room_request_name_textview);
			holder.requestTag = (TextView) convertView
					.findViewById(R.id.room_request_tag_textview);
			holder.requesOk = (Button) convertView
					.findViewById(R.id.room_ok_button);
			holder.requesNo = (Button) convertView
					.findViewById(R.id.room_no_button);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		setlister();
		return convertView;
	}

	class ViewHolder {
		TextView requestName;
		TextView requestTag;
		Button requesOk;
		Button requesNo;
	}

	private void setlister() {
		holder.requesOk.setOnClickListener(listener);
		holder.requesNo.setOnClickListener(listener);
	}

	View.OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.room_ok_button:
				holder.requestTag.setText("已加入");
				holder.requesOk.setAlpha(0);
				holder.requesNo.setAlpha(0);
				break;
			case R.id.room_no_button:
				holder.requestTag.setText("被拒绝加入...");
				holder.requesOk.setAlpha(0);
				holder.requesNo.setAlpha(0);
				break;
			}
		}
	};
}
