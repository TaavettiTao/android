package com.android;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

public class OtherActivity extends Activity {
	
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
		
		textView=(TextView)this.findViewById(R.id.msg);
		/**
		 * 第一种方式：接收剪切板简单变量传递的数据
		 */
		/*if(android.os.Build.VERSION.SDK_INT>11){//API11之后
			ClipboardManager clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
			ClipData clipData=(ClipData)clipboardManager.getPrimaryClip();
			Item item=(Item)clipData.getItemAt(0);
			textView.setText(item.getText());
		}else{//API11之前
			ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
			textView.setText(clipboardManager.getText());
		}*/
		
		/**
		 * 第二种方式：接收传递的序列化的对象
		 */
		//从剪切板获取数据
		String dataStr="";
		if(android.os.Build.VERSION.SDK_INT>11){//API11之后
				ClipboardManager clipboardManager=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
				ClipData clipData=(ClipData)clipboardManager.getPrimaryClip();
				Item item=(Item)clipData.getItemAt(0);
				dataStr=(String) item.getText();
		}else{//API11之前
			ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
			dataStr=(String) clipboardManager.getText();
		}
		//将获取的数据字符串转换为对象
		byte[] buf=Base64.decode(dataStr.getBytes(), Base64.DEFAULT);
		ByteArrayInputStream inputStream=new ByteArrayInputStream(buf);
		ObjectInputStream objectInputStream=null;
	    try {
			objectInputStream=new ObjectInputStream(inputStream);
		    MyData myData=(MyData)objectInputStream.readObject();
		    textView.setText(myData.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
