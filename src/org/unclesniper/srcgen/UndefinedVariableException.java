package org.unclesniper.srcgen;

import static org.unclesniper.util.ArgUtils.notNull;

public class UndefinedVariableException extends GenException {

	private final String variable;

	public UndefinedVariableException(String variable) {
		super("Undefined variable: " + notNull(variable, "variable"));
		this.variable = variable;
	}

	public String getVariable() {
		return variable;
	}

}
