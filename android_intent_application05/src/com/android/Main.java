package com.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * @author taoweiwei
 * 使用全局变量传递数据
 *
 */
public class Main extends Activity {
	
	private Button button;
	//全局对象
	private MyApp myApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button=(Button)this.findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				myApp=(MyApp)getApplication();//获取全局对象
				myApp.setName("jack");
				Intent intent=new Intent(getBaseContext(),OtherActivity.class);
				startActivity(intent);
			}
		});
	}
}
