package org.unclesniper.srcgen;

import java.util.List;
import java.io.IOException;
import java.util.LinkedList;

import static org.unclesniper.util.ArgUtils.notNull;

public class MultiTextGenerator implements TextGenerator {

	private final List<TextGenerator> generators = new LinkedList<TextGenerator>();

	public MultiTextGenerator() {}

	public void addGenerator(TextGenerator generator) {
		generators.add(notNull(generator, "generator"));
	}

	@Override
	public void generate(GenConfig config, Variables variables, TextSink sink) throws GenException, IOException {
		for(TextGenerator generator : generators)
			generator.generate(config, variables, sink);
	}

}
