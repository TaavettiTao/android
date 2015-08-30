package com.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	    button=(Button)this.findViewById(R.id.button);
	    button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/**
				 * 第一种方式：剪切板简单变量传递
				 */
				/*//获取系统剪切板服务
				if(android.os.Build.VERSION.SDK_INT>11){//API 11之后,通过（ClipData）复制文本、Uri和Intent。
					//获取系统剪切板服务
					ClipboardManager clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
					ClipData clipData=ClipData.newPlainText("name","jack");
					clipboardManager.setPrimaryClip(clipData);
				}else{//API 11之前,Android剪切板只能复制文本（可以为复合文本）信息
					ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
					clipboardManager.setText("jack");
				}
				Intent intent=new Intent(getBaseContext(),OtherActivity.class);
				startActivity(intent);*/
				
				/**
				 * 第二种方式：传递序列化的对象
				 */
				//将对象转换成字符串
				ByteArrayOutputStream byteArrayOutputStream =new ByteArrayOutputStream();
				ObjectOutputStream objectOutputStream=null;
				String base64Str="";
				MyData myData=new MyData("jack",25);
				try {
					objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
					objectOutputStream.writeObject(myData);
					base64Str=Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//获取系统剪切板服务
				if(android.os.Build.VERSION.SDK_INT>11){//API 11之后,通过（ClipData）复制文本、Uri和Intent。
					//获取系统剪切板服务
					ClipboardManager clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
					ClipData clipData=ClipData.newPlainText("label",base64Str);
					clipboardManager.setPrimaryClip(clipData);
				}else{//API 11之前,Android剪切板只能复制文本（可以为复合文本）信息
					ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
					clipboardManager.setText(base64Str);
				}
				Intent intent=new Intent(getBaseContext(),OtherActivity.class);
				startActivity(intent);
			}
		});
	}
}
