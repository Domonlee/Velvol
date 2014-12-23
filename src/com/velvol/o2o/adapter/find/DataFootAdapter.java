package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.velvol.o2o.R;
//���ݲ���listview
public class DataFootAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater inflater;
	public DataFootAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.listview_datafoot_item, null);
			holder=new ViewHolder();
			holder.day=(TextView)convertView.findViewById(R.id.data_food_day_textview);
			holder.explain=(TextView)convertView.findViewById(R.id.data_food_explain_textview);
			holder.left=(ImageView)convertView.findViewById(R.id.data_foot_left_imageview);
			holder.right=(ImageView)convertView.findViewById(R.id.data_foot_right_imageview1);
			holder.selectedPicture1=(ImageView)convertView.findViewById(R.id.data_foot_selected_picture1_imageview);
			holder.footPicture1=(ImageView)convertView.findViewById(R.id.data_foot_picture1_imageview);
			holder.footName1=(TextView)convertView.findViewById(R.id.data_foot_name1_textview);
			holder.selectedPicture2=(ImageView)convertView.findViewById(R.id.data_foot_selected_picture2_imageview);
			holder.footPicture2=(ImageView)convertView.findViewById(R.id.data_foot_picture2_imageview);
			holder.footName2=(TextView)convertView.findViewById(R.id.data_foot_name2_textview);
			holder.selectedPicture3=(ImageView)convertView.findViewById(R.id.data_foot_selected_picture3_imageview);
			holder.footPicture3=(ImageView)convertView.findViewById(R.id.data_foot_picture3_imageview);
			holder.footName3=(TextView)convertView.findViewById(R.id.data_foot_name3_textview);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	class ViewHolder{
		//day������
		TextView day;
		//��������
		TextView explain;
		//��߻�
		ImageView left;
		//�ұ߻�
		ImageView right;
		//ѡ�еĲ�ƷԲȦ
		ImageView selectedPicture1;
		//ѡ�в�Ʒ��ͼƬ
		ImageView footPicture1;
		//ѡ�в�Ʒ������
		TextView footName1;

		//ѡ�еĲ�Ʒ2
		ImageView selectedPicture2;
		//ѡ�в�Ʒ��ͼƬ2
		ImageView footPicture2;
		//ѡ�в�Ʒ������2
		TextView footName2;

		//ѡ�еĲ�Ʒ3
		ImageView selectedPicture3;
		//ѡ�в�Ʒ��ͼƬ3
		ImageView footPicture3;
		//ѡ�в�Ʒ������3
		TextView footName3;
	}
}
