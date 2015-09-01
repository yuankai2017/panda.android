package panda.android.lib.commonapp;

import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.TextView;

import panda.android.lib.R;
import panda.android.lib.base.ui.fragment.BaseFragment;

/**
 * 显示设备信息
 */
public class DeviceInfoFragment extends BaseFragment {

	TextView mViewDeviceInfo;

	@Override
	public int getLayoutId() {
		return R.layout.panda_fragment_device_info;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
        mViewDeviceInfo = (TextView) getView().findViewById(R.id.device_info);
		showDeviceInfo();
	}

	private void showDeviceInfo() {
		DisplayMetrics displayMetrics = new DisplayMetrics(); 
		Display display = getActivity().getWindowManager().getDefaultDisplay();
		display.getMetrics(displayMetrics); 
		
		String info = "";
		int width = display.getWidth();
		int height = display.getHeight();
		Point size = new Point();
		display.getSize(size);
		width = size.x;
		height = size.y;
		info += String.format("手机的屏幕像素大小为：%d×%d\n", width, height);
		info += String.format("手机的屏幕分辨率为：%d×%d\n", displayMetrics.widthPixels, displayMetrics.heightPixels);
		info += String.format("手机的每寸像素[dpi]为：%d\n", displayMetrics.densityDpi); //屏幕密度（每寸像素：120/160/240/320）  
		info += String.format("手机的像素比例为：%f\n", displayMetrics.density);  // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
		mViewDeviceInfo.setText(info);
	}

}
