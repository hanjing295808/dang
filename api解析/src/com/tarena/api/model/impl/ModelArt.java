package com.tarena.api.model.impl;

import java.util.List;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tarena.api.app.MyApplication;
import com.tarena.api.entity.Article;
import com.tarena.api.entity.QueryResult;
import com.tarena.api.model.IModelArt;

public class ModelArt implements IModelArt{
	private List<Article> articles;
	@Override
	public void getData(final Callback callback) {
		RequestQueue queue=Volley.newRequestQueue(MyApplication.getContext());
		String url="http://gank.io/api/data/Android/10/1";
		StringRequest sr=new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Log.i("info","------------>");
				Log.i("info","response --> "+response);
				Gson gson = new Gson();
				QueryResult result=gson.fromJson(response, QueryResult.class);			
				articles=result.getResults();
				Log.i("info","response --> article "+articles);
				callback.loadArticle(articles);				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("info","error --> "+error.getMessage());
			}
		});
		queue.add(sr);
	}
}
