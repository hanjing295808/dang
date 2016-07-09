package cn.tedu.gank.adapter;

import java.util.List;

import cn.tedu.gank.R;
import cn.tedu.gank.entity.Article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArticleAdapter extends BaseAdapter{
	private List<Article> articles;
	private Context context;
	private LayoutInflater inflater;
	public ArticleAdapter(List<Article> articles,Context context){
		this.articles=articles;
		this.context=context;
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
			holder.tvDesc=(TextView) convertView.findViewById(R.id.tv_content);
			holder.tvAuthor=(TextView) convertView.findViewById(R.id.tv_author_content);
			holder.tvPublish=(TextView) convertView.findViewById(R.id.tv_publish_content);
			convertView.setTag(holder);
		}
			holder=(ViewHolder) convertView.getTag();
			Article article=getItem(position);
			holder.tvDesc.setText(article.getDesc());
			holder.tvAuthor.setText(article.getWho());
			holder.tvPublish.setText(article.getPublishedAt());

			return convertView;
	}
	class ViewHolder{
		TextView tvDesc;
		TextView tvAuthor;
		TextView tvPublish;
	}
}
