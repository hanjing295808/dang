package com.tarena.api.entity;

import java.util.List;

public class QueryResult {
	private String error;
	private List<Article> results;
	public QueryResult(String error, List<Article> results) {
		super();
		this.error = error;
		this.results = results;
	}
	public QueryResult() {
		super();
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
