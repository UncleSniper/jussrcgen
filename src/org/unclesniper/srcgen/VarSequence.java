package org.unclesniper.srcgen;

import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

import static org.unclesniper.util.ArgUtils.notNull;

public final class VarSequence {

	private final List<Variables> elements = new LinkedList<Variables>();

	public VarSequence() {}

	public void addElement(Variables element) {
		elements.add(notNull(element, "element"));
	}

	public List<Variables> getElements() {
		return Collections.unmodifiableList(elements);
	}

}
