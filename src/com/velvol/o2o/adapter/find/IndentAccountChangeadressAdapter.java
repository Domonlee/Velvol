package com.velvol.o2o.adapter.find;

import java.util.zip.Inflater;

import com.velvol.o2o.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class IndentAccountChangeadressAdapter extends BaseAdapter{

	Context context;
	LayoutInflater inflater;
	public IndentAccountChangeadressAdapter(Context context){
		this.context=context;
		this.inflater=LayoutInflater.from(context);
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
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.listview_indent_chageaddress_item, null);
			holder=new ViewHolder();
			holder.listview_indent_changeaddress_site_name_tv=(TextView) convertView.findViewById(R.id.listview_indent_changeaddress_site_name_tv);
			holder.listview_indent_changeaddress_site_tv=(TextView) convertView.findViewById(R.id.listview_indent_changeaddress_site_tv);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
		
	}
	class ViewHolder{
		//µÿ÷∑√˚≥∆
		TextView listview_indent_changeaddress_site_name_tv;
		//µÿ÷∑
		TextView listview_indent_changeaddress_site_tv;
	}

}
