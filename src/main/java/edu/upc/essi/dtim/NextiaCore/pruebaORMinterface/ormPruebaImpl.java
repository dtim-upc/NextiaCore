package edu.upc.essi.dtim.NextiaCore.pruebaORMinterface;

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
    public String getGraphicalSchema() {
        return graphicalSchema;
    }

    @Override
    public void setGraphicalSchema(String graphicalSchema) {
        this.graphicalSchema = graphicalSchema;
    }


}
