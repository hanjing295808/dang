package cn.tedu.gank.activity;

import cn.tedu.gank.R;
import cn.tedu.gank.R.layout;
import cn.tedu.gank.R.menu;
import cn.tedu.gank.entity.Article;
import cn.tedu.gank.ui.CircleImageView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.TextView;

public class ArticleActivity extends Activity {
	private TextView tvDesc;
	private TextView tvUrl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article);
		tvDesc=(TextView) findViewById(R.id.tv_desc);
		tvUrl=(TextView) findViewById(R.id.tv_url);
		Intent intent=getIntent();
		Article article=(Article) intent.getSerializableExtra("article");
		tvDesc.setText(article.getDesc());
		tvUrl.setText(article.getUrl());
		//Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.github);
		CircleImageView civ=new CircleImageView(this);
		civ.setBackgroundResource(R.drawable.github);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article, menu);
		return true;
	}

}
