package edu.upc.essi.dtim.GraphProcessing;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;


public class GraphProcessingImpl implements GraphProcessingInterface{
    private Graph graph;

    public GraphProcessing() {
        // Creamos un nuevo grafo en memoria usando Jena In-Memory

    }

    // Método para agregar triples al grafo
    public void addTriple(Node subject, Node predicate, Node object) {
        graph.add(new Triple(subject, predicate, object));
    }
}
