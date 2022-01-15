package org.unclesniper.srcgen.java;

import org.unclesniper.srcgen.GenException;

import static org.unclesniper.util.ArgUtils.notNull;

public class UnrecognizedVisibilityException extends GenException {

	private final String visibility;

	public UnrecognizedVisibilityException(String visibility) {
		super("Unrecognized Java visibility: " + notNull(visibility, "visibility"));
		this.visibility = visibility;
	}

	public String getVisibility() {
		return visibility;
	}

}
