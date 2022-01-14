package org.unclesniper.srcgen;

import static org.unclesniper.util.ArgUtils.notNull;
import static org.unclesniper.util.ArgUtils.indexInclusive;

public interface GenStringFilter {

	String filterString(GenConfig config, Variables variables, String subject) throws GenException;

	void filterString(GenConfig config, Variables variables, StringBuilder subject, int offset) throws GenException;

	public static String by(GenStringFilter filter, GenConfig config, Variables variables, String subject)
			throws GenException {
		notNull(filter, "filter");
		StringBuilder builder = new StringBuilder(notNull(subject, "subject"));
		filter.filterString(config, variables, builder, 0);
		return builder.toString();
	}

	public static void by(GenStringFilter filter, GenConfig config, Variables variables, StringBuilder subject,
			int offset) throws GenException {
		notNull(filter, "filter");
		int length = notNull(subject, "subject").length();
		String oldString = subject.substring(indexInclusive(offset, length, "offset"));
		String newString = filter.filterString(config, variables, oldString);
		if(newString == null)
			subject.delete(offset, length);
		else
			subject.replace(offset, length, newString);
	}

}
