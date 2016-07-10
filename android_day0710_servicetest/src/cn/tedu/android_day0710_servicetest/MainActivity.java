package cn.tedu.android_day0710_servicetest;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.tedu.android_day0710_servicetest.TestService.MyBinder;

public class MainActivity extends Activity implements OnClickListener{
	private Button btnBind;
	private Button btnUnbind;
	private IPlayMusic binder;
	private ServiceConnection conn;
	private boolean isBind;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnBind=(Button) findViewById(R.id.button1);
		btnUnbind=(Button) findViewById(R.id.button2);
		btnBind.setOnClickListener(this);
		btnUnbind.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class MyService implements ServiceConnection{
		
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			//当已经与service建立连接
			TestService.MyBinder binder=(MyBinder) service;
			Log.i("info","play --> "+binder.play(3,5));
			Log.i("info", "service --> "+binder.getInterfaceDescriptor());
			Log.i("info","service ===> "+binder.getService().toString());
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void onClick(View v) {
		int flag=BIND_AUTO_CREATE;
		switch(v.getId()){
		case R.id.button1:
			Intent intent=new Intent(this,TestService.class);
			conn=new MyService();
			bindService(intent,conn,flag);
			isBind=true;
			Log.i("info","绑定service --> ");
			break;
		case R.id.button2:
			if(isBind){
				unbindService(conn);				
			}
			isBind=false;
			Log.i("info","解除绑定service-->");
			break;
		}
		
	}

}
