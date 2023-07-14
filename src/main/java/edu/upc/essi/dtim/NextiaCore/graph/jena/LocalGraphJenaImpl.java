package edu.upc.essi.dtim.NextiaCore.graph.jena;

import edu.upc.essi.dtim.NextiaCore.graph.LocalGraph;
import org.apache.jena.rdf.model.Model;

import java.util.List;
import java.util.Map;

public class LocalGraphJenaImpl extends GraphJenaImpl implements LocalGraph {

    public LocalGraphJenaImpl(String id, String name, Model triples) {
        super(id, name, triples);
    }

    public LocalGraphJenaImpl() {
        super();
    }

    /**
     * @return
     */
    public String getGraphName() {
        return super.getGraphName();
    }

    /**
     * @param subject
     * @param predicate
     * @param object
     */
    @Override
    public void addTriple(String subject, String predicate, String object) {
        super.addTriple(subject, predicate,object);
    }

    /**
     * @param subject
     * @param predicate
     * @param object
     */
    @Override
    public void addTripleLiteral(String subject, String predicate, String object) {
        super.addTripleLiteral(subject, predicate,object);
    }

    /**
     * @param subject
     * @param predicate
     * @param object
     */
    @Override
    public void deleteTriple(String subject, String predicate, String object) {
        super.deleteTriple(subject, predicate,object);
    }

    /**
     * @param sparql
     * @return
     */
    @Override
    public List<Map<String, Object>> query(String sparql) {
        return super.query(sparql);
    }

    /**
     * @return
     */
    @Override
    public String getGraphicalSchema() {
        return super.getGraphicalSchema();
    }

    /**
     * @param graphicalSchema
     */
    @Override
    public void setGraphicalSchema(String graphicalSchema) {
        super.setGraphicalSchema(graphicalSchema);
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