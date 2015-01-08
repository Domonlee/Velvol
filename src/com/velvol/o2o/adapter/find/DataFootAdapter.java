package com.velvol.o2o.adapter.find;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.velvol.o2o.R;
//���ݲ���listview
public class DataFootAdapter extends BaseAdapter{

	private Context context;
	private LayoutInflater inflater;
	private int heat;
	private int heat1;
	private int heat2;
	private int heat3;
	public DataFootAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressWarnings("null")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		convertView=inflater.inflate(R.layout.listview_datafoot_item, null);
		holder=new ViewHolder();
		if(convertView==null){
			holder.day=(TextView)convertView.findViewById(R.id.data_food_day_textview);
			holder.left=(ImageView)convertView.findViewById(R.id.data_foot_left_imageview);
			holder.right=(ImageView)convertView.findViewById(R.id.data_foot_right_imageview1);
//			holder.selectedPicture1=(CheckBox)convertView.findViewById(R.id.data_foot_selected_picture1_checkbox);
//			holder.footPicture1=(ImageView)convertView.findViewById(R.id.data_foot_picture1_imageview);
//			holder.footName1=(TextView)convertView.findViewById(R.id.data_foot_name1_textview);
//			holder.selectedPicture2=(CheckBox)convertView.findViewById(R.id.data_foot_selected_picture2_checkbox);
//			holder.footPicture2=(ImageView)convertView.findViewById(R.id.data_foot_picture2_imageview);
//			holder.footName2=(TextView)convertView.findViewById(R.id.data_foot_name2_textview);
//			holder.selectedPicture3=(CheckBox)convertView.findViewById(R.id.data_foot_selected_picture3_checkbox);
//			holder.footPicture3=(ImageView)convertView.findViewById(R.id.data_foot_picture3_imageview);
//			holder.footName3=(TextView)convertView.findViewById(R.id.data_foot_name3_textview);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		TextView explain = (TextView)convertView.findViewById(R.id.data_food_explain_textview);
		//��̬���벼��
		addview(convertView);
		//����
//		setlistener(explain,selectedPicture1,selectedPicture2,selectedPicture3,position);
		return convertView;
	}
	private void addview(View convertView) {
		LinearLayout foot=(LinearLayout)convertView.findViewById(R.id.datafoot_linearlayout);
		View view=inflater.inflate(R.layout.view_datafoot, null);
		View view2=inflater.inflate(R.layout.view_datafoot, null);
		View view3=inflater.inflate(R.layout.view_datafoot, null);
		//ʳ������
		TextView footName1=(TextView) view.findViewById(R.id.data_foot_name1_textview);
		TextView footName2=(TextView) view2.findViewById(R.id.data_foot_name1_textview);
		TextView footName3=(TextView) view3.findViewById(R.id.data_foot_name1_textview);
		//ʳ��ͼƬ
		ImageView footPicture1=(ImageView) view.findViewById(R.id.data_foot_picture1_imageview);
		ImageView footPicture2=(ImageView) view2.findViewById(R.id.data_foot_picture1_imageview);
		ImageView footPicture3=(ImageView) view3.findViewById(R.id.data_foot_picture1_imageview);
		//ʳ��ѡ��ͼƬ
		CheckBox selectedPicture1 = (CheckBox)view.findViewById(R.id.data_foot_selected_picture1_checkbox);
		CheckBox selectedPicture2 = (CheckBox)view2.findViewById(R.id.data_foot_selected_picture1_checkbox);
		CheckBox selectedPicture3 = (CheckBox)view3.findViewById(R.id.data_foot_selected_picture1_checkbox);
		
		footName2.setText("��������");
		foot.addView(view);
		foot.addView(view2);
		foot.addView(view3);
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
//		CheckBox selectedPicture1;
		//ѡ�в�Ʒ��ͼƬ
//		ImageView footPicture1;
		//ѡ�в�Ʒ������
//		TextView footName1;
		//ѡ�еĲ�Ʒ2
//		CheckBox selectedPicture2;
		//ѡ�в�Ʒ��ͼƬ2
//		ImageView footPicture2;
		//ѡ�в�Ʒ������2
//		TextView footName2;
		//ѡ�еĲ�Ʒ3
//		CheckBox selectedPicture3;
		//ѡ�в�Ʒ��ͼƬ3
//		ImageView footPicture3;
		//ѡ�в�Ʒ������3
//		TextView footName3;
	}
	//��ͨ��Item�±��ж��޸ļ�������heat
	private void setlistener(final TextView explain,final CheckBox selectedPicture1,final CheckBox selectedPicture2,final CheckBox selectedPicture3,final int position) {

		switch (position) {
		case 0:
			selectedPicture1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat+=500;
						Log.i("����1", heat+"");
						String exceed="������"+heat+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat+"����";
						explain.setText(heat<1000?normal:exceed);
					}else{
						heat-=500;
						Log.i("����1", heat+"");
						String exceed="������"+heat+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat+"����";
						explain.setText(heat<1000?normal:exceed);
					}
				}
			});
			selectedPicture2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat+=500;
						Log.i("����2", heat+"");
						String exceed="������"+heat+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat+"����";
						explain.setText(heat<1000?normal:exceed);
					}else{
						heat-=500;
						Log.i("����2", heat+"");
						String exceed="������"+heat+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat+"����";
						explain.setText(heat<1000?normal:exceed);
					}
				}
			});
			selectedPicture3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat+=500;
						Log.i("����3", heat+"");
						String exceed="������"+heat+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat+"����";
						explain.setText(heat<1000?normal:exceed);
					}else{
						heat-=500;
						Log.i("����3", heat+"");
						String exceed="������"+heat+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat+"����";
						explain.setText(heat<1000?normal:exceed);
					}
				}
			});
			break;
		case 1:
			selectedPicture1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat1+=500;
						Log.i("����1", heat1+"");
						String exceed="������"+heat1+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat1+"����";
						explain.setText(heat1<1000?normal:exceed);
					}else{
						heat1-=500;
						Log.i("����1", heat1+"");
						String exceed="������"+heat1+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat1+"����";
						explain.setText(heat1<1000?normal:exceed);
					}
				}
			});
			selectedPicture2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat1+=500;
						Log.i("����2", heat1+"");
						String exceed="������"+heat1+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat1+"����";
						explain.setText(heat1<1000?normal:exceed);
					}else{
						heat1-=500;
						Log.i("����2", heat1+"");
						String exceed="������"+heat1+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat1+"����";
						explain.setText(heat1<1000?normal:exceed);
					}
				}
			});
			selectedPicture3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat1+=500;
						Log.i("����3", heat1+"");
						String exceed="������"+heat1+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat1+"����";
						explain.setText(heat1<1000?normal:exceed);
					}else{
						heat1-=500;
						Log.i("����3", heat1+"");
						String exceed="������"+heat1+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat1+"����";
						explain.setText(heat1<1000?normal:exceed);
					}
				}
			});
			break;
		case 2:
			selectedPicture1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat2+=500;
						Log.i("����1", heat2+"");
						String exceed="������"+heat2+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat2+"����";
						explain.setText(heat2<1000?normal:exceed);
					}else{
						heat2-=500;
						Log.i("����1", heat2+"");
						String exceed="������"+heat2+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat2+"����";
						explain.setText(heat2<1000?normal:exceed);
					}
				}
			});
			selectedPicture2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat2+=500;
						Log.i("����2", heat2+"");
						String exceed="������"+heat2+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat2+"����";
						explain.setText(heat2<1000?normal:exceed);
					}else{
						heat2-=500;
						Log.i("����2", heat2+"");
						String exceed="������"+heat2+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat2+"����";
						explain.setText(heat2<1000?normal:exceed);
					}
				}
			});
			selectedPicture3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat2+=500;
						Log.i("����3", heat2+"");
						String exceed="������"+heat2+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat2+"����";
						explain.setText(heat2<1000?normal:exceed);
					}else{
						heat2-=500;
						Log.i("����3", heat2+"");
						String exceed="������"+heat2+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat2+"����";
						explain.setText(heat2<1000?normal:exceed);
					}
				}
			});
			break;
		case 3:
			selectedPicture1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat3+=500;
						Log.i("����1", heat3+"");
						String exceed="������"+heat3+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat3+"����";
						explain.setText(heat3<1000?normal:exceed);
					}else{
						heat3-=500;
						Log.i("����1", heat3+"");
						String exceed="������"+heat3+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat3+"����";
						explain.setText(heat3<1000?normal:exceed);
					}
				}
			});
			selectedPicture2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat3+=500;
						Log.i("����2", heat3+"");
						String exceed="������"+heat3+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat3+"����";
						explain.setText(heat3<1000?normal:exceed);
					}else{
						heat3-=500;
						Log.i("����2", heat3+"");
						String exceed="������"+heat3+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat3+"����";
						explain.setText(heat3<1000?normal:exceed);
					}
				}
			});
			selectedPicture3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat3+=500;
						Log.i("����3", heat3+"");
						String exceed="������"+heat3+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat3+"����";
						explain.setText(heat3<1000?normal:exceed);
					}else{
						heat3-=500;
						Log.i("����3", heat3+"");
						String exceed="������"+heat3+"�������г���Ŷ��������ʳ�ӵ������";
						String normal="������"+heat3+"����";
						explain.setText(heat3<1000?normal:exceed);
					}
				}
			});
			break;
		}
	}
}

