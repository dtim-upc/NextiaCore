package edu.upc.essi.dtim;

public class Triple {

	URI predicate;
	URI subject;
	URI object;

	public URI getSubject() {
		return this.subject;
	}

	public URI getPredicate() {
		return this.predicate;
	}

	public URI getObject() {
		return this.object;
	}

	/**
	 * 
	 * @param URIsubject
	 */
	public void setSubject(String URIsubject) {
		this.subject = new URI(URIsubject);
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param URIpredicate
	 */
	public void setPredicate(String URIpredicate) {
		// TODO - implement Triple.setPredicate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param URIobject
	 */
	public void setObject(String URIobject) {
		// TODO - implement Triple.setObject
		throw new UnsupportedOperationException();
	}

}