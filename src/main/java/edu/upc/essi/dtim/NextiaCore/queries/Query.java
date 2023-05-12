package edu.upc.essi.dtim.NextiaCore.queries;

import lombok.Data;

@Data
public class Query {

	QueryResult queryResult;
	private String queryId;
	private String queryText;

	public Query(String queryId, String queryText) {
		this.queryId = queryId;
		this.queryText = queryText;
	}

}