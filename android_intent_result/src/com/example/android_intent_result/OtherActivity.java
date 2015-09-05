package com.example.android_intent_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OtherActivity extends Activity {
	private Button button;
	private EditText editResult;
	private TextView message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		button=(Button)this.findViewById(R.id.button);
		editResult=(EditText)this.findViewById(R.id.editResult);
		message=(TextView)this.findViewById(R.id.message);
		final Intent intent=getIntent();
		int a=Integer.parseInt(intent.getCharSequenceExtra("a").toString());
		int b=Integer.parseInt(intent.getCharSequenceExtra("b").toString());
		message.setText(a+"+"+b+"=?");
		System.out.println("result:"+editResult.getText().toString());
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				  intent.putExtra("result",editResult.getText().toString());
				  setResult(2,intent);//设置返回结果给Main,此处resultCode只要大于1即可，此处设置为2，那么Main中处理返回结果方法的resultCode必须等于2才能正常运行
				  finish();//结束当前Activity的生命周期
			}
		});
		
	}

}
