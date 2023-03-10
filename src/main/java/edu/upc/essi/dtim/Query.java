package edu.upc.essi.dtim;

/**
 The Query class represents a query made by a user on one or more graphs.
 Each Query object contains a SPARQL query string and a list of associated graphs.
 The results of the query are stored in a QueryResult object.
 */
public class Query {
    private String queryId;
    private String queryText;
    private User user;

    /**
     * Creates a new instance of the Query class with the specified SPARQL query string.
     *
     * @param queryId
     * @param queryText the SPARQL query string to be executed
     * @param user the owner of the query
     */
    public Query(String queryId, String queryText, User user) {
        this.queryId = queryId;
        this.queryText = queryText;
        this.user = user;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
