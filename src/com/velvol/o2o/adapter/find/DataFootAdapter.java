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
import android.widget.TextView;

import com.velvol.o2o.R;
//数据餐饮listview
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.listview_datafoot_item, null);
			holder=new ViewHolder();
			holder.day=(TextView)convertView.findViewById(R.id.data_food_day_textview);
			holder.left=(ImageView)convertView.findViewById(R.id.data_foot_left_imageview);
			holder.right=(ImageView)convertView.findViewById(R.id.data_foot_right_imageview1);
			holder.selectedPicture1=(CheckBox)convertView.findViewById(R.id.data_foot_selected_picture1_checkbox);
			holder.footPicture1=(ImageView)convertView.findViewById(R.id.data_foot_picture1_imageview);
			holder.footName1=(TextView)convertView.findViewById(R.id.data_foot_name1_textview);
			holder.selectedPicture2=(CheckBox)convertView.findViewById(R.id.data_foot_selected_picture2_checkbox);
			holder.footPicture2=(ImageView)convertView.findViewById(R.id.data_foot_picture2_imageview);
			holder.footName2=(TextView)convertView.findViewById(R.id.data_foot_name2_textview);
			holder.selectedPicture3=(CheckBox)convertView.findViewById(R.id.data_foot_selected_picture3_checkbox);
			holder.footPicture3=(ImageView)convertView.findViewById(R.id.data_foot_picture3_imageview);
			holder.footName3=(TextView)convertView.findViewById(R.id.data_foot_name3_textview);
			holder.explain = (TextView)convertView.findViewById(R.id.data_food_explain_textview);
			convertView.setTag(holder);
		}else {
			holder=(ViewHolder) convertView.getTag();
		}
		setlistener(holder.explain,holder.selectedPicture1,holder.selectedPicture2,holder.selectedPicture3,position);
		return convertView;
	}
	class ViewHolder{
		//day上下午
		TextView day;
		//评价内容
		TextView explain;
		//左边滑
		ImageView left;
		//右边滑
		ImageView right;
		//选中的菜品圆圈
		CheckBox selectedPicture1;
		//选中菜品的图片
		ImageView footPicture1;
		//选中菜品的名字
		TextView footName1;
		//选中的菜品2
		CheckBox selectedPicture2;
		//选中菜品的图片2
		ImageView footPicture2;
		//选中菜品的名字2
		TextView footName2;
		//选中的菜品3
		CheckBox selectedPicture3;
		//选中菜品的图片3
		ImageView footPicture3;
		//选中菜品的名字3
		TextView footName3;
	}
	//先通过Item下标判断修改计数变量heat
	private void setlistener(final TextView explain,final CheckBox selectedPicture1,final CheckBox selectedPicture2,final CheckBox selectedPicture3,final int position) {

		switch (position) {
		case 0:
			selectedPicture1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					if(isChecked){
						heat+=500;
						Log.i("热量1", heat+"");
						String exceed="摄入了"+heat+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat+"卡。";
						explain.setText(heat<1000?normal:exceed);
					}else{
						heat-=500;
						Log.i("热量1", heat+"");
						String exceed="摄入了"+heat+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat+"卡。";
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
						Log.i("热量2", heat+"");
						String exceed="摄入了"+heat+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat+"卡。";
						explain.setText(heat<1000?normal:exceed);
					}else{
						heat-=500;
						Log.i("热量2", heat+"");
						String exceed="摄入了"+heat+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat+"卡。";
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
						Log.i("热量3", heat+"");
						String exceed="摄入了"+heat+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat+"卡。";
						explain.setText(heat<1000?normal:exceed);
					}else{
						heat-=500;
						Log.i("热量3", heat+"");
						String exceed="摄入了"+heat+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat+"卡。";
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
						Log.i("热量1", heat1+"");
						String exceed="摄入了"+heat1+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat1+"卡。";
						explain.setText(heat1<1000?normal:exceed);
					}else{
						heat1-=500;
						Log.i("热量1", heat1+"");
						String exceed="摄入了"+heat1+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat1+"卡。";
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
						Log.i("热量2", heat1+"");
						String exceed="摄入了"+heat1+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat1+"卡。";
						explain.setText(heat1<1000?normal:exceed);
					}else{
						heat1-=500;
						Log.i("热量2", heat1+"");
						String exceed="摄入了"+heat1+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat1+"卡。";
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
						Log.i("热量3", heat1+"");
						String exceed="摄入了"+heat1+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat1+"卡。";
						explain.setText(heat1<1000?normal:exceed);
					}else{
						heat1-=500;
						Log.i("热量3", heat1+"");
						String exceed="摄入了"+heat1+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat1+"卡。";
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
						Log.i("热量1", heat2+"");
						String exceed="摄入了"+heat2+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat2+"卡。";
						explain.setText(heat2<1000?normal:exceed);
					}else{
						heat2-=500;
						Log.i("热量1", heat2+"");
						String exceed="摄入了"+heat2+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat2+"卡。";
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
						Log.i("热量2", heat2+"");
						String exceed="摄入了"+heat2+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat2+"卡。";
						explain.setText(heat2<1000?normal:exceed);
					}else{
						heat2-=500;
						Log.i("热量2", heat2+"");
						String exceed="摄入了"+heat2+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat2+"卡。";
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
						Log.i("热量3", heat2+"");
						String exceed="摄入了"+heat2+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat2+"卡。";
						explain.setText(heat2<1000?normal:exceed);
					}else{
						heat2-=500;
						Log.i("热量3", heat2+"");
						String exceed="摄入了"+heat2+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat2+"卡。";
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
						Log.i("热量1", heat3+"");
						String exceed="摄入了"+heat3+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat3+"卡。";
						explain.setText(heat3<1000?normal:exceed);
					}else{
						heat3-=500;
						Log.i("热量1", heat3+"");
						String exceed="摄入了"+heat3+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat3+"卡。";
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
						Log.i("热量2", heat3+"");
						String exceed="摄入了"+heat3+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat3+"卡。";
						explain.setText(heat3<1000?normal:exceed);
					}else{
						heat3-=500;
						Log.i("热量2", heat3+"");
						String exceed="摄入了"+heat3+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat3+"卡。";
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
						Log.i("热量3", heat3+"");
						String exceed="摄入了"+heat3+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat3+"卡。";
						explain.setText(heat3<1000?normal:exceed);
					}else{
						heat3-=500;
						Log.i("热量3", heat3+"");
						String exceed="摄入了"+heat3+"卡，你有超标哦，正常饮食从点滴做起。";
						String normal="摄入了"+heat3+"卡。";
						explain.setText(heat3<1000?normal:exceed);
					}
				}
			});
			break;
		}
	}
}

