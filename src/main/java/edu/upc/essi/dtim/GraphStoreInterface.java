package edu.upc.essi.dtim;

import org.apache.jena.query.ResultSet;

import java.util.List;
import java.util.Map;

public interface GraphStoreInterface {
    //Este método inicializa el modelo RDF y establece las conexiones necesarias con la fuente de datos.
    void initGraph();

    //Este método añade una tripla al grafo.
    void addTriple(String subject, String predicate, String object);

    //Este método elimina una tripla del modelo.
    void removeTriple(String subject, String predicate, String object);

    //Este método realiza una consulta SPARQL en el modelo y devuelve los resultados en una lista de mapas.
    List<Map<String, String>> query(String sparqlQuery);

    Graph getGraph(String iri);

    Boolean containsGraph(String iri);

    void addModel(String namedGraph, Graph model);

    void addTriple(String namedGraph, String s, String p, String o);

    void addTripleLiteral(String namedGraph, String s, String p, String o);

    String getDomainOfProperty(String graphIRI, String propertyIRI);

    String getRDFSLabel(String graphIRI, String resourceIRI);

    void deleteTriplesWithSubject(String graphIRI, String subjectIRI);

    void deleteTriplesWithObject(String graphIRI, String objectIRI);

    void deleteTriples(String graphIRI, String subjectIRI, String predicateIRI, String objectIRI);

    void deleteGraph(String iri);

    void deleteAllGraphs();

    void updateLiteralFromGraph(String graphIRI, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral);

    //    This update it globally in all the dataset (i.e., all named graphs)
    void updateLiteral(String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral);
    void updateLiteral(String graphIri, String subjectIRI, String predicateIRI, String oldLiteral, String newLiteral);

    ResultSet runAQuery(String query);

    ResultSet runAQuery(String query, Graph m);

    void runAnUpdateQuery(String sparqlQuery);

    void runAnUpdateQuery(String sparqlQuery, Graph m);

    Graph getIntegratedResourcesOfSource(String id, String uri);

    Graph simplify(Graph m);

    Graph getPropertiesSameAs(Graph graph);

    Graph getSubGraph(List<String> resources, String uri);

    //Este método cierra el modelo RDF y libera los recursos.
    void closeModel();
}
