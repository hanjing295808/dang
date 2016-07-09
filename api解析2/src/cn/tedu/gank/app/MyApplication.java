package cn.tedu.gank.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application{
	private MyApplication context;
	private static RequestQueue queue;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context=this;
		queue=Volley.newRequestQueue(context);
	}
	public MyApplication getContext(){
		return context;
	}
	public static RequestQueue getQueue(){
		return queue;
	}
}
