package edu.upc.essi.dtim;

import org.apache.jena.rdf.model.*;

public class JenaToGraphAdapter {
    public static Graph convertModelToGraph(Model model) {
        Graph graph = new Graph();

        // Iterate over all the statements in the Jena model and add them as triples to the graph
        StmtIterator iter = model.listStatements();
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();

            // Convert the Jena resources to our node class
            
        }

        return graph;
    }
}
