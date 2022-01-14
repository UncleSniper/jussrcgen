package org.unclesniper.srcgen;

import java.util.List;
import java.io.IOException;
import java.util.LinkedList;

import static org.unclesniper.util.ArgUtils.notNull;

public abstract class AbstractTextPieceGenerator extends AbstractTextGenerator {

	private final List<GenString> strings = new LinkedList<GenString>();

	public AbstractTextPieceGenerator() {}

	public void addString(GenString string) {
		strings.add(notNull(string, "string"));
	}

	protected abstract void print(TextSink sink, String piece) throws IOException;

	@Override
	protected void generateImpl(GenConfig config, Variables variables, TextSink sink)
			throws GenException, IOException {
		for(GenString string : strings) {
			String s = string.getString(config, variables);
			if(s != null)
				print(sink, s);
		}
	}

}
