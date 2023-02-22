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
            Node s = new Node(subject.getURI());
            Node o;
            if (object.isLiteral()) {
                o = new Node(object.asLiteral().getString());
            } else {
                o = new Node(object.asResource().getURI());
            }

            // Convert the Jena property to our edge class
            Edge p = new Edge(predicate.getURI());

            // Add the triple to the graph
            graph.addTriple(new Triple(s, p, o));
        }

        return graph;
    }
}
