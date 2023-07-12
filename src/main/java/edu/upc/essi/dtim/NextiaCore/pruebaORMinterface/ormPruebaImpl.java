package edu.upc.essi.dtim.NextiaCore.pruebaORMinterface;

import org.apache.jena.rdf.model.Model;

public class ormPruebaImpl implements ormPrueba{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    private String graphicalSchema;
/*
    public Model getGraph() {
        return graph;
    }

    public void setGraph(Model graph) {
        this.graph = graph;
    }

    private transient Model graph;

 */

    @Override
    public String getGraphicalSchema() {
        return graphicalSchema;
    }

    @Override
    public void setGraphicalSchema(String graphicalSchema) {
        this.graphicalSchema = graphicalSchema;
    }


}
