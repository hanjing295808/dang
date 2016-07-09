package cn.tedu.gank.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.tedu.gank.R;
import cn.tedu.gank.adapter.ArticleAdapter;
import cn.tedu.gank.entity.Article;
import cn.tedu.gank.presenter.IPresenter;
import cn.tedu.gank.presenter.impl.PresenterArt;
import cn.tedu.gank.view.IView;

public class MainActivity extends Activity implements IView{
	private IPresenter presenter;
	private ArticleAdapter adapter;
	private ListView listView;
	private List<Article> articles;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.listView1);
		presenter=new PresenterArt(this);
		presenter.getData();
		setListener();
	}

	private void setListener() {
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Article article=articles.get(position);
				Intent intent=new Intent(MainActivity.this,ArticleActivity.class);
				intent.putExtra("article",article);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void showData(List<Article> articles) {
		this.articles=articles;
		adapter=new ArticleAdapter(articles, this);
		listView.setAdapter(adapter);
	}
}
