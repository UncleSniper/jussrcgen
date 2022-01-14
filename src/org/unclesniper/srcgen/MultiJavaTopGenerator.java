package org.unclesniper.srcgen;

import java.util.List;
import java.io.IOException;
import java.util.LinkedList;

import static org.unclesniper.util.ArgUtils.notNull;

public class MultiJavaTopGenerator implements JavaTopGenerator {

	private final List<JavaTopGenerator> generators = new LinkedList<JavaTopGenerator>();

	public MultiJavaTopGenerator() {}

	public void addGenerator(JavaTopGenerator generator) {
		generators.add(notNull(generator, "generator"));
	}

	@Override
	public void generate(GenConfig config, Variables variables, TextSink sink) throws GenException, IOException {
		for(JavaTopGenerator generator : generators)
			generator.generate(config, variables, sink);
	}

}
