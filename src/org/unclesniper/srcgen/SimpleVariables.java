package org.unclesniper.srcgen;

import java.util.Map;
import java.util.HashMap;

import static org.unclesniper.util.ArgUtils.notNull;

public class SimpleVariables implements Variables {

	private final Map<String, String> variables = new HashMap<String, String>();

	public SimpleVariables() {}

	public void setVariable(String name, String value) {
		notNull(name, "name");
		if(value == null)
			variables.remove(name);
		else
			variables.put(name, value);
	}

	@Override
	public boolean isDefined(String name) {
		return variables.containsKey(notNull(name, "name"));
	}

	@Override
	public String getVariable(String name) throws UndefinedVariableException {
		String value = variables.get(notNull(name, "name"));
		if(value == null)
			throw new UndefinedVariableException(name);
		return value;
	}

}
