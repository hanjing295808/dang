package cn.tena.android_0616_viewpager;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity implements OnClickListener{
	private Button btn;
	private long lastBackTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		Animation animation1=AnimationUtils.loadAnimation(this, R.anim.rotate);
		btn=(Button) findViewById(R.id.button1);
		btn.startAnimation(animation1);
		btn.setOnClickListener(this);
		//�ж��Ƿ�����
		haveNet(getBaseContext());
		Handler handler=new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent intent=new Intent(FirstActivity.this,MainActivity.class);
				startActivity(intent);
			}
		}, 5000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1:
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
			break;
			
		}
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (System.currentTimeMillis() - lastBackTime < 2000) {
				finish();
			}
			lastBackTime = System.currentTimeMillis();
			Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT).show();
		}
		return true;
	}
	
	//�ж������������	
    public boolean haveNet(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null) {
        	Toast.makeText(this, "���������Ƿ�����������", Toast.LENGTH_SHORT).show();
            return false;
        }

        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null || !ni.isAvailable()) {
        	Toast.makeText(this, "���������Ƿ�����������", Toast.LENGTH_SHORT).show();
        	return false;
        }
        Toast.makeText(this,"����������������������", Toast.LENGTH_SHORT).show();
        return true;
    }

}
