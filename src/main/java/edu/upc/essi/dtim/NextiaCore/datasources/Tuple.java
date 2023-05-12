package edu.upc.essi.dtim.NextiaCore.datasources;

public class Tuple {
    private String tupleId;
    private String tupleName;
    private String tupleDescription;

    public String getTupleId() {
        return tupleId;
    }

    public void setTupleId(String tupleId) {
        this.tupleId = tupleId;
    }

    public String getTupleName() {
        return tupleName;
    }

    public void setTupleName(String tupleName) {
        this.tupleName = tupleName;
    }

    public String getTupleDescription() {
        return tupleDescription;
    }

    public void setTupleDescription(String tupleDescription) {
        this.tupleDescription = tupleDescription;
    }
}