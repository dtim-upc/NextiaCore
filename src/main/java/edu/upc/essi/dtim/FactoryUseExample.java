package edu.upc.essi.dtim;

import java.util.List;
import java.util.Map;

public class FactoryUseExample {


    public void useExample() {
        GraphStoreInterface graphStoreInstance = GraphStoreFactory.getInstance();
        // Inicializar el graph
        graphStoreInstance.initGraph();

        // Añadir una tripla
        graphStoreInstance.addTriple("http://example.org/resource1", "http://example.org/predicate1", "Valor de objeto 1");

        // Consultar el modelo con una consulta SPARQL
        String sparqlQuery = "SELECT ?s ?p ?o WHERE { ?s ?p ?o }";
        List<Map<String, String>> resultList = graphStoreInstance.query(sparqlQuery);
        for (Map<String, String> row : resultList) {
            System.out.println(row.get("s") + " " + row.get("p") + " " + row.get("o"));
        }

        // Eliminar una tripla
        graphStoreInstance.removeTriple("http://example.org/resource1", "http://example.org/predicate1", "Valor de objeto 1");

        // Cerrar el modelo
        graphStoreInstance.closeGraph();
    }
}
