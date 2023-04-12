package edu.upc.essi.dtim.CoreGraph;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Triple {
	private final URI subject;
	private final URI predicate;
	private final URI object;

	public Triple(URI subject, URI predicate, URI object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}

	@Override
	public String toString() {
		return subject.toString() + " " + predicate.toString() + " " + object.toString() + " .";
	}
}