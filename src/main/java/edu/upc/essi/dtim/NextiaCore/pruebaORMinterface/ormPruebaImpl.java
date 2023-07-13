package edu.upc.essi.dtim.NextiaCore.pruebaORMinterface;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Override
    public Model getGraphoLoko() {
        return graphoLoko;
    }
    @Override
    public void setGraphoLoko(Model graphoLoko) {
        this.graphoLoko = graphoLoko;
    }

    @JsonIgnore
    private Model graphoLoko;

    @Override
    public String getGraphicalSchema() {
        return graphicalSchema;
    }

    @Override
    public void setGraphicalSchema(String graphicalSchema) {
        this.graphicalSchema = graphicalSchema;
    }


}
