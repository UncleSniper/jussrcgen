package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenException;

import static org.unclesniper.util.ArgUtils.notNull;

public class IllegalIdentifierException extends GenException {

	private final String identifier;

	public IllegalIdentifierException(String identifier) {
		super("Illegal Java identifier: " + notNull(identifier, "identifier"));
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

}
