package edu.upc.essi.dtim.NextiaCore.graph.jena;

import edu.upc.essi.dtim.NextiaCore.graph.LocalGraph;
import edu.upc.essi.dtim.NextiaCore.graph.Triple;
import edu.upc.essi.dtim.NextiaCore.graph.URI;
import org.apache.jena.rdf.model.Model;

import java.util.Set;

public class LocalGraphJena extends GraphJena implements LocalGraph {

    public LocalGraphJena(String id, String name, Model triples) {
        super(id, name, triples);
    }

    public LocalGraphJena() {
        super();
    }

    @Override
    public String getLocalGraphAttribute() {
        return localGraphAttribute;
    }

    @Override
    public void setLocalGraphAttribute(String localGraphAttribute) {
        this.localGraphAttribute = localGraphAttribute;
    }

    String localGraphAttribute;


}