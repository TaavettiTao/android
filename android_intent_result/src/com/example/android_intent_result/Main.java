package com.example.android_intent_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 
 * @author taoweiwei
 * 定义可以接收返回结果的Activity
 */
public class Main extends Activity {
	
	private Button button;
	private EditText one,two,result;
	private static final int REQUESTCODE=1;//返回的结果码

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button=(Button)this.findViewById(R.id.button1);
		one=(EditText)this.findViewById(R.id.one);
		two=(EditText)this.findViewById(R.id.two);
		result=(EditText)this.findViewById(R.id.result);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getBaseContext(),OtherActivity.class);
				intent.putExtra("a", one.getText().toString());
				intent.putExtra("b", two.getText().toString());
				startActivityForResult(intent, REQUESTCODE);//表示可以接收返回结果
			}
		});
	}
	
	
	/**
	 * 如果该Activity需要接收返回结果，则必须覆写该方法；
	 * 如需对返回结果进行处理，在其中定义即可。
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==2){//返回结果正常
			if(requestCode==REQUESTCODE){
				String resultValue=(String) data.getCharSequenceExtra("result");
				result.setText(resultValue);
			}
		}
	}
}
