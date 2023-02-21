package edu.upc.essi.dtim;

public class FactoryUseExample {
    GraphStoreFactory rdfModel = RDFModelFactory.getInstance();

    // Inicializar el modelo
    rdfModel.initModel();

    // Añadir una tripla
    rdfModel.addTriple("http://example.org/resource1", "http://example.org/predicate1", "Valor de objeto 1");

        // Consultar el modelo con una consulta SPARQL
        String sparqlQuery = "SELECT ?s ?p ?o WHERE { ?s ?p ?o }";
        List<Map<String, String>> resultList = rdfModel.query(sparqlQuery);
    for (Map<String, String> row : resultList) {
            System.out.println(row.get("s") + " " + row.get("p") + " " + row.get("o"));
        }

    // Eliminar una tripla
    rdfModel.removeTriple("http://example.org/resource1", "http://example.org/predicate1", "Valor de objeto 1");

    // Cerrar el modelo
    rdfModel.closeModel();
}
