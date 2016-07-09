package com.tarena.api.app;

import android.app.Application;

public class MyApplication extends Application{
	private static MyApplication context;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context=this;
	}
	public static MyApplication getContext(){
		return context;
	}
}
