package edu.upc.essi.dtim.NextiaCore.discovery;

public class Alignment {

	Attribute attributeA;
	Attribute attributeB;
	private String label;
	private float similarity;

	public Alignment() {
	}

	public Attribute getAttributeA() {
		return attributeA;
	}

	public void setAttributeA(Attribute attributeA) {
		this.attributeA = attributeA;
	}

	public Attribute getAttributeB() {
		return attributeB;
	}

	public void setAttributeB(Attribute attributeB) {
		this.attributeB = attributeB;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getSimilarity() {
		return similarity;
	}

	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}
}