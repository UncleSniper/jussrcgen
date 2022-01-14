package org.unclesniper.srcgen;

import java.util.Deque;
import java.util.LinkedList;

import static org.unclesniper.util.ArgUtils.notNull;

public class MultiVariables implements Variables {

	private final Deque<Variables> children = new LinkedList<Variables>();

	public MultiVariables() {}

	public void addChild(Variables child) {
		children.addLast(notNull(child, "child"));
	}

	public Variables popChild() {
		return children.removeLast();
	}

	@Override
	public String getVariable(String name) throws UndefinedVariableException {
		notNull(name, "name");
		for(Variables child : children) {
			try {
				return child.getVariable(name);
			}
			catch(UndefinedVariableException e) {}
		}
		throw new UndefinedVariableException(name);
	}

	@Override
	public boolean isDefined(String name) {
		notNull(name, "name");
		for(Variables child : children) {
			if(child.isDefined(name))
				return true;
		}
		return false;
	}

}
