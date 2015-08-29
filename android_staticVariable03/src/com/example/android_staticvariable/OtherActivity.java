package com.example.android_staticvariable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView textView; 
	
	//定义静态变量接收数据,必须定义成public，否则不可见
	public static String name;
	public static Integer age;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		
		textView=(TextView)this.findViewById(R.id.msg);
		textView.setText("name-->"+name+",age-->"+age);
	}

}
