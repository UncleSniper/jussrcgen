package org.unclesniper.srcgen;

public interface Variables {

	String getVariable(String name) throws UndefinedVariableException;

	boolean isDefined(String name);

}
