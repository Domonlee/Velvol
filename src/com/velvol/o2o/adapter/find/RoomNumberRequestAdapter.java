package com.velvol.o2o.adapter.find;



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

import com.velvol.o2o.R;
//请求加入房间
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class RoomNumberRequestAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater inflater;
	
	
	public RoomNumberRequestAdapter(Context context){
		this.context=context;
		 inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		 ViewHolder holder = null;
		if(convertView==null){
		   convertView=inflater.inflate(R.layout.listview_room_requestitem_item, null);
		   holder=new ViewHolder();
		   holder.requesOk=(Button) convertView.findViewById(R.id.room_ok_button);
		   holder.requesNo=(Button) convertView.findViewById(R.id.room_no_button);
		   holder.requestTag = (TextView) convertView.findViewById(R.id.room_request_tag_textview);
		   holder.requestName = (TextView) convertView.findViewById(R.id.room_request_name_textview);
		   convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		listener(holder.requesOk,holder.requesNo,holder.requestTag);
		return convertView;
	}
	 private void listener(final Button requesOk,final Button requesNo, final TextView requestTag) {
		 // TODO Auto-generated method stub
		 final String consent="已加入";
		 final String heat="被拒绝加入";
		 requesOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				requestTag.setText(consent);
				requesOk.setVisibility(View.GONE);
				requesNo.setVisibility(View.GONE);
			}
		});
		 requesNo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					requestTag.setText(heat);
					requesOk.setVisibility(View.GONE);
					requesNo.setVisibility(View.GONE);
				}
			});
	}
	class ViewHolder{
	    TextView requestName;
        TextView requestTag;
		Button requesOk;
		Button requesNo;
	}
}
