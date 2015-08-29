package com.example.android_lifedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
/**
 * 
 * @author taoweiwei
 * 测试android的生命周期
 * 日志，info级别：Log.i(TAG, "onCreate method is executed!");
 */
public class Main extends Activity {
	
	//标志
	private final String TAG="Main";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate method is executed!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		Log.i(TAG, "onStart method is executed!");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, "onRestart method is executed!");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, "onResume method is executed!");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, "onPause method is executed!");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, "onStop method is executed!");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy method is executed!");
		super.onDestroy();
	}
	
	
}
