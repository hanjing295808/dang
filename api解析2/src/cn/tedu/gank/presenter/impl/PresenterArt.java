package cn.tedu.gank.presenter.impl;

import java.util.List;

import cn.tedu.gank.entity.Article;
import cn.tedu.gank.model.IModel.Callback;
import cn.tedu.gank.model.IModelArt;
import cn.tedu.gank.model.impl.ModelImpl;
import cn.tedu.gank.presenter.IPresenter;
import cn.tedu.gank.view.IView;

public class PresenterArt implements IPresenter{
	private List<Article> articles;
	private IView view;
	private IModelArt model;
	public PresenterArt(IView view){
		this.view=view;
		model=new ModelImpl();
	}
	@Override
	public void getData() {
		model.loadData(new Callback() {
			
			@Override
			public void onSuccess(Object obj) {
				articles=(List<Article>) obj;
				view.showData(articles);
			}
		});
	}

}
