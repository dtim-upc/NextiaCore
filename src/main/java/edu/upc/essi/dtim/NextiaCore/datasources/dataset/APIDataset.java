package edu.upc.essi.dtim.NextiaCore.datasources.dataset;

public class APIDataset extends Dataset{
    String endpoint;

    public APIDataset(){
        super();
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
