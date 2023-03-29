package edu.upc.essi.dtim.Discovery;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
public class Attribute {
	Collection<Alignment> alignment;
	private String name;
	private String type;
}