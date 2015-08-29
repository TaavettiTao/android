package com.example.android_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 
 * @author taoweiwei
 * 主Activity
 *
 */
public class Main extends Activity {
	private Button button;

	/**
	 * Activity初始化函数
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//初始化该Activity布局
		setContentView(R.layout.main);
		//根据id获得按钮对,此时的this为Main类，即该布局对象在Main所在xml文件中寻找
		button=(Button)this.findViewById(R.id.button);
		//为button绑定单击事件，单击时向指定Activity传递数据
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//1、创建Intent:第一个参数为上下文对象，即当前窗口对象；第二个参数为目的窗口对象，即需要接收数据的Activity
				Intent intent=new Intent(getBaseContext(), OtherActivity.class);
				//2、设置传递的数据
				intent.putExtra("name","小明");
				intent.putExtra("age",21);
				intent.putExtra("address","北京");
				//3、启动意图
				startActivity(intent);
			}
		});
	}
}
