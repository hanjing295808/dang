package cn.tedu.gank.entity;

import java.util.List;

public class ArticleResult {
	private String error;
	private List<Article> results;
	public ArticleResult() {
		super();
	}
	public ArticleResult(String error, List<Article> results) {
		super();
		this.error = error;
		this.results = results;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<Article> getResults() {
		return results;
	}
	public void setResults(List<Article> results) {
		this.results = results;
	}
}
