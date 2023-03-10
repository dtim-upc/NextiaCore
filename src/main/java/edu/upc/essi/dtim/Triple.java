package edu.upc.essi.dtim;

public class Triple {
    private final String subjectIRI;
    private final String predicateIRI;
    private final String objectIRI;

    /**
     * @param subjectIRI   the IRI of the subject of the triples to be deleted.
     * @param predicateIRI the IRI of the predicate of the triples to be deleted.
     * @param objectIRI    the IRI of the object of the triples to be deleted.
     */
    public Triple(String subjectIRI, String predicateIRI, String objectIRI) {
        this.subjectIRI = subjectIRI;
        this.predicateIRI = predicateIRI;
        this.objectIRI = objectIRI;
    }

    public String getSubjectIRI() {
        return subjectIRI;
    }

    public String getPredicateIRI() {
        return predicateIRI;
    }

    public String getObjectIRI() {
        return objectIRI;
    }
}
