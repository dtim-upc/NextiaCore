package edu.upc.essi.dtim.NextiaCore.datasources;

public class DataResource {
    public DataResource(String id) {
        this.id = id;
    }

    public DataResource() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
}
