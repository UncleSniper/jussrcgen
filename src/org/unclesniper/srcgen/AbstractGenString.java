package org.unclesniper.srcgen;

import java.util.List;
import java.util.LinkedList;

import static org.unclesniper.util.ArgUtils.notNull;

public abstract class AbstractGenString implements GenString {

	private final List<GenStringFilter> filters = new LinkedList<GenStringFilter>();

	public AbstractGenString() {}

	public void addFilter(GenStringFilter filter) {
		filters.add(notNull(filter, "filter"));
	}

	protected abstract void buildStringImpl(GenConfig config, Variables variables, StringBuilder sink)
			throws GenException;

	@Override
	public void buildString(GenConfig config, Variables variables, StringBuilder sink) throws GenException {
		int start = notNull(sink, "sink").length();
		buildStringImpl(config, variables, sink);
		for(GenStringFilter filter : filters)
			filter.filterString(config, variables, sink, start);
	}

}
