package com.example.android_intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * 
 * @author taoweiwei
 * 创建该类之后，虚创建对应的布局文件，other.xml
 */
public class OtherActivity extends Activity {
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//初始化Activity布局
		setContentView(R.layout.others);
		textView=(TextView)this.findViewById(R.id.msg);
		//获取Intent，接收数据
		int age=getIntent().getIntExtra("age", 0);
		String name=getIntent().getStringExtra("name");
		String address=getIntent().getStringExtra("address");
		textView.setText(" name--->"+name+"\n age--->"+age+"\n address--->"+address);
	}

}
