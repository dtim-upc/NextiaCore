package edu.upc.essi.dtim.NextiaCore.pruebaORMinterface;

import org.apache.jena.rdf.model.Model;

public interface ormPrueba {

    Model getGraphoLoko();

    void setGraphoLoko(Model graphoLoko);

    String getGraphicalSchema();

    void setGraphicalSchema(String graphicalSchema);
}
