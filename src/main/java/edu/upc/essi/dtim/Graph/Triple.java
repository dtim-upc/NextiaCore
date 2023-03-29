package edu.upc.essi.dtim.Graph;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Triple {
	URI predicate;
	URI subject;
	URI object;
}