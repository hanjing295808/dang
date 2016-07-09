package com.tarena.api.adapter;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tarena.api.R;
import com.tarena.api.entity.Article;

public class ArticleAdapter extends BaseAdapter{
	private Context context;
	private List<Article> articles;
	private LayoutInflater inflater;
	public ArticleAdapter(Context context, List<Article> articles) {
		super();
		this.context = context;
		this.articles = articles;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return articles.size();
	}

	@Override
	public Article getItem(int position) {
		// TODO Auto-generated method stub
		return articles.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.item_content,null);
			holder=new ViewHolder();
			holder.tvDesc=(TextView) convertView.findViewById(R.id.tv_desc_content);
			holder.tvAuthor=(TextView) convertView.findViewById(R.id.tv_author_content);
			holder.tvPubAt=(TextView) convertView.findViewById(R.id.tv_data_publish);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
			Article art=getItem(position);
			holder.tvDesc.setText(art.getDesc());
			holder.tvAuthor.setText(art.getWho());
			holder.tvPubAt.setText(art.getPublishedAt());
		return convertView;
	}
	
	class ViewHolder{
		TextView tvDesc;
		TextView tvAuthor;
		TextView tvPubAt;
	}
}


















