package cn.tedu.gank.model.impl;

import java.util.List;

import android.util.Log;
import cn.tedu.gank.app.MyApplication;
import cn.tedu.gank.entity.Article;
import cn.tedu.gank.entity.ArticleResult;
import cn.tedu.gank.model.IModelArt;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

public class ModelImpl implements IModelArt{
	private RequestQueue queue;
	private List<Article> articles;
	@Override
	public void loadData(final Callback callback) {
		queue=MyApplication.getQueue();
		String url="http://gank.io/api/data/Android/10/1";
		StringRequest sr=new StringRequest(url, new Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.i("info","response --> "+response);
						Gson gson=new Gson();
						ArticleResult result=gson.fromJson(response, ArticleResult.class);
						articles=result.getResults();
						Log.i("info", "article --> "+articles);
						callback.onSuccess(articles);
					}
		},new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("info", "errorMessage --> "+error.getMessage());
			}
		});
		queue.add(sr);
	}

}
