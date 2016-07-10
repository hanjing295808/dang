package cn.tedu.android_day0710_servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service{
	//MyBinder binder;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		// binder=new MyBinder();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	@Override
	public IBinder onBind(Intent intent) {
		MyBinder binder=new MyBinder();
		Log.i("info","myBinder --> ");
		return binder;
	}
	
	class MyBinder extends Binder implements IPlayMusic{
		public TestService getService(){
			return TestService.this;
		}
		@Override
		public int play(int a,int b) {
				
			return a+b;
		}

		@Override
		public void pause() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void seekTo() {
			// TODO Auto-generated method stub
			
		}
		
	}
}
