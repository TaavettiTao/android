package com.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView textView;
	
	private MyApp myApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		myApp=(MyApp)getApplication();//获取全局对象
		textView=(TextView)this.findViewById(R.id.msg);
		textView.setText(myApp.getName());
	}

}
