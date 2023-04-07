package edu.upc.essi.dtim.Queries;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query {

	QueryResult queryResult;
	private String queryId;
	private String queryText;

	public Query(String queryId, String queryText) {
		this.queryId = queryId;
		this.queryText = queryText;
	}

}