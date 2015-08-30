package com.android;

import android.app.Application;
/**
 * 
 * @author taoweiwei
 * 全局对象，一个应用只存在一个Application对象
 * 如果自身应用中定义了全局对象，需要在AndroidManifest.xml文件的<application/>标签中定义
 * 如：
 * <application android:name=".MyApp" ..../>
 * 
 */
public class MyApp extends Application {
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 应用启动时初始化
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		setName("xiaoming");
	}

}
