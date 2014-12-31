package com.velvol.o2o.ui.make;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.velvol.o2o.R;

public class DialogMap {
	public Dialog dialog;

	public View showDitu(Activity activity, double jingdu, double weidu) {
		if(dialog != null)
			dialog.cancel();
		View layout = LayoutInflater.from(activity).inflate(
				R.layout.dialog_shopdetails, null);
		MapView mMapView = (MapView) layout.findViewById(R.id.bmapView);
		ImageView dingwei = (ImageView) layout.findViewById(R.id.iv_map);
		
		final BaiduMap mBaiduMap = mMapView.getMap();
		
		// ������ͨͼ
		mBaiduMap.setTrafficEnabled(false);
		// ����Maker�����
		LatLng point = new LatLng(weidu, jingdu);
		// ����Markerͼ��
		BitmapDescriptor bitmap = BitmapDescriptorFactory
				.fromResource(R.drawable.address);
		// ����MarkerOption�������ڵ�ͼ�����Marker
		final OverlayOptions option = new MarkerOptions().position(point).icon(
				bitmap);
		// �ڵ�ͼ�����Marker������ʾ
		mBaiduMap.addOverlay(option);
		
		// ���ñ����� 15��ʾ�����߼���
		final MapStatusUpdate msu = MapStatusUpdateFactory.newLatLngZoom(point,
				15);
		mBaiduMap.setMapStatus(msu);
		dingwei.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// ���¶�λ
				mBaiduMap.setMapStatus(msu);
			}
		});

		dialog = new Dialog(activity, R.style.dialog);
		dialog.setContentView(layout);
		dialog.setCanceledOnTouchOutside(true);
		dialog.show();
		return layout;
	}

}
