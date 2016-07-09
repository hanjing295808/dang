package com.tarena.api.presenter.impl;

import java.util.List;

import android.util.Log;

import com.tarena.api.entity.Article;
import com.tarena.api.model.IModel.Callback;
import com.tarena.api.model.impl.ModelArt;
import com.tarena.api.presenter.IPresenter;
import com.tarena.api.view.IArtView;

public class PresenterArt implements IPresenter{
	private ModelArt modelArt;
	private IArtView view;
	public PresenterArt(IArtView view){
		this.view=view;
		modelArt=new ModelArt();
	}
	@Override
	public void loadData() {
		Log.i("info","PresenterArt ---> ");
		modelArt.getData(new Callback() {		
			@Override
			public void loadArticle(Object obj) {
				Log.i("info","PresenterArt ---> loadArticle");
				List<Article> articles=(List<Article>) obj;
				view.showData(articles);
				Log.i("info","PresenterArt === > loadArticle");
			}
		});
		Log.i("info","PresenterArt ===> ");
	}

}
