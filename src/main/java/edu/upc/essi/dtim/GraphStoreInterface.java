package edu.upc.essi.dtim;

import java.util.List;
import java.util.Map;

public interface GraphStoreInterface {
    //Este método inicializa el modelo RDF y establece las conexiones necesarias con la fuente de datos.
    void initGraph();
    //Este método añade una tripla al modelo.
    void addTriple(String subject, String predicate, String object);
    //Este método elimina una tripla del modelo.
    void removeTriple(String subject, String predicate, String object);
    //Este método realiza una consulta SPARQL en el modelo y devuelve los resultados en una lista de mapas.
    List<Map<String, String>> query(String sparqlQuery);
    //Este método cierra el modelo RDF y libera los recursos.
    void closeModel();
}
