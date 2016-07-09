package com.tarena.api.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.tarena.api.R;
import com.tarena.api.adapter.ArticleAdapter;
import com.tarena.api.entity.Article;
import com.tarena.api.presenter.IPresenter;
import com.tarena.api.presenter.impl.PresenterArt;
import com.tarena.api.view.IArtView;

public class MainActivity extends Activity implements IArtView{
	private ListView listView;
	private List<Article> articles;
	private ArticleAdapter adapter;
	private IPresenter prestener;
	public MainActivity(){
		prestener=new PresenterArt(this);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.listView1);
		//¼ÓÔØÊý¾Ý
		Log.i("info","MainActivity--> ");
		prestener.loadData();
		Log.i("info","MainActivity ==> ");
		//setAdapter();
		//showData(articles);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void showData(List<Article> articles) {
		Log.i("info", "articles --> "+articles);
		adapter=new ArticleAdapter(this, articles);
		listView.setAdapter(adapter);
	}
}
