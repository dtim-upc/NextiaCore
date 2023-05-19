package edu.upc.essi.dtim.NextiaCore.graph;

import java.util.Set;

public class LocalGraph extends Graph {
    private String graphicalSchema;

    public LocalGraph(String id, URI name, Set<Triple> triples, String graphicalSchema) {
        super(id, name, triples);
        this.graphicalSchema = graphicalSchema;
    }

    public LocalGraph() {
        super();
    }

    public String getGraphicalSchema() {
        return graphicalSchema;
    }

    public void setGraphicalSchema(String graphicalSchema) {
        this.graphicalSchema = graphicalSchema;
    }
}