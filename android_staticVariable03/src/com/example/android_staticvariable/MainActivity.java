package com.example.android_staticvariable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button=(Button)this.findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener (){
			@Override
			public void onClick(View v) {
				//创建意图
				Intent intent=new Intent();
				intent.setClass(getBaseContext(),OtherActivity.class);
				OtherActivity.age=21;
				OtherActivity.name="android";
				//启动意图
				startActivity(intent);
			}
			
		});
		
		
	}
}
