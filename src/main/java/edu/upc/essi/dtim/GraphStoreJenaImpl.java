package edu.upc.essi.dtim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;

public class GraphStoreJenaImpl implements GraphStoreInterface {

    private Model model;

    @Override
    public void initGraph() {
        model = ModelFactory.createDefaultModel();
        // Configurar la fuente de datos si es necesario
    }

    @Override
    public void addTriple(String subject, String predicate, String object) {
        Resource subj = ResourceFactory.createResource(subject);
        Property pred = ResourceFactory.createProperty(predicate);
        RDFNode obj = ResourceFactory.createPlainLiteral(object);
        Statement stmt = ResourceFactory.createStatement(subj, pred, obj);
        model.add(stmt);
    }

    @Override
    public void removeTriple(String subject, String predicate, String object) {
        Resource subj = ResourceFactory.createResource(subject);
        Property pred = ResourceFactory.createProperty(predicate);
        RDFNode obj = ResourceFactory.createPlainLiteral(object);
        Statement stmt = ResourceFactory.createStatement(subj, pred, obj);
        model.remove(stmt);
    }

    @Override
    public List<Map<String, String>> query(String sparqlQuery) {
        List<Map<String, String>> resultList = new ArrayList<>();
        Query query = QueryFactory.create(sparqlQuery);
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet results = qexec.execSelect();
            List<String> varNames = results.getResultVars();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Map<String, String> row = new HashMap<>();
                for (String varName : varNames) {
                    RDFNode node = soln.get(varName);
                    if (node != null) {
                        row.put(varName, node.toString());
                    }
                }
                resultList.add(row);
            }
        }
        return resultList;
    }

    @Override
    public void closeModel() {
        if (model != null) {
            model.close();
        }
    }
}
